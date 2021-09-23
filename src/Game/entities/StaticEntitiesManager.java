package Game.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Game.Items.Item;
import Game.engine.Game;
import Game.tiles.TileManager;
import Game.ui.UiInventoryManager;

public class StaticEntitiesManager
{
	public static ArrayList<Integer> index = new ArrayList<Integer>();
	private static int destructionTimer = 0;
	public static float destructionBarValue = 0;
	private static int miningValue = 1;
	
	public static int framesLastUpdate = 320;
	
	public StaticEntitiesManager() 
	{
		
	}
	
	public static void tick()
	{	
		if(framesLastUpdate == 320)
		{
			index = new ArrayList<Integer>();
			for(int i = 0; i < Game.generateWorld.SESIZE; i++)
			{
				double c = Math.sqrt(Math.pow(Math.abs(Game.generateWorld.getSEntities().get(i).Vx - Game.virtualSpace.getX()), 2) + Math.pow(Math.abs(Game.generateWorld.getSEntities().get(i).Vx - Game.virtualSpace.getX()), 2));
				
				c /= 64;
				
				if(c < 32)
				{
					index.add(i);
				}
			}
			
			framesLastUpdate = 0;
		}
		
		framesLastUpdate++;
		
		for(int i = 0; i < index.size(); i++)
		{
			boolean otherEMining = false;
			int otherEMiningId = -999999;
			
			StaticEntity entity = Game.generateWorld.getSEntities().get(index.get(i));
			
			entity.tick();
			
			if(Game.mouseManager.getMouseX() >= entity.getX() &&
			   Game.mouseManager.getMouseX() <= entity.getX() + entity.getWidth() &&
			   Game.mouseManager.getMouseY() >= entity.getY() &&
			   Game.mouseManager.getMouseY() <= entity.getY() + entity.getHeight())
			{
				for(int j = 0; j < index.size(); j++)
				{
					if(Game.generateWorld.getSEntities().get(index.get(i)).isMining())
					{
						otherEMining = true;
						otherEMiningId = i;
						break;
					}
				}
				
				if(Game.mouseManager.isRightPressed())
				{
					if(!TileManager.rightPress)
					{
						entity.use();
					}
				}
				
				if(!otherEMining || i == otherEMiningId)
				{
					Game.pointerX = entity.getX() + entity.getPointerOffx();	
					Game.pointerY = entity.getY() + entity.getPointerOffy();
					
					if(Game.mouseManager.isLeftPressed() && !entity.isMining())
					{
						entity.setMining(true);
						destructionTimer = 0;
					}
					
					if(Game.mouseManager.isLeftPressed() && entity.isMining())
					{
						if(UiInventoryManager.inventoryTool != null)
						{
							destructionTimer += (miningValue * UiInventoryManager.inventoryTool.getMiningValue(entity.getType()));
							destructionBarValue += 64f / entity.getMiningTime() * (miningValue * UiInventoryManager.inventoryTool.getMiningValue(entity.getType()));
							Game.player.setFoodPerF(0.0055);
						}
						else
						{
							destructionTimer += (miningValue);
							destructionBarValue += 64f / entity.getMiningTime() * (miningValue);
							Game.player.setFoodPerF(0.006);
						}
					}				
					else if(!Game.mouseManager.isLeftPressed())
					{
						entity.setMining(false);
						destructionTimer = 0;
						destructionBarValue = 0;
					}
					
					if(Game.mouseManager.isLeftPressed() && entity.isMining() && destructionTimer >= entity.getMiningTime())
					{
						Random r = new Random();
						if(entity.getProbs().size() != 0)
						{
							Double v = r.nextDouble();
						
							for (int j = 0; j < entity.getItems().size(); j++)
							{
								if((j + 1) < entity.getItems().size())
								{
									if(v > entity.getProbs().get(j) && v < entity.getProbs().get(j + 1))
									{
										if(entity.getItems().get(j) != null)
										{
											UiInventoryManager.addItem(entity.getItems().get(j));
										}
										break;
									}
									else
									{
										if(entity.getItems().get(j + 1) != null)
										{
											UiInventoryManager.addItem(entity.getItems().get(j + 1));
										}
										break;
									}
								}
								else
								{
									if(v > entity.getProbs().get(j))
									{
										if(entity.getItems().get(j) != null)
										{
											UiInventoryManager.addItem(entity.getItems().get(j));
										}
										break;
									}
								}
							}
						}
						else
						{
							for (int j = 0; j < entity.getItems().size(); j++)
							{
								if(entity.getItems().get(j) != null)
								{
									UiInventoryManager.addItem(entity.getItems().get(j));
								}
							}
						}
						
						if(entity.getEntityReplace() != null)
						{
							Game.generateWorld.getSEntities().add(entity.getEntityReplace());
							Game.generateWorld.SESIZE++;
						}
						
						Game.generateWorld.getSEntities().remove((int) index.get(i));
						Game.generateWorld.SESIZE--;
						index.remove(i);
						
						Item item = new Item(null, 1, 0, 0, 0, 0, 0, true, 0, 0);
						
						item.refreshEntities();
						
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
		for(int i = 0; i < index.size(); i++)
		{
			StaticEntity entity = Game.generateWorld.getSEntities().get(index.get(i));
			
			if(entity.getX() + entity.getWidth() > 0 && entity.getX() < 0 + Game.width
			   && entity.getY() + entity.getHeight() > 0 && entity.getY() < 0 + Game.height)
			{
				entity.render(g);
			}
		}
	}
}
