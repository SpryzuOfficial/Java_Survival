package Game.tiles;

import Game.engine.gfx.Assets;

public class Rocks extends Tile
{
	public Rocks(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.rocks, Vx, Vy, Gx, Gy, width, height);
	}
}
