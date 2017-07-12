
package com.adaptionsoft.games.trivia.runner;
import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;


public class GameRunner {

	private static boolean notAWinner;
	private static Random rand = new Random();

	public static void main(String[] args) {
		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		

	
		do {
			
			aGame.roll(getRandomNumberBetween1And5());
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (notAWinner);
		
	}

	private static int getRandomNumberBetween1And5() {
		return rand.nextInt(5) + 1;
	}
}
