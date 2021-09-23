package Game.entities;

import Game.engine.gfx.Assets;

public class Bush extends StaticEntity
{
	public Bush(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.bush, Gx, Gy, Vx, Vy, 64, 64, 80, 0, 0, 0);
	}
}
