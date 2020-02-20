package com.albertsalud.helpers;

import com.albertsalud.entities.Dungeon;
import com.albertsalud.entities.characters.Character;
import com.albertsalud.entities.characters.EnemyCharacter;

public class EnemyTurn {
	
	private int remainingActions;
	private EnemyCharacter player;
	private Dungeon dungeon;
	
	
	public EnemyTurn(Dungeon dungeon, Character player) {
		this.remainingActions = 2;	// El jugador tiene dos acciones durante su turno
		this.player = (EnemyCharacter) player;
		this.dungeon = dungeon;
		
		System.out.println("Turno de " + player.getName());
		this.executeTurn();
	}


	private void executeTurn() {
		int selectedAction = 0;
		do {
			
			selectedAction = selectDesiredAction();
			
			if(executeAction(selectedAction)) {
				remainingActions--;
			}
			
			dungeon.printDungeon();
			
		} while (remainingActions > 0 && selectedAction != 4);
		
		System.out.println("Se ha acabado el turno de " + player.getName());
		
	}


	private int selectDesiredAction() {
		
		if(player.getEquipedWeapon().isAvailableAttack(player, dungeon.getMainCharacter())) {
			System.out.println("El enemigo decide atacarte!");
			return 2;
		} else {
			System.out.println("El enemigo se acerca peligrosamente!");
			return 1;
		}
		
	}


	private boolean executeAction(int selectedAction) {
		switch(selectedAction) {
			case 1: 	// Mover
				return executeMovementAction();
			case 2:	// Atacar
				return executeAttackAction();
			default:
				return true;
		}
		
	}


	/*private boolean executeChangeWeaponAction() {
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
	}*/


	private boolean executeAttackAction() {
		System.out.println("El enemigo te ataca con " + player.getEquipedWeapon().getName() + ".");
		
		boolean actionExecuted = false;	// Indica si la acción se ha ejecutado correctamente
		Character targetCharacter = dungeon.getMainCharacter();
		actionExecuted = player.attackTo(targetCharacter);
				
		if(!targetCharacter.isStillAlive()) dungeon.removeCharacter(targetCharacter);
		
		return actionExecuted;
		
	}


	private boolean executeMovementAction() {
		boolean actionExecuted = false;	// Indica si la acción se ha ejecutado correctamente
		
		// TODO programar movimiento del personaje enemigo
		
		/*Character targetCharacter = dungeon.getMainCharacter();
		
		int xCoordinateDifference = Math.abs(targetCharacter.getxCoordinate() - player.getxCoordinate());
		
		if(xCoordinateDifference >= player.getSpeed())*/
		
		
		
		actionExecuted = player.moveTo(1, 2);
		
		return actionExecuted;
	}

}
