package Game.Items;

import Game.engine.gfx.Assets;

public class Stick extends Item
{
	public Stick(int count, int x, int y) 
	{
		super(Assets.stick, count, x, y, 1, 1, 1, true, 1, 480);
	}
}
