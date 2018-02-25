package de.adrianschneble.dnd.playtestsimulator.src.encounters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import de.adrianschneble.dnd.playtestsimulator.src.actions.Action;
import de.adrianschneble.dnd.playtestsimulator.src.actions.IllegalTargetCountException;
import de.adrianschneble.dnd.playtestsimulator.src.actions.actionattributes.BeneficialAction;
import de.adrianschneble.dnd.playtestsimulator.src.actions.actionattributes.targets.SelfOnlyAction;
import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;

public class Encounter {

	private List<Creature> players;
	private List<Creature> enemies;
	private List<Creature> combatants;

	public Encounter(List<Creature> players, List<Creature> enemies) {
		this.players = players;
		this.enemies = enemies;
		rollInitiative();
		combatants = getCombatantsSortedByInitiative();
	}

	public boolean runEncounter() {
		while (getLiving(players) > 0 && getLiving(enemies) > 0) {
			for (Creature combatant : combatants) {
				if (combatant.isAlive()) {
					Action takenAction = chooseAction(combatant.getActions());
					takeAction(combatant, takenAction);
				}
			}
		}
		return getLiving(players) > 0;
	}

	private Action chooseAction(Action[] actions) {
		// TODO improve choosing algorithm
		// TODO bonus / regular actions?
		Action takenAction = chooseRandom(actions);
		return takenAction;
	}

	private void takeAction(Creature combatant, Action takenAction) {
		try {
			if (takenAction instanceof BeneficialAction) {
				takeBeneficialAction(combatant, takenAction);
			} else {
				takeHarmfulAction(combatant, takenAction);
			}
		} catch (IllegalTargetCountException e) {
			e.printStackTrace();
		}
	}

	private void takeHarmfulAction(Creature combatant, Action takenAction) throws IllegalTargetCountException {
		Creature randomTarget = chooseRandom(getFoes(combatant));
		takenAction.apply(randomTarget);
	}

	private void takeBeneficialAction(Creature combatant, Action takenAction) throws IllegalTargetCountException {
		if (takenAction instanceof SelfOnlyAction) {
			takenAction.apply(combatant);
		} else {
			Creature randomTarget = chooseRandom(getAllies(combatant));
			takenAction.apply(randomTarget);
		}
	}

	private List<Creature> getFoes(Creature combatant) {
		if (players.contains(combatant)) {
			return enemies;
		} else {
			return players;
		}
	}

	private List<Creature> getAllies(Creature combatant) {
		if (players.contains(combatant)) {
			return players;
		} else {
			return enemies;
		}
	}

	public static int getLiving(List<Creature> creatures) {
		int livingCount = 0;
		for (Creature creature : creatures) {
			if (creature.isAlive()) {
				livingCount++;
			}
		}
		return livingCount;
	}

	private <T> T chooseRandom(T[] array) {
		return chooseRandom(Arrays.asList(array));
	}

	private <T> T chooseRandom(List<T> list) {
		return list.get(new Random().nextInt(list.size()));
	}

	private List<Creature> getCombatantsSortedByInitiative() {
		List<Creature> combatants = new ArrayList<>();
		combatants.addAll(players);
		combatants.addAll(enemies);
		Collections.sort(combatants);
		return combatants;
	}

	private void rollInitiative() {
		for (Creature player : players) {
			player.rollInitiative();
		}
		for (Creature enemy : enemies) {
			enemy.rollInitiative();
		}
	}

	public List<Creature> getEnemies() {
		return enemies;
	}

	public List<Creature> getPlayers() {
		return players;
	}

	public Encounter copy() {
		return new Encounter(copyCreatureList(players), copyCreatureList(enemies));
	}

	private List<Creature> copyCreatureList(List<Creature> creatures) {
		List<Creature> copy = new ArrayList<>();
		for (Creature creature : creatures) {
			copy.add(creature.copy());
		}
		return copy;
	}

}
