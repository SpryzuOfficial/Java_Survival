package Game.Items;

import Game.engine.gfx.Assets;

public class IronAxe extends Tool
{
	public IronAxe(int x, int y)
	{
		super(Assets.ironAxe, x, y, 7, 1, 1, 42);
	}
	
	@Override
	public String toString()
	{
		return "Iron Axe";
	}
}
