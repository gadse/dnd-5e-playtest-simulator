package de.adrianschneble.dnd.playtestsimulator.src.actions;

import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;

public interface Action {
	public void apply(Creature... targets) throws IllegalTargetCountException;

	/*-
	 * subclasses according to targeting type & count:
	 * 	- 1x individual target
	 * 	- multiple individual targets
	 * 
	 * actions (that are relevant for this simulator):
	 * - Attack
	 * - Cast a Spell
	 * - Dodge
	 * 
	 */
}
