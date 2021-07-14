package Game.Items;

import Game.engine.gfx.Assets;

public class IronSwordClay extends Item
{
	public IronSwordClay(int count, int x, int y) 
	{
		super(Assets.ironSwordClay, count, x, y, 1, 1, 1, true, 1, 0);
	}
}
