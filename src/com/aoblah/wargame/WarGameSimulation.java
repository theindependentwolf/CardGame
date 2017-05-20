package com.aoblah.wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * This class contains the logic for the game. The logic for this game differs with the number of players.
 * When the number of players is 2, the WAR keeps happening until someone get a card of higher value or when a player runs out
 * out of cards.
 * 
 * When the number of players is 3 or 4, the winning decks of war go to a lucky winner, selected using randomization.
 */

public class WarGameSimulation {
	
	//Initializing all the variables to be used throughout all methods
	Deck deck;
	String playerName;
	List<Player> players;
	List<Card> winningList;
	List<Card> comparisonPool;
	Player player_1;
	Player player_2;
	Player winningPlayer;
	Card c1;
	Card c2;
	Random rando = null;
	private String cardHolderName; 

	
	
	// Constructor to initialize players and start game.
	public WarGameSimulation(int numberOfPlayers) throws InterruptedException{
		System.out.println("Initializing Game.");
		loadingAnimation(100);
		System.out.println();
		
		
		//Initializing New Standard Deck
		deck = new Deck();
		
		//Shuffling Deck
		deck.shuffleDeck();
		
		//initializing a list of players
		players = new LinkedList<Player>();
			
		
		//Creating players and adding them to 'players' list
		System.out.println("Players:\n----------");
		for(int playerIndex = 1; playerIndex <= numberOfPlayers; playerIndex++){
			playerName = "Player_" + playerIndex;
			System.out.println(playerName);
			players.add(new Player(playerName));
		}
		
		System.out.println();
		
		
		//Distribute cards to the players
		System.out.println("Dealing cards to the players. ");
		loadingAnimation(200);
		distributeCards(numberOfPlayers);
		System.out.println("Done");
		System.out.println();
		
		printPlayerCards();
		
		System.out.println();
		
		//Begin Game
		
		beginGame(numberOfPlayers);
		
	}
	
	
	/*
	 * The actual game - players show their cards simultaneously and person with the highest card value takes it.
	 * WAR happens when two or more players have the same number
	 * 
	 */
	private void beginGame(int numberOfPlayers) {
		System.out.println("Let the WAR GAME begin!!!");
		System.out.println();
		
		winningList = new ArrayList<Card>();
		
		/*
		 * Game logic for when the number of players is two
		 * 
		 */
		
		if (numberOfPlayers == 2){ 
			//player 1 and 2
			player_1 = players.get(0);
			player_2 = players.get(1);

			
			do{
				
				//Two cards C1 and C2 played by both players
				c1 = player_1.playCard();
				c2 = player_2.playCard();				
				
				//If player 1 has higher ranked cards, he takes the winnings, and vice-versa.
				if(c1.compareTo(c2) > 0){
					System.out.println("Player 1: " + c1);
					System.out.println("Player 2: " + c2);
					System.out.println("Player 1 wins round");
					player_1.addWinnings(c2);
					player_1.addWinnings(c1);
				}
				else if(c1.compareTo(c2) < 0){
					System.out.println("Player 1: " + c1);
					System.out.println("Player 2: " + c2);
					System.out.println("Player 2 wins round");
					player_2.addWinnings(c1);
					player_2.addWinnings(c2);
				}
				/*
				 * If both players have cards of the same value, they go to WAR. They keep playing cards, until
				 * one of them get a higher number and take all the winnings. 
				 */
				else{
					System.out.println("Player 1: " + c1);
					System.out.println("Player 2: " + c2);
					System.out.println("W A R !!!");
					
					//Adding to the prize deck for the war
					winningList.add(c1);
					winningList.add(c2);
					
					
					
					while(!player_1.isHandEmpty() && !player_2.isHandEmpty()){
						
						c1 = player_1.playCard();
						c2 = player_2.playCard();
						
						/*
						 * Adding an extra card from each player to the prize deck. This card's value is not 
						 * seen as it's face down.
						 *   
						 */
						winningList.add(c1);
						winningList.add(c2);
						
						if(!player_1.isHandEmpty() && !player_2.isHandEmpty()){	
							
							c1 = player_1.playCard();
							c2 = player_2.playCard();
										
							
							if(c1.compareTo(c2) > 0){
								System.out.println("Player 1: " + c1);
								System.out.println("Player 2: " + c2);
								System.out.println("Player 1 wins the war");
								player_1.addWinnings(c1);
								player_1.addWinnings(c2);
								player_1.addWarWinnings(winningList);
								winningList.clear();
								printNumberOfCards();
								break;
							}
							else if(c2.compareTo(c1) > 0){
								System.out.println("Player 1: " + c1);
								System.out.println("Player 2: " + c2);
								System.out.println("Player 2 wins the war");
								player_1.addWinnings(c1);
								player_1.addWinnings(c2);
								player_2.addWarWinnings(winningList);
								winningList.clear();
								printNumberOfCards();
								break;
							}
							else{
								System.out.println("Another war!");
								winningList.add(c1);
								winningList.add(c2);
							}
							
						}
											
						
					}
				}
				
				System.out.println();
				
			}while(!player_1.isHandEmpty() && !player_2.isHandEmpty());
			
			
			
			/*
			 * Printing out the winner of the game
			 */
			
			if(player_1.isHandEmpty()){
				if(!winningList.isEmpty())
					player_2.addWarWinnings(winningList);
				printNumberOfCards();
				System.out.println("Player 2 is the winner !!!");
			}else{
				if(!winningList.isEmpty())
					player_2.addWarWinnings(winningList);
				printNumberOfCards();
				System.out.println("Player 1 is the winner !!!");
				
			}
			
			
			
		}
		
		
		else{
			
			/*
			 * 
			 * More than 2 players (2-4 players)
			 * 
			 */
			
			moreThanTwo();
				
		}
		
	}

	
	
