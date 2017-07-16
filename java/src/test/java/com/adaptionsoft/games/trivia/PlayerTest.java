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
}