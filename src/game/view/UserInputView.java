package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import game.controller.GameController;
import game.model.RandomNumbers;

public class UserInputView extends JPanel
	{
		private GameController baseController;

		private SpringLayout baseLayout;

		private JButton enterButton;
		private JTextField userInputField;

		private int userGuess;

		public UserInputView(GameController baseController)
			{
				this.baseController = baseController;

				baseLayout = new SpringLayout();

				enterButton = new JButton("Enter Guess");
				userInputField = new JTextField();

				buildPanel();
				buildPlacements();
				buildListeners();
			}

		private void buildPanel()
			{
				setPreferredSize(new Dimension(500, 100));
				setBackground(Color.WHITE);
				setLayout(baseLayout);
				add(enterButton);
				add(userInputField);
			}

		private void buildPlacements()
			{
				baseLayout.putConstraint(SpringLayout.NORTH, enterButton, 31, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -30, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, enterButton, -10, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 31, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, userInputField, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, userInputField, -30, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, userInputField, -411, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.WEST, enterButton, 6, SpringLayout.EAST, userInputField);
			}

		private void buildListeners()
			{
				enterButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent clicked)
							{
								if (userInputField.getText().isEmpty() == true)
									{
										baseController.getFrame().getBasePanel().getDisplayView().setHintText("Enter a Number!");
									}
								else
									{
										baseController.getFrame().getBasePanel().getDisplayView().setUserGuessesText(userInputField.getText() + "\n");
										userGuess = Integer.parseInt(userInputField.getText());
										baseController.getFrame().getBasePanel().getDisplayView().setGuessesText(baseController.getNumbers().getCounter());

										if (baseController.getFrame().getBasePanel().getDiffView().getDifficultyNumber() == 1)
											baseController.getNumbers().checkEasy();
										else if (baseController.getFrame().getBasePanel().getDiffView().getDifficultyNumber() == 2)
											baseController.getNumbers().checkNormal();
										else
											baseController.getNumbers().checkHard();
									}
							}
					});
			}

		public int getUserGuess()
			{
				return userGuess;
			}

	}
