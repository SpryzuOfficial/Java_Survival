package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class WoodSwordTemplate extends Item
{
	public WoodSwordTemplate(int count, int x, int y) 
	{
		super(Assets.woodSwordTemplate, count, x, y, 1, 1, 1, true, 1, 480);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}
