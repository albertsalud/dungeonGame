package com.albertsalud.entities;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter extends Character {
	
	private List<Weapon> availableWeapons;
	
	public PlayerCharacter(int initialXCoordinate, int initialYCoordinate) {
		setCharacterFeatures();
		
		setInitialPosition(initialXCoordinate, initialYCoordinate);
		
		setAvailableWeapons();
	}

	private void setAvailableWeapons() {
		Weapon sword = new Sword();
		Weapon bow = new Bow();
		availableWeapons = new ArrayList<Weapon>(2);
		availableWeapons.add(0, sword);
		availableWeapons.add(1, bow);
		
		this.setEquipedWeapon(sword);
	}

	private void setInitialPosition(int initialXCoordinate, int initialYCoordinate) {
		this.setxCoordinate(initialXCoordinate);
		this.setyCoordinate(initialYCoordinate);
	}

	private void setCharacterFeatures() {
		this.setIntelligence(10);
		this.setName("Personaje jugador");
		this.setSpeed(3);
		this.setStrength(10);
		this.setVitality(10);
		this.setDungeonMark("P");
	}
	
	public void showAvailableWeapons() {
		int index = 0; 
		for(Weapon currentWeapon : availableWeapons) {
			index++;
			System.out.println(index + ") " + currentWeapon.getName() + (currentWeapon.equals(equipedWeapon) ? " [Equipada]" : "") 
					+ ": " + currentWeapon.getDescription());
		}
	}

	public boolean setEquipedWeapon(int selectedWeapon) {
		if(equipedWeapon.equals(availableWeapons.get(selectedWeapon - 1))) {
			System.out.println("El arma seleccionada ya está equipada!");
			return false;
		
		}
		
		equipedWeapon = availableWeapons.get(selectedWeapon - 1);
		System.out.println("Te has equipado con " + equipedWeapon.getName());
		return true;
	}
	
}
