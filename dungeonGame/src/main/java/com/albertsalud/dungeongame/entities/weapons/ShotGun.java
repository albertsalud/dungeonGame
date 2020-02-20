package com.albertsalud.dungeongame.entities.weapons;

import com.albertsalud.dungeongame.helpers.Dice;
import com.albertsalud.dungeongame.helpers.Modifiers;
import com.albertsalud.dungeongame.entities.characters.Character;

public class ShotGun extends Weapon {
	
	private int bullets;
	
	public ShotGun() {
		this.minDistance = 2;
		this.maxDistance = 10;
		this.name = "la escopeta";
		this.damageDice = Dice.TEN_SIDES_DICE;
		this.bullets = 5;
		
		description = "te quedan " + bullets + " balas disponibles";
	}

	@Override
	public boolean attack(Character attackerCharacter, Character targetCharacter) {
		if(!this.isAvailableAttack(attackerCharacter, targetCharacter)) {
			System.out.println("El enemigo no se encuentra a la distancia adecuada para atacar con el arco");
			return false;
		}
		
		if(bullets == 0) {
			System.out.println("No te quedan balas para disparar!");
		}
		
		if(isSuccessfullAttack(attackerCharacter, targetCharacter)) 
			targetCharacter.getDamage(Dice.roll(damageDice));
		else System.out.println("Fallo! " + targetCharacter.getName() + " ha esquivado el ataque.");
		
		bullets--;
		System.out.println(attackerCharacter.getName() + " tiene " + bullets + " balas disponibles.");
		
		return true;
	}
	
	private boolean isSuccessfullAttack(Character attackerCharacter, Character targetCharacter) {
		return Dice.roll(Dice.TWENTIE_SIDES_DICE) + Modifiers.getModifier(attackerCharacter.getSkill()) 
			>= targetCharacter.getArmorClass();
	}

}
