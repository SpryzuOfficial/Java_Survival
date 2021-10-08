package Game.tiles;

import java.awt.Graphics;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;

public class TileManager 
{
	public static int tileY1, tileY2, tileX1, tileX2;
	public static int x, y;
	public static boolean rightPress;
	
	public TileManager()
	{
		
	}
	
	public static void tick()
	{
		Tile[][] tiles = Game.generateWorld.getTiles();
		
		tileY1 = (int) (Game.virtualSpace.getY() / 64) - 64;
	 	tileX1 = (int) (Game.virtualSpace.getX() / 64) - 64;
	 	tileY2 = (int) (Game.virtualSpace.getY() / 64) + 64;
	 	tileX2 = (int) (Game.virtualSpace.getX() / 64) + 64;
	 	
		for(y = tileY1;  y < tileY2; y++)
		{
			for(x = tileX1; x < tileX2; x++)
			{
				if(tiles[y][x]!=null)
				{
				tiles[y][x].tick();
				
				if(tiles[y][x].getGx() + tiles[y][x].getWidth() > 0 && tiles[y][x].getGx() < 0 + Game.width
						   && tiles[y][x].getGy() + tiles[y][x].getHeight() > 0 && tiles[y][x].getGy() < 0 + Game.height)
				{
					if(Game.mouseManager.getMouseX() >= tiles[y][x].getGx() &&
							Game.mouseManager.getMouseX() <= tiles[y][x].getGx() + tiles[y][x].getWidth() &&
									Game.mouseManager.getMouseY() >= tiles[y][x].getGy() &&
											Game.mouseManager.getMouseY() <= tiles[y][x].getGy() + tiles[y][x].getHeight())
					{
						Game.pointerX = tiles[y][x].getGx();	
						Game.pointerY = tiles[y][x].getGy();	
						//System.out.println(Game.generateWorld.worldNoises[y][x] + " | " + Game.generateWorld.worldMoisture[y][x]);
						
						if(Game.mouseManager.isRightPressed())
						{
							if(!rightPress)
							{
								boolean band = false;
								boolean band2 = false;
								if(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3] != null)
								{
									band = UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].place();
									
									if(!band)
									{
										band2 = UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].use();
									}
								}
								
								if(band || band2)
								{
									rightPress = true;
									
									if(!band2)
									{
										UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].refreshEntities();
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
									}
								}
								else
								{
									rightPress = false;
								}
							}
						}
						else
						{
							if(rightPress)
							{
								if(!Game.mouseManager.isRightPressed())
								{
									rightPress = false;
								}
							}
						}
					}
					
					if(tiles[y][x].getVx() + tiles[y][x].getWidth() > Game.player.getVx() && tiles[y][x].getVx() < Game.player.getVx() + Game.player.getWidth()
						   && tiles[y][x].getVy() + tiles[y][x].getHeight() > Game.player.getVy() && tiles[y][x].getVy() < Game.player.getVy() + Game.player.getHeight())
					{
						if(tiles[y][x] instanceof Water)
						{
							Game.player.addExtraLayer(0);
						}
						else
						{
							Game.player.removeExtraLayer(Assets.player_water);
						}
					}
				}
				}
			}
		}
	}
	
	public static void render(Graphics g)
	{
		Tile[][] tiles = Game.generateWorld.getTiles();
		
		for(int y = tileY1;  y < tileY2; y++)
		{
			for(int x = tileX1; x < tileX2; x++)
			{
				if(tiles[y][x]!=null)
				{
				if(tiles[y][x].getGx() + tiles[y][x].getWidth() > 0 && tiles[y][x].getGx() < 0 + Game.width
				   && tiles[y][x].getGy() + tiles[y][x].getHeight() > 0 && tiles[y][x].getGy() < 0 + Game.height)
				{
					tiles[y][x].render(g);
				}
				}
			}
		}
	}
}
