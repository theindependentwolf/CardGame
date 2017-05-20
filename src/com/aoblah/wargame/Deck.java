package com.aoblah.wargame;

import java.util.Collections;
import java.util.Stack;
 
/*
 * Deck Class: A deck contains 52 cards. This is created using an Stack of Card objects
 * and then shuffled.
 *  
 */

public class Deck
{
  private Stack<Card> deck;
 
  
  // Constructor to make a deck of 52 cards
  public Deck ()
  {
    this.deck = new Stack<Card>();

    
    for (CardValue cardVal: CardValue.values()){
    	for(Suit suit: Suit.values()){
    		this.deck.add(new Card(cardVal, suit));
    	}
    }
  }
  
  /*
   * Shuffling the deck of cards
   */
  public void shuffleDeck(){
	  if(!deck.isEmpty()){
		  Collections.shuffle(this.deck);  
	  }
    
  }
  
  /*
   * Prints the entire deck of cards
   */
  public void printDeck(){
	  for(Card card:this.deck){
		  System.out.println(card.getCardValue() + " of " + card.getSuit());
	  }
  }
  
  /*
   * This removes the top element of the stack and is used in card distribution
   */
  public Card dealDeck(){
	  return this.deck.pop();
  }
  
  
  /*
   * Method to check if the deck is empty
   */
  public boolean isDeckEmpty(){
	  return this.deck.empty();
  }
  
  
  
}