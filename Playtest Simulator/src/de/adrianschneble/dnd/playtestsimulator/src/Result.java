package de.adrianschneble.dnd.playtestsimulator.src;

public class Result {

	private double probabiltyForNoCasualties;

	public Result(double probabiltyForNoCasualties) {
		this.probabiltyForNoCasualties = probabiltyForNoCasualties;
	}

	public double probabilityForCasualtyCount(int i) {
		return probabiltyForNoCasualties;
	}

}
