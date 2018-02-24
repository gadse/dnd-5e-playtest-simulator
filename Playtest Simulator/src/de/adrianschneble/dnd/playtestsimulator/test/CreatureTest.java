package de.adrianschneble.dnd.playtestsimulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;
import de.adrianschneble.dnd.playtestsimulator.src.creatures.CreatureBuilder;

public class CreatureTest {

	@Test
	public void givenAliveCreature_whenDropsToZeroHitpoints_thenIsDead() throws Exception {
		Creature creature = CreatureBuilder.createGenericCreature();

		creature.takeDamage(creature.getHitpoints());

		assertThat(creature.isAlive(), is(false));
	}
}
