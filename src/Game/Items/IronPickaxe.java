package Game.Items;

import Game.engine.gfx.Assets;

public class IronPickaxe extends Tool
{
	public IronPickaxe(int x, int y)
	{
		super(Assets.ironPickaxe, x, y, 1, 7, 1, 40);
	}
	
	@Override
	public String toString()
	{
		return "Iron Pickaxe";
	}
}
