package Game.Items;

import Game.engine.gfx.Assets;

public class RockPotWater extends Item
{
	public RockPotWater(int count, int x, int y) 
	{
		super(Assets.rockPotWater, count, x, y, 1, 1, 1, false, -1, 1);
	}
	
	@Override
	public String toString()
	{
		return "Rock Pot Water";
	}
}
