package utilities;

import java.util.ArrayList;

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
		try {  
			double number = Double.parseDouble(str);
			int numDigits = (int) Math.floor( Math.log10(number) + 1 );

			if (numDigits != 4) {
				return false;
			} 
		} catch(NumberFormatException nfe) {  
			return false;
		}  
		return true;  
	}

	public static boolean isIntNumeric(String str)  {  
		try {  
			int number = Integer.parseInt(str);
			int numDigits = (int) Math.floor( Math.log10(number) + 1 );

			if (numDigits != 4) {
				return false;
			} 
		} catch(NumberFormatException nfe) {  
			return false;
		}  
		return true;  
	}

}