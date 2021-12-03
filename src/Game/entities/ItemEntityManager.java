package Game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Game.Items.Item;
import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;
import Game.ui.utils.InventorySlot;

public class ItemEntityManager 
{
	private static int id = -1;
	public static int scrollY = 0;
	private static ArrayList<ArrayList<Item>> sameItems = new ArrayList<ArrayList<Item>>();
	
	public ItemEntityManager() 
	{
		
	}
	
	public static void tick()
	{
		try
		{
			sameItems.clear();
			for(int i = 0; i < Game.generateWorld.getItems().size(); i++)
			{
				Item item = Game.generateWorld.getFromItem(i);
				
				if(sameItems.size() < 1)
				{
					ArrayList<Item> arr = new ArrayList<Item>();
					arr.add(item);
					sameItems.add(arr);
				}
				else
				{
					boolean isBreak = false;
					for(int j = 0; j < sameItems.size(); j++)
					{
						if(sameItems.get(j).get(0).getVx() == item.getVx() && sameItems.get(j).get(0).getVy() == item.getVy())
						{
							if(sameItems.get(j).size() < 4)
							{
								sameItems.get(j).add(item);
								isBreak = true;
								break;
							}
							else
							{
								Game.generateWorld.getFromItem(i).setVx(Game.generateWorld.getFromItem(i).getVx() + 64);
								isBreak = true;
								break;
							}
						}
					}
					
					if(!isBreak)
					{
						ArrayList<Item> arr = new ArrayList<Item>();
						arr.add(item);
						sameItems.add(arr);
					}
				}
				
				item.setX(item.getVx() - Game.virtualSpace.getX());
				item.setY(item.getVy() - Game.virtualSpace.getY());
				
				if(Game.player.getVx() + Game.player.getWidth() > item.getVx() &&
					Game.player.getVx() < item.getVx() + 64 &&
					Game.player.getVy() + Game.player.getHeight() > item.getVy() &&
					Game.player.getVy() < item.getVy() + 64)
				{
					Item dropItem = item.clone();
					dropItem.setX(0);
					dropItem.setY(576);
					
					if(UiInventoryManager.addItem(dropItem))
					{
						Game.generateWorld.getItems().remove(i);
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
	
	public static void render(Graphics g)
	{
		if(Game.generateWorld.getItems().size() < 1)
		{
			id = -1;
		}
		
		for(int i = 0; i < Game.generateWorld.getItems().size(); i++)
		{
			Item item = Game.generateWorld.getFromItem(i);
			
			item.render(g);
			
			if(UiManager.uiImage == null)
			{
				if(new InventorySlot(item.getX(), item.getY(), 64, 64, item, false).mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
				{
					id = i;
				}
				else if(id < 0)
				{
					scrollY = 0;
				}
				else if(i == id)
				{
					id = -1;
				}
			}
		}
		
		if(UiManager.uiImage == null)
		{
			if(id != -1)
			{
				Item item = Game.generateWorld.getFromItem(id);
				
				for(int j = 0; j < sameItems.size(); j++)
				{
					for(int k = 0; k < sameItems.get(j).size(); k++)
					{
						if(item.getClass() == sameItems.get(j).get(k).getClass() && sameItems.get(j).get(k).getVx() == item.getVx() && sameItems.get(j).get(k).getVy() == item.getVy())
						{
							g.setColor(Color.GRAY);
							g.fillRect(sameItems.get(j).get(k).getX() + 64, sameItems.get(j).get(k).getY(), 96, 96);
							for(int l = 0; l < sameItems.get(j).size(); l++)
							{
								int finalX = sameItems.get(j).get(l).getX() + 64;
								int finalY = sameItems.get(j).get(l).getY() + (l * 64) + scrollY * 2;
								
								if(sameItems.get(j).size() > 1)
								{
									if(scrollY > 0)
									{
										scrollY = 0;
									}
									
									if(scrollY < (sameItems.get(j).size() * sameItems.get(j).size() * -4) - (sameItems.get(j).size() * 4))
									{
										scrollY = (sameItems.get(j).size() * sameItems.get(j).size() * -4) - (sameItems.get(j).size() * 4);
									}
								}
								else
								{
									scrollY = 0;
								}
								
								if(finalY > sameItems.get(j).get(k).getY() - 64 && finalY < sameItems.get(j).get(k).getY() + 96)
								{
									g.drawImage(Assets.hotbar, finalX, finalY, 64, 64, null);
									UiInventoryManager.renderItem(g, sameItems.get(j).get(l), finalX, finalY);
								}
							}
							
							g.setColor(Color.BLACK);
							g.fillRect(sameItems.get(j).get(k).getX() + 64, sameItems.get(j).get(k).getY() - 64, 96, 64);
							g.fillRect(sameItems.get(j).get(k).getX() + 64, sameItems.get(j).get(k).getY() + 96, 96, 64);
							g.setColor(Color.DARK_GRAY);
							g.fillRect(sameItems.get(j).get(k).getX() + 144, sameItems.get(j).get(k).getY(), 16, 96);
							
							break;
						}
					}
				}
			}
		}
	}
}
