package com.albertsalud.dungeongame.entities.weapons;

import com.albertsalud.dungeongame.entities.characters.Character;

public abstract class Weapon {

	protected String name;
	protected int minDistance;
	protected int maxDistance;
	
	protected int damageDice;
	protected String description;
	
	public abstract boolean attack(Character attackerCharacter, Character targetCharacter);

	public int getMinDistance() {
		return minDistance;
	}
	
	public int getMaxDistance() {
		return maxDistance;
	}

	protected void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	protected void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public int getDamageDice() {
		return damageDice;
	}

	protected void setDamageDice(int damage) {
		this.damageDice = damage;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	public boolean isAvailableAttack(Character attackerCharacter, Character targetCharacter) {
		int distanceBetweenCharacters = Math.abs(attackerCharacter.getxCoordinate() - targetCharacter.getxCoordinate())
		+ Math.abs(attackerCharacter.getyCoordinate() - targetCharacter.getyCoordinate());
		
		return getMinDistance() <= distanceBetweenCharacters && distanceBetweenCharacters <= getMaxDistance(); 
	}
	
	public String getDescription() {
		return description;
	}
	
	
}
