package com.albertsalud.helpers;

public abstract class Dice {
	
	public static final int FOUR_SIDES_DICE = 4;
	public static final int SIX_SIDES_DICE = 6;
	public static final int EIGTH_SIDES_DICE = 8;
	public static final int TEN_SIDES_DICE = 10;
	public static final int TWENTIE_SIDES_DICE = 20;
	
	public static int roll(int diceSides) {
		return ((int) (Math.random() * (diceSides - 1)) + 1); 
		
	}
	
	
	public static void main(String[] args) {

		for(int tiradas = 0; tiradas < 10; tiradas++) {
			System.out.println("Vamos a tirar un dado de 10 caras: " + Dice.roll(TEN_SIDES_DICE));
		
			System.out.println("Vamos a tirar un dado de 20 caras: " + Dice.roll(TWENTIE_SIDES_DICE));
		}
	}

}
