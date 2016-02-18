package game.view;

import javax.swing.JFrame;
import game.controller.GameController;

public class MainFrame extends JFrame
{
	private GameController baseController;
	private MainPanel basePanel;
	
	public MainFrame(GameController baseController)
	{
		this.baseController = baseController;
		basePanel = new MainPanel(baseController);
		
		buildFrame();
	}
	
	private void buildFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500,400);
		this.setTitle("Guess the Number!");
		this.setContentPane(basePanel);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public MainPanel getBasePanel()
	{
		return basePanel;
	}

}
