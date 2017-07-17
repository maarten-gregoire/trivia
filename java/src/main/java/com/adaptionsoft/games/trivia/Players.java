package com.adaptionsoft.games.trivia;

import java.util.ArrayList;

public class Players {
    ArrayList<Player> players = new ArrayList<>();
    private int size = 0;

    public int size() {
        return size;
    }

    public Player get(int index) {
        return players.get(index);
    }

    public void add(Player player) {
        if (size == 5) throw new IndexOutOfBoundsException();
        players.add(player);
        size++;
    }
}
