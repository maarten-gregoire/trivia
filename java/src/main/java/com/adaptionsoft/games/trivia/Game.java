package com.adaptionsoft.games.trivia;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.adaptionsoft.games.trivia.Player.aPlayer;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    int[] positions = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    Player currentPlayerObject;
    boolean isGettingOutOfPenaltyBox;

    public  Game(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (getNumberOfPlayers() >= 2);
    }

    public boolean add(String playerName) {

        players.add(aPlayer(playerName, players.size()));
        positions[getNumberOfPlayers()] = 0;
        purses[getNumberOfPlayers()] = 0;
        inPenaltyBox[getNumberOfPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        if (currentPlayerObject == null) {
            currentPlayerObject = players.get(0);
        }
        System.out.println(currentPlayerObject.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayerObject.getNumber()]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayerObject.getName() + " is getting out of the penalty box");
                positions[currentPlayerObject.getNumber()] = positions[currentPlayerObject.getNumber()] + roll;
                if (positions[currentPlayerObject.getNumber()] > 11) positions[currentPlayerObject.getNumber()] = positions[currentPlayerObject.getNumber()] - 12;

                System.out.println(currentPlayerObject.getName()
                        + "'s new location is "
                        + positions[currentPlayerObject.getNumber()]);
                System.out.println("The category is " + getCurrentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayerObject.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            positions[currentPlayerObject.getNumber()] = positions[currentPlayerObject.getNumber()] + roll;
            if (positions[currentPlayerObject.getNumber()] > 11) positions[currentPlayerObject.getNumber()] = positions[currentPlayerObject.getNumber()] - 12;

            System.out.println(currentPlayerObject.getName()
                    + "'s new location is "
                    + positions[currentPlayerObject.getNumber()]);
            System.out.println("The category is " + getCurrentCategory());
            askQuestion();
        }
    }

    private void askQuestion() {
        if (getCurrentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (getCurrentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (getCurrentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (getCurrentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }

    private String getCurrentCategory() {
        switch (positions[currentPlayerObject.getNumber()] % 4) {
            case 0:
                return "Pop";
            case 1:
                return "Science";
            case 2:
                return "Sports";
            default:
                return "Rock";
        }
    }

    public boolean giveCorrectAnswer() {
        if (currentPlayerObject == null) {
            currentPlayerObject = players.get(0);
        }
        if (inPenaltyBox[currentPlayerObject.getNumber()]){
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                purses[currentPlayerObject.getNumber()]++;
                System.out.println(players.get(currentPlayerObject.getNumber()).getName()
                        + " now has "
                        + purses[currentPlayerObject.getNumber()]
                        + " Gold Coins.");
                boolean winner = isPlayerWinner();

                int currentPlayerNumber = currentPlayerObject.getNumber()+1;
                if (currentPlayerNumber == players.size()) currentPlayerNumber = 0;
                currentPlayerObject = players.get(currentPlayerNumber);
                return winner;
            } else {
                int currentPlayerNumber = currentPlayerObject.getNumber()+1;
                if (currentPlayerNumber == players.size()) currentPlayerNumber = 0;
                currentPlayerObject = players.get(currentPlayerNumber);
                return true;
            }

        } else {
            System.out.println("Answer was correct!!!!");
            purses[currentPlayerObject.getNumber()]++;
            System.out.println(currentPlayerObject.getName()
                    + " now has "
                    + purses[currentPlayerObject.getNumber()]
                    + " Gold Coins.");

            boolean winner = isPlayerWinner();

            int currentPlayerNumber = currentPlayerObject.getNumber()+1;
            if (currentPlayerNumber == players.size()) currentPlayerNumber = 0;
            currentPlayerObject = players.get(currentPlayerNumber);
            return winner;
        }
    }

    public boolean giveWrongAnswer(){
        if (currentPlayerObject == null) {
            currentPlayerObject = players.get(0);
        }
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayerObject.getName() + " was sent to the penalty box");
        inPenaltyBox[currentPlayerObject.getNumber()] = true;

        int currentPlayerNumber = currentPlayerObject.getNumber()+1;
        if (currentPlayerNumber == players.size()) currentPlayerNumber = 0;
        currentPlayerObject = players.get(currentPlayerNumber);

        return true;
    }

    private boolean isPlayerWinner() {
        return !(purses[currentPlayerObject.getNumber()] == 6);
    }
}
