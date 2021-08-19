package Game.Items;

import Game.engine.gfx.Assets;

public class RockPotWater extends Item
{
	public RockPotWater(int count, int x, int y) 
	{
		super(Assets.rockPotWater, count, x, y, 1, 1, 1, true, -1, 1);
	}
}
