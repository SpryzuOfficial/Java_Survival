package Game.Items;

import Game.engine.gfx.Assets;

public class SheepMeat extends Food
{
	public SheepMeat(int count, int x, int y) 
	{
		super(Assets.sheepMeat, count, x, y, 5);
	}
}
