package Game.Items;

import Game.engine.gfx.Assets;

public class RockPotMushroomRed extends Item
{
	public RockPotMushroomRed(int count, int x, int y) 
	{
		super(Assets.rockPotMushroomRed, count, x, y, 1, 1, 1, false, 4, 0, new RockPot(1, 0, 576));
	}
	
	@Override
	public String toString()
	{
		return "Rock Pot Red Mushroom";
	}
}
