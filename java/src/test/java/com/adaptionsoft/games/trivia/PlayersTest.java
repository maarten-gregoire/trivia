package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static com.adaptionsoft.games.trivia.Player.player;
import static junit.framework.TestCase.assertEquals;

public class PlayersTest extends UnitTest{

    @Test
    public void givenNoPlayers_thenSizeIs0() {
        Players players = new Players();
        assertEquals(players.size(), 0);
    }

    @Test
    public void givenOnePlayers_thenSizeIs1() {
        Players players = new Players();
        players.add(player("",1));
        assertEquals(players.size(), 1);
    }

    @Test
    public void givenTwoPlayers_thenSizeIs2() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        assertEquals(players.size(), 2);
    }

    @Test
    public void givenThreePlayers_thenSizeIs3() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        assertEquals(players.size(), 3);
    }

    @Test
    public void givenFourPlayers_thenSizeIs4() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        assertEquals(players.size(), 4);
    }

    @Test
    public void givenFivePlayers_thenSizeIs5() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        assertEquals(players.size(), 5);
    }

    @Test
    public void givenFivePlayers_thenSizeIs6() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        assertEquals(players.size(), 5);
    }

    @Test
    public void givenFivePlayers_whenAddingPlayer_thenThrowIndexOutOfBoundsException() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        expectException.expect(IndexOutOfBoundsException.class);
        players.add(player("",1));
    }

    @Test
    public void givenFourPlayers_whenGet5_thenThrowIndexOutOfBoundsException() {
        Players players = new Players();
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        expectException.expect(IndexOutOfBoundsException.class);
        players.get(5);
    }

    @Test
    public void givenFourPlayers_whenGet3_thenReturnCorrectPlayer() {
        Players players = new Players();
        Player player = player("Mark", 50);
        players.add(player("",1));
        players.add(player("",1));
        players.add(player("",1));
        players.add(player);

        assertEquals(players.get(3), player);
    }
}