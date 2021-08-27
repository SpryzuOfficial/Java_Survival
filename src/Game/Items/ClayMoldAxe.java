package Game.Items;

import Game.engine.gfx.Assets;

public class ClayMoldAxe extends Item
{
	public ClayMoldAxe(int count, int x, int y) 
	{
		super(Assets.clayMoldAxe, count, x, y, 1, 1, 1, true, 1, 0);
	}
}
