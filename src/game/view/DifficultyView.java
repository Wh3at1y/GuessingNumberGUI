package game.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import game.controller.GameController;
import game.model.RandomNumbers;

public class DifficultyView extends JPanel
{
	private GameController baseController;
	private RandomNumbers genNum;
	
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
						baseController.setInfoText("Easy", "Yes", "1-50");
						baseController.getNumbers().generateEasy();
						
						difficultyNumber = 1;
					}
				});
		normalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				baseController.setInfoText("Normal", "Yes", "1-150");
				baseController.getNumbers().generateNormal();
				
				difficultyNumber = 2;
			}
		});
		hardButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				baseController.setInfoText("Hard", "No", "1-300");
				baseController.getNumbers().generateHard();
				
				difficultyNumber = 3;
			}
		});
	}
	
	public int getDifficultyNumber()
	{
		return difficultyNumber;
	}
}
