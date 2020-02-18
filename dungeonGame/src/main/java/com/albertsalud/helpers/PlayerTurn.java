package com.albertsalud.helpers;

import com.albertsalud.entities.Character;
import com.albertsalud.entities.Dungeon;
import com.albertsalud.main.Main;

public class PlayerTurn {
	
	private int remainingActions;
	private Character player;
	private Dungeon dungeon;
	
	
	public PlayerTurn(Dungeon dungeon, Character player) {
		this.remainingActions = 2;	// El jugador tiene dos acciones durante su turno
		this.player = player;
		this.dungeon = dungeon;
		
		System.out.println("Turno de " + player.getName());
		this.executeTurn();
	}


	private void executeTurn() {
		int selectedAction = 0;
		do {
			showTurnStatus();
			
			selectedAction = captureActionInput();
			
			if(executeAction(selectedAction)) {
				remainingActions--;
			}
			
			dungeon.printDungeon();
			
		} while (remainingActions > 0 && selectedAction != 4);
		
		System.out.println("Se ha acabado el turno de " + player.getName());
		
	}


	private boolean executeAction(int selectedAction) {
		switch(selectedAction) {
			case 1: 	// Mover
				return executeMovementAction();
			/*case 2:	// Atacar
				return executeAttackAction();
			case 3:	// Cambiar de arma
				return executeChangeWeaponAction();*/
			default:
				remainingActions = 0;
				Main.endOfGame = true;
				return true;
		}
		
	}


	private boolean executeMovementAction() {
		
		System.out.print("Indica las nuevas coordenadas de tu personaje (x,y) o 0,0 para cancelar: ");
		String coordinates;
		boolean actionExecuted = false;	// Indica si la acción se ha ejecutado correctamente
		boolean rigthEntry = false;	// Indica si se ha introducido un texto correcto por el teclado
		do {
			try {
				coordinates = KeyboardReader.getKeyboardInput();
				int xCoordinate = Integer.parseInt(coordinates.split(",")[0]);
				int yCoordinate = Integer.parseInt(coordinates.split(",")[1]);
			
				if(xCoordinate == 0 && yCoordinate == 0) break;
			
				if(!dungeon.isValidLocation(yCoordinate, xCoordinate) ||
					dungeon.isLocationBusy(yCoordinate, xCoordinate) != null
					) throw new Exception();
		
				
				actionExecuted = player.moveTo(xCoordinate, yCoordinate);
				rigthEntry = true;
				
			} catch (Exception e) {
				System.out.println("No has introducido unas coordenadas válidas...");
				System.out.print("Indica las nuevas coordenadas de tu personaje (x,y) o 0,0 para cancelar: ");
				
			}
			
		} while(!rigthEntry);
		
		return actionExecuted;
	}


	private int captureActionInput() {		
		boolean selectedAction = false;
		int action = 0;
		do {
			try {
				action = Integer.parseInt(KeyboardReader.getKeyboardInput());
				if(action < 1 || action > 4) throw new Exception();
				selectedAction = true;
			
			} catch (Exception e) {
				System.out.println("No has introducido un número de acción válido...");
				this.showTurnStatus();
			}
			selectedAction = true;
		} while(!selectedAction);
		
		return action;
	}


	private void showTurnStatus() {
		System.out.println("Tienes " + remainingActions + " accion/es disponible/s.");
		System.out.println("¿Qué deseas hacer? Elige una opción:");
		System.out.println("1) Mover a tu personaje.");
		System.out.println("2) Atacar.");
		System.out.println("3) Cambiar de arma.");
		System.out.println("4) Abandonar toda esperanza.");
		System.out.print("Indica aquí la acción deseada: ");
	}
	
	

}

