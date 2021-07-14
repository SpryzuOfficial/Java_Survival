package Game.Items;

import Game.engine.gfx.Assets;

public class StringItem extends Item
{
	public StringItem(int count, int x, int y) 
	{
		super(Assets.string, count, x, y, 1, 1, 1, true, 1, 0);
	}
}
