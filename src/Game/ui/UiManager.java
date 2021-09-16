package Game.ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.engine.Game;
import Game.engine.gfx.Assets;

public class UiManager
{
	public static BufferedImage uiImage;
	public static boolean ePressed;
	
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
			}
			else
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
}

