package com.adaptionsoft.games.trivia;

import org.junit.Test;

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
}