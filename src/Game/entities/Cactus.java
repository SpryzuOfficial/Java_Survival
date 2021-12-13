package Game.entities;

import Game.engine.gfx.Assets;

public class Cactus extends StaticEntity
{
	public Cactus(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.cactus, Gx, Gy, Vx, Vy, 64, 64, 120, 0, 0, 0);
	}
}
