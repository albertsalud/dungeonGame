package com.albertsalud.dungeongame.helpers;

import java.util.Scanner;

public abstract class KeyboardReader {
	
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public static String getKeyboardInput() {
		return scanner.next();
	}

}
