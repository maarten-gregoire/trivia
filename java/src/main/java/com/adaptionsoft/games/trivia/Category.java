package com.adaptionsoft.games.trivia;

import static java.util.Arrays.stream;

enum Category {
    POP(0, "Pop"), SCIENCE(1, "Science"), SPORTS(2, "Sports"), ROCK(3, "Rock");

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

    public static Category getCategory(int location) {
        return stream(Category.values())
                .filter(category -> (category.getLocation() == (location % 4) && (location < 12)))
                .findFirst().orElse(ROCK);
    }

}
