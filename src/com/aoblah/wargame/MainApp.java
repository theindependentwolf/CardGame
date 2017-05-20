package com.aoblah.wargame;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * MainApp - contains the main method. This gets the number of players from the config/properties file and 
 * starts the game
 * 
 */
public class MainApp {

	public static Properties prop = new Properties(); 
	public static FileInputStream warGameProperties = null;
	public static final int DEFAULT_NO_OF_PLAYERS = 2;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Loading configuration file for number of players
		warGameProperties = new FileInputStream("./wargame.properties");
		prop.load(warGameProperties);
		
		//Getting the number of players from the properties file and converting it to an integer
		int numberOfPlayers = getNumberOfPlayers(prop.getProperty("numberOfPlayers"), DEFAULT_NO_OF_PLAYERS);
		
		
		//Starting the game if the number of players is between 2 and 4
		if(numberOfPlayers > 4){
			System.out.println("Game can accommodate only 4 players. Sorry!");
		}
		else if(numberOfPlayers < 2){
			System.out.println("There must be at least 2 players. Sorry!");
		}
		else{
			new WarGameSimulation(numberOfPlayers);
		}
		
	}
	
	
	/*
	 * Method to convert String (Number of players) to Integer or return a default value of two
	 * define using DEFAULT_NO_OF_PLAYERS, if string cannot be converted into integer.
	 *  
	 */
	public static int getNumberOfPlayers(String stringToConvert, int defaultValue) {
	    try {
	        return Integer.parseInt(stringToConvert);
	    }
	    catch (NumberFormatException e) {
	        return defaultValue;
	    }
	}
	
	

}
