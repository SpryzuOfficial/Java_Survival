package Game.tiles;

import Game.engine.gfx.Assets;

public class Snow extends Tile
{
	public Snow(int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		super(Assets.snow, Vx, Vy, Gx, Gy, width, height);
	}
}
