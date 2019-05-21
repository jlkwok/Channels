package channels;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int local = -1;
		int receiver = -1;
		int line = 0;
		boolean result = false;
		Scanner input = new Scanner(System.in);
		String lineNew;
		StringBuilder localSB = new StringBuilder();
		StringBuilder receiverSB = new StringBuilder();

		while (!result) {
			try {
			lineNew = input.nextLine().toUpperCase();
			}catch(NoSuchElementException e) {
				break;
			}
			if (!MainBarricade.isValidCommand(lineNew))
				continue;
			local = setInitialLocalAddress(lineNew, line, local);
			receiver = setInitialReceiverAddress(lineNew, line, receiver);
			System.out.println("local: " + Integer.toString(local) + " receiver: " + Integer.toString(receiver));
			
			if (local > 0) {
				// if local address is incomplete
				buildLocalAddress(lineNew, localSB, local);
				// if local address is complete and correct
				buildReceiverAddress(lineNew, receiverSB, localSB, local);
				// sets result to true when both addresses are complete and correct
				result = isCorrectAddresses(localSB, local, receiverSB, receiver);
			}
			line++;
		}
		input.close();
		System.out.println(result);
	}

	public static int setInitialReceiverAddress(String lineNew, int lineNum, int receiver) {
		if (lineNum == 1)
		if (lineNew.chars().allMatch(Character::isDigit)) {
				return Integer.parseInt(lineNew);
		}
		return receiver;
	}
	
	public static int setInitialLocalAddress(String lineNew, int lineNum, int local) {
		if (lineNum == 0) 
		if (lineNew.chars().allMatch(Character::isDigit)) {
				return Integer.parseInt(lineNew);
		}
		return local;
	}

	/*
	 * builds local address from input stream
	 */
	public static void buildLocalAddress(String lineNew, StringBuilder localSB, int local) {
		int charIndex = 0;
		if (!isLocalCorrect(localSB, local)) {
			if (MainBarricade.isValidTO(lineNew, localSB))
				charIndex = 3;
			if (MainBarricade.isValidRep(lineNew, localSB))
				charIndex = 4;
		}
		if (charIndex != 0)
			addCharToSB(localSB, lineNew, charIndex);
	}

	/*
	 * appends the indicated char to the input StringBuilder
	 */
	public static void addCharToSB(StringBuilder sb, String lineNew, int charIndex) {
		sb.append(Character.toString(lineNew.charAt(charIndex)));
	}

	/*
	 * returns whether the local address is correct
	 */
	public static boolean isLocalCorrect(StringBuilder localSB, int local) {
		boolean result = false;
		if (localSB.toString().equals(Integer.toString(local)))
			result = true;
		return result;
	}

	/*
	 * builds the receiver address from input stream
	 */
	public static void buildReceiverAddress(String lineNew, StringBuilder receiverSB, StringBuilder localSB,
			int local) {
		int charIndex = 0;
		if (isLocalCorrect(localSB, local)) {
			if (MainBarricade.isValidTHISIS(lineNew, localSB))
				charIndex = 7;
			if (MainBarricade.isValidRep(lineNew, localSB) && !receiverSB.toString().isEmpty())
				charIndex = 4;
		}
		if (charIndex != 0)
			addCharToSB(receiverSB, lineNew, charIndex);
	}

	/*
	 * returns whether the local and receiver addresses are correct
	 */
	public static boolean isCorrectAddresses(StringBuilder localSB, int localInt, StringBuilder receiverSB,
			int receiverInt) {
		boolean result = false;
		if (localSB.toString().equals(Integer.toString(localInt))
				&& receiverSB.toString().equals(Integer.toString(receiverInt)))
			result = true;
		return result;
	}

}
