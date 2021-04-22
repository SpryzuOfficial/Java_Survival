package Game.tiles;

import Game.engine.gfx.Assets;

public class Sand extends Tile
{
	public Sand(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.sand, Vx, Vy, Gx, Gy, width, height);
	}
}
