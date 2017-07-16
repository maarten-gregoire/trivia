package com.adaptionsoft.games.trivia;

import static com.adaptionsoft.games.trivia.Category.*;

public class Player {
    private String name;
    private int number;
    private int goldCoins;
    private int location;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.goldCoins = 0;
        this.location = 0;
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

    public int getGoldCoins() {
        return goldCoins;
    }

    public int addGoldCoin() {
        return ++goldCoins;
    }

    public int getLocation() {
        return location;
    }

    public int addToLocation(int numberOfSteps) {
        location += numberOfSteps;
        if (location >= 12) {
            location = location - 12;
        }
        return location;
    }

    public Category getCurrentCategory() {
        if (location >= 12) return ROCK;
        switch (location % 4) {
            case 0:
                return POP;
            case 1:
                return SCIENCE;
            case 2:
                return SPORTS;
            default:
                return ROCK;
        }
    }
}
