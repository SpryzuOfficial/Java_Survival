package Game.tiles;

import Game.engine.gfx.Assets;

public class Ice extends Tile
{
	public Ice(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.ice, Vx, Vy, Gx, Gy, width, height);
	}
}
