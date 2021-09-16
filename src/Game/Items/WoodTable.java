package Game.Items;

import Game.engine.gfx.Assets;

public class WoodTable extends Item
{
	public WoodTable(int count, int x, int y) 
	{
		super(Assets.woodTable, count, x, y, 1, 1, 1, true, -1, 240);
	}
	
	@Override
	public String toString()
	{
		return "Wood Table";
	}
}
