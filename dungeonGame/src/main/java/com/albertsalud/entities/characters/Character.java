package com.albertsalud.entities.characters;

import com.albertsalud.entities.weapons.Weapon;

public abstract class Character {

	private String name;		// Nombre del personaje
	private int speed;			// Velocidad de movimiento
	private int strength;		// Fuerza
	private int intelligence;	// Inteligencia
	private int vitality;		// Vida
	
	private String dungeonMark;	// Icono (para pintar en la mazmorra)
	
	private int xCoordinate;	// Coordenada x de ubicacion
	private int yCoordinate;	// Coordenada y de ubicacion
	
	protected Weapon equipedWeapon;

	public Weapon getEquipedWeapon() {
		return equipedWeapon;
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

	protected void setDungeonMark(String dungeonMark) {
		this.dungeonMark = dungeonMark;
	}

	public String getDungeonMark() {
		return dungeonMark;
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
	
	protected void setEquipedWeapon(Weapon weapon) {
		this.equipedWeapon = weapon;
	}
	
	public void getDamage(int damage) {
		System.out.println(this.getName() + " sufre " + damage + " puntos de vida!");
		this.vitality -= damage;
		if(vitality > 0) System.out.println("Aún le quedan " + vitality + " puntos de vida.");
		else System.out.println("El personaje cae al suelo, derrotado.");
	}
	
	public boolean attackTo(Character targetCharacter) {
		return equipedWeapon.attack(this, targetCharacter);
	}
	
	public boolean isStillAlive() {
		return vitality > 0;
	}

}
