package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class WoodTable extends Item
{
	public WoodTable(int count, int x, int y) 
	{
		super(Assets.woodTable, count, x, y, 1, 1, 1, true, -1, 1);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}
