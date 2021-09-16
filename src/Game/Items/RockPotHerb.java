package Game.Items;

import Game.engine.gfx.Assets;

public class RockPotHerb extends Item
{
	public RockPotHerb(int count, int x, int y) 
	{
		super(Assets.rockPotHerb, count, x, y, 1, 1, 1, false, 3, 0, new RockPot(1, 0, 576));
	}
	
	@Override
	public String toString()
	{
		return "Rock Pot Herbs";
	}
}
