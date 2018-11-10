package com.tdd.tic.tac.toe;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private TicTacToe ticTacToe;

	@Before
	public void setup() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void whenPieceIsPlacedOutsideXThrowsRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(5, 2);
	}

	@Test
	public void whenPieceIsPlacedOutsideYThrowsRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}

	@Test
	public void whenPieceIsAddedToAnOccupiedSpotThrowsRuntimeException() {
		ticTacToe.play(2, 3);
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 3);
	}

	@Test
	public void whenGameBeginsTheFirstTurnShouldBePlayedByX() {
		assertEquals('X', ticTacToe.nextPlayer());
	}

	@Test
	public void whenXHasPlayedTheNextPlayerShouldBeO() {
		ticTacToe.play(2, 2);
		assertEquals('O', ticTacToe.nextPlayer());
	}

	@Test
	public void whenOHasPlayerTheNextPlayerShouldBeX() {
		ticTacToe.play(2, 2);
		ticTacToe.play(1, 3);
		assertEquals('X', ticTacToe.nextPlayer());
	}

	@Test
	public void whenThereIsNoWinnerByDefaultTheResponseShouldBeNoWinner() {
		assertEquals("No winner.", ticTacToe.play(2, 3));
	}

	@Test
	public void whenHorizontalLineIsTakenByXTheWinnerIsX() {
		ticTacToe.play(1, 1);
		ticTacToe.play(2, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 2);
		String winner = ticTacToe.play(1, 3);
		assertEquals("X is the winner.", winner);
	}

	@Test
	public void whenVerticalLineIsTakenByOTheWinnerIsO() {
		ticTacToe.play(2, 3);
		ticTacToe.play(1, 1);
		ticTacToe.play(3, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(3, 2);
		String winner = ticTacToe.play(3, 1);
		assertEquals("O is the winner.", winner);
	}
	
	@Test
	public void whenDiagonalLineIsTakenByXTheWinnerIsX() {
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(1, 1);
		ticTacToe.play(3, 2);
		String winner = ticTacToe.play(3, 3);
		assertEquals("X is the winner.", winner);
	}
	
	@Test
	public void whenAntiDiagonalLineIsTakenByOTheWinnerIsO() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 3);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 2);
		ticTacToe.play(2, 3);
		String winner = ticTacToe.play(3, 1);
		assertEquals("O is the winner.", winner);
	}
	
	
}
