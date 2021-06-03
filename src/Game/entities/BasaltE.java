package Game.entities;

import Game.Items.Basalt;
import Game.engine.gfx.Assets;

public class BasaltE extends StaticEntity
{
	public BasaltE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.basaltE, Gx, Gy, Vx, Vy, 64, 64, 600, 0, 0, 1);
		
		this.items.add(new Basalt(1, 0, 576));
	}
}
