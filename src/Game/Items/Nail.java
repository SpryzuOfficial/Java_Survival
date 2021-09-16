package Game.Items;

import Game.engine.gfx.Assets;

public class Nail extends Item
{
	public Nail(int count, int x, int y) 
	{
		super(Assets.nail, count, x, y, 1, 1, 1, true, 1, 0);
	}
	
	@Override
	public String toString()
	{
		return "Nails";
	}
}
