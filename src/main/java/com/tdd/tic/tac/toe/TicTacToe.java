package com.tdd.tic.tac.toe;

public class TicTacToe {

	private char[][] board;
	private char nextPlayer;

	public TicTacToe() {
		board = new char[3][3];
		nextPlayer = 'X';
	}

	public void play(int x, int y) {
		checkPositions(x, y);
		checkIfOccupied(x, y);
		occupySpot(x, y);
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

}
