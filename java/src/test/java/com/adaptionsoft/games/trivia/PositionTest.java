package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PositionTest extends ConsoleOutputTest {

    @Test
    public void givenPlayer_whenRoll12_thenLocationIs0() {
        createGameWithPlayersAndRoll(12, PLAYER1_NAME);

        String expectedOutputForLocationLine = PLAYER1_NAME + "'s new location is 0";

        String[] outputLines = getOutputInLines();
        String actualOutputForLocationLine = outputLines[4];

        assertEquals(expectedOutputForLocationLine, actualOutputForLocationLine);
    }

}
