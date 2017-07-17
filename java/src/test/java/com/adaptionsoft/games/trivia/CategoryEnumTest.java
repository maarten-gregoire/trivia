package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static com.adaptionsoft.games.trivia.Category.*;
import static junit.framework.TestCase.assertEquals;

public class CategoryEnumTest {
    @Test
    public void givenPlayerGivenLocation0_thenCategoryIsPop() {
        assertEquals(POP, getCategory(0));
    }

    @Test
    public void givenLocation1_thenCategoryIsScience() {
        assertEquals(SCIENCE, getCategory(1));
    }

    @Test
    public void giivenLocation2_thenCategoryIsSports() {
        assertEquals(SPORTS, getCategory(2));
    }

    @Test
    public void givenLocation3_thenCategoryIsRock() {
        assertEquals(ROCK, getCategory(3));
    }

    @Test
    public void givenLocation4_thenCategoryIsPop() {
        assertEquals(POP, getCategory(4));
    }

    @Test
    public void givenLocation5_thenCategoryIsScience() {
        assertEquals(SCIENCE, getCategory(5));
    }

    @Test
    public void givenLocation6_thenCategoryIsSports() {
        assertEquals(SPORTS, getCategory(6));
    }

    @Test
    public void givenLocation7_thenCategoryIsRock() {
        assertEquals(ROCK, getCategory(7));
    }

    @Test
    public void givenLocation8_thenCategoryIsPop() {
        assertEquals(POP, getCategory(8));
    }

    @Test
    public void givenPLocation9_thenCategoryIsScience() {
        assertEquals(SCIENCE, getCategory(9));
    }

    @Test
    public void givenLocation10_thenCategoryIsSports() {
        assertEquals(SPORTS, getCategory(10));
    }

    @Test
    public void givenLocation11_thenCategoryIsRock() {
        assertEquals(ROCK, getCategory(11));
    }

    @Test
    public void givenLocation12_thenCategoryIsRock() {
        assertEquals(ROCK, getCategory(12));
    }

    @Test
    public void givenLocation13_thenCategoryIsRock() {
        assertEquals(ROCK, getCategory(12));
    }
}