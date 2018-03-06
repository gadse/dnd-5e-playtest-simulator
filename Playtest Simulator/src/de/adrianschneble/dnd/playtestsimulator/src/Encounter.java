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
		double averagePlayerDamage = players.get(0).getDamage().expectation();
		double averageEnemyDamage = enemies.get(0).getDamage().expectation();
		if (averagePlayerDamage == 0) {
			return new Result(0);
		}
		if (averageEnemyDamage == 0){
			return new Result(1);
		}
		return null;
	}

}
