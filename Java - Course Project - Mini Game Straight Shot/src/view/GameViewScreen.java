package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import model.Score;
import utilities.FocusTraversalOnArray;

public class GameViewScreen extends JFrame {

	private static final long serialVersionUID = -8390189980390852683L;

	private JPanel contentPane;
	private JTextField txtEnterGuess;
	private JButton btnPressMe;
	private JScrollPane scrollPane;
	private JList<Score> list;
	private JButton btnNewGame;
	private JLabel lblLooserLabel;

	// Contractor
	public GameViewScreen() {
		layoutSubElements();
	}

	// Access methods
	public JLabel getLblLooserLabel() {
		return lblLooserLabel;
	}

	public void setLblLooserLabel(JLabel lblLooserLabel) {
		this.lblLooserLabel = lblLooserLabel;
	}

	public JTextField getTxtEnterGuess() {
		return txtEnterGuess;
	}

	public void setTxtEnterGuess(JTextField txtEnterGuess) {
		this.txtEnterGuess = txtEnterGuess;
	}

	public JButton getBtnPressMe() {
		return btnPressMe;
	}

	public void setBtnPressMe(JButton btnPressMe) {
		this.btnPressMe = btnPressMe;
	}

	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	public void setBtnNewGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JList<Score> getList() {
		return list;
	}

	public void setList(JList<Score> list) {
		this.list = list;
	}

	// Main class method, 
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Initialize the contents of the frame.
	private void layoutSubElements() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Straight Shot - MiniGame");
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);

		JLabel lblGameTitle = new JLabel("Straight Shot");
		lblGameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblGameTitle,  10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST , lblGameTitle,  10, SpringLayout.WEST , contentPane);
		springLayout.putConstraint(SpringLayout.EAST , lblGameTitle, -10, SpringLayout.EAST , contentPane);
		contentPane.add(lblGameTitle);

		JLabel lblInstractions = new JLabel("Please enter your guess and press the button");
		lblInstractions.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblInstractions, 6, SpringLayout.SOUTH, lblGameTitle);
		springLayout.putConstraint(SpringLayout.WEST , lblInstractions, 0, SpringLayout.WEST , lblGameTitle);
		springLayout.putConstraint(SpringLayout.EAST , lblInstractions, 0, SpringLayout.EAST , lblGameTitle);
		contentPane.add(lblInstractions);

		setTxtEnterGuess(new JTextField());;
		springLayout.putConstraint(SpringLayout.NORTH, getTxtEnterGuess(),  6, SpringLayout.SOUTH, lblInstractions );
		springLayout.putConstraint(SpringLayout.WEST , getTxtEnterGuess(), 10, SpringLayout.WEST , contentPane);
		getTxtEnterGuess().setText("Enter Guess");
		getTxtEnterGuess().setToolTipText("Enter guess");
		contentPane.add(getTxtEnterGuess());

		setBtnPressMe(new JButton("Press Me!"));;
		springLayout.putConstraint(SpringLayout.EAST , getTxtEnterGuess(), -10, SpringLayout.WEST , btnPressMe	  );
		springLayout.putConstraint(SpringLayout.NORTH, getBtnPressMe()	, 	6, SpringLayout.SOUTH, lblInstractions);
		springLayout.putConstraint(SpringLayout.EAST , getBtnPressMe()	, 	0, SpringLayout.EAST , lblInstractions);
		contentPane.add(getBtnPressMe());

		setScrollPane(new JScrollPane());
		getScrollPane().setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		springLayout.putConstraint(SpringLayout.NORTH, getScrollPane(),  10, SpringLayout.SOUTH, getTxtEnterGuess()	);
		springLayout.putConstraint(SpringLayout.WEST , getScrollPane(),   0, SpringLayout.WEST , lblInstractions	);
		springLayout.putConstraint(SpringLayout.EAST , getScrollPane(),   0, SpringLayout.EAST , getTxtEnterGuess()	);
		springLayout.putConstraint(SpringLayout.SOUTH, getScrollPane(), -10, SpringLayout.SOUTH, contentPane		);
		contentPane.add(getScrollPane());

		setList(new JList<Score>());
		getScrollPane().getViewport().setView(getList());

		setBtnNewGame(new JButton("New Game"));
		springLayout.putConstraint(SpringLayout.NORTH, getBtnNewGame() , 6, SpringLayout.SOUTH, getBtnPressMe());
		springLayout.putConstraint(SpringLayout.EAST , getBtnNewGame() , 0, SpringLayout.EAST , getBtnPressMe());
		springLayout.putConstraint(SpringLayout.WEST , getBtnNewGame() , 0, SpringLayout.WEST , getBtnPressMe());
		contentPane.add(getBtnNewGame());

		setLblLooserLabel(new JLabel("Looser label"));;
		getLblLooserLabel().setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, getLblLooserLabel(), 10, SpringLayout.SOUTH, getBtnNewGame()	);
		springLayout.putConstraint(SpringLayout.SOUTH, getLblLooserLabel(),  0, SpringLayout.SOUTH, getScrollPane()	);
		springLayout.putConstraint(SpringLayout.WEST , getLblLooserLabel(), 10, SpringLayout.EAST , getScrollPane()	);
		springLayout.putConstraint(SpringLayout.EAST , getLblLooserLabel(),  0, SpringLayout.EAST , lblGameTitle	);
		contentPane.add(getLblLooserLabel());

		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getTxtEnterGuess(), getBtnPressMe(), getBtnNewGame()}));

		// Respond to keyStroke events
		AbstractAction action = new AbstractAction() {
			private static final long serialVersionUID = -5131340540460082527L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton){
					JButton button = (JButton) e.getSource();
					button.doClick();        
				} else if(e.getSource() instanceof JComponent){
					getBtnPressMe().doClick();
				}
			}
		};
		
		// Binding response to Enter pressed
		getTxtEnterGuess().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), getBtnPressMe().getText());
		getTxtEnterGuess().getActionMap().put(getBtnPressMe().getText(), action);
		
		getBtnPressMe().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), getBtnPressMe().getText());
		getBtnPressMe().getActionMap().put(getBtnPressMe().getText(), action);		

		getBtnNewGame().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), getBtnNewGame().getText());
		getBtnNewGame().getActionMap().put(getBtnNewGame().getText(), action);
		
	}

	public void setListener(ActionListener listener) {
		getTxtEnterGuess().addActionListener(listener);
		getBtnPressMe().addActionListener(listener);
		getBtnNewGame().addActionListener(listener);
	}

	public void updateListModel(ArrayList<Score> gameResults) {
		DefaultListModel<Score> dml = new DefaultListModel<Score>();
		Collections.reverse(gameResults);
		for (Score score : gameResults) {
			dml.addElement(score);	
		}
		getList().setModel(dml);
	}

	public void updateListCellRenderer() {
		getList().setCellRenderer(new ScoreView());
	}
}
