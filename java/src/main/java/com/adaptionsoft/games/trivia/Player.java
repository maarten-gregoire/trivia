package com.adaptionsoft.games.trivia;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public static Player aPlayer(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
