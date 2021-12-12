package Game.entities;

import Game.Items.Obsidian;
import Game.engine.gfx.Assets;

public class ObsidianWall extends StaticEntity
{
	public ObsidianWall(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.obsidianWall, Gx, Gy, Vx, Vy, 64, 64, 1100, 0, 0, 1);
		
		this.items.add(new Obsidian(1, 0, 576));
	}
}
