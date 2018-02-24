package de.adrianschneble.dnd.playtestsimulator.src.encounters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import de.adrianschneble.dnd.playtestsimulator.src.actions.Action;
import de.adrianschneble.dnd.playtestsimulator.src.actions.IllegalTargetCountException;
import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;

public class Encounter {

	private List<Creature> players;
	private List<Creature> enemies;

	public Encounter(List<Creature> players, List<Creature> enemies) {
		this.players = players;
		this.enemies = enemies;
	}

	public boolean runEncounter() {
		rollInitiative();
		List<Creature> combatants = getCombatantsSortedByInitiative();

		while (getLiving(players) > 0 && getLiving(enemies) > 0) {
			for (Creature combatant : combatants) {
				if (combatant.isAlive()) {
					Action[] actions = combatant.getActions();
					Action takenAction = chooseRandom(actions);
					if (players.contains(combatant)) {
						try {
							Creature randomEnemy = chooseRandom(enemies);
							takenAction.apply(randomEnemy);
						} catch (IllegalTargetCountException e) {
							e.printStackTrace();
						}
					} else if (enemies.contains(combatant)) {
						try {
							Creature randomPlayer = chooseRandom(players);
							takenAction.apply(randomPlayer);
						} catch (IllegalTargetCountException e) {
							e.printStackTrace();
						}

					}
				}
			}
		}
		return getLiving(players) > 0;
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
