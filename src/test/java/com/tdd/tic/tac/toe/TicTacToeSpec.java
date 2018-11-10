package com.tdd.tic.tac.toe;

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
}
