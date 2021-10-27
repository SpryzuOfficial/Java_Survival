package Game.ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.engine.Game;
import Game.engine.gfx.Assets;

public class UiManager
{
	public static BufferedImage[] numbers = new BufferedImage[] {Assets.num0, Assets.num1, Assets.num2, Assets.num3, Assets.num4, Assets.num5, Assets.num6, Assets.num7, Assets.num8, Assets.num9};
	public static BufferedImage uiImage;
	public static boolean ePressed;
	public static boolean pPressed;
	
	public UiManager() 
	{ 
		
	}
	
	public static void tick()
	{
		if(!Game.mouseManager.isLeftPressed())
		{
			if(uiImage == null)
			{
				if(Game.keyManager.e)
				{
					if(!ePressed)
					{
						uiImage = Assets.inventory;
						ePressed = true;
					}
			 	}
			 	else
			 	{
			 		if(ePressed)
			 		{
			 			ePressed = false;
			 		}
			 	}
				
				if(Game.keyManager.p)
				{
					if(!pPressed)
					{
						uiImage = Assets.pause;
						pPressed = true;
					}
				}
				else if(pPressed)
				{
					pPressed = false;
				}
			}
			else if(uiImage != Assets.pause)
			{
				if(Game.keyManager.e)
				{
					if(!ePressed)
					{
						uiImage = null;
						ePressed = true;
					}
				}
				else
				{
					if(ePressed)
					{
						ePressed = false;
					}
				}
			}
			else if(uiImage == Assets.pause)
			{
				if(Game.keyManager.p)
				{
					if(!pPressed)
					{
						uiImage = null;
						pPressed = true;
					}
				}
				else if(pPressed)
				{
					pPressed = false;
				}
			}
		}
	}
	
	public static ArrayList<BufferedImage> stringToImage(String string)
	{
		ArrayList<BufferedImage> imageString = new ArrayList<BufferedImage>();
		char[] chars = string.toUpperCase().toCharArray();
		
		for(int i = 0; i < chars.length; i++)
		{
			if(chars[i] == ' ')
			{
				imageString.add(null);
			}
			else
			{
				imageString.add(Assets.font.get((int) chars[i] - 65));
				//System.out.println(chars[i] + " " + (int) chars[i]);
			}
		}
		
		return imageString;
	}
	
	public static ArrayList<BufferedImage> intToImage(int number)
	{
		ArrayList<BufferedImage> imageInt = new ArrayList<BufferedImage>();
		
		char[] chars = String.valueOf(number).toCharArray();
		
		for(int i = 0; i < chars.length; i++)
		{
			imageInt.add(numbers[Integer.parseInt(String.valueOf(chars[i]))]);
		}
		
		return imageInt;
	}
}

