package Game.entities;

import Game.Items.Herbs;
import Game.engine.gfx.Assets;

public class MushroomRedE extends StaticEntity
{
	public MushroomRedE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.mushroomRedE, Gx, Gy, Vx, Vy, 64, 64, 40, 0, 0, 0);
		
		this.items.add(new Herbs(1, 0, 576));
	}
}
