package Game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;

public class Player extends Entity
{
	private BufferedImage[] playerExtraLayers = new BufferedImage[] {Assets.player_water};
	private BufferedImage playerExtraLayer;
	
	public Player(int x, int y, int Vx, int Vy)
	{
		super(Assets.player, x, y, Vx, Vy, 64, 64, 4);
	}
	
	@Override
	public void tick()
	{
		if(Game.keyManager.shift)
		{
			virtualSpace.setSpeed(6);
		}
		else
		{
			virtualSpace.setSpeed(4);
		}
		
		Vx = (((virtualSpace.getWidth() / 2) - (width / 2)) + virtualSpace.getX());
		Vy = (((virtualSpace.getHeight() / 2) - (height / 2)) + virtualSpace.getY());
		
		for(int i = 0; i < Game.generateWorld.ASIZE; i++)
		{
			if((this.getVx() + 20) + (this.getWidth() - 40) > Game.generateWorld.getAnimals().get(i).getVx() && (this.getVx() + 20) < Game.generateWorld.getAnimals().get(i).getVx() + Game.generateWorld.getAnimals().get(i).getWidth()
			   && (this.getVy() + 32) + (this.getHeight() / 2) > Game.generateWorld.getAnimals().get(i).getVy() && (this.getVy() + 32) < Game.generateWorld.getAnimals().get(i).getVy() + Game.generateWorld.getAnimals().get(i).getHeight())
			{
				Game.colliding = true;
			}
		}
		
		for(int i = 0; i < Game.generateWorld.SESIZE; i++)
		{
			if((this.getVx() + 20) + (this.getWidth() - 40) > Game.generateWorld.getSEntities().get(i).getVx() && (this.getVx() + 20) < Game.generateWorld.getSEntities().get(i).getVx() + Game.generateWorld.getSEntities().get(i).getWidth()
			   && (this.getVy() + 32) + ((this.getHeight() / 2) - 20) > Game.generateWorld.getSEntities().get(i).getVy() && (this.getVy() + 32) < Game.generateWorld.getSEntities().get(i).getVy() + Game.generateWorld.getSEntities().get(i).getHeight())
			{
				Game.colliding = true;
			}
		}
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, width, height, null);
		if(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3] != null)
		{
			g.drawImage(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].getTexture(), x + 100, y, -64, 64, null);
		}
		
		if(UiInventoryManager.inventoryTool != null)
		{
			g.drawImage(UiInventoryManager.inventoryTool.getTexture(), x - 36, y, 64, 64, null);
		}
		g.drawImage(playerExtraLayer, x, y, width, height, null);
	}
	
	public BufferedImage[] getExtraLayers()
	{
		return playerExtraLayers;
	}
	
	public void setExtraLayer(int i)
	{
		if(i == -1) 
		{
			playerExtraLayer = null;
		}
		else
		{
			playerExtraLayer = playerExtraLayers[i];
		}
	}
}
