package game.view;

import java.awt.Color;

import javax.swing.*;
import game.controller.GameController;

public class MainPanel extends JPanel
{
	
	private SpringLayout baseLayout;
	
	private UserInputView userInputView;
	private DifficultyView diffView;
	private DisplayInfoView displayView;

	public MainPanel(GameController baseController)
	{
		
		baseLayout = new SpringLayout();
		
		userInputView = new UserInputView(baseController);
		diffView = new DifficultyView(baseController);
		displayView = new DisplayInfoView(baseController);
		
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setBackground(Color.WHITE);
		setLayout(baseLayout);
		add(userInputView);
		add(diffView);
		add(displayView);

	}
	
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, displayView, 0, SpringLayout.SOUTH, userInputView);
		baseLayout.putConstraint(SpringLayout.NORTH, userInputView, 0, SpringLayout.SOUTH, diffView);
	}
	
	private void buildListeners()
	{
		
	}

	public UserInputView getUserInputView()
	{
		return userInputView;
	}

	public DifficultyView getDiffView()
	{
		return diffView;
	}

	public DisplayInfoView getDisplayView()
	{
		return displayView;
	}
}
