package Game.Items;

import Game.engine.gfx.Assets;

public class RockFoodTray extends Item
{
	public RockFoodTray(int count, int x, int y) 
	{
		super(Assets.rockFoodTray, count, x, y, 1, 1, 1, true, -1, 1);
	}
}
