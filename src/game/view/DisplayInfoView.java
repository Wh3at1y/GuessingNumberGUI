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
		private JTextArea displayUserGuesses;
		private JCheckBox helperCheckBox;
		private JScrollPane guessPane;

		private boolean isOn;

		public DisplayInfoView(GameController baseController)
			{
				this.baseController = baseController;
				baseLayout = new SpringLayout();

				displayUserGuesses = new JTextArea();
				helperCheckBox = new JCheckBox("Higher/Lower Hints");
				clearButton = new JButton("Clear Guesses");
				clearButton.setVisible(true);
				displayGuesses = new JTextArea();
				displayGuesses.setEditable(false);
				displayGuesses.setText("Amount of Guesses: 0");
				displayHint = new JTextArea();
				displayHint.setEditable(false);
				displayHint.setWrapStyleWord(true);
				displayHint.setLineWrap(true);
				displayHint.setOpaque(false);
				displayGameInfo = new JTextArea();

				displayGameInfo.setEditable(false);
				displayGameInfo.setWrapStyleWord(true);
				displayGameInfo.setLineWrap(true);

				setupChatPane();
				buildPanel();
				buildPlacements();
				buildListeners();
				setHintBox(true);
			}

		private void setupChatPane()
			{
				displayUserGuesses.setLineWrap(true);
				displayUserGuesses.setWrapStyleWord(true);
				displayUserGuesses.setEnabled(false);
				displayUserGuesses.setEditable(false);
				guessPane = new JScrollPane(displayUserGuesses);

				guessPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				guessPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			}

		private void buildPanel()
			{
				setPreferredSize(new Dimension(500, 186));
				setBackground(Color.WHITE);
				setLayout(baseLayout);
				add(helperCheckBox);
				add(clearButton);
				add(displayGuesses);
				add(displayHint);
				add(displayGameInfo);
				add(guessPane);
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
				baseLayout.putConstraint(SpringLayout.WEST, clearButton, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.NORTH, displayGuesses, 10, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, displayGuesses, 15, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, displayGuesses, -147, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.NORTH, guessPane, 0, SpringLayout.SOUTH, displayGuesses);
				baseLayout.putConstraint(SpringLayout.WEST, guessPane, 15, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, guessPane, 0, SpringLayout.NORTH, clearButton);
				baseLayout.putConstraint(SpringLayout.EAST, guessPane, -15, SpringLayout.WEST, displayHint);
				baseLayout.putConstraint(SpringLayout.EAST, displayHint, -6, SpringLayout.WEST, displayGameInfo);
				baseLayout.putConstraint(SpringLayout.WEST, displayHint, 6, SpringLayout.EAST, clearButton);
				baseLayout.putConstraint(SpringLayout.NORTH, helperCheckBox, 60, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, helperCheckBox, -160, SpringLayout.EAST, this);
			}

		private void buildListeners()
			{
				helperCheckBox.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent checked)
							{

								if (checked.getStateChange() == ItemEvent.SELECTED)
									{
										baseController.setIsHelperOn("Yes");
										isOn = true;
									}
								else
									{
										baseController.setIsHelperOn("No");
										isOn = false;
									}
								updateInfoText();
							}
					});
				
				clearButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent clicked)
							{
								displayUserGuesses.setText("");
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

		public void setUserGuessesText(String userGuess)
			{
				displayUserGuesses.append(userGuess);
			}

		public void setHintBox(boolean isOn)
			{
				this.isOn = isOn;

				if (isOn)
					{
						helperCheckBox.setSelected(true);
						this.isOn = true;
					}
				else
					{
						helperCheckBox.setSelected(false);
						this.isOn = false;
					}
			}

		public boolean getHint()
			{
				return this.isOn;
			}
	}
