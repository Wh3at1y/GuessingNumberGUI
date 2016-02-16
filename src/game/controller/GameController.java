package game.controller;

import game.view.LookAndFeel;
import game.view.MainFrame;

public class GameController
{
	private MainFrame baseFrame;
	private LookAndFeel lookFeel;
	
	public GameController()
	{
		baseFrame = new MainFrame(this);
		lookFeel = new LookAndFeel();
		
		lookFeel.setLook();
		
		setInfoText("Not Selected", "Yes");
		
	}
	
	public void start(){}
	
	public void setInfoText(String setText, String isHelperOn)
	{
		baseFrame.getBasePanel().getDisplayView().setInfoText(setText, isHelperOn);
	}
	
}
