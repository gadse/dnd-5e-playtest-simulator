package de.adrianschneble.dnd.playtestsimulator.src.encounters;

import java.util.ArrayList;
import java.util.List;

import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;
import de.adrianschneble.dnd.playtestsimulator.src.creatures.CreatureBuilder;

public class EncounterBuilder {

	private EncounterBuilder() {
	}

	public static Encounter createGenericEncounter() {
		List<Creature> players = new ArrayList<>();
		List<Creature> enemies = new ArrayList<>();
		players.add(CreatureBuilder.createGenericCreature());
		enemies.add(CreatureBuilder.createGenericCreature());
		Encounter encounter = new Encounter(players, enemies);
		return encounter;
	}

}
