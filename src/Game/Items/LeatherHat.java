package Game.Items;

import Game.engine.gfx.Assets;

public class LeatherHat extends Item
{
	public LeatherHat(int count, int x, int y) 
	{
		super(Assets.leatherHat, count, x, y, 1, 1, 1, false, 1, 0);
		this.costumeId = 2;
	}
	
	@Override
	public String toString()
	{
		return "Leather Hat";
	}
}
