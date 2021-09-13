package Game.entities;

import Game.Items.MushroomBlue;
import Game.engine.gfx.Assets;

public class MushroomBlueE extends StaticEntity
{
	public MushroomBlueE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.mushroomBlueE, Gx, Gy, Vx, Vy, 64, 64, 40, 0, 0, 0);
		
		this.items.add(new MushroomBlue(1, 0, 576));
	}
}
