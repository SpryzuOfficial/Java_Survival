package Game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;

public class Player extends Entity
{
	private BufferedImage[] playerExtraLayers = new BufferedImage[] {Assets.player_water, Assets.player_leatherVest, Assets.player_leatherHat};
	private ArrayList<BufferedImage> playerExtraLayersW = new ArrayList<BufferedImage>();
	private double life = 100;
	private double food = 100;
	private double stamina = 100;
	
	private double lifePerF = 0.0;
	private double foodPerF = 0.001;
	private double staminaPerF = 0.0;
	
	public Player(int x, int y, int Vx, int Vy)
	{
		super(Assets.player, x, y, Vx, Vy, 64, 64, 4);
	}
	
	@Override
	public void tick()
	{
		if(Game.keyManager.shift)
		{
			if(stamina > -10)
			{
				virtualSpace.setSpeed(6);
			}
			else
			{
				virtualSpace.setSpeed(4);
			}
		}
		else
		{
			virtualSpace.setSpeed(4);
		}
		
		Vx = (((virtualSpace.getWidth() / 2) - (width / 2)) + virtualSpace.getX());
		Vy = (((virtualSpace.getHeight() / 2) - (height / 2)) + virtualSpace.getY());
		
		for(int i = 0; i < AnimalsManager.index.size(); i++)
		{
			if((this.getVx() + 20) + (this.getWidth() - 40) > Game.generateWorld.getAnimals().get(AnimalsManager.index.get(i)).getVx() && (this.getVx() + 20) < Game.generateWorld.getAnimals().get(AnimalsManager.index.get(i)).getVx() + Game.generateWorld.getAnimals().get(AnimalsManager.index.get(i)).getWidth()
			   && (this.getVy() + 32) + (this.getHeight() / 2) > Game.generateWorld.getAnimals().get(AnimalsManager.index.get(i)).getVy() && (this.getVy() + 32) < Game.generateWorld.getAnimals().get(AnimalsManager.index.get(i)).getVy() + Game.generateWorld.getAnimals().get(AnimalsManager.index.get(i)).getHeight())
			{
				Game.colliding = true;
			}
		}
		
		for(int i = 0; i < StaticEntitiesManager.index.size(); i++)
		{
			if((this.getVx() + 20) + (this.getWidth() - 40) > Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(i)).getVx() && (this.getVx() + 20) < Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(i)).getVx() + Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(i)).getWidth()
			   && (this.getVy() + 32) + ((this.getHeight() / 2) - 20) > Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(i)).getVy() && (this.getVy() + 32) < Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(i)).getVy() + Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(i)).getHeight())
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
		
		for(int i = 0; i < playerExtraLayersW.size(); i++)
		{
			g.drawImage(playerExtraLayersW.get(i), x, y, width, height, null);
		}
	}
	
	public BufferedImage[] getExtraLayers()
	{
		return playerExtraLayers;
	}
	
	public void addExtraLayer(int i)
	{
		if(playerExtraLayersW.contains(playerExtraLayers[i]))
		{
			return;
		}
		
		playerExtraLayersW.add(playerExtraLayers[i]);
	}
	
	public void removeExtraLayer(BufferedImage img)
	{
		playerExtraLayersW.remove(img);
	}

	public double getLife() 
	{
		return life;
	}

	public void setLife(double life) 
	{
		this.life = life;
	}

	public double getFood() 
	{
		return food;
	}

	public void setFood(double food) 
	{
		this.food = food;
	}

	public double getFoodPerF() 
	{
		return foodPerF;
	}

	public void setFoodPerF(double foodPerF) 
	{
		this.foodPerF = foodPerF;
	}

	public double getStamina()
	{
		return stamina;
	}

	public void setStamina(double stamina) 
	{
		this.stamina = stamina;
	}

	public double getStaminaPerF()
	{
		return staminaPerF;
	}

	public void setStaminaPerF(double staminaPerF) 
	{
		this.staminaPerF = staminaPerF;
	}

	public double getLifePerF() 
	{
		return lifePerF;
	}

	public void setLifePerF(double lifePerF)
	{
		this.lifePerF = lifePerF;
	}

	public ArrayList getPlayerExtraLayers() 
	{
		return playerExtraLayersW;
	}
}
