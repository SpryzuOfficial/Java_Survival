package Game.Items;

import Game.engine.gfx.Assets;

public class MushroomBlue extends Item
{
	public MushroomBlue(int count, int x, int y) 
	{
		super(Assets.mushroomBlue, count, x, y, 1, 1, 1, true, -1, 0);
	}
}	
