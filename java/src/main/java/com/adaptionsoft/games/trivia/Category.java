package com.adaptionsoft.games.trivia;

enum Category {
    POP(1, "pop"), SCIENCE(2, "science"), SPORTS(3, "sports"), ROCK(4, "rock");

    int location;
    String text;

    Category(int location, String text) {
        this.location = location;
        this.text = text;
    }

    public int getLocation() {
        return location;
    }

    public String getText() {
        return text;
    }
}
