package Game.entities;

import Game.Items.SandStone;
import Game.engine.gfx.Assets;

public class SandStoneE extends StaticEntity
{
	public SandStoneE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.sandStoneE, Gx, Gy, Vx, Vy, 64, 64, 500, 0, 0, 1);
		
		this.items.add(new SandStone(1, 0, 576));
	}
}
