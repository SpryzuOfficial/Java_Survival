package Game.entities;

import Game.Items.Clay;
import Game.engine.gfx.Assets;

public class ClayE extends StaticEntity
{
	public ClayE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.clayE, Gx, Gy, Vx, Vy, 64, 64, 240, 0, 0, 2);
		
		this.items.add(new Clay(1, 0, 576));
	}
}
