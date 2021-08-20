package Game.entities;

import Game.Items.Herbs;
import Game.engine.gfx.Assets;

public class Plant extends StaticEntity
{
	public Plant(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.plant, Gx, Gy, Vx, Vy, 64, 64, 60, 0, 0, 0);
		
		this.items.add(new Herbs(1, 0, 576));
	}
}
