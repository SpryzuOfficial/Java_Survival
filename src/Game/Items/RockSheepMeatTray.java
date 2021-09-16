package Game.Items;

import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;

public class RockSheepMeatTray extends Item
{
	public RockSheepMeatTray(int count, int x, int y) 
	{
		super(Assets.rockSheepMeatTray, count, x, y, 1, 1, 1, true, -1, 1);
	}
	
	@Override
	public boolean use()
	{
		if(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].getCount() > 1)
		{
			UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].setCount(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].getCount() - 1);
			UiInventoryManager.hInventorySlots[UiInventoryManager.hotbarSelected - 3].setItem(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3]);
		}
		else 
		{
			UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3] = null;
			UiInventoryManager.hInventorySlots[UiInventoryManager.hotbarSelected - 3].setItem(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3]);
		}
		
		UiInventoryManager.addItem(new SheepMeat(1, 0, 576));
		UiInventoryManager.addItem(new RockFoodTray(1, 0, 576));
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Rock Tray Sheep Meat";
	}
}
