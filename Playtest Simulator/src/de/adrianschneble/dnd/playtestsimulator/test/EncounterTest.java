package de.adrianschneble.dnd.playtestsimulator.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.adrianschneble.dnd.playtestsimulator.src.Creature;
import de.adrianschneble.dnd.playtestsimulator.src.Encounter;

public class EncounterTest {

	@Test(expected = IllegalArgumentException.class)
	public void dontAllowEncountersWithoutPlayers() throws Exception {
		List<Creature> players = new ArrayList<>();
		List<Creature> enemies = new ArrayList<>();
		enemies.add(new Creature(null));
		new Encounter(players, enemies);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dontAllowEncountersWithoutEnemies() throws Exception {
		List<Creature> players = new ArrayList<>();
		players.add(new Creature(null));
		List<Creature> enemies = new ArrayList<>();
		new Encounter(players, enemies);
	}
	
}
