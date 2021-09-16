package Game.Items;

import Game.engine.gfx.Assets;

public class Hammer extends Tool
{
	public Hammer(int x, int y)
	{
		super(Assets.hammer, x, y, 1, 2, 3, 15);
	}
	
	@Override
	public String toString()
	{
		return "Hammer";
	}
}
