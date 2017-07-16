package com.adaptionsoft.games.trivia;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.adaptionsoft.games.trivia.Player.aPlayer;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    int[] positions = new int[6];
    int[] goldCoins = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    Player currentPlayer;
    boolean isGettingOutOfPenaltyBox;
    private String ANSWER_WAS_CORRECT_LINE = "Answer was correct!!!!";
    private String GOLD_COINS_LINE = "%s now has %s Gold Coins.";

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
        goldCoins[getNumberOfPlayers()] = 0;
        inPenaltyBox[getNumberOfPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }
        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer.getNumber()]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
                positions[currentPlayer.getNumber()] = positions[currentPlayer.getNumber()] + roll;
                if (positions[currentPlayer.getNumber()] > 11) positions[currentPlayer.getNumber()] = positions[currentPlayer.getNumber()] - 12;

                System.out.println(currentPlayer.getName()
                        + "'s new location is "
                        + positions[currentPlayer.getNumber()]);
                System.out.println("The category is " + getCurrentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            positions[currentPlayer.getNumber()] = positions[currentPlayer.getNumber()] + roll;
            if (positions[currentPlayer.getNumber()] > 11) positions[currentPlayer.getNumber()] = positions[currentPlayer.getNumber()] - 12;

            System.out.println(currentPlayer.getName()
                    + "'s new location is "
                    + positions[currentPlayer.getNumber()]);
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
        switch (positions[currentPlayer.getNumber()] % 4) {
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
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }
        printAnswerWasCorrectLine();

        addGoldCoinForCurrentPlayer();

        printGoldCoinsLine();

        boolean noWinnerYet = isPlayerNotTheWinner();

        findCurrentPlayer();

        return noWinnerYet;
    }

    private void addGoldCoinForCurrentPlayer() {
        goldCoins[currentPlayer.getNumber()]++;
        currentPlayer.addGoldCoin();
    }

    private void printAnswerWasCorrectLine() {
        System.out.println(ANSWER_WAS_CORRECT_LINE);
    }

    private void printGoldCoinsLine() {
        System.out.println(
                String.format(GOLD_COINS_LINE, currentPlayer.getName(), goldCoins[currentPlayer.getNumber()] ));
    }

    private void findCurrentPlayer() {
        if (currentPlayer.getNumber()+1 == players.size()) {
            currentPlayer = players.get(0);
        } else {
            currentPlayer = players.get(currentPlayer.getNumber()+1);
        }
    }

    public boolean giveWrongAnswer(){
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        inPenaltyBox[currentPlayer.getNumber()] = true;

        int currentPlayerNumber = currentPlayer.getNumber()+1;
        if (currentPlayerNumber == players.size()) currentPlayerNumber = 0;
        currentPlayer = players.get(currentPlayerNumber);

        return true;
    }

    private boolean isPlayerNotTheWinner() {
        return inPenaltyBox[currentPlayer.getNumber()] && !isGettingOutOfPenaltyBox || !(goldCoins[currentPlayer.getNumber()] == 6);
    }
}
