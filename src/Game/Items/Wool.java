package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class Wool extends Item
{
	public Wool(int count, int x, int y) 
	{
		super(Assets.wool, count, x, y, 1, 1, 1, true, -1, 3);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}
