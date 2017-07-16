
package com.adaptionsoft.games.trivia.runner;
import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;


public class GameRunner {

	private static boolean notAWinner;
	private static Random rand = new Random();

	public static void main(String... args) {
		Game game = createGameWithPlayers("Chet", "Pat", "Sue");

		do {
			playGameRandomly(game);
		} while (notAWinner);
	}

	private static void playGameRandomly(Game game) {
		game.roll(getRandomNumberBetween1And5());

		if (rand.nextInt(9) == 7) {
            notAWinner = game.wrongAnswer();
        } else {
            notAWinner = game.wasCorrectlyAnswered();
        }
	}

	private static Game createGameWithPlayers(String... players) {
		Game game = new Game();
		for (String player: players){
			game.add(player);
		}
		return game;
	}

	private static int getRandomNumberBetween1And5() {
		return rand.nextInt(5) + 1;
	}
}
