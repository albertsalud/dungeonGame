package com.albertsalud.entities.weapons;

import com.albertsalud.entities.characters.Character;
import com.albertsalud.helpers.Dice;

public class Bow extends Weapon {
	
	private int arrows;
	
	public Bow() {
		this.setMinDistance(2);
		this.setMaxDistance(5);
		this.setName("el arco");
		this.setDamage(3);
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
		
		if(Dice.roll(Dice.TWENTIE_SIDES_DICE) > 12) targetCharacter.getDamage(this.getDamage());
		else System.out.println("Fallaste! El enemigo ha esquivado el ataque.");
		
		arrows--;
		System.out.println("Te quedan " + arrows + " flechas disponibles.");
		
		return true;
	}


}
