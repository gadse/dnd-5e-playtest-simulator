package de.adrianschneble.dnd.playtestsimulator.src;

import java.util.Random;

public class Roll {

	public static int d20() {
		return roll(20);
	}

	public static int roll(int dieSize) {
		Random random = new Random();
		return random.nextInt(dieSize) + 1;
	}

}
