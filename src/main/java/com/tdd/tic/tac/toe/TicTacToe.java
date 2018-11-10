package com.tdd.tic.tac.toe;

public class TicTacToe {

	private char[][] board;
	private char nextPlayer;
	private char currentPlayer;

	public TicTacToe() {
		board = new char[3][3];
		nextPlayer = 'X';
	}

	public String play(int x, int y) {
		checkPositions(x, y);
		checkIfOccupied(x, y);
		occupySpot(x, y);
		if (theCurrentPlayerHasWon()) {
			return currentPlayer + " is the winner.";
		}
		return "No winner.";
	}

	private boolean theCurrentPlayerHasWon() {
		currentPlayer = nextPlayer == 'X' ? 'O' : 'X';
		char diagonal = '\0';
		char antiDiagonal = '\0';
		int totalValueOfCurrentPlayer = currentPlayer * 3;
		for (int i = 0; i < board.length; i++) {
			diagonal += board[i][i];
			antiDiagonal += board[i][3 - i - 1];
			if (board[i][0] + board[i][1] + board[i][2] == totalValueOfCurrentPlayer) {
				return true;
			}
			if (board[0][i] + board[1][i] + board[2][i] == totalValueOfCurrentPlayer) {
				return true;
			}
		}
		if (diagonal == totalValueOfCurrentPlayer || antiDiagonal == totalValueOfCurrentPlayer) {
			return true;
		}
		return false;
	}

	private void occupySpot(int x, int y) {
		board[x - 1][y - 1] = nextPlayer;
		nextPlayer = (nextPlayer == 'X') ? 'O' : 'X';
	}

	private void checkIfOccupied(int x, int y) {
		if (board[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Spot has already been occupied");
		}
	}

	private void checkPositions(int x, int y) {
		if (withinLimits(x - 1) || withinLimits(y - 1)) {
			throw new RuntimeException("Position is out of bounds: (" + x + " " + y + ")");
		}
	}

	private boolean withinLimits(int position) {
		return position < 0 || position > 3;
	}

	public char nextPlayer() {
		return nextPlayer;
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
