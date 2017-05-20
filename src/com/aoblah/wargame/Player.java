package com.aoblah.wargame;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	private LinkedList<Card> myCards;
	private boolean inGame;
	
	public Player(String name){
		this.myCards = new LinkedList<Card>();
		this.name = name;
		this.inGame = true;
	}

	/*
	 * Receive card during initial shuffle - card added to the end of the list
	 * 
	 */
	public void receiveCard(Card card){
		this.myCards.add(card);
	}
	
	
	/*
	 * Show card during battle (when all players show their card simulatneiously)
	 */
	public Card playCard(){
		return this.myCards.removeLast();
	}
	
	
	/*
	 * Check if the users hand is empty
	 */
	public boolean isHandEmpty(){
		if(this.myCards.isEmpty()){
			this.inGame = false;
			return true;
		}
		else{
			return false;
		}
	}

	
	/*
	 * Add winnings to the front (back of the deck) of the list
	 */
	
	public void addWinnings(Card card){
		this.myCards.addFirst(card);
	}
	
	
	/*
	 * Add war winnings to the front (back of the deck) of the list
	 */
	
	public void addWarWinnings(List<Card> cardList){
		this.myCards.addAll(0, cardList);
	}
	
	
	/*
	 * Check if a player is in the game - if he still has cards remaining
	 */
	
	public boolean isInGame(){
		return this.inGame;
	}
	
	
	/*
	 * Get number of cards in a pile
	 */
	
	public int getNumberOfCards(){
		return this.myCards.size();
	}
	
	
	/*
	 * Set card holder's name in the card
	 */
	
	public void setNameInCard(String cardHolder){
		this.myCards.getLast().setCardHolder(cardHolder);
	}
	
	
	/*
	 * Get Card holder's name
	 */
	
	public String getNameInCard(){
		return this.myCards.getLast().getCardHolder();
	}
	
	
	/*
	 * Set card holder Names in All cards
	 */
	
	public void setNamesInAllCards(String cardHolderName){
		for(Card card: this.myCards){
			card.setCardHolder(cardHolderName);
		}
	}
	
	
	
	/*
	 * Add list to back of deck (front of list)
	 */
	
	public void addCardsToBack(List<Card> cardList){
		for(Card card: myCards){
			this.myCards.addFirst(card);
		}
		
	}
	
	
	
	
	/*
	 * Get player's name
	 */
	public String getName(){
		return this.name;
	}
	
	
	/*
	 * Overriding the default toString method
	 * 
	 */
	
	@Override
	public String toString() {
		String playerCardInfo = this.name + "\n";
		if(!this.myCards.isEmpty()){
			for(Card card: myCards){
				playerCardInfo += card + ", ";
			}
		}
		return playerCardInfo;
	}
	
	
	
	
	
	
	
}
