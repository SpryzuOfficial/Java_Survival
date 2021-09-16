package Game.Items;

import Game.engine.gfx.Assets;

public class IronPickaxeClay extends Item
{
	public IronPickaxeClay(int count, int x, int y) 
	{
		super(Assets.ironPickaxeClay, count, x, y, 1, 1, 1, true, 1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Iron Pickaxe in Brick";
	}
}
