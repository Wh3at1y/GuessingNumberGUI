package game.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import game.controller.GameController;

public class UserInputView extends JPanel
{
	private GameController baseController;
	
	private SpringLayout baseLayout;
	
	private JButton enterButton;
	private JTextField userInputField;
	
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
		this.setPreferredSize(new Dimension(500,100));
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
		
	}
}
