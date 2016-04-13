package game.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import game.controller.GameController;

public class DifficultyView extends JPanel
{
	private GameController baseController;
	
	private SpringLayout baseLayout;
	
	private JButton easyButton;
	private JButton normalButton;
	private JButton hardButton;
	
	private int difficultyNumber;
	
	public DifficultyView(GameController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		
		easyButton = new JButton("Easy");
		normalButton = new JButton("Normal");
		hardButton = new JButton("Hard");
		
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setPreferredSize(new Dimension(500, 100));
		setLayout(baseLayout);
		setBackground(Color.WHITE);
		add(easyButton);
		add(normalButton);
		add(hardButton);
	}
	
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.EAST, normalButton, -30, SpringLayout.WEST, hardButton);
		baseLayout.putConstraint(SpringLayout.NORTH, hardButton, 0, SpringLayout.NORTH, easyButton);
		baseLayout.putConstraint(SpringLayout.WEST, hardButton, 354, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, hardButton, 0, SpringLayout.SOUTH, easyButton);
		baseLayout.putConstraint(SpringLayout.NORTH, normalButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, hardButton, -17, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, normalButton, 30, SpringLayout.EAST, easyButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, normalButton, 0, SpringLayout.SOUTH, easyButton);
		baseLayout.putConstraint(SpringLayout.NORTH, easyButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, easyButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, easyButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, easyButton, -354, SpringLayout.EAST, this);
	}
	
	private void buildListeners()
	{
		easyButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent clicked)
					{
						baseController.setCounter(0);
						baseController.getNumbers().generateEasy();
						baseController.setDiffText("Easy");
						baseController.setShowNumbers("1-50");
						baseController.setIsHelperOn("Yes");
						baseController.getFrame().getBasePanel().getDisplayView().setHintBox(true);
						baseController.getFrame().getBasePanel().getDisplayView().updateInfoText();
						
						difficultyNumber = 1;
					}
				});
		normalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				baseController.setCounter(0);
				baseController.getNumbers().generateNormal();
				baseController.setDiffText("Normal");
				baseController.setShowNumbers("1-150");
				baseController.setIsHelperOn("Yes");
				baseController.getFrame().getBasePanel().getDisplayView().setHintBox(true);
				baseController.getFrame().getBasePanel().getDisplayView().updateInfoText();
				
				difficultyNumber = 2;
			}
		});
		hardButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				baseController.setCounter(0);
				baseController.getNumbers().generateHard();
				baseController.setDiffText("Hard");
				baseController.setShowNumbers("1-300");
				baseController.setIsHelperOn("No");
				baseController.getFrame().getBasePanel().getDisplayView().setHintBox(false);
				baseController.getFrame().getBasePanel().getDisplayView().updateInfoText();
				
				difficultyNumber = 3;
			}
		});
	}
	
	public int getDifficultyNumber()
	{
		return difficultyNumber;
	}
}
