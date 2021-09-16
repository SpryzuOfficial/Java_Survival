package Game.Items;

import Game.engine.gfx.Assets;

public class BasaltHammer extends Tool
{
	public BasaltHammer(int x, int y)
	{
		super(Assets.basaltHammer, x, y, 1, 4, 6, 30);
	}
	
	@Override
	public String toString()
	{
		return "Basalt Hammer";
	}
}
