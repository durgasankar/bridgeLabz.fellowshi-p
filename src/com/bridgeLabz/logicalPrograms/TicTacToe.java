package com.bridgeLabz.logicalPrograms;

import java.util.Scanner;

/**
 * its a game comprises of 9 boxes of 3*3 matrix two players play the game by
 * giving the input on the form of x and y coordinates. game terminates when one
 * of them fulfills win condition or ended with draw.
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-14
 * @version 1.0
 */
public class TicTacToe {
	private static Scanner scanner = new Scanner(System.in);
	private static int row, col;
	private static char[][] board = new char[3][3];
	private static char turn = 'X';

	/**
	 * designing of the board. i for loop is for row. j for loop is for column.
	 */
	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}

	/**
	 * This loop will run unless the game gets complete. user has to provide numbers
	 * between 1, 2, 3. if game gets over it will display the winner. after every
	 * trial it changes the player.
	 * 
	 * @param isPlaying is boolean type value
	 * @param row       takes input from user as rowNumber and -1 converts it to
	 *                  zero index.
	 * @param col       takes input from user as columnNumber and -1 converts it to
	 *                  zero index.
	 * @param gameOver  method returns a boolean value.
	 * @throws ArrayIndexOutOfBoundsException if input value is more than limit.
	 */
	public static void play() {
		boolean isPlaying = true;
		printBoard();
		/**
		 * While loop will continue till rows matches gameOver criteria it will display
		 * the winner name.
		 */
		while (isPlaying) {
			System.out.println("Please enter rows and column between 1, 2, 3 :");
			row = scanner.nextInt() - 1;
			col = scanner.nextInt() - 1;
			board[row][col] = turn;
			if (gameOver(row, col)) {
				isPlaying = false;
				System.out.println("GameOver! player " + turn + " wins!");
			}
			printBoard();
			if (turn == 'X') {
				turn = 'O';
				System.out.println("curent tern is : " + turn);
			} else {
				turn = 'X';
				System.out.println("curent tern is : " + turn);
			}
		}
	}

	/**
	 * it checks gameOver criteria if condition gets match
	 * 
	 * @param x takes the input parameter for x axis of the 2D array
	 * @param y takes the input parameter for y axis of the 2D array
	 * @return boolean type value if matches the condition
	 */
	private static boolean gameOver(int x, int y) {
		// checks parallel columns
		if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return true;
			// checks vertical rows
		} else if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return true;
			// checks equals side diagonals
		} else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
			return true;
			// checks non equal side diagonals
		} else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Board gets initialized with 3*3 matrix play method is called for execution
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}
		play();
	}

}
