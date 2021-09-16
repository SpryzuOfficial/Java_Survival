package Game.Items;

import Game.engine.gfx.Assets;

public class ClayMoldPickaxe extends Item
{
	public ClayMoldPickaxe(int count, int x, int y) 
	{
		super(Assets.clayMoldPickaxe, count, x, y, 1, 1, 1, true, 1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Clay Mold Pickaxe";
	}
}
