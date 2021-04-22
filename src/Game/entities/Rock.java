package Game.entities;

import Game.Items.*;
import Game.engine.gfx.Assets;

public class Rock extends StaticEntity
{
	public Rock(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.rock, Gx, Gy, Vx, Vy, 64, 64, 480, 0, 0, 1);
		
		this.items.add(new Stone(1, 0, 576));
	}
}
