package Game.entities;

import Game.Items.PolishedBasalt;
import Game.Items.Stone;
import Game.engine.gfx.Assets;

public class PolishedBasaltE extends StaticEntity
{
	public PolishedBasaltE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.polishedBasaltE, Gx, Gy, Vx, Vy, 64, 64, 660, 0, 0, 1);
		
		this.items.add(new PolishedBasalt(1, 0, 576));
	}
}
