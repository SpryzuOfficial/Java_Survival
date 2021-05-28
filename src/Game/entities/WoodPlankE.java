package Game.entities;

import Game.Items.Table;
import Game.Items.WoodPlank;
import Game.engine.gfx.Assets;

public class WoodPlankE extends StaticEntity
{
	public WoodPlankE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.woodPlankE, Gx, Gy, Vx, Vy, 64, 64, 300, 0, 0, 0);
		
		this.items.add(new WoodPlank(1, 0, 576));
	}

}
