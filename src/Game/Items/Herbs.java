package Game.Items;

import Game.engine.gfx.Assets;

public class Herbs extends Item
{
	public Herbs(int count, int x, int y) 
	{
		super(Assets.herbs, count, x, y, 1, 1, 1, true, -1, 0);
	}
}
