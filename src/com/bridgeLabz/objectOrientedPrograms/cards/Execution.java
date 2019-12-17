package com.bridgeLabz.objectOrientedPrograms.cards;

/**
 * Implementation of card playing
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-05
 * @version 11.0.5
 */
public class Execution {
	public static void main(String[] args) {
		DeckOfCardsArray deckOfCardsArraySorted = new DeckOfCardsArray();
		for (int playerNumber = 1; playerNumber <= 4; playerNumber++) {
			deckOfCardsArraySorted.assignCards(playerNumber);
			System.out.println("Player " + playerNumber + "\n---------");
			deckOfCardsArraySorted.print(playerNumber);
		}
		
		System.out.println("Second Test running...\n----------------------\n");

		UnsortedCards execution = new UnsortedCards();
		execution.shuffleCard();
		execution.displayCard();

	}

}
