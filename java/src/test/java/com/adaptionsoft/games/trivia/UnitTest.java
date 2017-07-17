package com.adaptionsoft.games.trivia;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public abstract class UnitTest {
    @Rule
    public ExpectedException expectException = ExpectedException.none();
}
