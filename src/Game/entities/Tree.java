package Game.entities;

import Game.Items.*;
import Game.engine.gfx.Assets;

public class Tree extends StaticEntity
{
	public Tree(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.tree, Gx, Gy, Vx, Vy, 64, 128, 240, 0, 32, 0);
		
		this.items.add(new Wood(1, 0, 576));
	}
}
