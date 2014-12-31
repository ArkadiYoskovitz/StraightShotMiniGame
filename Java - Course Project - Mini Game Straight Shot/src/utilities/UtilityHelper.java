package utilities;

import java.util.ArrayList;
import java.util.Scanner;

public final class UtilityHelper {
	
	public static ArrayList<Integer> toArray(int number) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		Integer curDigitInteger;
		
		int numDigits = (int) Math.floor( Math.log10(number) + 1 );
		
		for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
			int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
			curDigitInteger = new Integer(curDigit);
			results.add(curDigitInteger);
		}
		return results;
	}
	
	public static boolean hasDistinctDigits(int number) {
		int numMask = 0;
		int numDigits = (int) Math.floor( Math.log10(number) + 1 );
		
		for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
			
			int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
			
			int digitMask = (int)Math.pow(2, curDigit);             
			
			if ((numMask & digitMask) > 0) {
				return false;
			}
			numMask = numMask | digitMask;
		}
		return true;
	}
	
	public static ArrayList<Integer> toArray(String s) {
		int number = Integer.parseInt(s);
		return toArray(number);
	}
	
	public static boolean isNumeric(String str)  {  
		Scanner scanner = new Scanner(str);
		boolean flag = scanner.hasNextInt();
		scanner.close();
		return flag;  
	}
}