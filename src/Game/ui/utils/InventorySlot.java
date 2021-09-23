package Game.ui.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Items.Item;
import Game.engine.gfx.Assets;
import Game.ui.UiManager;

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
	
	public boolean mouseCollision(int mouseX, int mouseY, Graphics g)
	{
		if(mouseX >= x + 12 &&
		   mouseX <= x + 12 + width - 24 &&
		   mouseY >= y + 14 &&
		   mouseY <= y + 14 + height - 26)
		{
			if(item != null)
			{
				ArrayList<BufferedImage> string = UiManager.stringToImage(item.toString());
				
				for(int i = 0; i < string.size(); i++)
				{
					if(i == 0)
					{
						g.drawImage(Assets.nameFrameF, mouseX + 10, mouseY - 10, 15, 15, null);
					}
					else if(i == (string.size() - 2))
					{
						g.drawImage(Assets.nameFrameII, mouseX + 25 + ((string.size() - 3) * 7), mouseY - 10, 9, 15, null);
					}
					else if(i == (string.size() - 1))
					{
						g.drawImage(Assets.nameFrameE, mouseX + 25 + ((string.size() - 3) * 7) + 9, mouseY - 10, 15, 15, null);
					}
					else
					{
						g.drawImage(Assets.nameFrameI, mouseX + 18 + (i * 7), mouseY - 10, 7, 15, null);
					}
				}
				
				for(int i = 0; i < string.size(); i++)
				{
					if(string.get(i) == null)
					{
						continue;
					}
					else
					{
						g.drawImage(string.get(i), mouseX + ((i+1) * 7), mouseY - 18, 32, 32, null);
					}
				}
			}
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
