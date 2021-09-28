package Game.Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.engine.Game;
import Game.entities.AnimalsManager;
import Game.entities.StaticEntitiesManager;

public class Item implements Cloneable
{
	protected BufferedImage texture;
	protected int count;
	protected int x;
	protected int y;
	protected int[] miningValue = new int[3]; // Tree, Stone, Animals
	protected boolean isStack;
	protected int topLife;
	protected int life;
	protected double ovenValue;
	protected Item nextItem;
	
	public Item(BufferedImage texture, int count, int x, int y, int miningValue1, int miningValue2, int miningValue3, boolean isStack, int topLife, double ovenValue)
	{
		this.texture = texture;
		this.count = count;
		this.x = x;
		this.y = y;
		this.miningValue[0] = miningValue1;
		this.miningValue[1] = miningValue2;
		this.miningValue[2] = miningValue3;
		this.isStack = isStack;
		this.topLife = topLife;
		this.life = 0;
		this.ovenValue = ovenValue;
		this.nextItem = null;
	}
	
	public Item(BufferedImage texture, int count, int x, int y, int miningValue1, int miningValue2, int miningValue3, boolean isStack, int topLife, double ovenValue, Item nextItem)
	{
		this.texture = texture;
		this.count = count;
		this.x = x;
		this.y = y;
		this.miningValue[0] = miningValue1;
		this.miningValue[1] = miningValue2;
		this.miningValue[2] = miningValue3;
		this.isStack = isStack;
		this.topLife = topLife;
		this.life = 0;
		this.ovenValue = ovenValue;
		this.nextItem = nextItem;
	}
	
	public Item clone() throws CloneNotSupportedException
    {
        return (Item) super.clone();
    }
	
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
	
	public boolean use()
	{
		return false;
	}
	
	public boolean place()
	{
		return false;
	}
	
	public void refreshEntities()
	{
		StaticEntitiesManager.index = new ArrayList<Integer>();
		for(int i = 0; i < Game.generateWorld.SESIZE; i++)
		{
			double c = Math.sqrt(Math.pow(Math.abs(Game.generateWorld.getSEntities().get(i).getVx() - Game.virtualSpace.getX()), 2) + Math.pow(Math.abs(Game.generateWorld.getSEntities().get(i).getVx() - Game.virtualSpace.getX()), 2));
			
			c /= 64;
			
			if(c < 32)
			{
				StaticEntitiesManager.index.add(i);
			}
		}
		
		StaticEntitiesManager.framesLastUpdate = 0;
	}
	
	public void refreshAnimals()
	{
		AnimalsManager.index = new ArrayList<Integer>();
		for(int i = 0; i < Game.generateWorld.ASIZE; i++)
		{
			double c = Math.sqrt(Math.pow(Math.abs(Game.generateWorld.getAnimals().get(i).getVx() - Game.virtualSpace.getX()), 2) + Math.pow(Math.abs(Game.generateWorld.getAnimals().get(i).getVx() - Game.virtualSpace.getX()), 2));
			
			c /= 64;
			
			if(c < 32)
			{
				AnimalsManager.index.add(i);
			}
		}
		
		AnimalsManager.framesLastUpdate = 0;
	}
	
	public int getCount() 
	{
		return count;
	}

	public void setCount(int count) 
	{
		this.count = count;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public BufferedImage getTexture() 
	{
		return texture;
	}

	public void setTexture(BufferedImage texture)
	{
		this.texture = texture;
	}

	public int getMiningValue(int i) 
	{
		return miningValue[i];
	}

	public void setMiningValue(int[] miningValue) 
	{
		this.miningValue = miningValue;
	}

	public boolean isStack() 
	{
		return isStack;
	}

	public void setStack(boolean isStack) 
	{
		this.isStack = isStack;
	}
	
	public int getTopLife() 
	{
		return topLife;
	}

	public void setTopLife(int topLife) 
	{
		this.topLife = topLife;
	}

	public int getLife() 
	{
		return life;
	}

	public void setLife(int life) 
	{
		this.life = life;
	}

	public double getOvenValue() 
	{
		return ovenValue;
	}

	public void setOvenValue(double ovenValue) 
	{
		this.ovenValue = ovenValue;
	}

	public Item getNextItem() 
	{
		return nextItem;
	}
	
	@Override
	public String toString()
	{
		return "";
	}
}
