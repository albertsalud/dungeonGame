package com.albertsalud.dungeongame.main;

import com.albertsalud.dungeongame.entities.Dungeon;
import com.albertsalud.dungeongame.entities.characters.Character;
import com.albertsalud.dungeongame.factories.DungeonFactory;
import com.albertsalud.dungeongame.helpers.DungeonPrinter;
import com.albertsalud.dungeongame.helpers.EnemyTurn;
import com.albertsalud.dungeongame.helpers.PlayerTurn;

public class Main {
	
	public static boolean endOfGame = false;
	
	public static void main(String[] args) {
		
		Dungeon dungeon = DungeonFactory.createDungeon();
		DungeonPrinter printer = new DungeonPrinter();
		dungeon.setDungeonPrinter(printer);
		
		dungeon.printDungeon();
		
		do {
			for(Character currentCharacter : dungeon.getCharacters()) {
				executeCharacterTurn(dungeon, currentCharacter);
			}
			
		} while(!endOfGame);
		
		System.out.println("Fin de la partida. ¡Hasta la próxima!");
		
	}

	private static void executeCharacterTurn(Dungeon dungeon, Character currentCharacter) {
		if(currentCharacter.getDungeonMark().contentEquals("P")) new PlayerTurn(dungeon, currentCharacter);
		else new EnemyTurn(dungeon, currentCharacter);
		
	}

}
