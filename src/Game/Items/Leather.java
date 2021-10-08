package Game.Items;

import Game.engine.gfx.Assets;

public class Leather extends Item
{
	public Leather(int count, int x, int y) 
	{
		super(Assets.leather, count, x, y, 1, 1, 1, true, 1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Leather";
	}
}
