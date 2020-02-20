package com.albertsalud.dungeongame.helpers;

import com.albertsalud.dungeongame.entities.Dungeon;
import com.albertsalud.dungeongame.entities.characters.PlayerCharacter;
import com.albertsalud.dungeongame.entities.characters.Character;
import com.albertsalud.dungeongame.main.Main;

public class PlayerTurn {
	
	private int remainingActions;
	private PlayerCharacter player;
	private Dungeon dungeon;
	
	
	public PlayerTurn(Dungeon dungeon, Character player) {
		this.remainingActions = 2;	// El jugador tiene dos acciones durante su turno
		this.player = (PlayerCharacter) player;
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
			case 2:	// Atacar
				return executeAttackAction();
			case 3:	// Cambiar de arma
				return executeChangeWeaponAction();
			default:
				remainingActions = 0;
				Main.endOfGame = true;
				return true;
		}
		
	}


	private boolean executeChangeWeaponAction() {
		boolean actionExecuted = false;	// Indica si la acción se ha ejecutado correctamente
		boolean rigthEntry = false;	// Indica si se ha introducido un texto correcto por el teclado
		
		int selectedWeapon;
		do {
			try {
				System.out.println("Selecciona el arma que deseas equipar, o 0 para cancelar: ");
				player.showAvailableWeapons();
				
				System.out.print("Indica qué arma quieres equipar: ");
				selectedWeapon = Integer.parseInt(KeyboardReader.getKeyboardInput());
			
				if(selectedWeapon == 0) break;
				
				actionExecuted = player.setEquipedWeapon(selectedWeapon);
				if(!actionExecuted) throw new Exception("No te has podido equipar con el arma seleccionada.");
				rigthEntry = true;
				
			} catch (NumberFormatException e) {
				System.out.println("El número que has introducido no es válido!");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
		} while(!rigthEntry);
		
		return actionExecuted;
	}


	private boolean executeAttackAction() {
		System.out.println("Vas a atacar con " + player.getEquipedWeapon().getName() + ".");
		System.out.print("Indica las coordenadas del personaje a atacar (x,y) o 0,0 para cancelar: ");
		
		boolean actionExecuted = false;	// Indica si la acción se ha ejecutado correctamente
		boolean rigthEntry = false;	// Indica si se ha introducido un texto correcto por el teclado
		
		String coordinates;
		do {
			try {
				coordinates = KeyboardReader.getKeyboardInput();
				int xCoordinate = Integer.parseInt(coordinates.split(",")[0]);
				int yCoordinate = Integer.parseInt(coordinates.split(",")[1]);
			
				if(xCoordinate == 0 && yCoordinate == 0) break;
			
				Character targetCharacter = dungeon.getCharacterAt(xCoordinate, yCoordinate);
				if(targetCharacter == null) throw new Exception("No hay nadie en la posición indicada!");
				if(targetCharacter.equals(player)) throw new Exception("No te puedes atacar a ti mismo!");
						
				actionExecuted = player.attackTo(targetCharacter);
				
				if(!targetCharacter.isStillAlive()) dungeon.removeCharacter(targetCharacter);
				rigthEntry = true;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.print("Indica las coordenadas del personaje a atacar (x,y) o 0,0 para cancelar: ");
				
			}
			
		} while(!rigthEntry);
		
		return actionExecuted;
		
	}


	private boolean executeMovementAction() {
		System.out.println("Tu personaje se puede mover hasta " + player.getSpeed() + " posiciones.");
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

