package com.albertsalud.entities;

public class EnemyCharacter extends Character {
	
	public EnemyCharacter(int initialXCoordinate, int initialYCoordinate) {
		this.setIntelligence(2);
		this.setName("Enemigo");
		this.setSpeed(4);
		this.setStrength(5);
		this.setVitality(4);
		this.setDungeonMark("X");
		
		this.setxCoordinate(initialXCoordinate);
		this.setyCoordinate(initialYCoordinate);
	}

}
