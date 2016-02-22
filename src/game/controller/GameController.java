package game.controller;

import game.model.RandomNumbers;
import game.view.LookAndFeel;
import game.view.MainFrame;

public class GameController
{
	private MainFrame baseFrame;
	private RandomNumbers genNumber;
	private LookAndFeel lookFeel;
	
	private String diffText;
	private String isHelperOn = "";
	private String showNumbers;
	
	public GameController()
	{
		baseFrame = new MainFrame(this);
		genNumber = new RandomNumbers(this);
		lookFeel = new LookAndFeel();
		lookFeel.setLook();
	}
	
	public void start(){}
	
	
	public void setCounter(int counter)
	{
		genNumber.setCounter(counter);
	}

	public void setDiffText(String diffText)
		{
			this.diffText = diffText;
		}

	public void setIsHelperOn(String isHelperOn)
		{
			this.isHelperOn = isHelperOn;
		}
	
	public void setShowNumbers(String showNumbers)
	{
		this.showNumbers = showNumbers;
	}

	public String getDiffictyText()
	{
		return diffText;
	}
	
	public String getIsHelperOn()
	{
		return isHelperOn;
	}
	
	public String getShowNumbers()
	{
		return showNumbers;
	}
	
	public MainFrame getFrame()
	{
		return baseFrame;
	}
	
	public RandomNumbers getNumbers()
	{
		return genNumber;
	}
	
}
