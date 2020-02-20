package com.albertsalud.dungeongame.entities.weapons;

import com.albertsalud.dungeongame.helpers.Dice;
import com.albertsalud.dungeongame.helpers.Modifiers;
import com.albertsalud.dungeongame.entities.characters.Character;

public class Sword extends Weapon {
	
	public Sword() {
		name = "la espada";
		maxDistance = 1;
		minDistance = 1;
		damageDice = Dice.SIX_SIDES_DICE;
		
		description = "siempre fiable";
	}
	
	public boolean attack(Character attackerCharacter, Character targetCharacter) {
		
		if(!this.isAvailableAttack(attackerCharacter, targetCharacter)) {
			System.out.println("El enemigo no se encuentra a la distancia adecuada para atacar con la espada");
			return false;
		}
		
		if(isSuccessfullAttack(attackerCharacter, targetCharacter)) {
			int damage = Dice.roll(damageDice) + Modifiers.getModifier(attackerCharacter.getStrength());
			targetCharacter.getDamage(damage <= 0 ? 1 : damage);
		}
			
		else System.out.println("Fallo! " + targetCharacter.getName() + " ha esquivado el ataque.");
		
		return true;
	}

	private boolean isSuccessfullAttack(Character attackerCharacter, Character targetCharacter) {
		return Dice.roll(Dice.TWENTIE_SIDES_DICE) + Modifiers.getModifier(attackerCharacter.getStrength()) 
			>= targetCharacter.getArmorClass();
	}
	
}
