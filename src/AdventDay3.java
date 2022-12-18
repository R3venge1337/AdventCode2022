import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AdventDay3 {
	
	public int rucksackReorganization(String fileName) throws FileNotFoundException {
		int calculatedSum = 0;
		try (Scanner scr = new Scanner(new File(fileName))) {
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				
				String firstCompartment = line.substring(0,line.length() / 2);
				String secondCompartment = line.substring(line.length() / 2,line.length());
				
				calculatedSum += calculateSumPrioritiesInCompartments(firstCompartment,secondCompartment);
			}
		}
		return calculatedSum;
	}
	
	public int calculateSumPrioritiesInCompartments(String firstCompartment,String secondCompartment) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		HashMap<Character,Integer> prioritesAlphabet = new HashMap<>();
		int sum = 0;
		
		for(int i = 0; i < alphabet.length() / 2; i++) {
			prioritesAlphabet.put(alphabet.charAt(i), i+1);
		}
		
		for(int i = 26; i < alphabet.length() ; i++) {
			prioritesAlphabet.put(alphabet.charAt(i), i+1);
		}
		
		char sameItemInBoth = 0;
		for(int i = 0; i < firstCompartment.length(); i++) {
			for(int j = 0; j < secondCompartment.length(); j++) {
				if(firstCompartment.charAt(i) == secondCompartment.charAt(j)) {
					sameItemInBoth = firstCompartment.charAt(i);
				}
			}
		}
		sum += prioritesAlphabet.get(sameItemInBoth);

		return sum;	
	}
	
	public int rucksackReorganizationForThreeElves(String fileName) throws FileNotFoundException {
		int calculatedSum = 0;
		List<String> groupElves = new ArrayList<>();
		try (Scanner scr = new Scanner(new File(fileName))) {
			while (scr.hasNextLine()) {
				String line = scr.nextLine();
				groupElves.add(line);
			}
		}
		calculatedSum += calculateSumPrioritiesInThreeElvesBadges(groupElves);

		return calculatedSum;
	}
	
	public int calculateSumPrioritiesInThreeElvesBadges(List<String> groupElves) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		HashMap<Character,Integer> prioritesAlphabet = new HashMap<>();
		int sum = 0;
		
		
		for(int i = 0; i < alphabet.length() / 2; i++) {
			prioritesAlphabet.put(alphabet.charAt(i), i+1);
		}
		
		for(int i = 26; i < alphabet.length() ; i++) {
			prioritesAlphabet.put(alphabet.charAt(i), i+1);
		}
		
		char sameItemInThreeRucksacks = 0;
		
		for(int i = 0; i < groupElves.size(); i+=3) {
			String firstRucksacks = groupElves.get(i);
			String secondRucksacks = groupElves.get(i + 1);
			String thirdRucksacks = groupElves.get(i + 2);
			
			for(int j = 0; j < firstRucksacks.length(); j++) {
				for(int k = 0; k < secondRucksacks.length(); k++) {
					for(int l = 0; l < thirdRucksacks.length(); l++) {
						
						if(firstRucksacks.charAt(j) == secondRucksacks.charAt(k)
								&& firstRucksacks.charAt(j) == thirdRucksacks.charAt(l)
								&& secondRucksacks.charAt(k) == thirdRucksacks.charAt(l))
						   {
							sameItemInThreeRucksacks = firstRucksacks.charAt(j);
						}
					}
				}
			}
			sum += prioritesAlphabet.get(sameItemInThreeRucksacks);
		}
		return sum;	
	}
}
