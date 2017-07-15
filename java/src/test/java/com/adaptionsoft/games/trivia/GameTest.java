package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

	@Rule
	public ExpectedException expectException = ExpectedException.none();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(consoleOutput));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void givenNoPlayers_whenWrongAnswer_thenThrowIndexOutOfBoundsException() {
		expectException.expect(IndexOutOfBoundsException.class);
		Game game = new Game();

		game.giveWrongAnswer();
	}

	@Test
	public void givenOnePlayer_whenOneWrongAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");

		boolean result = game.giveWrongAnswer();

		assertTrue(result);
	}

	@Test
	public void givenOnePlayer_whenOneCorrectAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");

		boolean result = game.giveCorrectAnswer();

		assertTrue(result);
	}

	@Test
	public void givenOnePlayer_whenSixCorrectAnswers_thenNotAWinnerFalse() {
		Game game = new Game();
		game.add("Ben");

		giveCorrectAnswers(game, 5);

		assertFalse(game.giveCorrectAnswer());
	}

	@Test
	public void givenOnePlayer_whenFourCorrectAndTwoWrongAndOneCorrectAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");

		giveCorrectAnswers(game, 4);
		giveWrongAnswers(game, 2);
		assertTrue(game.giveCorrectAnswer());
	}

	@Test
	public void givenTwoPlayers_whenOneCorrectAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		boolean result = game.giveCorrectAnswer();

		assertTrue(result);
	}

	@Test
	public void givenTwoPlayers_whenOneWrongAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		assertTrue(game.giveWrongAnswer());
	}

	@Test
	public void givenTwoPlayers_whenSixCorrectAnswers_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveCorrectAnswers(game, 5);
		assertTrue(game.giveCorrectAnswer());
	}

	@Test
	public void givenTwoPlayers_whenElevenCorrectAnswers_thenNotAWinnerFalsee() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveCorrectAnswers(game, 10);

		assertFalse(game.giveCorrectAnswer());
	}


	@Test
	public void givenTwoPlayers_whenElevenWrongAnswers_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveWrongAnswers(game, 10);
		assertTrue(game.giveWrongAnswer());
	}

	@Test
	public void givenTwoPlayers_whenWrongAnswerAfterNotAWinnerIsFalse_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");

		giveCorrectAnswers(game, 11);
		assertTrue(game.giveWrongAnswer());

	}
	@Test
	public void givenThreePlayers_whenOneWrongAnswer_thenNotAWinnerTrue() {
		Game game = new Game();
		game.add("Ben");
		game.add("Bart");
		game.add("James");

		assertTrue(game.giveWrongAnswer());
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

		assertThat(game.getNumberOfPlayers()).isEqualTo(0);
	}

	@Test
	public void given1Player_thenHowManyPlayersIs1() {
		Game game = new Game();
		game.add("Bart");

		assertThat(game.getNumberOfPlayers()).isEqualTo(1);
	}

	@Test
	public void givenPlayer_whenInLocation0AfterRoll_thenCurrentCategoryIsPop() {
		Game game = new Game();
		game.add("Bart");

		game.roll(0);

		String expectedOutputForLocationLine = "Bart's new location is 0";
		String expectedOutputForCategoryLine = "The category is Pop";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation1AfterRoll_thenCurrentCategoryIsScience() {
		Game game = new Game();
		game.add("Bart");

		game.roll(1);

		String expectedOutputForLocationLine = "Bart's new location is 1";
		String expectedOutputForCategoryLine = "The category is Science";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation2AfterRoll_thenCurrentCategoryIsSports() {
		Game game = new Game();
		game.add("Bart");

		game.roll(2);

		String expectedOutputForLocationLine = "Bart's new location is 2";
		String expectedOutputForCategoryLine = "The category is Sports";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}
	@Test
	public void givenPlayer_whenInLocation3AfterRoll_thenCurrentCategoryIsRock() {
		Game game = new Game();
		game.add("Bart");

		game.roll(3);

		String expectedOutputForLocationLine = "Bart's new location is 3";
		String expectedOutputForCategoryLine = "The category is Rock";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation4AfterRoll_thenCurrentCategoryIsPop() {
		Game game = new Game();
		game.add("Bart");

		game.roll(4);

		String expectedOutputForLocationLine = "Bart's new location is 4";
		String expectedOutputForCategoryLine = "The category is Pop";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation5AfterRoll_thenCurrentCategoryIsScience() {
		Game game = new Game();
		game.add("Bart");

		game.roll(5);

		String expectedOutputForLocationLine = "Bart's new location is 5";
		String expectedOutputForCategoryLine = "The category is Science";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation6AfterRoll_thenCurrentCategoryIsSports() {
		Game game = new Game();
		game.add("Bart");

		game.roll(6);

		String expectedOutputForLocationLine = "Bart's new location is 6";
		String expectedOutputForCategoryLine = "The category is Sports";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation7AfterRoll_thenCurrentCategoryIsRock() {
		Game game = new Game();
		game.add("Bart");

		game.roll(7);

		String expectedOutputForLocationLine = "Bart's new location is 7";
		String expectedOutputForCategoryLine = "The category is Rock";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation8AfterRoll_thenCurrentCategoryIsPop() {
		Game game = new Game();
		game.add("Bart");

		game.roll(8);

		String expectedOutputForLocationLine = "Bart's new location is 8";
		String expectedOutputForCategoryLine = "The category is Pop";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation9AfterRoll_thenCurrentCategoryIsScience() {
		Game game = new Game();
		game.add("Bart");

		game.roll(9);

		String expectedOutputForLocationLine = "Bart's new location is 9";
		String expectedOutputForCategoryLine = "The category is Science";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation10AfterRoll_thenCurrentCategoryIsSports() {
		Game game = new Game();
		game.add("Bart");

		game.roll(10);

		String expectedOutputForLocationLine = "Bart's new location is 10";
		String expectedOutputForCategoryLine = "The category is Sports";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenInLocation11AfterRoll_thenCurrentCategoryIsRock() {
		Game game = new Game();
		game.add("Bart");

		game.roll(11);

		String expectedOutputForLocationLine = "Bart's new location is 11";
		String expectedOutputForCategoryLine = "The category is Rock";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];
		String actualOutputForCategoryLine = outputLines[5];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
		assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
	}

	@Test
	public void givenPlayer_whenRoll12_thenLocationIs0() {
		Game game = new Game();
		game.add("Bart");

		game.roll(12);

		String expectedOutputForLocationLine = "Bart's new location is 0";

		String[] outputLines = getOutputInLines();
		String actualOutputForLocationLine = outputLines[4];

		assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
	}

	private String[] getOutputInLines() {
		return consoleOutput.toString().split("\r\n");
	}

	private void giveWrongAnswers(Game game, int amount) {
		for (int i = 0; i < amount; i++) {
			game.giveWrongAnswer();
		}
	}

	private void giveCorrectAnswers(Game game, int amount) {
		for (int i = 0; i < amount; i++) {
			game.giveCorrectAnswer();
		}
	}
}
