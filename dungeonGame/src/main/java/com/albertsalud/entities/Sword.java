package com.albertsalud.entities;

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
		
		// TODO tirar el dado para ver si acierta
		targetCharacter.getDamage(this.getDamage());
		
		return true;
	}
	
}
