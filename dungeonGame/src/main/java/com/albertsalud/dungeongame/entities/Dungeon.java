package com.albertsalud.dungeongame.entities;

import java.util.ArrayList;
import java.util.List;

import com.albertsalud.dungeongame.helpers.DungeonPrinter;
import com.albertsalud.dungeongame.entities.characters.Character;

public class Dungeon {
	
	private static final int MAX_DUNGEON_WITH = 8;
	private static final int MAX_DUNGEON_HEIGHT = 8;
	
	private List<Character> dungeonCharacters;
	private DungeonPrinter dungeonPrinter;

	private int height;
	private int width;
	
	public Dungeon() {
		int height = (int) (Math.random() * (MAX_DUNGEON_HEIGHT - 1)) + 1;
		if(height < 3) height = 3;
		
		int width = (int) (Math.random() * (MAX_DUNGEON_WITH - 1)) + 1;
		if(width < 3) width = 3;
		
		this.height = height;
		this.width = width;
		
		dungeonCharacters = new ArrayList<Character>();
		
	}
	
	public Dungeon(int height, int width) {
		this.height = height;
		this.width = width;
		
		dungeonCharacters = new ArrayList<Character>();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void addCharacter(Character newCharacter) {
		dungeonCharacters.add(newCharacter);
	}
	
	public List<Character> getCharacters(){
		return this.dungeonCharacters;
	}
	
	public boolean isValidLocation(int yCoordinate, int xCoordinate) {
		if(yCoordinate < 0 || yCoordinate > this.height) return false;
		if(xCoordinate < 0 || xCoordinate > this.width) return false;
		
		return true;
	}
	
	public Character isLocationBusy(int yCoordinate, int xCoordinate) {
		for(Character currentCharacter : dungeonCharacters) {
			if(currentCharacter.getxCoordinate() == xCoordinate &&
					currentCharacter.getyCoordinate() == yCoordinate) return currentCharacter;
		}
		
		return null;
	}

	public void setDungeonPrinter(DungeonPrinter dungeonPrinter) {
		this.dungeonPrinter = dungeonPrinter;
	}
	
	public void printDungeon() {
		dungeonPrinter.printDungeon(this);
	}
	
	public Character getCharacterAt(int xCoordinate, int yCoordinate) {
		for(Character currentCharacter : dungeonCharacters) {
			if(currentCharacter.getxCoordinate() == xCoordinate &&
					currentCharacter.getyCoordinate() == yCoordinate) return currentCharacter;
		}
		
		return null;
	}

	public void removeCharacter(Character targetCharacter) {
		dungeonCharacters.remove(targetCharacter);
		
	}
	
	public Character getMainCharacter() {
		return dungeonCharacters.get(0);
	}

	
}
