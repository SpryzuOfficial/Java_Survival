package Game.entities;

import Game.Items.Chest;
import Game.Items.Item;
import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;

public class ChestE extends StaticEntity
{
	public Item[] content;
	
	public ChestE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.chestE, Gx, Gy, Vx, Vy, 64, 64, 480, 0, 0, 0);
		
		content = new Item[8];
		this.items.add(new Chest(1, 0, 576));
		Game.generateWorld.getChests().add(this);
	}
	
	@Override
	public void use()
	{
		UiManager.uiImage = Assets.chestUI;
		UiInventoryManager.chest = this;
		
		UiInventoryManager.openChest();
	}
	
	@Override
	public void tick()
	{
		x = Vx - virtualSpace.getX();
		y = Vy - virtualSpace.getY();
		
		this.items.clear();
		this.items.add(new Chest(1, 0, 576));
		
		for(int i = 0; i < 8; i++)
		{
			this.items.add(content[i]);
		}
	}
}
