package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain;

import java.util.Random;

public class Dice {
	private static final int NUM_SIDES = 6;
	private Random random;
	
	public Dice() {
		random = new Random();
	}
	
	public int rollDice() {
		return random.nextInt(NUM_SIDES) + 1;
	}
}
