package Game.ui;

import java.awt.image.BufferedImage;

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
			
			if(uiImage == Assets.inventory)
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
			
			if(uiImage == Assets.craftingtable)
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
			
			if(uiImage == Assets.ovenUI)
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
}