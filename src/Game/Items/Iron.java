package Game.Items;

import Game.engine.gfx.Assets;

public class Iron extends Item
{
	public Iron(int count, int x, int y) 
	{
		super(Assets.iron, count, x, y, 1, 1, 1, true, -1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Iron";
	}
}
