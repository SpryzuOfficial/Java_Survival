package Game.tiles;

import Game.engine.gfx.Assets;

public class Water extends Tile
{
	public Water(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.water, Vx, Vy, Gx, Gy, width, height);
	}
}
