package com.adaptionsoft.games.trivia;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.adaptionsoft.games.trivia.Player.aPlayer;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    Player currentPlayer;
    boolean isGettingOutOfPenaltyBox;
    private String ANSWER_WAS_CORRECT_LINE = "Answer was correct!!!!";
    private String GOLD_COINS_LINE = "%s now has %s Gold Coins.";
    private String PLAYER_ADDED_LINE = "%s was added";
    private String PLAYER_NUMBER_LINE = "They are player number %s";
    private String INCORRECT_ANSWER_LINE = "Question was incorrectly answered";
    private String CATEGORY_LINE = "The category is %s";
    private String LOCATION_LINE = "%s's new location is %s";
    private String CURRENT_PLAYER_LINE = "%s is the current player";
    private String ROLLED_LINE = "They have rolled a %s";

    public Game(){
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

    public void add(String playerName) {

        players.add(aPlayer(playerName, players.size()));
        inPenaltyBox[getNumberOfPlayers()] = false;

        printPlayerNameLine(playerName);
        printPlayerNumberLine();
    }

    private void printPlayerNumberLine() {
        System.out.println(String.format(PLAYER_NUMBER_LINE, players.size()));
    }

    private void printPlayerNameLine(String playerName) {
        System.out.println(String.format(PLAYER_ADDED_LINE, playerName));
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }
        printCurrentPlayerLine();

        printRolledLine(roll);
        if (inPenaltyBox[currentPlayer.getNumber()]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(currentPlayer.getName() + " is getting out of the penalty box");

            } else {
                System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        }

        if (!inPenaltyBox[currentPlayer.getNumber()] || (roll % 2 != 0)) {
            currentPlayer.addToLocation(roll);
            printLocationLine();
            printCategoryLine();
            askQuestion();
        }
    }

    private void printRolledLine(int roll) {
        System.out.println(String.format(ROLLED_LINE, roll));
    }

    private void printCategoryLine() {
        System.out.println(String.format(CATEGORY_LINE, getCurrentCategory()));
    }

    private void printLocationLine() {
        System.out.println(
                String.format(LOCATION_LINE,
                currentPlayer.getName(),
                currentPlayer.getLocation()));
    }

    private void printCurrentPlayerLine() {
        System.out.println(String.format(CURRENT_PLAYER_LINE, currentPlayer.getName()));
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
        return currentPlayer.getCurrentCategory().getText();
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
        currentPlayer.addGoldCoin();
    }

    private void printAnswerWasCorrectLine() {
        System.out.println(ANSWER_WAS_CORRECT_LINE);
    }

    private void printGoldCoinsLine() {
        System.out.println(
                String.format(GOLD_COINS_LINE, currentPlayer.getName(), currentPlayer.getGoldCoins() ));
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
        printIncorrectAnswerLine();

        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        inPenaltyBox[currentPlayer.getNumber()] = true;

        findCurrentPlayer();

        return true;
    }

    private void printIncorrectAnswerLine() {
        System.out.println(INCORRECT_ANSWER_LINE);
    }

    private boolean isPlayerNotTheWinner() {
        return inPenaltyBox[currentPlayer.getNumber()] && !isGettingOutOfPenaltyBox || !(currentPlayer.getGoldCoins() == 6);
    }
}
