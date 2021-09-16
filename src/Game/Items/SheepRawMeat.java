package Game.Items;

import Game.engine.gfx.Assets;

public class SheepRawMeat extends Item
{
	public SheepRawMeat(int count, int x, int y) 
	{
		super(Assets.sheepRawMeat, count, x, y, 1, 1, 1, true, -1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Raw Sheep Meat";
	}
}
