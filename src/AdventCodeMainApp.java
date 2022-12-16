import java.io.FileNotFoundException;

public class AdventCodeMainApp {

	public static void main(String[] args) {
		
		AdventDay1 adv1 = new AdventDay1();
	
		try {
			int maxCal = adv1.maxElfCalories("src/input.txt");
			//System.out.println(maxCal);
			
			int maxTopThreeCaloriesSum = adv1.maxTopThreeElfCalories("src/input.txt");
			//System.out.println(maxTopThreeCaloriesSum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
