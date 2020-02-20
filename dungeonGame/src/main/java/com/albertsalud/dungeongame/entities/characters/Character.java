package com.albertsalud.dungeongame.entities.characters;

import com.albertsalud.dungeongame.entities.weapons.Weapon;
import com.albertsalud.dungeongame.helpers.Modifiers;

public abstract class Character {

	protected String name;		// Nombre del personaje
	protected int speed;		// Velocidad de movimiento
	protected int strength;		// Fuerza. Determinante para el combate cuerpo a cuerpo.
	protected int skill;		// Destreza. Determinante para las armas a distancia.
	protected int intelligence;	// Inteligencia
	protected int vitality;		// Vida
	protected int armorClass;	// Clase de armadura. Indica la dificultad para recibir impactos (1-20) 
	
	public int getArmorClass() {
		return armorClass;
	}

	protected void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	protected String dungeonMark;	// Icono (para pintar en la mazmorra)
	
	protected int xCoordinate;	// Coordenada x de ubicacion
	protected int yCoordinate;	// Coordenada y de ubicacion
	
	protected Weapon equipedWeapon;

	public Weapon getEquipedWeapon() {
		return equipedWeapon;
	}
	
	protected void setEquipedWeapon(Weapon weapon) {
		this.equipedWeapon = weapon;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	protected void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	protected void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getVitality() {
		return vitality;
	}

	protected void setVitality(int vitality) {
		this.vitality = vitality;
	}
	
	public String getDungeonMark() {
		return dungeonMark;
	}

	protected void setDungeonMark(String dungeonMark) {
		this.dungeonMark = dungeonMark;
	}


	public int getxCoordinate() {
		return xCoordinate;
	}

	protected void setxCoordinate(int xCoodinate) {
		this.xCoordinate = xCoodinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	protected void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public int getSkill() {
		return skill;
	}
	
	protected void setSkill(int skill) {
		this.skill = skill;
	}
	
	public void getDamage(int damage) {
		System.out.println(this.getName() + " sufre " + damage + " puntos de vida!");
		this.vitality -= damage;
		if(vitality > 0) System.out.println(this.getName() + " aún tiene " + vitality + " puntos de vida.");
		else System.out.println(this.getName() + " cae al suelo, derrotado.");
	}
	
	public boolean attackTo(Character targetCharacter) {
		return equipedWeapon.attack(this, targetCharacter);
	}
	
	public boolean isStillAlive() {
		return vitality > 0;
	}

	
	public boolean moveTo(int xCoordinate, int yCoordinate) {
		if(checkForAvailableMovement(xCoordinate, yCoordinate)) {
			this.setxCoordinate(xCoordinate);
			this.setyCoordinate(yCoordinate);
			System.out.println("El personaje se ha movido a (" + xCoordinate + ", " + yCoordinate + ")");
			
			return true;
		
		} else {
			System.out.println("No se puede mover el personaje a (" + xCoordinate + ", " + yCoordinate + "), está demasiado lejos!");
			return false;
		}
	}

	private boolean checkForAvailableMovement(int xDestinationCoordinate, int yDestinationCoordinate) {
		if(Math.abs(xDestinationCoordinate - this.xCoordinate) + Math.abs(yDestinationCoordinate - this.yCoordinate) <= this.speed) return true;
		return false;
		
	}
	
	public void printFeatures() {
		System.out.println("Características del personaje:");
		System.out.println("Fuerza: " + this.strength + " (" + Modifiers.getModifier(this.strength) + ")");
		System.out.println("Destreza: " + this.skill + " (" + Modifiers.getModifier(this.skill) + ")");
		System.out.println("Inteligencia: " + this.intelligence + " (" + Modifiers.getModifier(this.intelligence) + ")");
	}

}
