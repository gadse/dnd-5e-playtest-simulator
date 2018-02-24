package de.adrianschneble.dnd.playtestsimulator.src;

public class Damage {
	private int dieSize;
	private int damageBonus;

	public Damage(int dieSize, int damageBonus) {
		this.dieSize = dieSize;
		this.damageBonus = damageBonus;
	}

	public int getDieSize() {
		return dieSize;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public int roll() {
		int damage = Roll.roll(dieSize) + damageBonus;
		return damage;
	}
}
