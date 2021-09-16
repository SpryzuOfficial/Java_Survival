package Game.Items;

import Game.engine.gfx.Assets;

public class Knife extends Tool
{
	public Knife(int x, int y)
	{
		super(Assets.kinfe, x, y, 1, 1, 2, 20);
	}
	
	@Override
	public String toString()
	{
		return "Knife";
	}
}
