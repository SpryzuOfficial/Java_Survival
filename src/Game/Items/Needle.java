package Game.Items;

import Game.engine.gfx.Assets;

public class Needle extends Tool
{
	public Needle(int count, int x, int y) 
	{
		super(Assets.needle, x, y, 1, 1, 1, 8);
	}
	
	@Override
	public String toString()
	{
		return "Needle";
	}
}
