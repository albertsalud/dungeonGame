package com.albertsalud.entities.weapons;

import com.albertsalud.entities.characters.Character;
import com.albertsalud.helpers.Dice;

public class ShotGun extends Weapon {
	
	private int bullets;
	
	public ShotGun() {
		this.setMinDistance(2);
		this.setMaxDistance(10);
		this.setName("la escopeta");
		this.setDamage(20);
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
		
		if(Dice.roll(Dice.TWENTIE_SIDES_DICE) > 12) targetCharacter.getDamage(this.getDamage());
		else System.out.println("Fallaste! El enemigo ha esquivado el ataque.");
		
		bullets--;
		System.out.println("Te quedan " + bullets + " balas disponibles.");
		
		return true;
	}

}
