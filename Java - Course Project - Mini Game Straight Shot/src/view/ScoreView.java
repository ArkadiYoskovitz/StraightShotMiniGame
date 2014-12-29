package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.Score;

public class ScoreView extends JPanel implements ListCellRenderer<Object> {

	// Attributes
	private static final long serialVersionUID = 2181271177662577139L;
	private static JLabel label = new JLabel("1234");
	private static Font font = new Font("Lucida Grande", Font.BOLD, 20);
	private Score score;

	final int borderWidth = 2;
	final int baseline;
	final int width;
	final int height;

	// Constructor
	public ScoreView() {
		super();
		FontMetrics metrics = label.getFontMetrics(font);
		this.baseline = metrics.getAscent() + borderWidth;
		this.height = metrics.getHeight() + (1 * borderWidth);
		this.width = 200;
	}

	// Access Methods
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public int getBaseline() {
		return baseline;
	}

	/** 
	 * Return the renderer fixed size here.  
	 */
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	/**
	 * Completely bypass all of the standard JComponent painting machinery.
	 * This is a special case: the renderer is guaranteed to be opaque,
	 * it has no children, and it's only a child of the JList while
	 * it's being used to rubber stamp cells.
	 * <p>
	 * Clear the background and then draw the text.
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		// Preparing the Graphics context
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getForeground());

		// Draw a cell separator
		g.setColor(Color.black);
		int startingX = -1;
		int startingY = getHeight() - 1;
		
		int targetX   = getWidth() + 1;
		int targetY   = startingY;
		
		g.drawRect(startingX,startingY,targetX,targetY);

		// Draw the guess text
		g.drawString("Guess : " + Integer.toString(getScore().getGuess()), getBorderWidth() * 2, getBaseline());

		// Initial calculations for drawing game state
		int margin = 2;

		int startinglocationX = getWidth() / 3;
		int startinglocationY =  margin;

		int targetWidth = getHeight() - margin * 3;
		int targetHeight = getHeight() - margin * 3;


		// Draw game state lights for Bulls eye
		for (int i = 0; i < getScore().getCountBullsEye(); i++) {
			g.setColor(Color.black);
			g.drawOval(startinglocationX, startinglocationY, targetWidth, targetHeight);
			g.setColor(Color.green);
			g.fillOval(startinglocationX, startinglocationY, targetWidth, targetHeight);
			startinglocationX = startinglocationX + targetWidth + margin;
		}

		// Move the pen to get some space
		startinglocationX = startinglocationX + margin;


		// Draw game state lights for hits
		for (int i = 0; i < getScore().getCountHit(); i++) {
			g.setColor(Color.black);
			g.drawOval(startinglocationX, startinglocationY, targetWidth, targetHeight);
			g.setColor(Color.red);
			g.fillOval(startinglocationX, startinglocationY, targetWidth, targetHeight);
			startinglocationX = startinglocationX + targetWidth + margin;
		}

		// Move the pen to get some space
		startinglocationX = startinglocationX + margin;
		
		// Draw game state lights for misses
		for (int i = 0; i < getScore().getCountMiss(); i++) {
			g.setColor(Color.black);
			g.drawOval(startinglocationX, startinglocationY, targetWidth, targetHeight);
			startinglocationX = startinglocationX + targetWidth + margin;
		}
	}


	/* This is is the ListCellRenderer method.  It just sets
	 * the foreground and background properties and updates the
	 * local text field.
	 */
	@Override
	public Component getListCellRendererComponent(
			JList<?> list,
			Object value,
			int index,
			boolean isSelected, 
			boolean cellHasFocus) 
	{
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setScore( (Score) value );

		return this;
	}
}
