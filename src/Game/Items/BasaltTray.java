package Game.Items;

import Game.engine.gfx.Assets;

public class BasaltTray extends Item
{
	public BasaltTray(int count, int x, int y) 
	{
		super(Assets.basaltTray, count, x, y, 1, 1, 1, true, -1, 0);
	}
}
