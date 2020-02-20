package com.albertsalud.helpers;

import com.albertsalud.entities.Dungeon;
import com.albertsalud.entities.characters.Character;

public class DungeonPrinter {
	
	private Dungeon dungeon;
	
	public DungeonPrinter() {}
	
	public void printDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
		
		StringBuilder dungeonPrint = new StringBuilder();
		
		dungeonPrint.append(printHorizontalFrame());
		
		for(int i = 1; i <= dungeon.getHeight(); i ++) {
			for(int j = 1; j <= dungeon.getWidth(); j++) {
				if (j == 1) dungeonPrint.append(i + " |");
				dungeonPrint.append(checkCurrentLocation(i, j));
				
			}
			dungeonPrint.append("\n");
		}
		
		System.out.println(dungeonPrint.toString());
		
	}
	
	
	private String checkCurrentLocation(int yCoordinate, int xCoordinate) {
		Character dungeonCharacter = dungeon.isLocationBusy(yCoordinate, xCoordinate);
		if(dungeonCharacter != null) return "_" + dungeonCharacter.getDungeonMark() + "_|"; 
		else return "___|";
	}
	
	
	private String printHorizontalFrame() {
		StringBuilder horizontalFrame = new StringBuilder();
		horizontalFrame.append("   ");	// Espacio para marco vertical
		
		for(int i = 1; i <= dungeon.getWidth(); i++) {
			horizontalFrame.append(" " + i + "  ");
		}
		
		horizontalFrame.append("\n");
		horizontalFrame.append("   ");	// Espacio para marco vertical
		
		for(int i = 1; i <= dungeon.getWidth(); i++) {
			horizontalFrame.append("____");
		}
		horizontalFrame.append("\n");
		return horizontalFrame.toString();
	}

}
