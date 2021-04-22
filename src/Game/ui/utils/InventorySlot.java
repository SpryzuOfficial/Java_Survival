package Game.ui.utils;

import Game.Items.Item;

public class InventorySlot 
{
	private Item item;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public InventorySlot(int x, int y, int width, int height, Item item)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.item = item;
	}
	
	public boolean mouseCollision(int mouseX, int mouseY)
	{
		if(mouseX >= x &&
		   mouseX <= x + width &&
		   mouseY >= y &&
		   mouseY <= y + height)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Item getItem()
	{
		return item;
	}

	public void setItem(Item item) 
	{
		this.item = item;
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
}
