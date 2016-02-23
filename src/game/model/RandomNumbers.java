package game.model;

import game.controller.GameController;

public class RandomNumbers
	{
		private GameController baseController;

		private int easyNumber;
		private int normalNumber;
		private int hardNumber;
		private int counter;

		public RandomNumbers(GameController baseController)
			{
				this.baseController = baseController;
			}

		public void generateEasy()
			{
				easyNumber = (int) (Math.random() * 51);
				System.out.println(easyNumber);
			}

		public void generateNormal()
			{
				normalNumber = (int) (Math.random() * 151);
				System.out.println(normalNumber);
			}

		public void generateHard()
			{
				hardNumber = (int) (Math.random() * 301);
				System.out.println(hardNumber);
			}

		public void checkEasy()
			{
				counter++;
				baseController.getFrame().getBasePanel().getDisplayView().setGuessesText(counter);
				
				int userGuess = baseController.getFrame().getBasePanel().getUserInputView().getUserGuess();
				if(userGuess != easyNumber)
					{
						if(baseController.getFrame().getBasePanel().getDisplayView().getHint() == true)
							{
								if(userGuess > easyNumber)
									{
										baseController.getFrame().getBasePanel().getDisplayView().setHintText("Your guess was too high. Try again.");
									}
								else if(userGuess < easyNumber)
									{
										baseController.getFrame().getBasePanel().getDisplayView().setHintText("Your guess was too low. Try again.");
									}
								
							}
						else if(baseController.getFrame().getBasePanel().getDisplayView().getHint() == false)
							{
								if(userGuess != easyNumber)
									{
										baseController.getFrame().getBasePanel().getDisplayView().setHintText("Your guess was wrong. Try again.");
									}
							}
					}
				if(userGuess == easyNumber)
					{
						baseController.getFrame().getBasePanel().getDisplayView().setHintText("Wow! You guessed it!");
					}
			}

		public void checkNormal()
			{
				counter++;
				baseController.getFrame().getBasePanel().getDisplayView().setGuessesText(counter);
				
				int userGuess = baseController.getFrame().getBasePanel().getUserInputView().getUserGuess();
				if (userGuess == normalNumber)
					{
						baseController.getFrame().getBasePanel().getDisplayView().setHintText("Wow! You guessed it!");
					}
				else
						baseController.getFrame().getBasePanel().getDisplayView().setHintText("Your guess was wrong. Try again.");
			}

		public void checkHard()
			{
				counter++;
				baseController.getFrame().getBasePanel().getDisplayView().setGuessesText(counter);
				
				int userGuess = baseController.getFrame().getBasePanel().getUserInputView().getUserGuess();
				if (userGuess == hardNumber)
					{
						baseController.getFrame().getBasePanel().getDisplayView().setHintText("Wow! You guessed it!");
					}
				else
						baseController.getFrame().getBasePanel().getDisplayView().setHintText("Your guess was wrong. Try again.");
			}
		
		public int getCounter()
		{
			return counter;
		}
		
		public void setCounter(int counter)
		{
			this.counter = counter;
			baseController.getFrame().getBasePanel().getDisplayView().setGuessesText(counter);
		}
	}
