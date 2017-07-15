package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CategoryTest extends ConsoleOutputTest {

    private String ROCK = "Rock";
    private String POP = "Pop";
    private String SCIENCE = "Science";
    private String SPORTS = "Sports";

    @Test
    public void givenPlayer_whenInLocation0AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPositionAfterRoll(0);
        assertCategoryEquals(POP);
    }

    @Test
    public void givenPlayer_whenInLocation1AfterRoll_thenCurrentCategoryIsScience() {
        createGameWithPositionAfterRoll(1);
        assertCategoryEquals(SCIENCE);
    }

    @Test
    public void givenPlayer_whenInLocation2AfterRoll_thenCurrentCategoryIsSports() {
        createGameWithPositionAfterRoll(2);
        assertCategoryEquals(SPORTS);
    }

    @Test
    public void givenPlayer_whenInLocation3AfterRoll_thenCurrentCategoryIsRock() {
        createGameWithPositionAfterRoll(3);
        assertCategoryEquals(ROCK);
    }

    @Test
    public void givenPlayer_whenInLocation4AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPositionAfterRoll(4);
        assertCategoryEquals(POP);
    }

    @Test
    public void givenPlayer_whenInLocation5AfterRoll_thenCurrentCategoryIsScience() {
        createGameWithPositionAfterRoll(5);
        assertCategoryEquals(SCIENCE);
    }

    @Test
    public void givenPlayer_whenInLocation6AfterRoll_thenCurrentCategoryIsSports() {
        createGameWithPositionAfterRoll(6);
        assertCategoryEquals(SPORTS);
    }

    @Test
    public void givenPlayer_whenInLocation7AfterRoll_thenCurrentCategoryIsRock() {
        createGameWithPositionAfterRoll(7);
        assertCategoryEquals(ROCK);
    }

    @Test
    public void givenPlayer_whenInLocation8AfterRoll_thenCurrentCategoryIsPop() {
        createGameWithPositionAfterRoll(8);
        assertCategoryEquals(POP);
    }

    @Test
    public void givenPlayer_whenInLocation9AfterRoll_thenCurrentCategoryIsScience() {
        createGameWithPositionAfterRoll(9);
        assertCategoryEquals(SCIENCE);
    }

    @Test
    public void givenPlayer_whenInLocation10AfterRoll_thenCurrentCategoryIsSports() {
        createGameWithPositionAfterRoll(10);
        assertCategoryEquals(SPORTS);
    }

    @Test
    public void givenPlayer_whenInLocation11AfterRoll_thenCurrentCategoryIsRock() {
        createGameWithPositionAfterRoll(11);
        assertCategoryEquals(ROCK);
    }

    private void assertLocationEquals(int location) {
        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is " + location;
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

    private void createGameWithPositionAfterRoll(int roll) {
        createGameWithPlayersAndRoll(roll, PLAYER1_NAME);

        assertLocationEquals(roll);
    }

}
