/**
 * 
 */
package model;

import java.util.ArrayList;

import utilities.UtilityHelper;

/**
 * @author Arkadi Yoskovitz
 */
public class Score {

	// Attribute
	private Target target;
	private int guess;
	private int countBullsEye;
	private int countHit;
	private int countMiss;

	// Contractor
	public Score(Target target) {
		this(target,0,0,0,0);
	}

	public Score(Target target,String guessString) {
		this(target,Integer.parseInt(guessString),0,0,0);
		calculateScore(guessString);
	}

	public Score(Target target,int guessNumber) {
		this(target,guessNumber,0,0,0);
		calculateScore(Integer.toString(guessNumber));
	}
	public Score(Target target, int guess, int bullsEye, int hit, int miss) {
		this.target = target;
		this.guess = guess;
		this.countBullsEye = bullsEye;
		this.countHit = hit;
		this.countMiss = miss;
	}

	// Access Methods
	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public int getCountBullsEye() {
		return countBullsEye;
	}

	public void setCountBullsEye(int countBullsEye) {
		this.countBullsEye = countBullsEye;
	}

	public int getCountHit() {
		return countHit;
	}

	public void setCountHit(int countHit) {
		this.countHit = countHit;
	}

	public int getCountMiss() {
		return countMiss;
	}

	public void setCountMiss(int countMiss) {
		this.countMiss = countMiss;
	}

	public void setCountMiss() {
		setCountMiss(4 - getCountBullsEye() - getCountHit());
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append("\t"+this.getClass().getName() + " Object {" + NEW_LINE);
		result.append("\t"+"Target: " + getTarget().getValue() + NEW_LINE);
		result.append("\t"+"Guess: " + getGuess() + NEW_LINE);
		result.append("\t"+"BullsEye counter: " + getCountBullsEye() + NEW_LINE);
		result.append("\t"+"Hit counter: " + getCountHit() + NEW_LINE);
		result.append("\t"+"Miss counter: " + getCountMiss() + NEW_LINE);
		result.append("\t"+"}");
		return result.toString();
	}
	/**
	 * 1. Receive the string and parse it into an integer;
	 * 2. Run the comparison algorithm and create a Score object corresponding with the guess state
	 * 3. Add the Score object to guessResults
	 * 4. If there are 4 BullsEyes in the Score object change the active attribute to false
	 * 5. If there are less then 4 BullsEyes and the count of guessResults is at the limit then change active attribute to false		 

	 * @param guess
	 */
	private void calculateScore(String guess) {
		int intGuess = Integer.parseInt(guess);

		if (intGuess ==  getTarget().getValue()) {
			setCountBullsEye(4);
			setCountHit(0);
			setCountMiss(0);
		} else {
			// convert to array
			ArrayList<Integer> targetArray = UtilityHelper.toArray(getTarget().getValue());
			ArrayList<Integer>  guessArray = UtilityHelper.toArray(guess);

			// Run in a loop on the guess and test for state
			for (Integer integer : guessArray) {
				// Test for hit at the same location ("Bullseye")
				if (targetArray.indexOf(integer) == guessArray.indexOf(integer)) {
					setCountBullsEye(getCountBullsEye() + 1);
				} else if (targetArray.contains(integer)) { // Test for Hits
					setCountHit(getCountHit() + 1);
				}
			}
			// Calculate the number of Misses
			setCountMiss();
		}
	}
}
