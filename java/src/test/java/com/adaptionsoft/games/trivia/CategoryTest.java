package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CategoryTest extends ConsoleOutputTest {

    private String ROCK = "Rock";
    private String POP = "Pop";
    private String SCIENCE = "Science";
    private String SPORTS = "Sports";

    @Test
    public void givenPlayer_whenInLocation0AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPlayersAndRoll(0, "Bart");

        assertLocationEquals(0);
        assertCategoryEquals(POP);
    }

    @Test
    public void givenPlayer_whenInLocation1AfterRoll_thenCurrentCategoryIsScience() {
        createGameWithPlayersAndRoll(1, "Bart");

        assertLocationEquals(1);
        assertCategoryEquals(SCIENCE);
    }

    @Test
    public void givenPlayer_whenInLocation2AfterRoll_thenCurrentCategoryIsSports() {
        createGameWithPlayersAndRoll(2, "Bart");

        assertLocationEquals(2);
        assertCategoryEquals(SPORTS);
    }

    @Test
    public void givenPlayer_whenInLocation3AfterRoll_thenCurrentCategoryIsRock() {
        createGameWithPlayersAndRoll(3, "Bart");

        assertLocationEquals(3);
        assertCategoryEquals(ROCK);
    }

    @Test
    public void givenPlayer_whenInLocation4AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPlayersAndRoll(4, "Bart");

        assertLocationEquals(4);
        assertCategoryEquals(POP);
    }

    @Test
    public void givenPlayer_whenInLocation5AfterRoll_thenCurrentCategoryIsScience() {
        createGameWithPlayersAndRoll(5, "Bart");

        assertLocationEquals(5);
        assertCategoryEquals(SCIENCE);
    }

    @Test
    public void givenPlayer_whenInLocation6AfterRoll_thenCurrentCategoryIsSports() {
        createGameWithPlayersAndRoll(6, "Bart");

        assertLocationEquals(6);
        assertCategoryEquals(SPORTS);
    }

    @Test
    public void givenPlayer_whenInLocation7AfterRoll_thenCurrentCategoryIsRock() {
        createGameWithPlayersAndRoll(7, "Bart");

        assertLocationEquals(7);
        assertCategoryEquals(ROCK);
    }

    @Test
    public void givenPlayer_whenInLocation8AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPlayersAndRoll(8, "Bart");

        assertLocationEquals(8);
        assertCategoryEquals(POP);
    }

    @Test
    public void givenPlayer_whenInLocation9AfterRoll_thenCurrentCategoryIsScience() {
        createGameWithPlayersAndRoll(9, "Bart");

        assertLocationEquals(9);
        assertCategoryEquals(SCIENCE);
    }

    @Test
    public void givenPlayer_whenInLocation10AfterRoll_thenCurrentCategoryIsSports() {
        createGameWithPlayersAndRoll(10, "Bart");

        assertLocationEquals(10);
        assertCategoryEquals(SPORTS);
    }

    @Test
    public void givenPlayer_whenInLocation11AfterRoll_thenCurrentCategoryIsRock() {
        createGameWithPlayersAndRoll(11, "Bart");

        assertLocationEquals(11);
        assertCategoryEquals(ROCK);
    }

    @Test
    public void givenPlayer_whenRoll12_thenLocationIs0() {
        createGameWithPlayersAndRoll(12, "Bart");

        String expectedOutputForLocationLine = "Bart's new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    private void assertLocationEquals(int location) {
        String expectedOutputForLocationLine = "Bart's new location is " + location;
        String actualOutputForLocationLine = getLocationLineFromConsole();
        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

    private void assertCategoryEquals(String category) {
        String expectedOutputForCategoryLine = "The category is " + category;
        String actualOutputForCategoryLine = getCategoryLineFromConsole();
        assertEquals(expectedOutputForCategoryLine, actualOutputForCategoryLine);
    }

    private String getLocationLineFromConsole() {
        String[] outputLines = getOutputInLines();
        return outputLines[4];
    }

    private String getCategoryLineFromConsole() {
        String[] outputLines = getOutputInLines();
        return outputLines[5];
    }

    private void createGameWithPlayersAndRoll(int roll, String... playerNames) {
        Game game = new Game();
        game.add(playerNames[0]);

        game.roll(roll);
    }
}
