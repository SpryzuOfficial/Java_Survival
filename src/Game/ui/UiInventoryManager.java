package Game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.Items.*;
import Game.engine.CheckCraftings;
import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.ui.utils.InventorySlot;

public class UiInventoryManager
{
	private static int ISIZE = 5;
	public static int hotbarSelected = 3;
	
	private static Item inventoryItemHolded;
	public static Item[] itemsHotbar;
	private static Item[][] itemsInventory;
	private static Item[][] itemsCrafting;
	private static Item itemCraftingTool;
	private static Item itemCraftingResult;
	private static Item inventoryTrashCan;
	public static Item inventoryTool;
	private static InventorySlot[] hInventorySlots;
	private static InventorySlot[][] iInventorySlots;
	private static InventorySlot[][] cInventorySlots;
	private static InventorySlot ctInventorySlot;
	private static InventorySlot crInventorySlot;
	private static InventorySlot tInventorySlot;
	public static InventorySlot toolInventorySlot;
	private static BufferedImage[] numHotBar;
	private static boolean uiLeftPressed;
	private static boolean uiRightPressed;
	private static CheckCraftings checkCraftings;
	
	private static boolean fPressed;
	private static boolean cPressed;
	
	public UiInventoryManager()
	{
		
	}
	
	public static void init()
	{
		itemsHotbar = new Item[ISIZE];
		itemsInventory = new Item[2][ISIZE];
		itemsCrafting = new Item[2][2];
		iInventorySlots = new InventorySlot[2][ISIZE];
		hInventorySlots = new InventorySlot[ISIZE];
		cInventorySlots = new InventorySlot[2][2];
		
		for(int i = 0; i < ISIZE; i++)
		{
			itemsHotbar[i] = null;
		}
		
		numHotBar = new BufferedImage[] {Assets.num0, Assets.num1, Assets.num2, Assets.num3, Assets.num4, Assets.num5, Assets.num6, Assets.num7, Assets.num8, Assets.num9};
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < ISIZE; j++)
			{
				iInventorySlots[i][j] = new InventorySlot((3 + j) * 64, (5 + i) * 64, 64, 64, itemsInventory[i][j]);
			}
		}
		
		for(int i = 0; i < ISIZE; i++)
		{
			hInventorySlots[i] = new InventorySlot((3 + i) * 64, 512, 64, 64, itemsHotbar[i]);
		}
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				cInventorySlots[i][j] = new InventorySlot((6 + j) * 64, (2 + i) * 64, 64, 64, itemsCrafting[i][j]);
			}
		}
		
		ctInventorySlot = new InventorySlot(576, 128, 64, 64, itemCraftingTool);
		
		crInventorySlot = new InventorySlot(576, 192, 64, 64, itemCraftingResult);
		
		checkCraftings = new CheckCraftings();
		
		tInventorySlot = new InventorySlot(576, 512, 64, 64, inventoryTrashCan);
		
		toolInventorySlot = new InventorySlot(64, 512, 64, 64, inventoryTool);
	}
	
	public static void tick()
	{
		if(Game.keyManager.f)
		{
			if(!fPressed)
			{
				if(inventoryTool == null && itemsHotbar[hotbarSelected - 3] != null && !itemsHotbar[hotbarSelected - 3].isStack())
				{
					inventoryTool = itemsHotbar[hotbarSelected - 3];
					inventoryTool.setX(64);
					inventoryTool.setY(576);
					toolInventorySlot.setItem(inventoryTool);
					
					itemsHotbar[hotbarSelected - 3] = null;
					hInventorySlots[hotbarSelected - 3].setItem(itemsHotbar[hotbarSelected - 3]);
					
					fPressed = true;
				}
				else if(inventoryTool != null && itemsHotbar[hotbarSelected - 3] == null)
				{
					Item tool = inventoryTool;
					
					inventoryTool = null;
					toolInventorySlot.setItem(inventoryTool);
					
					itemsHotbar[hotbarSelected - 3] = tool;
					itemsHotbar[hotbarSelected - 3].setX(hotbarSelected * 64);
					itemsHotbar[hotbarSelected - 3].setY(576);
					hInventorySlots[hotbarSelected - 3].setItem(itemsHotbar[hotbarSelected - 3]);
					
					fPressed = true;
				}
				else if(inventoryTool != null && itemsHotbar[hotbarSelected - 3] != null && !itemsHotbar[hotbarSelected - 3].isStack())
				{
					Item tool = inventoryTool;
					int t_x = inventoryTool.getX();
					int t_y = inventoryTool.getY();
					int h_x = itemsHotbar[hotbarSelected - 3].getX();
					int h_y = itemsHotbar[hotbarSelected - 3].getY();
					
					inventoryTool = itemsHotbar[hotbarSelected - 3];
					inventoryTool.setX(t_x);
					inventoryTool.setY(t_y);
					toolInventorySlot.setItem(inventoryTool);
					
					itemsHotbar[hotbarSelected - 3] = tool;
					itemsHotbar[hotbarSelected - 3].setX(h_x);
					itemsHotbar[hotbarSelected - 3].setY(h_y);
					hInventorySlots[hotbarSelected - 3].setItem(itemsHotbar[hotbarSelected - 3]);
					
					fPressed = true;
				}
			}
		}
		else if(fPressed)
		{
			fPressed = false;
		}
		
		if(Game.keyManager.c)
		{
			if(!cPressed)
			{
				addItem(new Sandpaper(0, 576));
				addItem(new Pickaxe(0, 576));
				addItem(new Axe(0, 576));
				addItem(new Knife(0, 576));
				addItem(new Hammer(0, 576));
				cPressed = true;
			}
		}
		else if(cPressed)
		{
			cPressed = false;
		}
		
		if(Game.keyManager.num1)
		{
			hotbarSelected = 3;
		}
		
		if(Game.keyManager.num2)
		{
			hotbarSelected = 4;
		}
		
		if(Game.keyManager.num3)
		{
			hotbarSelected = 5;
		}
		
		if(Game.keyManager.num4)
		{
			hotbarSelected = 6;
		}
		
		if(Game.keyManager.num5)
		{
			hotbarSelected = 7;
		}
	}
	
	public static void render(Graphics g)
	{
		for(int i = 3; i < 8; i++)
		{
			g.drawImage(Assets.hotbar, i * 64, 576, 64, 64, null);
		}
		
		g.drawImage(Assets.hotbar, 64, 576, 64, 64, null);
		
		g.drawImage(Assets.hotbarSelected, hotbarSelected * 64, 576, 64, 64, null);
		
		for(int i = 0; i < ISIZE; i++)
		{
			if(itemsHotbar[i] != null)
			{
				itemsHotbar[i].render(g);
				if(itemsHotbar[i].getTopLife() != -1 && itemsHotbar[i].getLife() != 0)
				{
					g.setColor(Color.BLACK);
					g.fillRect(itemsHotbar[i].getX() + 13, itemsHotbar[i].getY() + 45, 40, 5);
					g.drawRect(itemsHotbar[i].getX() + 12, itemsHotbar[i].getY() + 44, 41, 6);
					
					g.setColor(Color.GREEN);
					g.fillRect(itemsHotbar[i].getX() + 13, itemsHotbar[i].getY() + 45, (int) ((1-(((itemsHotbar[i].getLife() * 100) / itemsHotbar[i].getTopLife())/100f)) * 40), 5);
				}
			}
		}
		
		if(inventoryTool != null)
		{
			inventoryTool.render(g);
			if(inventoryTool.getTopLife() != -1 && inventoryTool.getLife() != 0)
			{
				g.setColor(Color.BLACK);
				g.fillRect(inventoryTool.getX() + 13, inventoryTool.getY() + 45, 40, 5);
				g.drawRect(inventoryTool.getX() + 12, inventoryTool.getY() + 44, 41, 6);
				
				g.setColor(Color.GREEN);
				g.fillRect(inventoryTool.getX() + 13, inventoryTool.getY() + 45, (int) ((1-(((inventoryTool.getLife() * 100) / inventoryTool.getTopLife())/100f)) * 40), 5);
			}
		}
		
		for(int i = 0; i < ISIZE; i++)
		{
			if(itemsHotbar[i] != null)
			{
				if(itemsHotbar[i].getCount() < 10)
				{
					if(numHotBar[itemsHotbar[i].getCount()] != null)
					{
						if(itemsHotbar[i].getCount() != 1)
						{
							g.drawImage(numHotBar[itemsHotbar[i].getCount()], ((i + 3) * 64) + 32, 608, 32, 32, null);	
						}
					}
				}
				else
				{
					g.drawImage(numHotBar[1], ((i + 3) * 64) + 22, 608, 32, 32, null);
					g.drawImage(numHotBar[itemsHotbar[i].getCount() - 10], ((i + 3) * 64) + 32, 608, 32, 32, null);
				}
			}
		}
		
		if(inventoryTool != null)
		{
			if(inventoryTool.getCount() < 10)
			{
				if(numHotBar[inventoryTool.getCount()] != null)
				{
					if(inventoryTool.getCount() != 1)
					{
						g.drawImage(numHotBar[inventoryTool.getCount()], 64 + 32, 608, 32, 32, null);	
					}
				}
			}
			else
			{
				g.drawImage(numHotBar[1], 64 + 22, 608, 32, 32, null);
				g.drawImage(numHotBar[inventoryTool.getCount() - 10], 64 + 32, 608, 32, 32, null);
			}
		}
		
		if(UiManager.uiImage == Assets.inventory)
		{
			g.drawImage(UiManager.uiImage, 0, 64, 704, 576, null);
			g.drawImage(Assets.player, 160, 160, 64, 64, null);
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					g.drawImage(itemsHotbar[i].getTexture(), itemsHotbar[i].getX(), 512, 64, 64, null);
					if(itemsHotbar[i].getTopLife() != -1 && itemsHotbar[i].getLife() != 0)
					{
						g.setColor(Color.BLACK);
						g.fillRect(itemsHotbar[i].getX() + 13, 512 + 45, 40, 5);
						g.drawRect(itemsHotbar[i].getX() + 12, 512 + 44, 41, 6);
						
						g.setColor(Color.GREEN);
						g.fillRect(itemsHotbar[i].getX() + 13, 512 + 45, (int) ((1-(((itemsHotbar[i].getLife() * 100) / itemsHotbar[i].getTopLife())/100f)) * 40), 5);
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						g.drawImage(itemsInventory[i][j].getTexture(), iInventorySlots[i][j].getX(), iInventorySlots[i][j].getY(), 64, 64, null);
						if(itemsInventory[i][j].getTopLife() != -1 && itemsInventory[i][j].getLife() != 0)
						{
							g.setColor(Color.BLACK);
							g.fillRect(itemsInventory[i][j].getX() + 13, iInventorySlots[i][j].getY() + 45, 40, 5);
							g.drawRect(itemsInventory[i][j].getX() + 12, iInventorySlots[i][j].getY() + 44, 41, 6);
							
							g.setColor(Color.GREEN);
							g.fillRect(itemsInventory[i][j].getX() + 13, iInventorySlots[i][j].getY() + 45, (int) ((1-(((itemsInventory[i][j].getLife() * 100) / itemsInventory[i][j].getTopLife())/100f)) * 40), 5);
						}
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					if(itemsCrafting[i][j] != null)
					{
						g.drawImage(itemsCrafting[i][j].getTexture(), cInventorySlots[i][j].getX(), cInventorySlots[i][j].getY(), 64, 64, null);
						if(itemsCrafting[i][j].getTopLife() != -1 && itemsCrafting[i][j].getLife() != 0)
						{
							g.setColor(Color.BLACK);
							g.fillRect(itemsCrafting[i][j].getX() + 13, cInventorySlots[i][j].getY() + 45, 40, 5);
							g.drawRect(itemsCrafting[i][j].getX() + 12, cInventorySlots[i][j].getY() + 44, 41, 6);
							
							g.setColor(Color.GREEN);
							g.fillRect(itemsCrafting[i][j].getX() + 13, cInventorySlots[i][j].getY() + 45, (int) ((1-(((itemsCrafting[i][j].getLife() * 100) / itemsCrafting[i][j].getTopLife())/100f)) * 40), 5);
						}
					}
				}
			}
			
			if(itemCraftingTool != null)
			{
				g.drawImage(itemCraftingTool.getTexture(), ctInventorySlot.getX(), ctInventorySlot.getY(), 64, 64, null);
				if(itemCraftingTool.getTopLife() != -1 && itemCraftingTool.getLife() != 0)
				{
					g.setColor(Color.BLACK);
					g.fillRect(itemCraftingTool.getX() + 13, ctInventorySlot.getY() + 45, 40, 5);
					g.drawRect(itemCraftingTool.getX() + 12, ctInventorySlot.getY() + 44, 41, 6);
					
					g.setColor(Color.GREEN);
					g.fillRect(itemCraftingTool.getX() + 13, ctInventorySlot.getY() + 45, (int) ((1-(((itemCraftingTool.getLife() * 100) / itemCraftingTool.getTopLife())/100f)) * 40), 5);
				}
			}
			
			if(itemCraftingResult != null)
			{
				g.drawImage(itemCraftingResult.getTexture(), crInventorySlot.getX(), crInventorySlot.getY(), 64, 64, null);
			}
			
			if(inventoryTrashCan != null)
			{
				g.drawImage(inventoryTrashCan.getTexture(), tInventorySlot.getX(), tInventorySlot.getY(), 64, 64, null);
				if(inventoryTrashCan.getTopLife() != -1 && inventoryTrashCan.getLife() != 0)
				{
					g.setColor(Color.BLACK);
					g.fillRect(inventoryTrashCan.getX() + 13, tInventorySlot.getY() + 45, 40, 5);
					g.drawRect(inventoryTrashCan.getX() + 12, tInventorySlot.getY() + 44, 41, 6);
					
					g.setColor(Color.GREEN);
					g.fillRect(inventoryTrashCan.getX() + 13, tInventorySlot.getY() + 45, (int) ((1-(((inventoryTrashCan.getLife() * 100) / inventoryTrashCan.getTopLife())/100f)) * 40), 5);
				}
			}
			
			if(inventoryTool != null)
			{
				g.drawImage(inventoryTool.getTexture(), toolInventorySlot.getX(), toolInventorySlot.getY(), 64, 64, null);
				if(inventoryTool.getTopLife() != -1 && inventoryTool.getLife() != 0)
				{
					g.setColor(Color.BLACK);
					g.fillRect(inventoryTool.getX() + 13, toolInventorySlot.getY() + 45, 40, 5);
					g.drawRect(inventoryTool.getX() + 12, toolInventorySlot.getY() + 44, 41, 6);
					
					g.setColor(Color.GREEN);
					g.fillRect(inventoryTool.getX() + 13, toolInventorySlot.getY() + 45, (int) ((1-(((inventoryTool.getLife() * 100) / inventoryTool.getTopLife())/100f)) * 40), 5);
				}
			}
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					if(itemsHotbar[i].getCount() < 10)
					{
						if(numHotBar[itemsHotbar[i].getCount()] != null)
						{
							if(itemsHotbar[i].getCount() != 1)
							{
								g.drawImage(numHotBar[itemsHotbar[i].getCount()], ((i + 3) * 64) + 32, 544, 32, 32, null);	
							}
						}
					}
					else
					{
						g.drawImage(numHotBar[1], ((i + 3) * 64) + 22, 544, 32, 32, null);
						g.drawImage(numHotBar[itemsHotbar[i].getCount() - 10], ((i + 3) * 64) + 32, 544, 32, 32, null);
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						if(itemsInventory[i][j].getCount() < 10)
						{
							if(numHotBar[itemsInventory[i][j].getCount()] != null)
							{
								if(itemsInventory[i][j].getCount() != 1)
								{
									g.drawImage(numHotBar[itemsInventory[i][j].getCount()], ((j + 3) * 64) + 32, ((i + 5) * 64) + 32, 32, 32, null);	
								}
							}
						}
						else
						{
							g.drawImage(numHotBar[1], ((j + 3) * 64) + 22, ((i + 5) * 64) + 32, 32, 32, null);
							g.drawImage(numHotBar[itemsInventory[i][j].getCount() - 10], ((j + 3) * 64) + 32, ((i + 5) * 64) + 32, 32, 32, null);
						}
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					if(itemsCrafting[i][j] != null)
					{
						if(itemsCrafting[i][j].getCount() < 10)
						{
							if(numHotBar[itemsCrafting[i][j].getCount()] != null)
							{	
								if(itemsCrafting[i][j].getCount() != 1)
								{
									g.drawImage(numHotBar[itemsCrafting[i][j].getCount()], ((j + 6) * 64) + 32, ((i + 2) * 64) + 32, 32, 32, null);	
								}
							}
						}
						else
						{
							g.drawImage(numHotBar[1], ((j + 6) * 64) + 22, ((i + 2) * 64) + 32, 32, 32, null);
							g.drawImage(numHotBar[itemsCrafting[i][j].getCount() - 10], ((j + 6) * 64) + 32, ((i + 2) * 64) + 32, 32, 32, null);
						}
					}
				}
			}
			
			if(itemCraftingTool != null)
			{
				if(itemCraftingTool.getCount() < 10)
				{
					if(numHotBar[itemCraftingTool.getCount()] != null)
					{
						if(itemCraftingTool.getCount() != 1)
						{
							g.drawImage(numHotBar[itemCraftingTool.getCount()], 576 + 32, 128 + 32, 32, 32, null);
						}
					}
				}
				else
				{
					g.drawImage(numHotBar[1], 576 + 22, 128 + 32, 32, 32, null);
					g.drawImage(numHotBar[itemCraftingTool.getCount() - 10], 576 + 32, 128 + 32, 32, 32, null);
				}
			}
			
			if(itemCraftingResult != null)
			{
				if(itemCraftingResult.getCount() < 10)
				{
					if(numHotBar[itemCraftingResult.getCount()] != null)
					{
						if(itemCraftingResult.getCount() != 1)
						{
							g.drawImage(numHotBar[itemCraftingResult.getCount()], 576 + 32, 192 + 32, 32, 32, null);	
						}
					}
				}
				else
				{
					g.drawImage(numHotBar[1], 576 + 22, 192 + 32, 32, 32, null);
					g.drawImage(numHotBar[itemCraftingResult.getCount() - 10], 576 + 32, 192 + 32, 32, 32, null);
				}
			}
			
			if(inventoryTrashCan != null)
			{
				if(inventoryTrashCan.getCount() < 10)
				{
					if(numHotBar[inventoryTrashCan.getCount()] != null)
					{
						if(inventoryTrashCan.getCount() != 1)
						{
							g.drawImage(numHotBar[inventoryTrashCan.getCount()], 576 + 32, 544, 32, 32, null);
						}
					}
				}
				else
				{
					g.drawImage(numHotBar[1], 576 + 22, 544, 32, 32, null);
					g.drawImage(numHotBar[inventoryTrashCan.getCount() - 10], 576 + 32, 544, 32, 32, null);
				}
			}
			
			if(inventoryTool != null)
			{
				if(inventoryTool.getCount() < 10)
				{
					if(numHotBar[inventoryTool.getCount()] != null)
					{
						if(inventoryTool.getCount() != 1)
						{
							g.drawImage(numHotBar[inventoryTool.getCount()], 64 + 32, 544, 32, 32, null);	
						}
					}
				}
				else
				{
					g.drawImage(numHotBar[1], 64 + 22, 544, 32, 32, null);
					g.drawImage(numHotBar[inventoryTool.getCount() - 10], 64 + 32, 544, 32, 32, null);
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(inventoryItemHolded != null)
					{
						inventoryItemHolded.setX(iInventorySlots[i][j].getX());
					}
					
					if(!uiLeftPressed && !uiRightPressed)
					{
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isLeftPressed())
						{	
							try
							{
								if(itemsInventory[i][j].getClass() == inventoryItemHolded.getClass())
								{
									if(itemsInventory[i][j].getCount() < 12 && itemsInventory[i][j].isStack())
									{
										if(itemsInventory[i][j].getCount() + inventoryItemHolded.getCount() <= 12)
										{
											itemsInventory[i][j].setCount(itemsInventory[i][j].getCount() + inventoryItemHolded.getCount());
											inventoryItemHolded = null;
											iInventorySlots[i][j].setItem(itemsInventory[i][j]);
											uiLeftPressed = true;
										}
										else
										{
											int x;
											int xTop = 12 - itemsInventory[i][j].getCount();
											
											for(x = 0; x < xTop; x++)
											{
												itemsInventory[i][j].setCount(itemsInventory[i][j].getCount() + 1);
											}
											
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
											iInventorySlots[i][j].setItem(itemsInventory[i][j]);
											uiLeftPressed = true;
										}
									}
									else
									{
										throw new Exception();
									}
								}
								else
								{
									throw new Exception();
								}
							}
							catch(Exception e)
							{ 
								itemsInventory[i][j] = inventoryItemHolded;
								inventoryItemHolded = iInventorySlots[i][j].getItem();
								iInventorySlots[i][j].setItem(itemsInventory[i][j]); 
								uiLeftPressed = true;
							}
						}
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isRightPressed())
						{
							try
							{
								if(inventoryItemHolded == null)
								{
									inventoryItemHolded = iInventorySlots[i][j].getItem().clone();
									inventoryItemHolded.setCount((itemsInventory[i][j].getCount() / 2) + (itemsInventory[i][j].getCount() % 2));
									itemsInventory[i][j].setCount((itemsInventory[i][j].getCount() / 2));
									
									if(itemsInventory[i][j].getCount() == 0)
									{
										itemsInventory[i][j] = null;
									}
									
									iInventorySlots[i][j].setItem(itemsInventory[i][j]); 
									uiRightPressed = true;
								}
								else if(itemsInventory[i][j].getClass() == inventoryItemHolded.getClass() && itemsInventory[i][j].isStack())
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsInventory[i][j].setCount(itemsInventory[i][j].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										iInventorySlots[i][j].setItem(itemsInventory[i][j]); 
										uiRightPressed = true;
									}
									else
									{
										itemsInventory[i][j].setCount(itemsInventory[i][j].getCount() + 1);
										inventoryItemHolded = null;
										iInventorySlots[i][j].setItem(itemsInventory[i][j]); 
										uiRightPressed = true;
									}
								}
							}	
							catch(Exception e)
							{ 
								try
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsInventory[i][j] = inventoryItemHolded.clone();
										itemsInventory[i][j].setCount(0);
										itemsInventory[i][j].setCount(itemsInventory[i][j].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										iInventorySlots[i][j].setItem(itemsInventory[i][j]); 
										uiRightPressed = true;
									}
									else
									{
										itemsInventory[i][j] = inventoryItemHolded.clone();
										inventoryItemHolded = null;
										iInventorySlots[i][j].setItem(itemsInventory[i][j]); 
										uiRightPressed = true;
									}
								}
								catch(Exception ex)
								{ }
							}
						}
					}
					else
					{
						if(!Game.mouseManager.isLeftPressed())
						{
							uiLeftPressed = false;
						}
						
						if(!Game.mouseManager.isRightPressed())
						{
							uiRightPressed = false;
						}
					}
				}
			}
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(inventoryItemHolded != null)
				{
					inventoryItemHolded.setX(hInventorySlots[i].getX());
				}
				
				if(!uiLeftPressed && !uiRightPressed)
				{
					if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()))
					{	
						if(Game.mouseManager.isLeftPressed())
						{
							try
							{
								if(itemsHotbar[i].getClass() == inventoryItemHolded.getClass())
								{
									if(itemsHotbar[i].getCount() < 12 && itemsHotbar[i].isStack())
									{
										if(itemsHotbar[i].getCount() + inventoryItemHolded.getCount() <= 12)
										{
											itemsHotbar[i].setCount(itemsHotbar[i].getCount() + inventoryItemHolded.getCount());
											inventoryItemHolded = null;
											hInventorySlots[i].setItem(itemsHotbar[i]);
											uiLeftPressed = true;
										}
										else
										{
											int x;
											int xTop = 12 - itemsHotbar[i].getCount();
											
											for(x = 0; x < xTop; x++)
											{
												itemsHotbar[i].setCount(itemsHotbar[i].getCount() + 1);
											}
											
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
											hInventorySlots[i].setItem(itemsHotbar[i]);
											uiLeftPressed = true;
										}
									}
									else
									{
										throw new Exception();
									}
								}
								else
								{
									throw new Exception();
								}
							}
							catch(Exception e)
							{ 
								itemsHotbar[i] = inventoryItemHolded;
								inventoryItemHolded = hInventorySlots[i].getItem();
								hInventorySlots[i].setItem(itemsHotbar[i]); 
								uiLeftPressed = true;
							}
						}
						else if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isRightPressed())
						{
							try
							{
								if(inventoryItemHolded == null)
								{
									inventoryItemHolded = hInventorySlots[i].getItem().clone();
									inventoryItemHolded.setCount((itemsHotbar[i].getCount() / 2) + (itemsHotbar[i].getCount() % 2));
									itemsHotbar[i].setCount((itemsHotbar[i].getCount() / 2));
									
									if(itemsHotbar[i].getCount() == 0)
									{
										itemsHotbar[i] = null;
									}
									
									hInventorySlots[i].setItem(itemsHotbar[i]); 
									uiRightPressed = true;
								}
								else if(itemsHotbar[i].getClass() == inventoryItemHolded.getClass() && itemsHotbar[i].isStack())
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsHotbar[i].setCount(itemsHotbar[i].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										hInventorySlots[i].setItem(itemsHotbar[i]); 
										uiRightPressed = true;
									}
									else
									{
										itemsHotbar[i].setCount(itemsHotbar[i].getCount() + 1);
										inventoryItemHolded = null;
										hInventorySlots[i].setItem(itemsHotbar[i]); 
										uiRightPressed = true;
									}
								}
							}	
							catch(Exception e)
							{ 
								try
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsHotbar[i] = inventoryItemHolded.clone();
										itemsHotbar[i].setCount(0);
										itemsHotbar[i].setCount(itemsHotbar[i].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										hInventorySlots[i].setItem(itemsHotbar[i]); 
										uiRightPressed = true;
									}
									else
									{
										itemsHotbar[i] = inventoryItemHolded.clone();
										inventoryItemHolded = null;
										hInventorySlots[i].setItem(itemsHotbar[i]); 
										uiRightPressed = true;
									}
								}
								catch(Exception ex)
								{ }
							}
						}
					}
				}
				else
				{
					if(!Game.mouseManager.isLeftPressed())
					{
						uiLeftPressed = false;
					}
					
					if(!Game.mouseManager.isRightPressed())
					{
						uiRightPressed = false;
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					if(inventoryItemHolded != null)
					{
						inventoryItemHolded.setX(cInventorySlots[i][j].getX());
					}
					
					if(!uiLeftPressed && !uiRightPressed)
					{
						if(cInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isLeftPressed())
						{	
							try
							{
								if(itemsCrafting[i][j].getClass() == inventoryItemHolded.getClass() && itemsCrafting[i][j].isStack())
								{
									if(itemsCrafting[i][j].getCount() < 12)
									{
										if(itemsCrafting[i][j].getCount() + inventoryItemHolded.getCount() <= 12)
										{
											itemsCrafting[i][j].setCount(itemsCrafting[i][j].getCount() + inventoryItemHolded.getCount());
											inventoryItemHolded = null;
											cInventorySlots[i][j].setItem(itemsCrafting[i][j]);
											uiLeftPressed = true;
										}
										else
										{
											int x;
											int xTop = 12 - itemsCrafting[i][j].getCount();
											
											for(x = 0; x < xTop; x++)
											{
												itemsCrafting[i][j].setCount(itemsCrafting[i][j].getCount() + 1);
											}
											
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
											cInventorySlots[i][j].setItem(itemsCrafting[i][j]);
											uiLeftPressed = true;
										}
									}
									else
									{
										throw new Exception();
									}
								}
								else
								{
									throw new Exception();
								}
							}
							catch(Exception e)
							{ 
								itemsCrafting[i][j] = inventoryItemHolded;
								inventoryItemHolded = cInventorySlots[i][j].getItem();
								cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
								uiLeftPressed = true;
							}
						}
						else if(cInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isRightPressed())
						{
							try
							{
								if(inventoryItemHolded == null)
								{
									inventoryItemHolded = cInventorySlots[i][j].getItem().clone();
									inventoryItemHolded.setCount((itemsCrafting[i][j].getCount() / 2) + (itemsCrafting[i][j].getCount() % 2));
									itemsCrafting[i][j].setCount((itemsCrafting[i][j].getCount() / 2));
									
									if(itemsCrafting[i][j].getCount() == 0)
									{
										itemsCrafting[i][j] = null;
									}
									
									cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
									uiRightPressed = true;
								}
								else if(itemsCrafting[i][j].getClass() == inventoryItemHolded.getClass() && itemsCrafting[i][j].isStack())
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsCrafting[i][j].setCount(itemsCrafting[i][j].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
										uiRightPressed = true;
									}
									else
									{
										itemsCrafting[i][j].setCount(itemsCrafting[i][j].getCount() + 1);
										inventoryItemHolded = null;
										cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
										uiRightPressed = true;
									}
								}
							}	
							catch(Exception e)
							{ 
								try
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsCrafting[i][j] = inventoryItemHolded.clone();
										itemsCrafting[i][j].setCount(0);
										itemsCrafting[i][j].setCount(itemsCrafting[i][j].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
										uiRightPressed = true;
									}
									else
									{
										itemsCrafting[i][j] = inventoryItemHolded.clone();
										inventoryItemHolded = null;
										cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
										uiRightPressed = true;
									}
								}
								catch(Exception ex)
								{ }
							}
						}
					}
					else
					{
						if(!Game.mouseManager.isLeftPressed())
						{
							uiLeftPressed = false;
						}
						
						if(!Game.mouseManager.isRightPressed())
						{
							uiRightPressed = false;
						}
					}
				}
			}
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(crInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(crInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()))
				{	
					if(Game.mouseManager.isLeftPressed())
					{
						try
						{
							if(inventoryItemHolded != null)
							{
								if(itemCraftingResult != null)
								{
									if(itemCraftingResult.getClass() == inventoryItemHolded.getClass() && itemCraftingResult.isStack())
									{
										if((inventoryItemHolded.getCount() + itemCraftingResult.getCount()) <= 12)
										{
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() + itemCraftingResult.getCount());
											
											for(int y = 0; y < 2; y++)
											{
												for(int x = 0; x < 2; x++)
												{
													if(itemsCrafting[y][x] != null)
													{
														itemsCrafting[y][x].setCount(itemsCrafting[y][x].getCount() - 1);
														
														if(itemsCrafting[y][x].getCount() == 0)
														{
															itemsCrafting[y][x] = null;
														}
													}
													
													cInventorySlots[y][x].setItem(itemsCrafting[y][x]);
												}
											}
											
											if(itemCraftingTool != null)
											{
												if((itemCraftingTool.getCount() - 1) == 0)
												{
													itemCraftingTool.setLife(itemCraftingTool.getLife() + 1);
													if(itemCraftingTool.getLife() == itemCraftingTool.getTopLife())
													{
														itemCraftingTool = null;
													}
												}
												else
												{
													itemCraftingTool.setCount(itemCraftingTool.getCount() - 1);
												}
											}
											
											ctInventorySlot.setItem(itemCraftingTool);
											
											crInventorySlot.setItem(itemCraftingResult);
											uiLeftPressed = true;
										}
									}
								}
							}
							else
							{
								throw new Exception();
							}
						}
						catch(Exception e)
						{ 
							
							try
							{
								if(inventoryItemHolded == null && itemCraftingResult != null)
								{
									inventoryItemHolded = crInventorySlot.getItem().clone();
									
									for(int y = 0; y < 2; y++)
									{
										for(int x = 0; x < 2; x++)
										{
											if(itemsCrafting[y][x] != null)
											{
												itemsCrafting[y][x].setCount(itemsCrafting[y][x].getCount() - 1);
												
												if(itemsCrafting[y][x].getCount() == 0)
												{
													itemsCrafting[y][x] = null;
												}
											}
											
											cInventorySlots[y][x].setItem(itemsCrafting[y][x]);
										}
									}
									
									if(itemCraftingTool != null)
									{
										if((itemCraftingTool.getCount() - 1) == 0)
										{
											itemCraftingTool.setLife(itemCraftingTool.getLife() + 1);
											if(itemCraftingTool.getLife() == itemCraftingTool.getTopLife())
											{
												itemCraftingTool = null;
											}
										}
										else
										{
											itemCraftingTool.setCount(itemCraftingTool.getCount() - 1);
										}
									}
									
									ctInventorySlot.setItem(itemCraftingTool);
									
									crInventorySlot.setItem(itemCraftingResult); 
									uiLeftPressed = true;
								}
							}
							catch(CloneNotSupportedException ex)
							{ System.err.println(ex); }
						}
					}
				}
			}
			else
			{
				if(!Game.mouseManager.isLeftPressed())
				{
					uiLeftPressed = false;
				}
				
				if(!Game.mouseManager.isRightPressed())
				{
					uiRightPressed = false;
				}
			}
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(ctInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(ctInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isLeftPressed())
				{	
					try
					{
						if(itemCraftingTool.getClass() == inventoryItemHolded.getClass() && itemCraftingTool.isStack())
						{
							if(itemCraftingTool.getCount() < 12)
							{
								if(itemCraftingTool.getCount() + inventoryItemHolded.getCount() <= 12)
								{
									itemCraftingTool.setCount(itemCraftingTool.getCount() + inventoryItemHolded.getCount());
									inventoryItemHolded = null;
									ctInventorySlot.setItem(itemCraftingTool);
									uiLeftPressed = true;
								}
								else
								{
									int x;
									int xTop = 12 - itemCraftingTool.getCount();
									
									for(x = 0; x < xTop; x++)
									{
										itemCraftingTool.setCount(itemCraftingTool.getCount() + 1);
									}
									
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
									ctInventorySlot.setItem(itemCraftingTool);
									uiLeftPressed = true;
								}
							}
							else
							{
								throw new Exception();
							}
						}
						else
						{
							throw new Exception();
						}
					}
					catch(Exception e)
					{ 
						itemCraftingTool = inventoryItemHolded;
						inventoryItemHolded = ctInventorySlot.getItem();
						ctInventorySlot.setItem(itemCraftingTool); 
						uiLeftPressed = true;
					}
				}
				else if(ctInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isRightPressed())
				{
					try
					{
						if(inventoryItemHolded == null)
						{
							inventoryItemHolded = ctInventorySlot.getItem().clone();
							inventoryItemHolded.setCount((itemCraftingTool.getCount() / 2) + (itemCraftingTool.getCount() % 2));
							itemCraftingTool.setCount((itemCraftingTool.getCount() / 2));
							
							if(itemCraftingTool.getCount() == 0)
							{
								itemCraftingTool = null;
							}
							
							ctInventorySlot.setItem(itemCraftingTool); 
							uiRightPressed = true;
						}
						else if(itemCraftingTool.getClass() == inventoryItemHolded.getClass() && itemCraftingTool.isStack())
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemCraftingTool.setCount(itemCraftingTool.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								ctInventorySlot.setItem(itemCraftingTool); 
								uiRightPressed = true;
							}
							else
							{
								itemCraftingTool.setCount(itemCraftingTool.getCount() + 1);
								inventoryItemHolded = null;
								ctInventorySlot.setItem(itemCraftingTool); 
								uiRightPressed = true;
							}
						}
					}	
					catch(Exception e)
					{ 
						try
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemCraftingTool = inventoryItemHolded.clone();
								itemCraftingTool.setCount(0);
								itemCraftingTool.setCount(itemCraftingTool.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								ctInventorySlot.setItem(itemCraftingTool); 
								uiRightPressed = true;
							}
							else
							{
								itemCraftingTool = inventoryItemHolded.clone();
								inventoryItemHolded = null;
								ctInventorySlot.setItem(itemCraftingTool); 
								uiRightPressed = true;
							}
						}
						catch(Exception ex)
						{ }
					}
				}
			}
			else
			{
				if(!Game.mouseManager.isLeftPressed())
				{
					uiLeftPressed = false;
				}
				
				if(!Game.mouseManager.isRightPressed())
				{
					uiRightPressed = false;
				}
			}
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(tInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(tInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()))
				{	
					if(Game.mouseManager.isLeftPressed())
					{
						try
						{
							if(inventoryTrashCan.getClass() == inventoryItemHolded.getClass() && inventoryTrashCan.isStack())
							{
								if(inventoryTrashCan.getCount() < 12)
								{
									if(inventoryTrashCan.getCount() + inventoryItemHolded.getCount() <= 12)
									{
										inventoryTrashCan.setCount(inventoryTrashCan.getCount() + inventoryItemHolded.getCount());
										inventoryItemHolded = null;
										tInventorySlot.setItem(inventoryTrashCan);
										uiLeftPressed = true;
									}
									else
									{
										int x;
										int xTop = 12 - inventoryTrashCan.getCount();
										
										for(x = 0; x < xTop; x++)
										{
											inventoryTrashCan.setCount(inventoryTrashCan.getCount() + 1);
										}
										
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
										tInventorySlot.setItem(inventoryTrashCan);
										uiLeftPressed = true;
									}
								}
								else
								{
									throw new Exception();
								}
							}
							else
							{
								throw new Exception();
							}
						}
						catch(Exception e)
						{ 
							inventoryTrashCan = inventoryItemHolded;
							inventoryItemHolded = tInventorySlot.getItem();
							tInventorySlot.setItem(inventoryTrashCan); 
							uiLeftPressed = true;
						}
					}
					else if(tInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isRightPressed())
					{
						try
						{
							if(inventoryItemHolded == null)
							{
								inventoryItemHolded = tInventorySlot.getItem().clone();
								inventoryItemHolded.setCount((inventoryTrashCan.getCount() / 2) + (inventoryTrashCan.getCount() % 2));
								inventoryTrashCan.setCount((inventoryTrashCan.getCount() / 2));
								
								if(inventoryTrashCan.getCount() == 0)
								{
									inventoryTrashCan = null;
								}
								
								tInventorySlot.setItem(inventoryTrashCan); 
								uiRightPressed = true;
							}
							else if(inventoryTrashCan.getClass() == inventoryItemHolded.getClass() && inventoryTrashCan.isStack())
							{
								if((inventoryItemHolded.getCount() - 1) > 0)
								{
									inventoryTrashCan.setCount(inventoryTrashCan.getCount() + 1);
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
									tInventorySlot.setItem(inventoryTrashCan); 
									uiRightPressed = true;
								}
								else
								{
									inventoryTrashCan.setCount(inventoryTrashCan.getCount() + 1);
									inventoryItemHolded = null;
									tInventorySlot.setItem(inventoryTrashCan); 
									uiRightPressed = true;
								}
							}
						}	
						catch(Exception e)
						{ 
							try
							{
								if((inventoryItemHolded.getCount() - 1) > 0)
								{
									inventoryTrashCan = inventoryItemHolded.clone();
									inventoryTrashCan.setCount(0);
									inventoryTrashCan.setCount(inventoryTrashCan.getCount() + 1);
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
									tInventorySlot.setItem(inventoryTrashCan); 
									uiRightPressed = true;
								}
								else
								{
									inventoryTrashCan = inventoryItemHolded.clone();
									inventoryItemHolded = null;
									tInventorySlot.setItem(inventoryTrashCan); 
									uiRightPressed = true;
								}
							}
							catch(Exception ex)
							{ }
						}
					}
				}
			}
			else
			{
				if(!Game.mouseManager.isLeftPressed())
				{
					uiLeftPressed = false;
				}
				
				if(!Game.mouseManager.isRightPressed())
				{
					uiRightPressed = false;
				}
			}
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(toolInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()))
				{	
					try
					{
						if(!inventoryItemHolded.isStack())
						{
							if(Game.mouseManager.isLeftPressed())
							{
								inventoryTool = inventoryItemHolded;
								inventoryItemHolded = toolInventorySlot.getItem();
								toolInventorySlot.setItem(inventoryTool); 
								uiLeftPressed = true;
							}
							else if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY()) && Game.mouseManager.isRightPressed())
							{
								inventoryTool = inventoryItemHolded;
								inventoryItemHolded = toolInventorySlot.getItem();
								toolInventorySlot.setItem(inventoryTool); 
								uiLeftPressed = true;
							}
						}
					}
					catch(Exception e)
					{ 
						if(Game.mouseManager.isLeftPressed())
						{
							inventoryTool = inventoryItemHolded;
							inventoryItemHolded = toolInventorySlot.getItem();
							toolInventorySlot.setItem(inventoryTool); 
							uiLeftPressed = true;
						}
					}
				}
			}
			else
			{
				if(!Game.mouseManager.isLeftPressed())
				{
					uiLeftPressed = false;
				}
				
				if(!Game.mouseManager.isRightPressed())
				{
					uiRightPressed = false;
				}
			}
			
			if(inventoryItemHolded != null)
			{
				g.drawImage(inventoryItemHolded.getTexture(), Game.mouseManager.getMouseX() - 32, Game.mouseManager.getMouseY() - 32, 64, 64, null);
				
				if(inventoryItemHolded.getTopLife() != -1 && inventoryItemHolded.getLife() != 0)
				{
					g.setColor(Color.BLACK);
					g.fillRect(Game.mouseManager.getMouseX() - 32 + 13, Game.mouseManager.getMouseY() - 32 + 45, 40, 5);
					g.drawRect(Game.mouseManager.getMouseX() - 32 + 12, Game.mouseManager.getMouseY() - 32 + 44, 41, 6);
					
					g.setColor(Color.GREEN);
					g.fillRect(Game.mouseManager.getMouseX() - 32 + 13, Game.mouseManager.getMouseY() - 32 + 45, (int) ((1-(((inventoryItemHolded.getLife() * 100) / inventoryItemHolded.getTopLife())/100f)) * 40), 5);
				}
				
				if(inventoryItemHolded.getCount() < 10)
				{
					if(numHotBar[inventoryItemHolded.getCount()] != null)
					{
						if(inventoryItemHolded.getCount() != 1)
						{
							g.drawImage(numHotBar[inventoryItemHolded.getCount()], Game.mouseManager.getMouseX() - 32 + 32, Game.mouseManager.getMouseY(), 32, 32, null);	
						}
					}
				}
				else
				{
					g.drawImage(numHotBar[1], Game.mouseManager.getMouseX() - 32 + 22, Game.mouseManager.getMouseY(), 32, 32, null);
					g.drawImage(numHotBar[inventoryItemHolded.getCount() - 10], Game.mouseManager.getMouseX() - 32 + 32, Game.mouseManager.getMouseY(), 32, 32, null);
				}
			}
			
			itemCraftingResult = checkCraftings.checkCrafting(itemsCrafting, itemCraftingTool);
			crInventorySlot.setItem(itemCraftingResult);
		}
		else
		{
			if(inventoryItemHolded != null)
			{
				addItem(inventoryItemHolded);
				inventoryItemHolded = null;
			}
			
			if(inventoryTrashCan != null)
			{
				inventoryTrashCan = null;
				tInventorySlot.setItem(inventoryTrashCan);
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					if(itemsCrafting[i][j] != null)
					{
						addItem(itemsCrafting[i][j]);
						itemsCrafting[i][j] = null;
						cInventorySlots[i][j].setItem(itemsCrafting[i][j]); 
					}
				}
			}
			
			if(itemCraftingTool != null)
			{
				addItem(itemCraftingTool);
				itemCraftingTool = null;
				ctInventorySlot.setItem(itemCraftingTool);
			}
		}
		
		//System.out.println(inventoryTool);
	}
	
	public static void addItem(Item item)
	{
		boolean isTool = false;
		boolean finish = false;
		boolean isBreak1 = false;
		boolean isBreak2 = false;
		boolean isBreak3 = false;
		
		if(item instanceof Tool)
		{
			if(inventoryTool == null)
			{
				item.setX(64);
				inventoryTool = item;
				toolInventorySlot.setItem(item);
				isTool = true;
			}
		}
		
		if(!isTool)
		{
			for(int i = 0; i < item.getCount(); i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsHotbar[j] == null)
					{
						item.setCount(item.getCount() - i);
						item.setX((j + 3) * 64);
						itemsHotbar[j] = item;
						isBreak2 = true;
						finish = true;
						break;
					}
					else if(itemsHotbar[j].getClass() == item.getClass() && itemsHotbar[j].isStack())
					{
						if(itemsHotbar[j].getCount() < 12)
						{
							itemsHotbar[j].setCount(itemsHotbar[j].getCount() + 1);
							itemsHotbar[j].setX((j + 3) * 64);
							
							if(i == item.getCount() - 1)
							{
								finish = true;
							}
							
							break;
						}
					}
					else
					{
						isBreak2 = true;
					}
				}
				
				if(isBreak2)
				{
					break;
				}
			}
	
			if(!finish)
			{
				for(int y = 0; y < 2; y++)
				{
					for(int i = 0; i < item.getCount(); i++)
					{
						for(int x = 0; x < ISIZE; x++)
						{
							if(itemsInventory[y][x] != null)
							{
								if(itemsInventory[y][x].getClass() == item.getClass() && itemsInventory[y][x].isStack())
								{
									if(itemsInventory[y][x].getCount() < 12)
									{
										itemsInventory[y][x].setCount(itemsInventory[y][x].getCount() + 1);
										iInventorySlots[y][x].setX((x + 3) * 64);
										iInventorySlots[y][x].setY((y + 5) * 64);
										
										if(i == item.getCount() - 1)
										{
											isBreak3 = true;
										}
										
										break;
									}
								}
							}
							else if(itemsInventory[y][x] == null)
							{
								item.setCount(item.getCount() - i);
								iInventorySlots[y][x].setX((x + 3) * 64);
								iInventorySlots[y][x].setY((y + 5) * 64);
								itemsInventory[y][x] = item;
								isBreak1 = true;
								break;
							}
							else
							{
								isBreak1 = true;
							}
						}
						
						if(isBreak1)
						{
							break;
						}
					}
					
					if(isBreak1)
					{
						break;
					}
					
					if(isBreak3)
					{
						break;
					}
				}
			}
		}
		for(int i = 0; i < ISIZE; i++)
		{
			hInventorySlots[i].setItem(itemsHotbar[i]);
		}
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < ISIZE; j++)
			{
				iInventorySlots[i][j].setItem(itemsInventory[i][j]);
			}
		}
	}
}
