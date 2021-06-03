package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class BasaltTray extends Item
{
	public BasaltTray(int count, int x, int y) 
	{
		super(Assets.basaltTray, count, x, y, 1, 1, 1, true, -1);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}
