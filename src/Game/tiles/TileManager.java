package Game.tiles;

import java.awt.Graphics;

import Game.engine.Game;
import Game.entities.Entity;
import Game.entities.StaticEntity;
import Game.ui.UiInventoryManager;

public class TileManager 
{
	public static int tileY1, tileY2, tileX1, tileX2;
	
	public TileManager()
	{
		
	}
	
	public static void tick()
	{
		Tile[][] tiles = Game.generateWorld.getTiles();
		
		tileY1 = (int) (Game.virtualSpace.getY() / 64) - 128;
	 	tileX1 = (int) (Game.virtualSpace.getX() / 64) - 128;
	 	tileY2 = (int) (Game.virtualSpace.getY() / 64) + 128;
	 	tileX2 = (int) (Game.virtualSpace.getX() / 64) + 128;
	 	
		for(int y = tileY1;  y < tileY2; y++)
		{
			for(int x = tileX1; x < tileX2; x++)
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
						
						if(Game.mouseManager.isRightPressed())
						{
							tiles[y][x] = new Dirt(tiles[y][x].getVx(),
													tiles[y][x].getVy(),
													tiles[y][x].getGx(),
													tiles[y][x].getGy(),
													64,
													64);
						}
					}
					
					if(tiles[y][x].getVx() + tiles[y][x].getWidth() > Game.player.getVx() && tiles[y][x].getVx() < Game.player.getVx() + Game.player.getWidth()
						   && tiles[y][x].getVy() + tiles[y][x].getHeight() > Game.player.getVy() && tiles[y][x].getVy() < Game.player.getVy() + Game.player.getHeight())
					{
						if(tiles[y][x] instanceof Water)
						{
							Game.player.setExtraLayer(0);
						}
						else
						{
							Game.player.setExtraLayer(-1);
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
				if(tiles[y][x].getGx() + tiles[y][x].getWidth() > 0 && tiles[y][x].getGx() < 0 + Game.width
				   && tiles[y][x].getGy() + tiles[y][x].getHeight() > 0 && tiles[y][x].getGy() < 0 + Game.height)
				{
					tiles[y][x].render(g);
				}
			}
		}
	}
}
