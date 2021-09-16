package Game.Items;

import Game.engine.gfx.Assets;

public class WoodPickaxeTemplate extends Item
{
	public WoodPickaxeTemplate(int count, int x, int y) 
	{
		super(Assets.woodPickaxeTemplate, count, x, y, 1, 1, 1, true, 1, 480);
	}
	
	@Override
	public String toString()
	{
		return "Wood Pickaxe";
	}
}
