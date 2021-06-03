package Game.entities;

import Game.Items.IronOre;
import Game.engine.gfx.Assets;

public class IronOreE extends StaticEntity
{
	public IronOreE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.ironOreE, Gx, Gy, Vx, Vy, 64, 64, 540, 0, 0, 1);
		
		this.items.add(new IronOre(1, 0, 576));
	}
}
