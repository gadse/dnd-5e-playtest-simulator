package de.adrianschneble.dnd.playtestsimulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import de.adrianschneble.dnd.playtestsimulator.src.Creature;
import de.adrianschneble.dnd.playtestsimulator.src.DiceRoll;
import de.adrianschneble.dnd.playtestsimulator.src.Dice;
import de.adrianschneble.dnd.playtestsimulator.src.Encounter;
import de.adrianschneble.dnd.playtestsimulator.src.Result;

public class RunEncounterTest {

	@Test
	public void successChanceIs100percentWithEnemiesThatDealNoDamageAndPlayersThatDo() {
		List<Creature> players = new ArrayList<>();
		players.add(new Creature(new DiceRoll(new Dice(6), 1)));
		List<Creature> enemies = new ArrayList<>();
		enemies.add(new Creature(new DiceRoll(new Dice(0), 0)));
		Encounter encounter = new Encounter(players, enemies);
		
		Result result = encounter.run();
		
		assertThat(result.probabilityForCasualtyCount(0), is(1.0));
	}
	
	@Test
	public void successChanceIs0percentWithPlayersThatDealNoDamageAndEnemiesThatDo() {
		List<Creature> players = new ArrayList<>();
		players.add(new Creature(new DiceRoll(new Dice(0), 0)));
		List<Creature> enemies = new ArrayList<>();
		enemies.add(new Creature(new DiceRoll(new Dice(6), 1)));
		Encounter encounter = new Encounter(players, enemies);
		
		Result result = encounter.run();
		
		assertThat(result.probabilityForCasualtyCount(0), is(0.0));
	}

}
