package appDelegate;

import controller.GuessingGameViewController;

public class AppDelegate {

	// Attribute
	private static GuessingGameViewController gameViewController;

	// Main 
	public static void main(String[] args) {
		setGameViewController(new GuessingGameViewController());

	}

	public static GuessingGameViewController getGameViewController() {
		return gameViewController;
	}

	public static void setGameViewController(GuessingGameViewController gameViewController) {
		AppDelegate.gameViewController = gameViewController;
	}
}
