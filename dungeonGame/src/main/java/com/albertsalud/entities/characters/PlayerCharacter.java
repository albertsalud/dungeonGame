package com.albertsalud.entities.characters;

import java.util.ArrayList;
import java.util.List;

import com.albertsalud.entities.weapons.Bow;
import com.albertsalud.entities.weapons.ShotGun;
import com.albertsalud.entities.weapons.Sword;
import com.albertsalud.entities.weapons.Weapon;

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
		Weapon shotgun = new ShotGun();
		
		availableWeapons = new ArrayList<Weapon>(3);
		availableWeapons.add(0, sword);
		availableWeapons.add(1, bow);
		availableWeapons.add(2, shotgun);
		
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
