package Game.Items;

import Game.engine.gfx.Assets;

public class Pickaxe extends Tool
{
	public Pickaxe(int x, int y)
	{
		super(Assets.pickaxe, x, y, 1, 3, 1, 16);
	}
}
