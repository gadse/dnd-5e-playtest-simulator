package de.adrianschneble.dnd.playtestsimulator.src.actions.actionattributes.targets;

import de.adrianschneble.dnd.playtestsimulator.src.actions.Action;

public abstract class MultiTargetAction implements Action {
	protected int targetCount;

	public MultiTargetAction(int targetCount) {
		this.targetCount = targetCount;
	}
}
