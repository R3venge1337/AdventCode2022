import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventDay4 {
	public int campCleanup(String fileName) throws FileNotFoundException {
		int sum = 0;
		try (Scanner scr = new Scanner(new File(fileName))) {
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				String[] str = line.split(",");
				sum += sumAssignmentsInBothPair(str[0], str[1]);
			}
		}
		return sum;
	}

	public int sumAssignmentsInBothPair(String firstSection, String secondSection) {
		int sum = 0;
		int firstPairLow = Integer.parseInt(firstSection.split("-")[0]);
		int firstPairHigh = Integer.parseInt(firstSection.split("-")[1]);
		int secondPairLow = Integer.parseInt(secondSection.split("-")[0]);
		int secondPairHigh = Integer.parseInt(secondSection.split("-")[1]);

		if (firstPairLow >= secondPairLow && firstPairHigh <= secondPairHigh) {
			sum += 1;
		} else if (firstPairLow <= secondPairLow && firstPairHigh >= secondPairHigh) {
			sum += 1;
		}
		return sum;
	}

	public int campCleanupPart2(String fileName) throws FileNotFoundException {
		int sumOverlap = 0;
		try (Scanner scr = new Scanner(new File(fileName))) {
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				String[] str = line.split(",");
				sumOverlap += sumAssignmentsOverlapPairs(str[0], str[1]);
			}
		}
		return sumOverlap;
	}

	public int sumAssignmentsOverlapPairs(String firstSection, String secondSection) {
		int sum = 0;
		int all = 0;
		int firstPairLow = Integer.parseInt(firstSection.split("-")[0]);
		int firstPairHigh = Integer.parseInt(firstSection.split("-")[1]);
		int secondPairLow = Integer.parseInt(secondSection.split("-")[0]);
		int secondPairHigh = Integer.parseInt(secondSection.split("-")[1]);

		if (firstPairLow > secondPairHigh) {
			sum += 1;
		} else if (secondPairLow > firstPairHigh) {
			sum += 1;
		}
		all++;
		return all - sum;
	}

}
