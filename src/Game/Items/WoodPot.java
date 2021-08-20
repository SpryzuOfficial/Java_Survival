package Game.Items;

import Game.engine.gfx.Assets;

public class WoodPot extends Item
{
	public WoodPot(int count, int x, int y) 
	{
		super(Assets.woodPot, count, x, y, 1, 1, 1, true, -1, 0);
	}
}
