package Game.Items;

import Game.engine.gfx.Assets;

public class ClayMoldSword extends Item
{
	public ClayMoldSword(int count, int x, int y) 
	{
		super(Assets.clayMoldSword, count, x, y, 1, 1, 1, true, 1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Clay Mold Sword";
	}
}
