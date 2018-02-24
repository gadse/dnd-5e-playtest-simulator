package de.adrianschneble.dnd.playtestsimulator.src.creatures;

import de.adrianschneble.dnd.playtestsimulator.src.Damage;
import de.adrianschneble.dnd.playtestsimulator.src.actions.Action;
import de.adrianschneble.dnd.playtestsimulator.src.actions.AttackAction;

public class CreatureBuilder {

	private CreatureBuilder() {
	}

	public static Creature createGenericCreature() {
		int hitpoints = 1;
		int armorClass = 10;
		int initiativeBonus = 0;
		Action[] actions = { //
				new AttackAction(0, new Damage(6, 0)), //
		};
		Creature creature = new Creature(hitpoints, armorClass, initiativeBonus, actions);
		return creature;
	}

}
