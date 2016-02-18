package game.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import game.controller.GameController;

public class DisplayInfoView extends JPanel
{
	private GameController baseController;
	
	private SpringLayout baseLayout;
	
	private JButton clearButton;
	private JTextArea displayGuesses;
	private JTextArea displayHint;
	private JTextArea displayGameInfo;
	
	public DisplayInfoView(GameController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		clearButton = new JButton("Clear Guesses");
		displayGuesses = new JTextArea();
		displayGuesses.setEditable(false);
		displayHint = new JTextArea();
		displayHint.setEditable(false);
		displayHint.setWrapStyleWord(true);
		displayHint.setLineWrap(true);
		displayGameInfo = new JTextArea();
		displayGameInfo.setEditable(false);
		displayGameInfo.setWrapStyleWord(true);
		displayGameInfo.setLineWrap(true);
		
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setPreferredSize(new Dimension(500, 171));
		setBackground(Color.WHITE);
		setLayout(baseLayout);
		add(clearButton);
		add(displayGuesses);
		add(displayHint);
		add(displayGameInfo);
	}
	
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, -308, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, displayGuesses, -308, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, displayHint, 6, SpringLayout.EAST, clearButton);
		baseLayout.putConstraint(SpringLayout.EAST, displayHint, -6, SpringLayout.WEST, displayGameInfo);
		baseLayout.putConstraint(SpringLayout.EAST, displayGameInfo, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, displayGameInfo, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, displayGameInfo, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, displayGameInfo, -153, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, displayHint, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, displayHint, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, displayGuesses, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, displayGuesses, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, displayGuesses, -6, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
	}
	
	private void buildListeners()
	{
		
	}
	
	public void setInfoText(String setText, String isHelperOn, String guessString)
	{
		displayGameInfo.setText("Difficulty: " + setText + "\nHigher/Lower: " + isHelperOn + "\nGuess between: " + guessString);
	}
	
	public void setHintText(String setText)
	{
		displayHint.setText(setText);
	}
	
	public void setGuessesText(int counter)
	{
		displayGuesses.setText("Amount of Guesses: " + counter);
	}
}
