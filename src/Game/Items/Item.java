package Game.Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	}
	
	public Item clone() throws CloneNotSupportedException
    {
        return (Item) super.clone();
    }
	
	public void render(Graphics g)
	{
		
	}
	
	public void use()
	{
		
	}
	
	public boolean place()
	{
		return false;
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
}
