package Game.Items;

import java.awt.Graphics;

import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;

public class RockSheepMeatTray extends Item
{
	public RockSheepMeatTray(int count, int x, int y) 
	{
		super(Assets.rockSheepMeatTray, count, x, y, 1, 1, 1, true, -1, 1);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
	
	@Override
	public void use()
	{
		UiInventoryManager.addItem(new SheepMeat(1, 0, 576));
		UiInventoryManager.addItem(new RockFoodTray(1, 0, 576));
		
		UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3] = null;
	}
}
