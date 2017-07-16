package com.adaptionsoft.games.uglytrivia;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class ConsoleOutputTest {

    String PLAYER1_NAME = "Bart";

    protected final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

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
