package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class ClayMold extends Item
{
	public ClayMold(int count, int x, int y) 
	{
		super(Assets.clayMold, count, x, y, 1, 1, 1, true, -1, 0);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
}