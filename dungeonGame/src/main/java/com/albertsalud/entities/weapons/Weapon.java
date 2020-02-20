package com.albertsalud.entities.weapons;

import com.albertsalud.entities.characters.Character;

public abstract class Weapon {

	private String name;
	private int minDistance;
	private int maxDistance;
	
	private int damage;
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

	public int getDamage() {
		return damage;
	}

	protected void setDamage(int damage) {
		this.damage = damage;
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
