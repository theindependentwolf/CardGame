package com.aoblah.wargame;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

	CardValue cardVal = CardValue.QUEEN;
	Suit suit = Suit.HEARTS;
	Player testPlayer = new Player("Adam");
	Card testCard = new Card(cardVal, suit);
	
	
	


	@Test
	public void testPlayCard() {
		testPlayer.addWinnings(testCard);
		testPlayer.addWinnings(testCard);
		testPlayer.playCard();
		assertEquals(1,testPlayer.getNumberOfCards());
	}

	@Test
	public void testIsHandEmpty() {
		assertNotNull(testPlayer.isHandEmpty());
	}


	@Test
	public void testGetNumberOfCards() {
		testPlayer.addWinnings(testCard);
		testPlayer.addWinnings(testCard);
		int numberOfCards = testPlayer.getNumberOfCards();
		assertEquals(2, numberOfCards);
	}

	@Test
	public void testSetNameInCard() {
		testPlayer.addWinnings(testCard);
		testPlayer.setNameInCard("Marcel");
		String actualName = testPlayer.getNameInCard();
		System.out.println(actualName);
		assertEquals("Marcel", actualName);
	}

	@Test
	public void testGetNameInCard() {
		testPlayer.addWinnings(testCard);
		testPlayer.setNameInCard("Marcel");
		String actualName = testPlayer.getNameInCard();
		System.out.println(actualName);
		assertEquals("Marcel", actualName);
	}


	@Test
	public void testGetName() {
		String actualName = testPlayer.getName();
		assertEquals("Adam", actualName);
	}

}
