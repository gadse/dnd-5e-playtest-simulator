package de.adrianschneble.dnd.playtestsimulator.src;

import java.util.ArrayList;
import java.util.List;

import de.adrianschneble.dnd.playtestsimulator.src.encounters.Encounter;

public class Simulation {

	private Encounter encounter;
	private int iterationCount;

	public Simulation(Encounter encounter, int iterationCount) {
		this.encounter = encounter;
		this.iterationCount = iterationCount;
	}
	
	public List<Boolean> runSimulation() {
		List<Boolean> results = new ArrayList<>();
		for (int iteration = 0; iteration < iterationCount; iteration++) {
			boolean encounterResult = encounter.copy().runEncounter();
			results.add(encounterResult);
		}
		return results;
	}
	
}
