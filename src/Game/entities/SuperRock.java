package Game.entities;

import Game.engine.gfx.Assets;

public class SuperRock extends StaticEntity
{
	public SuperRock(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.superRock, Gx, Gy, Vx, Vy, 64, 64, 0, 0, 0, 1);
	}
}
