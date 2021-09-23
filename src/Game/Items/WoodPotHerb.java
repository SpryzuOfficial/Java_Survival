package Game.Items;

import Game.engine.gfx.Assets;

public class WoodPotHerb extends Food
{
	public WoodPotHerb(int count, int x, int y) 
	{
		super(Assets.woodPotHerb, count, x, y, 2, new WoodPot(1, 0, 576));
	}
	
	@Override
	public String toString()
	{
		return "Wood Pot Herb";
	}
}
