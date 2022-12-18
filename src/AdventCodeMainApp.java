import java.io.FileNotFoundException;

public class AdventCodeMainApp {

	public static void main(String[] args) {
		
		AdventDay1 adv1 = new AdventDay1();
		AdventDay2 adv2 = new AdventDay2();
		AdventDay3 adv3 = new AdventDay3();
	
		try {
			
			System.out.println(adv1.maxElfCalories("src/inputDay1.txt"));
			System.out.println(adv1.maxTopThreeElfCalories("src/inputDay1.txt"));

			System.out.println(adv2.calculatePointsFromGameRockPaperScissors("src/inputDay2.txt"));
			System.out.println(adv2.calculatePointsFromDecryptingStrategy("src/inputDay2.txt"));

			System.out.println(adv3.rucksackReorganization("src/inputDay3.txt"));
			System.out.println(adv3.rucksackReorganizationForThreeElves("src/inputDay3.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
