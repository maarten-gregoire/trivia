package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static com.adaptionsoft.games.trivia.Category.*;
import static com.adaptionsoft.games.trivia.Player.aPlayer;
import static junit.framework.TestCase.assertEquals;

public class PlayerTest {

    @Test
    public void givenNewPlayer_thenGoldenCoinsIs0() {
        Player player = new Player("Will", 1);

        assertEquals(player.getGoldCoins(), 0);
    }

    @Test
    public void givenNewPlayer_whenAddGoldCoin_thenGoldenCoinsIs1() {
        Player player = new Player("Will", 1);

        assertEquals(player.addGoldCoin(), 1);
    }

    @Test
    public void givenNewPlayer_whenAdd2GoldCoins_thenGoldenCoinsIs2() {
        Player player = new Player("Will", 1);
        player.addGoldCoin();
        assertEquals(player.addGoldCoin(), 2);
    }

    @Test
    public void givenNewPlayer_whenAdd7GoldCoins_thenGoldenCoinsIs7() {
        Player player = new Player("Will", 1);
        player.addGoldCoin();
        player.addGoldCoin();
        player.addGoldCoin();
        player.addGoldCoin();
        player.addGoldCoin();
        player.addGoldCoin();
        assertEquals(player.addGoldCoin(), 7);
    }

    @Test
    public void givenNewPlayer_whenAdd1ToLocation_thenLocationIs1() {
        Player player = new Player("Ben", 1);
        assertEquals(player.addToLocation(1), 1);
    }

    @Test
    public void givenPlayerwithLocation4_whenAdd4ToLocation_thenLocationIs8() {
        Player player = new Player("Ben", 1);
        player.addToLocation(4);
        assertEquals(player.addToLocation(4), 8);
    }

    @Test
    public void givenNewPlayer_thenLocationIs0() {
        Player player = new Player("Ben", 1);
        assertEquals(player.getLocation(), 0);
    }

    @Test
    public void givenNewPlayer_whenAdd12ToLocation_thenLocationIs0() {
        Player player = new Player("Ben", 1);
        assertEquals(0, player.addToLocation(12));
    }

    @Test
    public void givenNewPlayer_whenAdd24ToLocation_thenLocationIs12() {
        Player player = new Player("Ben", 1);
        assertEquals(12, player.addToLocation(24));
    }

    @Test
    public void givenNewPlayer_whenAdd27ToLocation_thenLocationIs15() {
        Player player = new Player("Ben", 1);
        assertEquals(15, player.addToLocation(27));
    }

    @Test
    public void givenPlayerGivenLocation0_thenCategoryIsPop() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(0);

        assertEquals(POP, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation1_thenCategoryIsScience() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(1);

        assertEquals(SCIENCE, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation2_thenCategoryIsSports() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(2);

        assertEquals(SPORTS, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation3_thenCategoryIsRock() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(3);

        assertEquals(ROCK, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation4_thenCategoryIsPop() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(4);

        assertEquals(POP, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation5_thenCategoryIsScience() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(5);

        assertEquals(SCIENCE, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation6_thenCategoryIsSports() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(6);

        assertEquals(SPORTS, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation7_thenCategoryIsRock() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(7);

        assertEquals(ROCK, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation8_thenCategoryIsPop() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(8);

        assertEquals(POP, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation9_thenCategoryIsScience() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(9);

        assertEquals(SCIENCE, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation10_thenCategoryIsSports() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(10);

        assertEquals(SPORTS, player.getCurrentCategory());
    }

    @Test
    public void givenPlayerGivenLocation11_thenCategoryIsRock() {
        Player player = aPlayer("Jan", 1);
        player.addToLocation(11);

        assertEquals(ROCK, player.getCurrentCategory());
    }

}