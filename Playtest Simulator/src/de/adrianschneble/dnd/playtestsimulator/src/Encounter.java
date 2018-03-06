package de.adrianschneble.dnd.playtestsimulator.src;

import java.util.List;

public class Encounter {

	private List<Creature> players;
	private List<Creature> enemies;

	public Encounter(List<Creature> players, List<Creature> enemies) throws IllegalArgumentException {
		this.players = players;
		this.enemies = enemies;
		if (players.isEmpty() || enemies.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	public Result run() {
		double expectation = players.get(0).getDamage().expectation();
		if (expectation == 0) {
			return new Result(0);
		} else {
			return new Result(1);
		}
	}

}
