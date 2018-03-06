package de.adrianschneble.dnd.playtestsimulator.src;

public class Dice {

	private int value;

	public Dice(int value) {
		this.value = value;
	}

	public double expectation() {
		// prevent division by 0
		if (value == 0) {
			return 0;
		}
		int sum = sumUpToLimit(value);
		return sum / (double) value;
	}

	private static int sumUpToLimit(int limit) {
		int sum = 0;
		for (int i = 1; i <= limit; i++) {
			sum += i;
		}
		return sum;
	}

}
