package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LocationTest extends ConsoleOutputTest {

    @Test
    public void givenPlayer_whenRoll12_thenLocationIs0() {
        createGameWithPlayersAndRoll(12, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll24_thenLocationIs12() {
        createGameWithPlayersAndRoll(24, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 12";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll27_thenLocationIs15() {
        createGameWithPlayersAndRoll(27, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 15";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }


    @Test
    public void givenPlayer_whenRoll1_thenLocationIs1() {
        createGameWithPlayersAndRoll(1, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 1";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll6_thenLocationIs6() {
        createGameWithPlayersAndRoll(6, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 6";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll11_thenLocationIs11() {
        createGameWithPlayersAndRoll(11, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 11";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll0_thenLocationIs0() {
        createGameWithPlayersAndRoll(0, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll0andThen1_thenLocationIs1() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.roll(0);
        game.roll(1);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 1";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[9];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll6andThen2_thenLocationIs8() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.roll(6);
        game.roll(2);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 8";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[9];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void givenPlayer_whenRoll6andThen6_thenLocationIs0() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.roll(6);
        game.roll(6);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[9];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void given2Players_whenP2Roll6andThen6_thenLocationIs0() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.add(PLAYER2_NAME);
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(6);
        game.giveCorrectAnswer();
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(6);
        game.giveCorrectAnswer();

        String expectedOutputForLocationLine = PLAYER2_NAME + "'s new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[27];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void given2Players_whenP2Roll6andThen5_thenLocationIs11() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.add(PLAYER2_NAME);
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(6);
        game.giveCorrectAnswer();
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(5);
        game.giveCorrectAnswer();

        String expectedOutputForLocationLine = PLAYER2_NAME + "'s new location is 11";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[27];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void given2Players_whenP2Roll6andThen5WithWrongAnswers_thenLocationIs11() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.add(PLAYER2_NAME);
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(6);
        game.giveWrongAnswer();
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(5);
        game.giveWrongAnswer();

        String expectedOutputForLocationLine = PLAYER2_NAME + "'s new location is 11";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[28];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void given2Players_whenP2Roll6_thenLocationIs6() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.add(PLAYER2_NAME);
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(6);

        String expectedOutputForLocationLine = PLAYER2_NAME + "'s new location is 6";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[13];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    @Test
    public void given2Players_whenP2Roll0_thenLocationIs6() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        game.add(PLAYER2_NAME);
        game.roll(5);
        game.giveCorrectAnswer();
        game.roll(0);

        String expectedOutputForLocationLine = PLAYER2_NAME + "'s new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[13];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

}
