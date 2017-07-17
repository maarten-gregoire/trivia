package com.adaptionsoft.games.trivia;

import static com.adaptionsoft.games.trivia.Category.*;

public class Player {
    private String name;
    private int number;
    private int goldCoins;
    private int location;
    private boolean inPenaltyBox;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.goldCoins = 0;
        this.location = 0;
        this.inPenaltyBox = false;
    }

    public static Player player(String name, int number) {
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
        return getCategory(location);
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void sendToPenaltyBox() {
        this.inPenaltyBox = true;
    }

    public void getOutOfPenaltyBox() {
        this.inPenaltyBox = false;
    }
}
