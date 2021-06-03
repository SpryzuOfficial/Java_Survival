package Game.entities;

import Game.Items.Anvil;
import Game.engine.gfx.Assets;

public class AnvilE extends StaticEntity
{
	public AnvilE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.anvilE, Gx, Gy, Vx, Vy, 64, 64, 780, 0, 0, 1);
		
		this.items.add(new Anvil(1, 0, 576));
	}
}
