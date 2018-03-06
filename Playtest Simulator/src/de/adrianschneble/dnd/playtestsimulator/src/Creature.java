package de.adrianschneble.dnd.playtestsimulator.src;

public class Creature {

	private DiceRoll damage;

	public Creature(DiceRoll damage) {
		this.damage = damage;
	}

	public DiceRoll getDamage() {
		return damage;
	}

}
