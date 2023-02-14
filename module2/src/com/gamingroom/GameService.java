package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamiId = 1;
	
	private static GameService GsSingleton = null; 
	/* 
	 * turn to singleton so that only one instance of class can exist at a time
	 * set to a private constructor so we don't instantiate any 
	 * additional instances outside of this class.
	 */

	public static GameService getInstance() { 
		if (GsSingleton == null) {            
			GsSingleton = new GameService();
			
		}

		return GsSingleton;
	}
	/*
	 * public accessor for our instance, 
	 * this allows outside classes to
	 * access objects in this singleton class.
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		Iterator itr = games.iterator();
		while (itr.hasNext()) {
			Game game1 = (Game) itr.next();

			if (name.equalsIgnoreCase(game1.getName())) {
				game = game1;
				
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 *
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 *
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		Iterator itr = games.iterator();
		while (itr.hasNext()) {
			Game game1 = (Game) itr.next();

			if (game1.getId() == id) {
				game = game1;
			}
		}
		// if found, simply assign that instance to the local variable
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 *
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable

		Iterator itr = games.iterator();
		while (itr.hasNext()) {
			Game game1 = (Game) itr.next();

			if (name.equalsIgnoreCase(game1.getName())) {
				game = game1;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 *
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	/**
	* Returns the team and player whose turn is next
	*
	* @return the team and player whose turn is next
	*/
	public long getNextPlayerId() {
		return nextPlayerId;
		}
	public long getNextTeamId() {
		return nextTeamiId;
		}
}