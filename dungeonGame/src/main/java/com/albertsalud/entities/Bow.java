package com.albertsalud.entities;

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
		
		// TODO tirar el dado para ver si acierta
		
		arrows--;
		targetCharacter.getDamage(this.getDamage());
		System.out.println("Te quedan " + arrows + " flechas disponibles.");
		
		return true;
	}


}
