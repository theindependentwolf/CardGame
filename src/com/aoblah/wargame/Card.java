package com.aoblah.wargame;

/*
 * Card class - a card object would contain a number (value) and a suite 
 * 
 * 
 */
public class Card implements Comparable<Card> {
	private CardValue cardValue;
	private Suit suit;
	private String cardHolder;
	
	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Card(CardValue cardValue, Suit suit) {
		this.cardValue = cardValue;
		this.suit = suit;
	}

	public CardValue getCardValue() {
		return cardValue;
	}

	public void setCardValue(CardValue cardValue) {
		this.cardValue = cardValue;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public int compareTo(Card card) {
		int myRank = this.cardValue.getCardValue();
		int otherRank = card.cardValue.getCardValue();
		return Integer.compare(myRank, otherRank);		
	}

	@Override
	public String toString() {
		return cardValue + " of " + suit;
	}
	
}
