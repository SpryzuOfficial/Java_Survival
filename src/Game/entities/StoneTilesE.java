package Game.entities;

import Game.Items.StoneTiles;
import Game.engine.gfx.Assets;

public class StoneTilesE extends StaticEntity
{
	public StoneTilesE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.stoneTilesE, Gx, Gy, Vx, Vy, 64, 64, 480, 0, 0, 1);
		
		this.items.add(new StoneTiles(1, 0, 576));
	}
}
