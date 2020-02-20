package com.albertsalud.main;

import com.albertsalud.entities.Dungeon;
import com.albertsalud.entities.characters.Character;
import com.albertsalud.factories.DungeonFactory;
import com.albertsalud.helpers.DungeonPrinter;
import com.albertsalud.helpers.EnemyTurn;
import com.albertsalud.helpers.PlayerTurn;

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
