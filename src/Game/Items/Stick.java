package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class Stick extends Item
{
	public Stick(int count, int x, int y) 
	{
		super(Assets.stick, count, x, y, 1, 1, 1, true, 1, 0.5);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}
