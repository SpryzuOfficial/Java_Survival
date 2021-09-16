package Game.Items;

import Game.engine.gfx.Assets;

public class Wool extends Item
{
	public Wool(int count, int x, int y) 
	{
		super(Assets.wool, count, x, y, 1, 1, 1, true, -1, 60);
	}
	
	@Override
	public String toString()
	{
		return "Wool";
	}
}
