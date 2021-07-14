package Game.entities;

import java.awt.Graphics;

import Game.engine.Game;
import Game.tiles.TileManager;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;

public class StaticEntitiesManager
{
	private static int destructionTimer = 0;
	public static float destructionBarValue = 0;
	private static int miningValue = 1;
	
	public StaticEntitiesManager() 
	{
		
	}
	
	public static void tick()
	{	
		for(int i = 0; i < Game.generateWorld.SESIZE; i++)
		{
			boolean otherEMining = false;
			int otherEMiningId = -999999;
			
			Game.generateWorld.getSEntities().get(i).tick();
			
			if(Game.mouseManager.getMouseX() >= Game.generateWorld.getSEntities().get(i).getX() &&
					Game.mouseManager.getMouseX() <= Game.generateWorld.getSEntities().get(i).getX() + Game.generateWorld.getSEntities().get(i).getWidth() &&
					Game.mouseManager.getMouseY() >= Game.generateWorld.getSEntities().get(i).getY() &&
					Game.mouseManager.getMouseY() <= Game.generateWorld.getSEntities().get(i).getY() + Game.generateWorld.getSEntities().get(i).getHeight())
			{
				for(int j = 0; j < Game.generateWorld.SESIZE; j++)
				{
					if(Game.generateWorld.getSEntities().get(j).isMining())
					{
						otherEMining = true;
						otherEMiningId = j;
						break;
					}
				}
				
				if(Game.mouseManager.isRightPressed())
				{
					if(!TileManager.rightPress)
					{
						Game.generateWorld.getSEntities().get(i).use();
					}
				}
				
				if(!otherEMining || i == otherEMiningId)
				{
					Game.pointerX = Game.generateWorld.getSEntities().get(i).getX() + Game.generateWorld.getSEntities().get(i).getPointerOffx();	
					Game.pointerY = Game.generateWorld.getSEntities().get(i).getY() + Game.generateWorld.getSEntities().get(i).getPointerOffy();
					
					if(Game.mouseManager.isLeftPressed() && !Game.generateWorld.getSEntities().get(i).isMining())
					{
						Game.generateWorld.getSEntities().get(i).setMining(true);
						destructionTimer = 0;
					}
					
					if(Game.mouseManager.isLeftPressed() && Game.generateWorld.getSEntities().get(i).isMining())
					{
						if(UiInventoryManager.inventoryTool != null)
						{
							destructionTimer += (miningValue * UiInventoryManager.inventoryTool.getMiningValue(Game.generateWorld.getSEntities().get(i).getType()));
							destructionBarValue += 64f / Game.generateWorld.getSEntities().get(i).getMiningTime() * (miningValue * UiInventoryManager.inventoryTool.getMiningValue(Game.generateWorld.getSEntities().get(i).getType()));
							Game.player.setFoodPerF(0.0055);
						}
						else
						{
							destructionTimer += (miningValue);
							destructionBarValue += 64f / Game.generateWorld.getSEntities().get(i).getMiningTime() * (miningValue);
							Game.player.setFoodPerF(0.006);
						}
					}				
					else if(!Game.mouseManager.isLeftPressed())
					{
						Game.generateWorld.getSEntities().get(i).setMining(false);
						destructionTimer = 0;
						destructionBarValue = 0;
					}
					
					if(Game.mouseManager.isLeftPressed() && Game.generateWorld.getSEntities().get(i).isMining() && destructionTimer >= Game.generateWorld.getSEntities().get(i).getMiningTime())
					{
						for (int j = 0; j < Game.generateWorld.getSEntities().get(i).getItems().size(); j++)
						{
							if(Game.generateWorld.getSEntities().get(i).getItems().get(j) != null)
							{
								UiInventoryManager.addItem(Game.generateWorld.getSEntities().get(i).getItems().get(j));
							}
						}
						
						Game.generateWorld.getSEntities().remove(i);
						Game.generateWorld.SESIZE--;
						
						if(UiInventoryManager.inventoryTool != null)
						{
							UiInventoryManager.inventoryTool.setLife(UiInventoryManager.inventoryTool.getLife() + 1);
							if(UiInventoryManager.inventoryTool.getLife() == UiInventoryManager.inventoryTool.getTopLife())
							{
								UiInventoryManager.inventoryTool = null;
								UiInventoryManager.toolInventorySlot.setItem(UiInventoryManager.inventoryTool);
							}
						}
						
						destructionTimer = 0;
						destructionBarValue = 0;
					}
				}
			}
		}
	}
	
	public static void render(Graphics g)
	{
		for(int i = 0; i < Game.generateWorld.SESIZE; i++)
		{
			if(Game.generateWorld.getSEntities().get(i).getX() + Game.generateWorld.getSEntities().get(i).getWidth() > 0 && Game.generateWorld.getSEntities().get(i).getX() < 0 + Game.width
			   && Game.generateWorld.getSEntities().get(i).getY() + Game.generateWorld.getSEntities().get(i).getHeight() > 0 && Game.generateWorld.getSEntities().get(i).getY() < 0 + Game.height)
			{
				Game.generateWorld.getSEntities().get(i).render(g);
			}
		}
	}
}
