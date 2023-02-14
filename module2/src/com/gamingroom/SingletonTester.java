package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		GameService service = GameService.getInstance(); 
		/*
		 * this get the instance from the game service in order to produce an out put
		 */
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
		System.out.println(service.getGame(i));
		}

	}
}
