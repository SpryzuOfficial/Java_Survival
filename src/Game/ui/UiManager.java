package Game.ui;

import java.awt.image.BufferedImage;

import Game.engine.Game;
import Game.engine.gfx.Assets;

public class UiManager
{
	public static BufferedImage uiImage;
	
	public UiManager() 
	{ 
		
	}
	
	public static void tick()
	{
		if(!Game.mouseManager.isLeftPressed())
		{
			if(Game.keyManager.e)
			{
		 		uiImage = Assets.inventory;
		 	}
		 	else
		 	{
		 		uiImage = null;
		 	}
		}
	}
}