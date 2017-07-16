package com.adaptionsoft.games.trivia;

enum Category {
    POP(1, "Pop"), SCIENCE(2, "Science"), SPORTS(3, "Sports"), ROCK(4, "Rock");

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
