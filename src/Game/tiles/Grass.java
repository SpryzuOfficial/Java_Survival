package Game.tiles;

import Game.engine.gfx.Assets;

public class Grass extends Tile
{
	public Grass(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.grass, Vx, Vy, Gx, Gy, width, height);
	}
}
