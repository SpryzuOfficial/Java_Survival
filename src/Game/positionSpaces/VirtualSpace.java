package Game.positionSpaces;

import Game.engine.Game;
import Game.engine.input.*;

public class VirtualSpace 
{
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private int x;
	private int y;
	private int width;
	private int height;
	private int totalWidth;
	private int totalHeight;
	private int speed;
	
	public VirtualSpace(int x, int y, int width, int height, int totalWidth, int totalHeight, int speed, KeyManager keyManager, MouseManager mouseManager)
	{
		this.keyManager = keyManager;
		this.mouseManager = mouseManager;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.totalWidth = totalWidth;
		this.totalHeight = totalHeight;
		this.speed = speed;
	}
	
	public void tick()
	{
		if(!mouseManager.isLeftPressed())
		{
			if(keyManager.up)
			{
				y -= speed;
			}
			
			if(keyManager.down)
			{
				y += speed;
			}
			
			if(keyManager.right)
			{
				x += speed;
			}
			
			if(keyManager.left)
			{
				x -= speed;
			}
		}
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

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getTotalWidth() 
	{
		return totalWidth;
	}

	public void setTotalWidth(int totalWidth) 
	{
		this.totalWidth = totalWidth;
	}

	public int getTotalHeight()
	{
		return totalHeight;
	}

	public void setTotalHeight(int totalHeight) 
	{
		this.totalHeight = totalHeight;
	}

	public int getSpeed() 
	{
		return speed;
	}

	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
}