	/*
	 * War Game for more than 2 players (2-4 players). 
	 * 
	 * Logic: Player with highest ranked card takes all the cards and in the case of war, the winning cards go to
	 * a lucky winner selected using randomization
	 * 
	 */
	
	private void moreThanTwo(){
		winningList.clear();
		//This array list is used to compare all the cards
		comparisonPool = new ArrayList<Card>(); // ArrayList is slightly faster for sorting in Java 8 
		
		
		//Setting player names in the card which will later be used in linking card and the holder while doing comparisons
		for(Player playerr: players){
			playerr.setNamesInAllCards(playerr.getName());
		}
	
		
		do{
	
			//Adding cards to comparison index

			for(int playerIndex = 0; playerIndex < players.size(); playerIndex++){

				if(!players.get(playerIndex).isHandEmpty()){
					comparisonPool.add(players.get(playerIndex).playCard());
				}
				else{
					players.remove(playerIndex);
				}

			}

			//Sorting the cards in descending order
			
			Collections.sort(comparisonPool, Collections.reverseOrder());

			printCardsInComparisonPool(comparisonPool);
			
			
			// Player with higher ranked card gets all the cards
			
			if(comparisonPool.size() > 1){
				if(comparisonPool.get(0).compareTo(comparisonPool.get(1)) > 0){
					//Add all cards in the pool to winning hand
					cardHolderName = comparisonPool.get(0).getCardHolder();
					System.out.println(cardHolderName + " wins round.");
					System.out.println();
					for(Player p: players){
						if(p.getName().equals(cardHolderName)){
							p.addWarWinnings(comparisonPool);
							comparisonPool.clear();
							break;
						}
					}
				}
				
				// If top2 cards are same, then a lucky winner is selected to take all the cards
				
				else{
					System.out.println("There is a war!!! A War!!! A War!!!!!!!!!!!!!!");
					System.out.println();

					//Anybody can win -- a random player is chosen and given the spoils of the war
					winningPlayer = getRandomPlayer();
					System.out.println("Lucky Winner is " + winningPlayer.getName());
					System.out.println();
					winningPlayer.addWarWinnings(comparisonPool);
					comparisonPool.clear();
					printNumberOfCards();

				}
			}
			

		}while(players.size() > 1);
		

		System.out.println();
		if(comparisonPool.isEmpty())
			players.get(0).addWarWinnings(comparisonPool);
		
		if(winningList.isEmpty())
			players.get(0).addWarWinnings(winningList);
		
		System.out.println(players.get(0).getName() + " wins the game!");
		

		
	}
	


	/*
	 * Distribute cards evenly to all players. In case of odd number of players, 
	 * player 1 gets an extra card. 
	 * 
	 */
	private void distributeCards(int numberOfPlayers){
		
		if(numberOfPlayers == 3){
			players.get(0).receiveCard(deck.dealDeck());
		}
		while(!deck.isDeckEmpty()){
			for(Player player: players){
				player.receiveCard(deck.dealDeck());
			}
		}

	}
	
	
	/*
	 * Graphics/Animation for loading
	 */
	private void loadingAnimation(int milliseconds) throws InterruptedException{
		for(int i = 0; i < 10; i++){
			System.out.print(".");
			Thread.sleep(milliseconds);
		}
		System.out.println();
	}
	
	
	
	/*
	 * Print All the players' card info
	 */
	private void printPlayerCards(){
		for(Player player: players){
			System.out.println(player);
			System.out.println(player.getNumberOfCards());
			System.out.println();
		}
	}
	
	
	/*
	 * print cards in Comparison pool
	 * 
	 */
	
	private void printCardsInComparisonPool(List<Card> cardList){
		for(Card card: cardList){
			System.out.println(card);
		}
	}
	
	
	/*
	 * Get Random index from the list
	 */
	
	private Player getRandomPlayer(){
		int listSize = players.size();
		Player player = players.get(new Random().nextInt(listSize));
		return player;
	}
	
	
	/*
	 * Get number of cards with each player
	 */
	private void printNumberOfCards(){
		int totalNumberOfCards = 0;
		for(Player player: players){
			totalNumberOfCards += player.getNumberOfCards();
			System.out.println(player.getName() + " has " + player.getNumberOfCards() + " cards.");
		}
		System.out.println("Total number of cards: " + totalNumberOfCards);
		System.out.println();
	}
	
	
	
}
