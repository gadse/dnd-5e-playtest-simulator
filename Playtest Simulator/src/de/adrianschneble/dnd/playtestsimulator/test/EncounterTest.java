package de.adrianschneble.dnd.playtestsimulator.test;

import static de.adrianschneble.dnd.playtestsimulator.src.encounters.EncounterBuilder.createGenericEncounter;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;
import de.adrianschneble.dnd.playtestsimulator.src.encounters.Encounter;

public class EncounterTest {

	@Test
	public void givenGenericEncounter_whenRunEncounter_thenOneSideIsDead() {
		Encounter encounter = createGenericEncounter();

		encounter.runEncounter();

		List<Creature> players = encounter.getPlayers();
		List<Creature> enemies = encounter.getEnemies();
		assertThat(Math.min(Encounter.getLiving(players), Encounter.getLiving(enemies)), is(0));
	}

	@Test
	@Ignore
	public void givenAllEnemiesDied_thenEncounterSuccessful() throws Exception {
		// Encounter encounter = EncounterBuilder.createGenericEncounter();
		//
		// encounter.runEncounter();

		Encounter encounter = Mockito.mock(Encounter.class);

		Mockito.when(encounter.getEnemies()).thenReturn(new ArrayList<Creature>());

		assertThat(encounter.runEncounter(), is(true));
	}

}
