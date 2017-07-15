package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CategoryTest extends ConsoleOutputTest {

    @Test
    public void givenPlayer_whenInLocation0AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPlayersAndRoll(0, "Bart");

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
        createGameWithPlayersAndRoll(1, "Bart");

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
        createGameWithPlayersAndRoll(2, "Bart");

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
        createGameWithPlayersAndRoll(3, "Bart");

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
        createGameWithPlayersAndRoll(4, "Bart");

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
        createGameWithPlayersAndRoll(5, "Bart");

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
        createGameWithPlayersAndRoll(6, "Bart");

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
        createGameWithPlayersAndRoll(7, "Bart");

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
        createGameWithPlayersAndRoll(8, "Bart");

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
        createGameWithPlayersAndRoll(9, "Bart");

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
        createGameWithPlayersAndRoll(10, "Bart");

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

        createGameWithPlayersAndRoll(11, "Bart");

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
        createGameWithPlayersAndRoll(12, "Bart");

        String expectedOutputForLocationLine = "Bart's new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    private void createGameWithPlayersAndRoll(int roll, String... playerNames) {
        Game game = new Game();
        game.add(playerNames[0]);

        game.roll(roll);
    }
}
