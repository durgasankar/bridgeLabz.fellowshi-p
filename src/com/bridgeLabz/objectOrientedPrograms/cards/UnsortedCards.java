package com.bridgeLabz.objectOrientedPrograms.cards;

/**
 * This class has the constructor which initialize the deck with sequential
 * order in sorted manner. Shuffle function randomly assigned the value to each
 * card place and then print function prints the card received by all 4
 * Players.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-05
 * @version 11.0.5
 */
public class UnsortedCards {
	private static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private int deckLength = SUITS.length * RANKS.length;
	private String[] deck = new String[deckLength];

	/**
	 * Constructor to initialize the deck with sequential order in sorted manner
	 * during object creation.
	 */
	public UnsortedCards() {
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				deck[SUITS.length * i + j] = RANKS[i] + " " + SUITS[j];
			}
		}
	}

	/**
	 * pick up each card starting from first index and replace the old data of old
	 * card and assign with new data.
	 */
	public void shuffleCard() {
		for (int i = 0; i < deck.length; i++) {
			int rcurrentCard = i + (int) (Math.random() * (deck.length - i));
			String temp = deck[rcurrentCard];
			deck[rcurrentCard] = deck[i];
			deck[i] = temp;
		}
	}

	/**
	 * prints all the cards received by player 1, player 2, player 3, player 4.
	 */
	public void displayCard() {
		System.out.println("Total number of cards in deck : " + deck.length);
		int player = 1;
		for (int i = 0; i < deck.length; i++) {
			if (i % 13 == 0) {
				System.out.println("\nplayer : " + player++ + "\n----------");
			}
			System.out.println(deck[i]);
		}
	}

}
