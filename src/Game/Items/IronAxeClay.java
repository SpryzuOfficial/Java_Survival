package Game.Items;

import Game.engine.gfx.Assets;

public class IronAxeClay extends Item
{
	public IronAxeClay(int count, int x, int y) 
	{
		super(Assets.ironAxeClay, count, x, y, 1, 1, 1, true, 1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Iron Axe in Brick";
	}
}
