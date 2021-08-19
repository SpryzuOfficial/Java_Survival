package Game.Items;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;

public class RockPot extends Item
{
	public RockPot(int count, int x, int y) 
	{
		super(Assets.rockPot, count, x, y, 1, 1, 1, false, -1, 1);
	}
	
	@Override
	public void use()
	{
		if(Game.player.getPlayerExtraLayer() == Assets.player_water)
		{
			UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3] = null;
			UiInventoryManager.hInventorySlots[UiInventoryManager.hotbarSelected - 3].setItem(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3]);
		
			UiInventoryManager.addItem(new RockPotWater(1, 0, 576));
		}
	}
}
