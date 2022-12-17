import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AdventDay2 {

	public int calculatePointsFromGameRockPaperScissors(String fileName) throws FileNotFoundException {
		HashMap<Character, String> opponentChoices = new HashMap<>();
		opponentChoices.put('A', "Rock");
		opponentChoices.put('B', "Paper");
		opponentChoices.put('C', "Scissors");

		HashMap<Character, String> ownChoices = new HashMap<>();
		ownChoices.put('X', "Rock");
		ownChoices.put('Y', "Paper");
		ownChoices.put('Z', "Scissors");
		int maxPoints = 0;

		try (Scanner scr = new Scanner(new File(fileName))) {
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				String[] lineSplit = line.split(" ");
				String opponentChoice = opponentChoices.get(lineSplit[0].charAt(0));
				String ownChoice = ownChoices.get(lineSplit[1].charAt(0));
				maxPoints += encryptedStrategyGuideElf(opponentChoice, ownChoice);
			}
		}
		return maxPoints;

	}

	public int encryptedStrategyGuideElf(String enemyChoice, String myChoice) {

		int rock = 1;
		int paper = 2;
		int scissors = 3;

		if (enemyChoice.equals("Scissors") && myChoice.equals("Scissors"))
			return scissors + 3;

		if (enemyChoice.equals("Rock") && myChoice.equals("Rock"))
			return rock + 3;

		if (enemyChoice.equals("Paper") && myChoice.equals("Paper"))
			return paper + 3;

		if (enemyChoice.equals("Scissors") && myChoice.equals("Rock"))
			return rock + 6;

		if (enemyChoice.equals("Paper") && myChoice.equals("Scissors"))
			return scissors + 6;
		if (enemyChoice.equals("Rock") && myChoice.equals("Paper"))
			return paper + 6;
		if (enemyChoice.equals("Rock") && myChoice.equals("Scissors"))
			return scissors + 0;
		if (enemyChoice.equals("Paper") && myChoice.equals("Rock"))
			return rock + 0;
		if (enemyChoice.equals("Scissors") && myChoice.equals("Paper"))
			return paper + 0;

		return 0;
	}

	// Part 2
	public int calculatePointsFromDecryptingStrategy(String fileName) throws FileNotFoundException {
		HashMap<Character, String> opponentChoices = new HashMap<>();
		opponentChoices.put('A', "Rock");
		opponentChoices.put('B', "Paper");
		opponentChoices.put('C', "Scissors");

		int pont = 0;

		try (Scanner scr = new Scanner(new File(fileName))) {
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				String[] lineSplit = line.split(" ");
				String opponentChoice = opponentChoices.get(lineSplit[0].charAt(0));
				pont += decryptingStrategyGuideElf(opponentChoice, lineSplit[1]);
			}
		}
		return pont;
	}

	public int decryptingStrategyGuideElf(String enemyChoice, String myChoice) {
		// X means you need to lose,
		// Y means you need to end the round in a draw,
		// Z means you need to win.
		int rock = 1;
		int paper = 2;
		int scissors = 3;
		
		int win = 6;
		int draw = 3;
		int lose = 0;
		
		int calc = 0;

		HashMap<Character, String> ownChoices = new HashMap<>();
		ownChoices.put('X', "Lose");
		ownChoices.put('Y', "Draw");
		ownChoices.put('Z', "Win");

		if (ownChoices.get(myChoice.charAt(0)).equals("Lose")) {

			if (enemyChoice.equals("Rock")) {
				calc = scissors + lose;
			}

			if (enemyChoice.equals("Scissors")) {
				calc = paper + lose;
			}
			
			if (enemyChoice.equals("Paper")) {
				calc = rock + lose;
			}
		}

		 if (ownChoices.get(myChoice.charAt(0)).equals("Draw")) {

			if (enemyChoice.equals("Rock")) {
				calc = rock + draw;
			}
			
			if (enemyChoice.equals("Paper")) {
				calc = paper + draw;
			}
			
			if (enemyChoice.equals("Scissors")) {
				calc =  scissors + draw;
			}

		}
		
		 if (ownChoices.get(myChoice.charAt(0)).equals("Win")) {

			if (enemyChoice.equals("Rock")) {
				calc = paper + win;
			}
			
			if (enemyChoice.equals("Paper")) {
				calc = scissors + win;
			}
			
			if (enemyChoice.equals("Scissors")) {
				calc =  rock + win;
			}
		}
		return calc;
	}
}
