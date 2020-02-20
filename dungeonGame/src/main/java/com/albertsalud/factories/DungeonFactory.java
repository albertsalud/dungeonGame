package com.albertsalud.factories;

import com.albertsalud.entities.Dungeon;
import com.albertsalud.entities.characters.EnemyCharacter;
import com.albertsalud.entities.characters.PlayerCharacter;

public abstract class DungeonFactory {
	
	public static Dungeon createDungeon() {
		System.out.println("Generando mazmorra...");
		Dungeon dungeon = new Dungeon();
		
		System.out.println("Generando personaje jugador...");
		PlayerCharacter player = new PlayerCharacter(1, 1);
		dungeon.addCharacter(player);
		
		System.out.println("Generando enemigos...");
		RandomCoordinatesFactory randomCoordinates;
		do {
			randomCoordinates = new RandomCoordinatesFactory(dungeon);
		} while (dungeon.isLocationBusy(randomCoordinates.initialYCoordinate, randomCoordinates.initialXCoordinate) != null);
		
		EnemyCharacter enemy = new EnemyCharacter(randomCoordinates.initialXCoordinate, randomCoordinates.initialYCoordinate);
		dungeon.addCharacter(enemy);
		
		return dungeon;
		
	}
	
	private static class RandomCoordinatesFactory {
		int initialXCoordinate;
		int initialYCoordinate;
		
		private RandomCoordinatesFactory(Dungeon dungeon) {
			initialYCoordinate = (int) (Math.random() * (dungeon.getHeight() - 1)) + 1;
			initialXCoordinate = (int) (Math.random() * (dungeon.getWidth() - 1)) + 1;
			
		}
		
		//private static RandomCoordinatesFactory randomCoordinates;
		
	}

}
