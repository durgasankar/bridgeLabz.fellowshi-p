package com.bridgeLabz.objectOrientedPrograms.cards;

/**
 * This class has suits and rank when ever it is called it randomly generate a
 * number between suits and cards range and based on that number it picks up the
 * card.
 * 
 * @author Durgasankar Mishra
 * @created 2019-12-05
 * @version 11.0.5
 */
public class Cards {

	private String suit;
	private String rank;

	/**
	 * Initialize during object creation.
	 * 
	 * @param suit as input parameter.
	 * @param rank as input parameter.
	 */
	public Cards(int suit, int rank) {
		this.suit = getSuit(suit);
		this.rank = getRank(rank);
	}

	/**
	 * returns Suite name of the card.
	 * 
	 * @return String value.
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * returns rank of the card.
	 * 
	 * @return String value.
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Takes Suits number as input parameter and returns suits name.
	 * 
	 * @param suitNumber as input parameter.
	 * @return String value.
	 */
	public static String getSuit(int suitNumber) {
		switch (suitNumber) {
		case 0:
			return "Clubs";

		case 1:
			return "Diamonds";

		case 2:
			return "Hearts";

		case 3:
			return "Spades";

		default:
			return "Invalid";
		}
	}

	/**
	 * Takes Rank number as input parameter and returns Rank name.
	 * 
	 * @param cardNumber as input parameter.
	 * @return String value.
	 */
	public static String getRank(int cardNumber) {
		switch (cardNumber) {
		case 0:
			return ("2");
		case 1:
			return ("3");
		case 2:
			return ("4");
		case 3:
			return ("5");
		case 4:
			return ("6");
		case 5:
			return ("7");
		case 6:
			return ("8");
		case 7:
			return ("9");
		case 8:
			return ("10");
		case 9:
			return ("Jack");
		case 10:
			return ("Queen");
		case 11:
			return ("King");
		case 12:
			return ("Ace");
		default:
			return ("Invalid");

		}

	}

}
