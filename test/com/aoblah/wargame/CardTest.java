package com.aoblah.wargame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

	CardValue queen = CardValue.QUEEN;
	CardValue ace = CardValue.ACE;
	Suit hearts = Suit.HEARTS;
	Suit spades = Suit.SPADES;
	
			
	
	
	Card testCard = new Card(queen, hearts);
	Card testCard2 = new Card(ace, spades);

	@Test
	public void testCompareTo() {
		int actual = testCard.compareTo(testCard2);
		assertEquals(-1, actual);
	}

}
