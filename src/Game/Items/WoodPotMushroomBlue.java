package Game.Items;

import Game.engine.gfx.Assets;

public class WoodPotMushroomBlue extends Food
{
	public WoodPotMushroomBlue(int count, int x, int y) 
	{
		super(Assets.woodPotMushroomBlue, count, x, y, 3, new WoodPot(1, 0, 576));
	}
	
	@Override
	public String toString()
	{
		return "Wood Pot Blue Mushroom";
	}
}
