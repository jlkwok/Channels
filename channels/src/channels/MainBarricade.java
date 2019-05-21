package channels;

import java.util.Arrays;
import java.util.List;

public class MainBarricade {
	
	/*
	 * Checks if characters after TO are integers
	 * returns whether the current line starts with TO and if it should be added to
	 * the StringBuilder
	 */
	public static boolean isValidTO(String lineNew, StringBuilder localSB) {
		if(!lineNew.startsWith("TO"))
			return false;
		return lineNew.substring(3).chars().allMatch(Character::isDigit) && !localSB.toString().contains(Character.toString(lineNew.charAt(3)));
			
	}
	
	public static boolean isValidRep(String lineNew, StringBuilder localSB) {
		if(!lineNew.startsWith("REP"))
			return false;
		return lineNew.substring(4).chars().allMatch(Character::isDigit);
	}
	
	public static boolean isValidTHISIS(String lineNew, StringBuilder localSB) {
		if(!lineNew.startsWith("THISIS"))
			return false;
		return lineNew.substring(7).chars().allMatch(Character::isDigit) && !localSB.toString().contains(Character.toString(lineNew.charAt(7)));
			
	}
	
	public static boolean isValidCommand(String lineNew) {
		if(lineNew.isEmpty()) return true;
		List<String> validStrings = Arrays.asList("TO", "REP", "THISIS");
		for (String s : validStrings) {
			if (lineNew.contains(s))
				return true;
		}
		if(lineNew.chars().allMatch(Character::isDigit)) return true;
		return false;

		
	}
	

}
