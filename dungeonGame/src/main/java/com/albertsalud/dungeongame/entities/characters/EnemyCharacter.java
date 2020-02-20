package com.albertsalud.dungeongame.entities.characters;

import com.albertsalud.dungeongame.entities.weapons.Bow;
import com.albertsalud.dungeongame.entities.weapons.Weapon;
import com.albertsalud.dungeongame.helpers.Dice;

public class EnemyCharacter extends Character {
	
	public EnemyCharacter(int initialXCoordinate, int initialYCoordinate) {
		setCharacterFeatures();
		
		setInitialPosition(initialXCoordinate, initialYCoordinate);
		
		/*Weapon sword = new Sword();
		this.setEquipedWeapon(sword);*/
		Weapon bow = new Bow();
		this.setEquipedWeapon(bow);
	}
	
	private void setInitialPosition(int initialXCoordinate, int initialYCoordinate) {
		this.setxCoordinate(initialXCoordinate);
		this.setyCoordinate(initialYCoordinate);
	}
	
	private void setCharacterFeatures() {
		this.speed = 4;
		this.intelligence = Dice.roll(Dice.TWENTIE_SIDES_DICE);
		this.strength = Dice.roll(Dice.TWENTIE_SIDES_DICE);
		this.name = "Enemigo";
		this.skill = Dice.roll(Dice.TWENTIE_SIDES_DICE);		
		this.dungeonMark = "X";
		this.vitality = 4;
		this.armorClass = 11;
	}

}
