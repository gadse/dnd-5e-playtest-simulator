package de.adrianschneble.dnd.playtestsimulator.src.actions;

import de.adrianschneble.dnd.playtestsimulator.src.creatures.Creature;

public interface Action {
	public void apply(Creature... targets) throws IllegalTargetCountException;
}
