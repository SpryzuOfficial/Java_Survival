package Game.entities;

import Game.Items.Table;
import Game.engine.gfx.Assets;
import Game.ui.UiManager;

public class TableE extends StaticEntity
{
	public TableE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.tableE, Gx, Gy, Vx, Vy, 64, 64, 300, 0, 0, 0);
		
		this.items.add(new Table(1, 0, 576));
	}
	
	@Override
	public void use()
	{
		UiManager.uiImage = Assets.craftingtable;
	}
}
