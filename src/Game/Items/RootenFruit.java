package Game.Items;

import Game.engine.gfx.Assets;

public class RootenFruit extends Item
{
	public RootenFruit(int count, int x, int y) 
	{
		super(Assets.rootenFruit, count, x, y, 1, 1, 1, true, -1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Rooten Fruit";
	}
}
