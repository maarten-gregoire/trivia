package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CategoryTest extends ConsoleOutputTest {

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

}
