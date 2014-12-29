package testApp;

import java.util.Scanner;

import model.GuessingGame;


/**
 * A small test class to test the application model
 * @author Arkadi Yoskovitz
 *
 */
public class TestAppCommandLine {

	// Attributes
	public static GuessingGame game;
	
	public static void main(String[] args) {
		String NEW_LINE = System.getProperty("line.separator");
		System.out.println("Game Start");
		// Game initialization and printing the game state
		game  = new GuessingGame();
		System.out.println(game.toString());
		System.out.println(NEW_LINE);

		// Input a guess
		Scanner scanIn = new Scanner(System.in);
		String sWhatever;
		do {
			System.out.println("Enter a guess: ");
			sWhatever = scanIn.nextLine();	
			//Check the guess 
			game.calculateGuessState(sWhatever);
			if (game.isActive()) {
				System.out.println("Error please try again");
			}
		} while (game.isActive());

		scanIn.close();            
		System.out.println(NEW_LINE);
		
		// Print the game state
		System.out.println(game.toString());
		System.out.println(NEW_LINE);
		
		System.out.println("Game End");
	}

}
