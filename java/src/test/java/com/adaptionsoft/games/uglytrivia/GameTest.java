package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest extends ConsoleOutputTest {

	@Test
	public void givenNoPlayers_whenWrongAnswer_thenThrowIndexOutOfBoundsException() {
		expectException.expect(IndexOutOfBoundsException.class);
		Game game = new Game();

		game.wrongAnswer();
	}

	@Test
	public void givenOnePlayer_whenOneWrongAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");

		boolean result = game.wrongAnswer();

		assertTrue(result);
	}

	@Test
	public void givenOnePlayer_whenOneCorrectAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");

		boolean result = game.wasCorrectlyAnswered();

		assertTrue(result);
	}

	@Test
	public void givenOnePlayer_whenSixCorrectAnswers_thenNotAWinnerFalse() {
		Game game = new Game();
		game.add("Ben");

		giveCorrectAnswers(game, 5);

		assertFalse(game.wasCorrectlyAnswered());
	}

	@Test
	public void givenOnePlayer_whenFourCorrectAndTwoWrongAndOneCorrectAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");

		giveCorrectAnswers(game, 4);
		giveWrongAnswers(game, 2);
		assertTrue(game.wasCorrectlyAnswered());
	}

	@Test
	public void givenTwoPlayers_whenOneCorrectAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		boolean result = game.wasCorrectlyAnswered();

		assertTrue(result);
	}

	@Test
	public void givenTwoPlayers_whenOneWrongAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		assertTrue(game.wrongAnswer());
	}

	@Test
	public void givenTwoPlayers_whenSixCorrectAnswers_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveCorrectAnswers(game, 5);
		assertTrue(game.wrongAnswer());
	}

	@Test
	public void givenTwoPlayers_whenElevenCorrectAnswers_thenNotAWinnerFalsee() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveCorrectAnswers(game, 10);

		assertFalse(game.wasCorrectlyAnswered());
	}

	@Test
	public void givenTwoPlayers_whenElevenWrongAnswers_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveWrongAnswers(game, 10);
		assertTrue(game.wrongAnswer());
	}

	@Test
	public void givenTwoPlayers_whenWrongAnswerAfterNotAWinnerIsFalse_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveCorrectAnswers(game, 11);
		assertTrue(game.wrongAnswer());
	}

	@Test
	public void givenThreePlayers_whenOneWrongAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");
		game.add("James");

		assertTrue(game.wrongAnswer());
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

	private void giveWrongAnswers(Game game, int amount) {
		for (int i = 0; i < amount; i++) {
			game.wrongAnswer();
		}
	}

	private void giveCorrectAnswers(Game game, int amount) {
		for (int i = 0; i < amount; i++) {
			game.wasCorrectlyAnswered();
		}
	}
}
