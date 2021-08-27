package Game.Items;

import Game.engine.gfx.Assets;

public class RockPotMushroomBlue extends Item
{
	public RockPotMushroomBlue(int count, int x, int y) 
	{
		super(Assets.rockPotMushroomBlue, count, x, y, 1, 1, 1, false, 3, 0, new RockPot(1, 0, 576));
	}
}
