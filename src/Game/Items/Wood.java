package Game.Items;

import Game.engine.gfx.Assets;

public class Wood extends Item
{
	public Wood(int count, int x, int y) 
	{
		super(Assets.wood, count, x, y, 1, 1, 1, true, -1, 240);
	}
}
