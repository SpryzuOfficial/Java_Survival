package Game.Items;

import java.awt.image.BufferedImage;

import Game.engine.Game;
import Game.ui.UiInventoryManager;

public class Food extends Item
{
	protected Item itemGive;
	protected double level;
	
	public Food(BufferedImage texture, int count, int x, int y, double level, Item itemGive) 
	{
		super(texture, count, x, y, 1, 1, 1, true, -1, 0);
		this.level = level;
		this.itemGive = itemGive;
	}
	
	@Override
	public boolean use()
	{
		if(Game.player.getFood() < 90)
		{
			Game.player.setFood(Game.player.getFood() + (level * 10));
			
			if(Game.player.getFood() > 100)
			{
				Game.player.setFood(100);
			}

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
			UiInventoryManager.addItem(itemGive);
			
			return true;
		}
		
		return false;
	}
}
