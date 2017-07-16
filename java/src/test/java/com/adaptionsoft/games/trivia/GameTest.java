package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest extends ConsoleOutputTest {

    @Test
    public void givenNoPlayers_whenWrongAnswer_thenThrowIndexOutOfBoundsException() {
        expectException.expect(IndexOutOfBoundsException.class);
        Game game = new Game();

        game.giveWrongAnswer();
    }

    @Test
    public void givenFourPlayers_whenAddOnePlayer_thenHowManyPlayersIsFive() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME, PLAYER3_NAME, PLAYER4_NAME);
        game.add(PLAYER5_NAME);

        assertEquals(5, game.getNumberOfPlayers());
    }

    @Test
    public void givenFivePlayers_whenAddOnePlayer_thenThrowException() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME, PLAYER3_NAME, PLAYER4_NAME, PLAYER5_NAME);
        expectException.expect(IndexOutOfBoundsException.class);
        game.add(PLAYER6_NAME);
    }

    @Test
    public void givenOnePlayer_whenOneWrongAnswer_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME);

        boolean result = game.giveWrongAnswer();

        assertTrue(result);
    }

    @Test
    public void givenOnePlayer_whenOneCorrectAnswer_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME);

        boolean result = game.giveCorrectAnswer();

        assertTrue(result);
    }

    @Test
    public void givenOnePlayer_whenSixCorrectAnswers_thenNotAWinnerFalse() {
        Game game = createGameWithPlayers(PLAYER1_NAME);

        giveCorrectAnswers(game, 5);

        assertFalse(game.giveCorrectAnswer());
    }

    @Test
    public void givenOnePlayer_whenFourCorrectAndTwoWrongAndOneCorrectAnswer_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME);

        giveCorrectAnswers(game, 4);
        giveWrongAnswers(game, 2);
        assertTrue(game.giveCorrectAnswer());
    }

    @Test
    public void givenTwoPlayers_whenOneCorrectAnswer_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        boolean result = game.giveCorrectAnswer();

        assertTrue(result);
    }

    @Test
    public void givenTwoPlayers_whenOneWrongAnswer_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        assertTrue(game.giveWrongAnswer());
    }

    @Test
    public void givenTwoPlayers_whenSixCorrectAnswers_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        giveCorrectAnswers(game, 5);
        assertTrue(game.giveCorrectAnswer());
    }

    @Test
    public void givenTwoPlayers_whenElevenCorrectAnswers_thenNotAWinnerFalse() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        giveCorrectAnswers(game, 10);

        assertFalse(game.giveCorrectAnswer());
    }

    @Test
    public void givenOnePlayer_whenSixCorrectAnswers_thenConsoleOutputIsCorrect() {
        Game game = createGameWithPlayers("Ben");

        giveCorrectAnswers(game, 6);

        String expectedOutput = "Ben was added\r\n" +
                "They are player number 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 1 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 2 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 3 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 4 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 5 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 6 Gold Coins.\r\n";

        String actualOutput = consoleOutput.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenTwoPlayers_whenElevenCorrectAnswers_thenConsoleOutputIsCorrect() {
        Game game = createGameWithPlayers("Ben", "Bart");

        giveCorrectAnswers(game, 11);

        String expectedOutput = "Ben was added\r\n" +
                "They are player number 1\r\n" +
                "Bart was added\r\n" +
                "They are player number 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 1 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 1 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 2 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 2 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 3 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 3 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 4 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 4 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 5 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 5 Gold Coins.\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 6 Gold Coins.\r\n";

        String actualOutput = consoleOutput.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenTwoPlayers_whenOnePlayerHasAllWrongAndTheOtherAllRight_thenConsoleOutputIsCorrect() {
        Game game = createGameWithPlayers("Ben", "Bart");

        giveAlternatelyCorrectAndWrongAnswers(game, 11);

        String expectedOutput = "Ben was added\r\n" +
                "They are player number 1\r\n" +
                "Bart was added\r\n" +
                "They are player number 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 1 Gold Coins.\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 2 Gold Coins.\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 3 Gold Coins.\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 4 Gold Coins.\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 5 Gold Coins.\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 6 Gold Coins.\r\n";

        String actualOutput = consoleOutput.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenTwoPlayers_whenEachAnsweringRightAndWrongAlternately_thenConsoleOutputIsCorrect() {
        Game game = createGameWithPlayers("Ben", "Bart");

        giveAlternatelyCorrectAndWrongAnswersForEachPlayerUntilWinner(game, 2);

        String expectedOutput = "Ben was added\r\n" +
                "They are player number 1\r\n" +
                "Bart was added\r\n" +
                "They are player number 2\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 1 Gold Coins.\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 1 Gold Coins.\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 0\r\n" +
                "Question was incorrectly answered\r\n" +
                "Ben was sent to the penalty box\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 1\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 3\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 2 Gold Coins.\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 3\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 2 Gold Coins.\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 0\r\n" +
                "Question was incorrectly answered\r\n" +
                "Ben was sent to the penalty box\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 1\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 3 Gold Coins.\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 3 Gold Coins.\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 6\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 2\r\n" +
                "Question was incorrectly answered\r\n" +
                "Ben was sent to the penalty box\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 6\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 3\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 4 Gold Coins.\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 4 Gold Coins.\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 2\r\n" +
                "Question was incorrectly answered\r\n" +
                "Ben was sent to the penalty box\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 3\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 9\r\n" +
                "The category is Science\r\n" +
                "Science Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 5 Gold Coins.\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 9\r\n" +
                "The category is Science\r\n" +
                "Science Question 5\r\n" +
                "Answer was correct!!!!\r\n" +
                "Bart now has 5 Gold Coins.\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 10\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 4\r\n" +
                "Question was incorrectly answered\r\n" +
                "Ben was sent to the penalty box\r\n" +
                "Bart is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Bart is getting out of the penalty box\r\n" +
                "Bart's new location is 10\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 5\r\n" +
                "Question was incorrectly answered\r\n" +
                "Bart was sent to the penalty box\r\n" +
                "Ben is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Ben is getting out of the penalty box\r\n" +
                "Ben's new location is 11\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Ben now has 6 Gold Coins.\r\n";

        String actualOutput = consoleOutput.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenTheePlayers_whenEachAnsweringRightAndWrongAlternately_thenConsoleOutputIsCorrect() {
        Game game = createGameWithPlayers("Chet", "Pat", "Sue");

        giveAlternatelyCorrectAndWrongAnswersForEachPlayerUntilWinner(game, 3);

        String expectedOutput = "Chet was added\r\n" +
                "They are player number 1\r\n" +
                "Pat was added\r\n" +
                "They are player number 2\r\n" +
                "Sue was added\r\n" +
                "They are player number 3\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 1 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 1 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 1 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 0\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 1\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 2\r\n" +
                "Question was incorrectly answered\r\n" +
                "Sue was sent to the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 3\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 2 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 3\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 2 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 3\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 2 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 0\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 1\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 2\r\n" +
                "Question was incorrectly answered\r\n" +
                "Sue was sent to the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 3 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 3 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 5\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 3 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 6\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 3\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 6\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 4\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 6\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 5\r\n" +
                "Question was incorrectly answered\r\n" +
                "Sue was sent to the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 4 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 4 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 5\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 4 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 3\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 4\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 5\r\n" +
                "Question was incorrectly answered\r\n" +
                "Sue was sent to the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 9\r\n" +
                "The category is Science\r\n" +
                "Science Question 6\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 5 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 9\r\n" +
                "The category is Science\r\n" +
                "Science Question 7\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 5 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 9\r\n" +
                "The category is Science\r\n" +
                "Science Question 8\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 5 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 10\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 6\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 10\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 7\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 10\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 8\r\n" +
                "Question was incorrectly answered\r\n" +
                "Sue was sent to the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 11\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 6\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 6 Gold Coins.\r\n";

        String actualOutput = consoleOutput.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    private void giveAlternatelyCorrectAndWrongAnswersForEachPlayerUntilWinner(Game game, int numberOfPlayers) {
        boolean mustGiveCorrectAnswer = true;
        int currentPlayer = 0;
        boolean noWinnerYet = true;
        while (noWinnerYet) {
            game.roll(1);
            if (mustGiveCorrectAnswer) {
                noWinnerYet = game.giveCorrectAnswer();
            } else {
                noWinnerYet = game.giveWrongAnswer();
            }
            currentPlayer++;
            if (currentPlayer >= numberOfPlayers) {
                mustGiveCorrectAnswer = !mustGiveCorrectAnswer;
                currentPlayer = 0;
            }
        }
    }

    private void giveAlternatelyCorrectAndWrongAnswers(Game game, int amount) {
        boolean mustGiveCorrectAnswer = true;
        for (int i = 0; i < amount; i++) {
            if (mustGiveCorrectAnswer) {
                game.giveCorrectAnswer();
                mustGiveCorrectAnswer = false;
            } else {
                game.giveWrongAnswer();
                mustGiveCorrectAnswer = true;
            }
        }
    }

    @Test
    public void givenTwoPlayers_whenElevenWrongAnswers_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        giveWrongAnswers(game, 10);
        assertTrue(game.giveWrongAnswer());
    }

    @Test
    public void givenTwoPlayers_whenWrongAnswerAfterNotAWinnerIsFalse_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        giveCorrectAnswers(game, 11);
        assertTrue(game.giveWrongAnswer());
    }

    @Test
    public void givenThreePlayers_whenOneWrongAnswer_thenNotAWinnerTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        assertTrue(game.giveWrongAnswer());
    }

    @Test
    public void givenNoPlayers_thenIsPlayableFalse() {
        Game game = new Game();

        assertFalse(game.isPlayable());
    }

    @Test
    public void givenOnePlayer_thenIsPlayableFalse() {
        Game game = createGameWithPlayers(PLAYER1_NAME);

        assertFalse(game.isPlayable());
    }

    @Test
    public void givenTwoPlayers_thenIsPlayableTrue() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        assertTrue(game.isPlayable());
    }

    @Test
    public void givenNoPlayers_thenHowManyPlayersIs0() {
        Game game = new Game();

        assertThat(game.getNumberOfPlayers()).isEqualTo(0);
    }

    @Test
    public void given1Player_thenHowManyPlayersIs1() {
        Game game = createGameWithPlayers(PLAYER1_NAME);

        assertThat(game.getNumberOfPlayers()).isEqualTo(1);
    }

    @Test
    public void givenGameWithoutPlayers_whenAddFirstPlayer_thenOutputCorrectNameInAddedLine() {
        Game game = new Game();
        game.add(PLAYER1_NAME);

        String expectedOutput = PLAYER1_NAME + " was added";
        String actualOutput = getPlayerAddedLineFromConsole(1);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_whenAddSecondPlayer_thenOutputCorrectNameInAddedLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.add(PLAYER2_NAME);

        String expectedOutput = PLAYER2_NAME + " was added";
        String actualOutput = getPlayerAddedLineFromConsole(2);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithTwoPlayers_whenAddThirdPlayer_thenOutputCorrectNameInAddedLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);
        game.add(PLAYER3_NAME);

        String expectedOutput = PLAYER3_NAME + " was added";
        String actualOutput = getPlayerAddedLineFromConsole(3);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithThreePlayers_whenAddFourthPlayer_thenOutputCorrectNameInAddedLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME, PLAYER3_NAME);
        game.add(PLAYER4_NAME);

        String expectedOutput = PLAYER4_NAME + " was added";
        String actualOutput = getPlayerAddedLineFromConsole(4);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithFourPlayers_whenAddFifthPlayer_thenOutputCorrectNameInAddedLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME, PLAYER3_NAME, PLAYER4_NAME);
        game.add(PLAYER5_NAME);

        String expectedOutput = PLAYER5_NAME + " was added";
        String actualOutput = getPlayerAddedLineFromConsole(5);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_thenOutputCorrectNameInCurrentPlayerLineInFirstTurn() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.roll(1);

        String expectedOutput = PLAYER1_NAME + " is the current player";
        String actualOutput = getLineFromConsole(2);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_thenOutputCorrectNameInCurrentPlayerLineInSecondTurn() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        game.roll(1);
        game.giveCorrectAnswer();
        game.roll(1);
        game.giveCorrectAnswer();
        game.roll(1);

        String expectedOutput = PLAYER1_NAME + " is the current player";
        String actualOutput = getLineFromConsole(18);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithSecondPlayer_thenOutputCorrectNameInCurrentPlayerLineInFirstTurn() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        game.roll(1);
        game.giveCorrectAnswer();
        game.roll(1);

        String expectedOutput = PLAYER2_NAME + " is the current player";
        String actualOutput = getLineFromConsole(11);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithSecondPlayer_thenOutputCorrectNameInCurrentPlayerLineInSecondTurn() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);

        game.roll(1);
        game.giveCorrectAnswer();
        game.roll(1);
        game.giveCorrectAnswer();
        game.roll(1);
        game.giveCorrectAnswer();
        game.roll(1);

        String expectedOutput = PLAYER2_NAME + " is the current player";
        String actualOutput = getLineFromConsole(25);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_thenOutputCorrectNameInLocationLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.roll(1);

        String expectedOutput = PLAYER1_NAME + "'s new location is 1";
        String actualOutput = getLineFromConsole(4);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_thenOutputCorrectNameInGoldCoinsLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.roll(1);
        game.giveCorrectAnswer();

        String expectedOutput = PLAYER1_NAME + " now has 1 Gold Coins.";
        String actualOutput = getLineFromConsole(8);

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void givenGameWithOnePlayer_thenOutputCorrectNameInSentToPenaltyBoxLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.roll(1);
        game.giveWrongAnswer();

        String expectedOutput = PLAYER1_NAME + " was sent to the penalty box";
        String actualOutput = getLineFromConsole(8);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_thenOutputCorrectNameInOutOfPenaltyBoxLine() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.roll(1);
        game.giveWrongAnswer();
        game.roll(1);

        String expectedOutput = PLAYER1_NAME + " is getting out of the penalty box";
        String actualOutput = getLineFromConsole(11);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithoutPlayers_whenAddFirstPlayer_thenOutputCorrectNumber() {
        Game game = new Game();
        game.add(PLAYER1_NAME);
        int playerNumber = 1;

        String expectedOutput = "They are player number " + playerNumber;
        String actualOutput = getPlayerNumberLineFromConsole(playerNumber);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithOnePlayer_whenAddSecondPlayer_thenOutputCorrectNumber() {
        Game game = createGameWithPlayers(PLAYER1_NAME);
        game.add(PLAYER2_NAME);

        int playerNumber = 2;

        String expectedOutput = "They are player number " + playerNumber;
        String actualOutput = getPlayerNumberLineFromConsole(playerNumber);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithTwoPlayers_whenAddThirdPlayer_thenOutputCorrectNumber() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME);
        game.add(PLAYER3_NAME);

        int playerNumber = 3;

        String expectedOutput = "They are player number " + playerNumber;
        String actualOutput = getPlayerNumberLineFromConsole(playerNumber);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithThreePlayers_whenAddFourthPlayer_thenOutputCorrectNumber() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME, PLAYER3_NAME);
        game.add(PLAYER4_NAME);

        int playerNumber = 4;

        String expectedOutput = "They are player number " + playerNumber;
        String actualOutput = getPlayerNumberLineFromConsole(playerNumber);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void givenGameWithFourPlayers_whenAddFifthPlayer_thenOutputCorrectNumber() {
        Game game = createGameWithPlayers(PLAYER1_NAME, PLAYER2_NAME, PLAYER3_NAME, PLAYER4_NAME);
        game.add(PLAYER5_NAME);

        int playerNumber = 5;

        String expectedOutput = "They are player number " + playerNumber;
        String actualOutput = getPlayerNumberLineFromConsole(playerNumber);

        assertEquals(expectedOutput, actualOutput);
    }

    private String getPlayerAddedLineFromConsole(int playerNumber) {
        return getLineFromConsole(2 * (playerNumber - 1));
    }

    private String getLineFromConsole(int line) {
        String[] outputLines = getOutputInLines();
        return outputLines[line];
    }

    private String getPlayerNumberLineFromConsole(int playerNumber) {
        return getLineFromConsole(1 + 2 * (playerNumber - 1));
    }

    private void giveWrongAnswers(Game game, int amount) {
        for (int i = 0; i < amount; i++) {
            game.giveWrongAnswer();
        }
    }

    private void giveCorrectAnswers(Game game, int amount) {
        for (int i = 0; i < amount; i++) {
            game.giveCorrectAnswer();
        }
    }

    private static Game createGameWithPlayers(String... players) {
        Game game = new Game();
        for (String player : players) {
            game.add(player);
        }
        return game;
    }
}
