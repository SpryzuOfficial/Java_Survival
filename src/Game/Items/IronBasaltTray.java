package Game.Items;

import Game.engine.gfx.Assets;

public class IronBasaltTray extends Item
{
	public IronBasaltTray(int count, int x, int y) 
	{
		super(Assets.ironBasaltTray, count, x, y, 1, 1, 1, true, -1, 1);
	}
	
	@Override
	public String toString()
	{
		return "Basalt Tray Iron";
	}
}
