package com.adaptionsoft.games.trivia;

public class Player {
    private String name;
    private int number;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Player aPlayer(String name, int number) {
        return new Player(name, number);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
