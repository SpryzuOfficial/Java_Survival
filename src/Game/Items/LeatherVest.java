package Game.Items;

import Game.engine.gfx.Assets;

public class LeatherVest extends Item
{
	public LeatherVest(int count, int x, int y) 
	{
		super(Assets.leatherVest, count, x, y, 1, 1, 1, false, 1, 0);
		this.costumeId = 1;
	}
	
	@Override
	public String toString()
	{
		return "Leather Vest";
	}
}
