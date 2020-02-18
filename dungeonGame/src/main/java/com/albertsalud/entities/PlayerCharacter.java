package com.albertsalud.entities;

public class PlayerCharacter extends Character {
	
	public PlayerCharacter(int initialXCoordinate, int initialYCoordinate) {
		this.setIntelligence(10);
		this.setName("Personaje jugador");
		this.setSpeed(3);
		this.setStrength(10);
		this.setVitality(10);
		this.setDungeonMark("P");
		
		this.setxCoodinate(initialXCoordinate);
		this.setyCoordinate(initialYCoordinate);
	}
	
	

}
