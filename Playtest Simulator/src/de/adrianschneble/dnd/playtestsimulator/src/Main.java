package de.adrianschneble.dnd.playtestsimulator.src;

import java.util.Collections;
import java.util.List;

import de.adrianschneble.dnd.playtestsimulator.src.encounters.Encounter;
import de.adrianschneble.dnd.playtestsimulator.src.encounters.EncounterBuilder;

public class Main {

	public static void main(String[] args) {
		Encounter encounter = EncounterBuilder.createGenericEncounter();
		Simulation simulation = new Simulation(encounter, 100);
		List<Boolean> results = simulation.runSimulation();
		for (Boolean result : results) {
			System.out.println(result);
		}
		int successes = Collections.frequency(results, true);
		System.out.println((double) successes / results.size());
	}

}
