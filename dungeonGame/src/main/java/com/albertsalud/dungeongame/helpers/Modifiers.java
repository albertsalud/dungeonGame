package com.albertsalud.dungeongame.helpers;

import java.util.HashMap;
import java.util.Map;


public abstract class Modifiers {
	
	private static Map<Integer, Integer> modifiers;
	
	static {
		modifiers = new HashMap<Integer, Integer>();
		
		modifiers.put(1, -5);
		modifiers.put(2, -4);
		modifiers.put(3, -4);
		modifiers.put(4, -3);
		modifiers.put(5, -3);
		modifiers.put(6, -2);
		modifiers.put(7, -2);
		modifiers.put(8, -1);
		modifiers.put(9, -1);
		modifiers.put(10, 0);
		modifiers.put(11, 0);
		modifiers.put(12, 1);
		modifiers.put(13, 1);
		modifiers.put(14, 2);
		modifiers.put(15, 2);
		modifiers.put(16, 3);
		modifiers.put(17, 3);
		modifiers.put(18, 4);
		modifiers.put(19, 4);
		modifiers.put(20, 5);
		
	}
	
	public static int getModifier(Integer featureValue) {
		return modifiers.get(featureValue);
	}

}
