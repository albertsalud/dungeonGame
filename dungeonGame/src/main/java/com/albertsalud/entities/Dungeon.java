package com.albertsalud.entities;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
	
	private List<Character> dungeonCharacters;

	private int height;
	private int width;
	
	public Dungeon() {
		this(8, 8);
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
	
	public String printDungeon() {
		StringBuilder dungeonPrint = new StringBuilder();
		
		dungeonPrint.append(printHorizontalFrame());
		
		for(int i = 1; i <= this.height; i ++) {
			for(int j = 1; j <= this.width; j++) {
				if (j == 1) dungeonPrint.append(i + " |");
				dungeonPrint.append(checkCurrentLocation(i, j));
				
			}
			dungeonPrint.append("\n");
		}
		
		return dungeonPrint.toString();
		
	}
	
	public void addCharacter(Character newCharacter) {
		dungeonCharacters.add(newCharacter);
	}

	private String checkCurrentLocation(int yCoordinate, int xCoordinate) {
		Character dungeonCharacter = isCurrentLocationBusy(yCoordinate, xCoordinate);
		if(dungeonCharacter != null) return "_" + dungeonCharacter.getDungeonMark() + "_|"; 
		else return "___|";
	}

	private Character isCurrentLocationBusy(int yCoordinate, int xCoordinate) {
		for(Character currentCharacter : dungeonCharacters) {
			if(currentCharacter.getxCoodinate() == xCoordinate &&
					currentCharacter.getyCoordinate() == yCoordinate) return currentCharacter;
		}
		
		return null;
	}

	private String printHorizontalFrame() {
		StringBuilder horizontalFrame = new StringBuilder();
		horizontalFrame.append("   ");	// Espacio para marco vertical
		
		for(int i = 1; i <= this.width; i++) {
			horizontalFrame.append(" " + i + "  ");
		}
		
		horizontalFrame.append("\n");
		horizontalFrame.append("   ");	// Espacio para marco vertical
		
		for(int i = 1; i <= this.width; i++) {
			horizontalFrame.append("____");
		}
		horizontalFrame.append("\n");
		return horizontalFrame.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Creando mazmorra\n");
		Dungeon dungeon = new Dungeon(6, 10);
		System.out.println(dungeon.printDungeon());
		
		Character player = new PlayerCharacter();
		
		dungeon.addCharacter(player);
		System.out.println("Personaje jugador cargado en el sistema\n");
		
		System.out.println(dungeon.printDungeon());
		player.moveTo(8, 5);
		
		System.out.println("Personaje jugador movido!\n");
		System.out.println(dungeon.printDungeon());
		
		player.moveTo(2, 3);
		System.out.println("Personaje jugador movido!\n");
		System.out.println(dungeon.printDungeon());
		
	}
	
	
}
