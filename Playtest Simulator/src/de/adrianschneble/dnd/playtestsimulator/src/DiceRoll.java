package de.adrianschneble.dnd.playtestsimulator.src;

public class DiceRoll {

	private Dice dice;
	private int modifier;

	public DiceRoll(Dice dice, int modifier) {
		this.dice = dice;
		this.modifier = modifier;
	}

	public double expectation() {
		return dice.expectation() + modifier;
	}

}
