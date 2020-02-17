package com.albertsalud.entities;

public class Dungeon {

	private int height;
	private int width;
	
	public Dungeon() {
		this(8, 8);
	}
	
	public Dungeon(int height, int width) {
		this.height = height;
		this.width = width;
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
				
				dungeonPrint.append("___|");
				
			}
			dungeonPrint.append("\n");
		}
		
		return dungeonPrint.toString();
		
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
		
		Dungeon dungeon = new Dungeon(6, 10);
		System.out.println(dungeon.printDungeon());
		
	}
	
	
}
