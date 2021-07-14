package Game.Items;

import Game.engine.gfx.Assets;

public class Clay extends Item
{
	public Clay(int count, int x, int y) 
	{
		super(Assets.clay, count, x, y, 1, 1, 1, true, -1, 0);
	}
}
