package de.adrianschneble.dnd.playtestsimulator.src.creatures;

import de.adrianschneble.dnd.playtestsimulator.src.Roll;
import de.adrianschneble.dnd.playtestsimulator.src.actions.Action;

public class Creature implements Comparable<Creature> {

	private int hitpoints;
	private int armorClass;
	private int initiativeBonus;
	private Action[] actions;
	private int initiative = Integer.MIN_VALUE;

	Creature(int hitpoints, int armorClass, int initiativeBonus, Action... actions) {
		this.hitpoints = hitpoints;
		this.armorClass = armorClass;
		this.initiativeBonus = initiativeBonus;
		this.actions = actions;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void rollInitiative() {
		this.initiative = Roll.d20() + initiativeBonus;
	}

	public int getInitiative() {
		if (initiative == Integer.MIN_VALUE) {
			rollInitiative();
		}
		return initiative;
	}

	public Action[] getActions() {
		return actions;
	}

	public void takeDamage(int damageRoll) {
		this.hitpoints -= damageRoll;
	}

	public boolean isAlive() {
		return hitpoints > 0;
	}

	@Override
	public int compareTo(Creature o) {
		if (this.getInitiative() > o.getInitiative()) {
			return 1;
		}
		if (this.getInitiative() < o.getInitiative()) {
			return -1;
		}
		return 0;
	}

	public Creature copy() {
		return new Creature(hitpoints, armorClass, initiativeBonus, actions);
	}

}
