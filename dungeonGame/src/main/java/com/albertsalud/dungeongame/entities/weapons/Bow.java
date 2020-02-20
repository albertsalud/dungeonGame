package com.albertsalud.dungeongame.entities.weapons;

import com.albertsalud.dungeongame.helpers.Dice;
import com.albertsalud.dungeongame.helpers.Modifiers;
import com.albertsalud.dungeongame.entities.characters.Character;

public class Bow extends Weapon {
	
	private int arrows;
	
	public Bow() {
		minDistance = 2;
		maxDistance = 5;
		name = "el arco";
		damageDice = Dice.FOUR_SIDES_DICE;
		this.arrows = 20;
		
		description = "te quedan " + arrows + " flechas disponibles";
	}

	@Override
	public boolean attack(Character attackerCharacter, Character targetCharacter) {
		if(!this.isAvailableAttack(attackerCharacter, targetCharacter)) {
			System.out.println("El enemigo no se encuentra a la distancia adecuada para atacar con el arco");
			return false;
		}
		
		if(arrows == 0) {
			System.out.println("No te quedan flechas para disparar!");
		}
		
		if(isSuccessfullAttack(attackerCharacter, targetCharacter)) 
			targetCharacter.getDamage(Dice.roll(damageDice));
		else System.out.println("Fallo! " + targetCharacter.getName() + " ha esquivado el ataque.");
		
		arrows--;
		System.out.println(attackerCharacter.getName() + " tiene " + arrows + " flechas disponibles.");
		
		return true;
	}
	
	private boolean isSuccessfullAttack(Character attackerCharacter, Character targetCharacter) {
		return Dice.roll(Dice.TWENTIE_SIDES_DICE) + Modifiers.getModifier(attackerCharacter.getSkill()) 
			>= targetCharacter.getArmorClass();
	}


}
