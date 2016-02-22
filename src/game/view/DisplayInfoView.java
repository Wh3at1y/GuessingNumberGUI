package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
		private JCheckBox isHelperOn;

		public DisplayInfoView(GameController baseController)
			{
				this.baseController = baseController;

				baseLayout = new SpringLayout();

				isHelperOn = new JCheckBox("Higher/Lower Hints");
				baseLayout.putConstraint(SpringLayout.NORTH, isHelperOn, 60, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, isHelperOn, -160, SpringLayout.EAST, this);
				clearButton = new JButton("Clear Guesses");
				clearButton.setVisible(true);
				displayGuesses = new JTextArea();
				baseLayout.putConstraint(SpringLayout.NORTH, displayGuesses, 10, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, displayGuesses, -45, SpringLayout.SOUTH, this);
				displayGuesses.setEditable(false);
				displayGuesses.setText("Amount of Guesses: 0");
				displayHint = new JTextArea();
				baseLayout.putConstraint(SpringLayout.WEST, displayHint, 6, SpringLayout.EAST, clearButton);
				displayHint.setEditable(false);
				displayHint.setWrapStyleWord(true);
				displayHint.setLineWrap(true);
				displayHint.setOpaque(false);
				displayGameInfo = new JTextArea();
				baseLayout.putConstraint(SpringLayout.EAST, displayHint, -6, SpringLayout.WEST, displayGameInfo);
				displayGameInfo.setEditable(false);
				displayGameInfo.setWrapStyleWord(true);
				displayGameInfo.setLineWrap(true);

				buildPanel();
				buildPlacements();
				buildListeners();
			}

		private void buildPanel()
			{
				setPreferredSize(new Dimension(500, 186));
				setBackground(Color.WHITE);
				setLayout(baseLayout);
				add(isHelperOn);
				add(clearButton);
				add(displayGuesses);
				add(displayHint);
				add(displayGameInfo);
			}

		private void buildPlacements()
			{
				baseLayout.putConstraint(SpringLayout.EAST, clearButton, -308, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.EAST, displayGuesses, -308, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.EAST, displayGameInfo, 0, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, displayGameInfo, 10, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, displayGameInfo, -10, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, displayGameInfo, -153, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, displayHint, 10, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, displayHint, -10, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, displayGuesses, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.WEST, clearButton, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
			}

		private void buildListeners()
			{
				isHelperOn.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent checked)
							{

								if (checked.getStateChange() == ItemEvent.DESELECTED)
									{
										baseController.setIsHelperOn("False");
										updateInfoText();
									}
								else
									{
										baseController.setIsHelperOn("True");
										updateInfoText();
									}
							}
					});
			}

		public void updateInfoText()
			{
				displayGameInfo.setText("Game Difficulty: " + baseController.getDiffictyText() + "\nGuess Helper: " + baseController.getIsHelperOn() + "\nGuess between:" + baseController.getShowNumbers());
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
