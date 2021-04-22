package Game.tiles;

import Game.engine.gfx.Assets;

public class Dirt extends Tile
{
	public Dirt(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.dirt, Vx, Vy, Gx, Gy, width, height);
	}
}
