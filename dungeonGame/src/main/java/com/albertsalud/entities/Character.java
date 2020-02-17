package com.albertsalud.entities;

public abstract class Character {

	private String name;
	private int speed;
	private int strength;
	private int intelligence;
	private int vitality;
	
	private String dungeonMark;
	
	private int xCoodinate;
	private int yCoordinate;

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

	public int getxCoodinate() {
		return xCoodinate;
	}

	protected void setxCoodinate(int xCoodinate) {
		this.xCoodinate = xCoodinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	protected void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public void moveTo(int xCoordinate, int yCoordinate) {
		if(checkForAvailableMovement(xCoordinate, yCoordinate)) {
			this.setxCoodinate(xCoordinate);
			this.setyCoordinate(yCoordinate);
			System.out.println("El personaje se ha movido a (" + xCoordinate + ", " + yCoordinate + ")");
		} else {
			System.out.println("No se puede mover el personaje a (" + xCoordinate + ", " + yCoordinate + "), está demasiado lejos!");
		}
	}

	private boolean checkForAvailableMovement(int xDestinationCoordinate, int yDestinationCoordinate) {
		if(Math.abs(xDestinationCoordinate - this.xCoodinate) + Math.abs(yDestinationCoordinate - this.yCoordinate) <= this.speed) return true;
		return false;
		
	}

}
