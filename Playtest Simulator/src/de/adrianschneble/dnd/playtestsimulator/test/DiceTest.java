package de.adrianschneble.dnd.playtestsimulator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import de.adrianschneble.dnd.playtestsimulator.src.Dice;

public class DiceTest {

	@Test
	public void expectationOfD6Is3point5() throws Exception {
		Dice dice = new Dice(6);
		
		double expectation = dice.expectation();
		
		assertThat(expectation, is(3.5));
	}

	@Test
	public void expectationOfD8Is4point5() throws Exception {
		Dice dice = new Dice(8);
		
		double expectation = dice.expectation();
		
		assertThat(expectation, is(4.5));
	}

}
