/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Arkadi Yoskovitz
 */
public class GuessingGame {

	// Attribute
	private final Target gameTarget;
	private ArrayList<Score> 	gameResults;
	private boolean 			active;
	private boolean 			winner;
	private int					limit;

	// Contractor
	public GuessingGame() {
		this.gameTarget = new Target();
		this.gameResults = new ArrayList<Score>();
		this.active = true;
		this.winner = false;
		this.limit = 10;
	}

	// Access Methods
	public Target getGameTarget() {
		return gameTarget;
	}

	public ArrayList<Score> getGameResults() {
		return gameResults;
	}

	public void setGameResults(ArrayList<Score> guessResults) {
		this.gameResults = guessResults;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append(gameTarget.toString() + NEW_LINE);
		result.append("Active state: " + isActive() + NEW_LINE);
		result.append("Limit: " + getLimit() + NEW_LINE);
		result.append("Current size: " + getGameResults().size() + NEW_LINE);
		result.append("Guess results: " + NEW_LINE);
		for (Score score : gameResults) {
			result.append(score.toString() + NEW_LINE);
		}
		result.append("}");
		return result.toString();
	}

	// Handling Guess Event
	public void calculateGuessState(String guess) {
		
		Score newScore = new Score(getGameTarget(),guess);
		
		getGameResults().add(0,newScore);

		if (newScore.getCountBullsEye() == 4) {
			setActive(false);
		} else if (getGameResults().size() == limit) {
			setActive(false);
		}
	}
}
