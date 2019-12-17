package com.bridgeLabz.objectOrientedPrograms.cards;

import java.util.Random;

/**
 * This class Shuffle function randomly assigned the value to each card place
 * and then print function prints the card received by all 4 Players.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-05
 * @version 11.0.5
 */

public class DeckOfCardsArray {
	private int[][] cardsArray;

	public DeckOfCardsArray() {
		cardsArray = new int[4][13];
	}

	/**
	 * Shuffling the card and assigning to each player 9 cards.
	 * 
	 * @param playerNumber
	 */
	public void assignCards(int playerNumber) {
		for (int i = 0; i < 9; i++) {
			shuffleCards(playerNumber);
		}
	}

	/**
	 * Randomly generate suits and rank recursively calls the function unless 0 is
	 * found in the 2D array if not found then assign card to that player.
	 * 
	 * @param playerNumber as integer Input parameter
	 */
	private void shuffleCards(int playerNumber) {
		Random random = new Random();
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		if (cardsArray[suit][rank] != 0)
			shuffleCards(playerNumber);
		else
			cardsArray[suit][rank] = playerNumber;
	}

	/**
	 * prints all the cards received by player 1, player 2, player 3, player 4
	 */
	public void print(int playerNumber) {
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				if (cardsArray[suit][rank] == playerNumber) {
					System.out.print(Cards.getSuit(suit) + " -> " + Cards.getRank(rank) + "\n");
				}
			}
		}
		System.out.println();
	}

}
