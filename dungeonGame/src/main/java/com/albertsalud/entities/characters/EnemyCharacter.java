package com.albertsalud.entities.characters;

import com.albertsalud.entities.weapons.Sword;
import com.albertsalud.entities.weapons.Weapon;

public class EnemyCharacter extends Character {
	
	public EnemyCharacter(int initialXCoordinate, int initialYCoordinate) {
		this.setIntelligence(2);
		this.setName("Enemigo");
		this.setSpeed(10);
		this.setStrength(5);
		this.setVitality(4);
		this.setDungeonMark("X");
		
		this.setxCoordinate(initialXCoordinate);
		this.setyCoordinate(initialYCoordinate);
		
		Weapon sword = new Sword();
		this.setEquipedWeapon(sword);
	}

}
