package appDelegate;

import controller.GuessingGameViewController;

public class AppDelegate {

	// Attribute
	@SuppressWarnings("unused")
	private static GuessingGameViewController gameViewController;
	// Main 
	public static void main(String[] args) {
		gameViewController = new GuessingGameViewController();

	}
}
