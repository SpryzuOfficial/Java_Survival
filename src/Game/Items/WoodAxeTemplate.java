package Game.Items;

import Game.engine.gfx.Assets;

public class WoodAxeTemplate extends Item
{
	public WoodAxeTemplate(int count, int x, int y) 
	{
		super(Assets.woodAxeTemplate, count, x, y, 1, 1, 1, true, 1, 480);
	}
	
	@Override
	public String toString()
	{
		return "Wood Axe";
	}
}
