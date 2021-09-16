package Game.Items;

import Game.engine.gfx.Assets;

public class Sandpaper extends Tool
{
	public Sandpaper(int x, int y)
	{
		super(Assets.sandpaper, x, y, 2, 2, 1, 12);
	}
	
	@Override
	public String toString()
	{
		return "Sandpaper";
	}
}
