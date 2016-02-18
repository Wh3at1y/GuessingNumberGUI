package game.controller;

import game.model.RandomNumbers;
import game.view.LookAndFeel;
import game.view.MainFrame;

public class GameController
{
	private MainFrame baseFrame;
	private RandomNumbers genNumber;
	private LookAndFeel lookFeel;
	
	public GameController()
	{
		baseFrame = new MainFrame(this);
		genNumber = new RandomNumbers(this);
		lookFeel = new LookAndFeel();
		lookFeel.setLook();
		
		setInfoText("Not Selected", "Yes", "No mode selected.");
		
	}
	
	public void start(){}
	
	public void setInfoText(String setText, String isHelperOn, String guessString)
	{
		baseFrame.getBasePanel().getDisplayView().setInfoText(setText, isHelperOn, guessString);
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
