package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GuessingGame;
import utilities.UtilityHelper;
import view.GameViewScreen;

public class GuessingGameViewController implements ActionListener {

	// Attribute
	private GuessingGame game;
	private GameViewScreen view;
	private Font font;

	// Contractor
	public GuessingGameViewController() {
		setupNewGame();
	}

	// Access Methods
	public GuessingGame getGame() {
		return game;
	}

	public void setGame(GuessingGame game) {
		this.game = game;
	}

	public GameViewScreen getView() {
		return view;
	}

	public void setView(GameViewScreen view) {
		this.view = view;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	// Setup Game
	private void setupNewGame() {
		this.game = new GuessingGame();
		this.view = new GameViewScreen();
		this.font = new Font("Lucida Grande", Font.BOLD, 20);
		run();
	}
	
	//
	public void run() {
		// Game initialization and printing the game state
		getView().setListener(this);
		updateUI();
		getView().run();
		
	}

	// Handle action events
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();

		if (action.equals("Press Me!")) {

			if (getGame().isActive()) {
				
				String guess = getView().getTxtEnterGuess().getText();
				
				boolean flagNumeric = UtilityHelper.isIntNumeric(guess);
				
				if (guess.isEmpty() || !flagNumeric) {
					setBadInput();
				} else {
					if (!UtilityHelper.hasDistinctDigits(Integer.parseInt(guess))) {
						setBadInput();
					} else {
						getGame().calculateGuessState(guess);
						updateUI();
					}
				}
				
				if (getGame().getGameResults().size() == getGame().getLimit()) {
					setLooser();
				} else if (!getGame().isActive()) {
					setWinner();
				}
				
			} else if (!getGame().isWinner()){
				setLooser();
			}
			
		} else if (action.equals("New Game")) {
			setupNewGame();
		}
	}
	
	// Handle UI changes
	private void updateUI() {
		getView().updateListModel(getGame().getGameResults());
		getView().updateListCellRenderer();
		getView().getLblLooserLabel().setText(null);
	}
	
	private void setBadInput() {
		getView().getLblLooserLabel().setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		getView().getLblLooserLabel().setText("<html><b>Bad input:</b> <br/> please enter a four digit number <br/>Note that bad input doesnt count</html>");
		getView().getTxtEnterGuess().setText(null);
	}
	
	private void setLooser() {
		getView().getLblLooserLabel().setFont(getFont());
		getView().getLblLooserLabel().setText("<html>Looser!<br/>The target was: " + getGame().getGameTarget().getValue() + "</html>");
	}
	
	private void setWinner() {
		getView().getLblLooserLabel().setFont(getFont());
		getView().getLblLooserLabel().setText("Winner");
		getGame().setWinner(true);
	}

}
