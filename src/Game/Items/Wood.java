package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class Wood extends Item
{
	public Wood(int count, int x, int y) 
	{
		super(Assets.wood, count, x, y, 1, 1, 1, true, -1, 1);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}
