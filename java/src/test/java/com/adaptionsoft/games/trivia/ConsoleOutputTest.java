package com.adaptionsoft.games.trivia;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class ConsoleOutputTest {

    protected final String PLAYER1_NAME = "Bart";
    protected final String PLAYER2_NAME = "Harry";
    protected final String PLAYER3_NAME = "Ben";
    protected final String PLAYER4_NAME = "Luc";
    protected final String PLAYER5_NAME = "Marie";
    protected final String PLAYER6_NAME = "Mark";


    final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

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

    String[] getOutputInLines() {
        return consoleOutput.toString().split("\r\n");
    }


    void createGameWithPlayersAndRoll(int roll, String... playerNames) {
        Game game = new Game();
        game.add(playerNames[0]);

        game.roll(roll);
    }
}
