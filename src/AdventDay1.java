import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdventDay1 {

	public int maxElfCalories(String fileName) throws FileNotFoundException {
		int maxCalories = 0;
		int eachElfCaloriesCount = 0;
		Scanner scr = new Scanner(new File(fileName));

		while (scr.hasNextLine()) {
			String line = scr.nextLine();
			if (!(line.equals(""))) {
				// System.out.println(scr.nextLine());
				eachElfCaloriesCount += Integer.parseInt(line);
				maxCalories = Math.max(maxCalories, eachElfCaloriesCount);
			}

			if (line.equals("")) {
				eachElfCaloriesCount = 0;
			}
		}
		return maxCalories;
	}

	public int maxTopThreeElfCalories(String fileName) throws FileNotFoundException {
		int maxCalories = 0;
		int eachElfCaloriesCount = 0;
		List<Integer> elfCaloriesList = new ArrayList<Integer>();
		Scanner scr = new Scanner(new File(fileName));

		while (scr.hasNextLine()) {
			String line = scr.nextLine();
			if (!(line.equals(""))) {
				// System.out.println(scr.nextLine());
				eachElfCaloriesCount += Integer.parseInt(line);
				maxCalories = Math.max(maxCalories, eachElfCaloriesCount);
			}

			if (line.equals("")) {
				elfCaloriesList.add(eachElfCaloriesCount);
				eachElfCaloriesCount = 0;
			}
		}
		Collections.sort(elfCaloriesList, Collections.reverseOrder());

		return elfCaloriesList.get(0) + elfCaloriesList.get(1) + elfCaloriesList.get(2);
	}
}
