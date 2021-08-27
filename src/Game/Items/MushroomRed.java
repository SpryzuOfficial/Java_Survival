package Game.Items;

import Game.engine.gfx.Assets;

public class MushroomRed extends Item
{
	public MushroomRed(int count, int x, int y) 
	{
		super(Assets.mushroomRed, count, x, y, 1, 1, 1, true, -1, 0);
	}
}
