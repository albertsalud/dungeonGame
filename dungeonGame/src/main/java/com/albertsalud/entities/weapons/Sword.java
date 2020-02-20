package com.albertsalud.entities.weapons;

import com.albertsalud.entities.characters.Character;
import com.albertsalud.helpers.Dice;

public class Sword extends Weapon {
	
	public Sword() {
		setName("la espada");
		setMaxDistance(1);
		setMinDistance(1);
		setDamage(5);
		
		description = "siempre fiable";
	}
	
	public boolean attack(Character attackerCharacter, Character targetCharacter) {
		
		if(!this.isAvailableAttack(attackerCharacter, targetCharacter)) {
			System.out.println("El enemigo no se encuentra a la distancia adecuada para atacar con la espada");
			return false;
		}
		
		if(Dice.roll(Dice.TWENTIE_SIDES_DICE) > 12) targetCharacter.getDamage(this.getDamage());
		else System.out.println("Fallaste! El enemigo ha esquivado el ataque.");
		
		return true;
	}
	
}
