package Game.Items;

import Game.engine.gfx.Assets;

public class RockPotHerb extends Item
{
	public RockPotHerb(int count, int x, int y) 
	{
		super(Assets.rockPotHerb, count, x, y, 1, 1, 1, false, 4, 0);
	}
}
