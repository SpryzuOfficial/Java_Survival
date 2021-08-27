package Game.Items;

import Game.engine.gfx.Assets;

public class WoodPotMushroomRed extends Food
{
	public WoodPotMushroomRed(int count, int x, int y) 
	{
		super(Assets.woodPotMushroomRed, count, x, y, 1.5, new WoodPot(1, 0, 576));
	}
}
