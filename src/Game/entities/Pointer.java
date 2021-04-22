package Game.entities;

import java.awt.Graphics;

import Game.engine.gfx.Assets;

public class Pointer extends Entity
{
	public Pointer(int x, int y)
	{
		super(Assets.pointer, x, y, 0, 0, 64, 64, 0);
	}
	
	@Override
	public void tick()
	{
		
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, width, height, null);
	}
}
