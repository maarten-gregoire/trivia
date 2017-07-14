package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

	@Rule
	public ExpectedException expectException = ExpectedException.none();

	@Test
	public void givenNoPlayers_whenWrongAnswer_thenThrowIndexOutOfBoundsException() {
		expectException.expect(IndexOutOfBoundsException.class);
		Game game = new Game();

		game.wrongAnswer();
	}

	@Test
	public void givenOnePlayer_whenWrongAnswer_thenReturnTrue() {
		Game game = new Game();
		game.add("Ben");

		boolean result = game.wrongAnswer();

		assertTrue(result);
	}

	@Test
	public void givenNoPlayers_thenIsPlayableFalse() {
		Game game = new Game();

		assertFalse(game.isPlayable());
	}

	@Test
	public void givenOnePlayer_thenIsPlayableFalse() {
		Game game = new Game();
		game.add("Ben");

		assertFalse(game.isPlayable());
	}

	@Test
	public void givenTwoPlayers_thenIsPlayableTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		assertTrue(game.isPlayable());
	}

	@Test
	public void givenNoPlayers_thenHowManyPlayersIs0() {
		Game game = new Game();

		assertThat(game.howManyPlayers()).isEqualTo(0);
	}

	@Test
	public void given1Player_thenHowManyPlayersIs1() {
		Game game = new Game();
		game.add("Bart");

		assertThat(game.howManyPlayers()).isEqualTo(1);
	}
}
