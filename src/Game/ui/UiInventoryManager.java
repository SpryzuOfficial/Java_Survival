package Game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Items.*;
import Game.engine.CheckAnvil;
import Game.engine.CheckCraftings;
import Game.engine.CheckOven;
import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.entities.ChestE;
import Game.entities.OvenE;
import Game.ui.utils.InventorySlot;

public class UiInventoryManager
{
	private static int ISIZE = 5;
	public static int hotbarSelected = 3;
	
	private static Item inventoryItemHolded;
	public static Item[] itemsHotbar;
	private static Item[][] itemsInventory;
	private static Item[][] itemsCrafting;
	private static Item[][] itemsCraftingTable;
	private static Item itemCraftingTool;
	private static Item[] itemsCraftingToolsTable;
	private static Item itemCraftingResult;
	private static Item itemCraftingResultTable;
	public static Item itemOvenInput;
	public static Item itemOvenFuel;
	public static Item itemOvenOutputT;
	public static Item itemOvenOutput;
	private static Item itemAnvilInput;
	private static Item itemAnvilTool;
	private static Item itemAnvilOutput;
	private static Item[] itemsChest;
	private static Item inventoryTrashCan;
	public static Item inventoryTool;
	public static InventorySlot[] hInventorySlots;
	private static InventorySlot[][] iInventorySlots;
	private static InventorySlot[][] cInventorySlots;
	private static InventorySlot[][] cTableSlots;
	private static InventorySlot ctInventorySlot;
	private static InventorySlot[] ctTableSlots;
	private static InventorySlot crInventorySlot;
	private static InventorySlot crTableSlot;
	public static InventorySlot oiOvenSlot;
	public static InventorySlot ofOvenSlot;
	public static InventorySlot ootOvenSlot;
	public static InventorySlot ooOvenSlot;
	private static InventorySlot aiAnvilSlot;
	private static InventorySlot atAnvilSlot;
	private static InventorySlot aoAnvilSlot;
	private static InventorySlot[] chestInventorySlots;
	private static InventorySlot tInventorySlot;
	public static InventorySlot toolInventorySlot;
	private static BufferedImage[] numHotBar;
	private static boolean uiLeftPressed;
	private static boolean uiRightPressed;
	private static CheckCraftings checkCraftings;
	private static CheckAnvil checkAnvil;
	private static CheckOven checkOven;
	
	private static boolean fPressed;
	private static boolean cPressed;
	
	private static boolean isFirstTick = true;
	
	public static OvenE oven;
	public static ChestE chest;
	
	public UiInventoryManager()
	{
		
	}
	
	public static void init()
	{
		itemsHotbar = new Item[ISIZE];
		itemsInventory = new Item[2][ISIZE];
		itemsCrafting = new Item[2][2];
		itemsCraftingTable = new Item[3][3];
		itemsCraftingToolsTable = new Item[2];
		itemsChest = new Item[8];
		iInventorySlots = new InventorySlot[2][ISIZE];
		hInventorySlots = new InventorySlot[ISIZE];
		cInventorySlots = new InventorySlot[2][2];
		cTableSlots = new InventorySlot[3][3];
		ctTableSlots = new InventorySlot[2];
		chestInventorySlots = new InventorySlot[8];
		
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
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				cTableSlots[i][j] = new InventorySlot((3 + j) * 64, (2 + i) * 64, 64, 64, itemsCraftingTable[i][j]);
			}
		}
		
		for(int i = 0; i < 2; i++)
		{
			ctTableSlots[i] = new InventorySlot((7 + i) * 64, 128, 64, 64, itemsCraftingToolsTable[i]);
		}
		
		for(int i = 0; i < 5; i++)
		{
			chestInventorySlots[i] = new InventorySlot((3 + i) * 64, 192, 64, 64, itemsChest[i]);
		}
		
		for(int i = 5; i < 8; i++)
		{
			chestInventorySlots[i] = new InventorySlot((4 + (i - 5)) * 64, 256, 64, 64, itemsChest[i]);
		}
		
		ctInventorySlot = new InventorySlot(576, 128, 64, 64, itemCraftingTool);
		
		crInventorySlot = new InventorySlot(576, 192, 64, 64, itemCraftingResult);
		
		crTableSlot = new InventorySlot(448, 192, 64, 64, itemCraftingResultTable);
		
		checkCraftings = new CheckCraftings();
		
		checkAnvil = new CheckAnvil();
		
		checkOven = new CheckOven();
		
		tInventorySlot = new InventorySlot(576, 512, 64, 64, inventoryTrashCan);
		
		toolInventorySlot = new InventorySlot(64, 512, 64, 64, inventoryTool);
		
		oiOvenSlot = new InventorySlot(256, 128, 64, 64, itemOvenInput);
		
		ofOvenSlot = new InventorySlot(256, 256, 64, 64, itemOvenFuel);
		
		ootOvenSlot = new InventorySlot(256, 192, 64, 64, itemOvenOutputT);
		
		ooOvenSlot = new InventorySlot(384, 192, 64, 64, itemOvenOutput);
		
		aiAnvilSlot = new InventorySlot(256, 192, 64, 64, itemAnvilInput);
		
		atAnvilSlot = new InventorySlot(384, 128, 64, 64, itemAnvilTool);
		
		aoAnvilSlot = new InventorySlot(384, 192, 64, 64, itemAnvilOutput);
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
				//Game.player.setFood(0);
				addItem(new Pickaxe(0, 576));
				addItem(new Axe(0, 576));
				addItem(new Hammer(0, 576));
				addItem(new BasaltHammer(0, 576));
				addItem(new Sandpaper(0, 576));
				addItem(new Knife(0, 576));
				addItem(new Table(1, 0, 576));
				addItem(new Oven(1, 0, 576));
				addItem(new Anvil(1, 0, 576));
				addItem(new Wood(12, 0, 576));
				addItem(new Stone(12, 0, 576));
				addItem(new Chest(1, 0, 576));
				//addItem(new WoodPot(12, 0, 576));
				//addItem(new RockPotHerb(1, 0, 576));
				//addItem(new MushroomRed(1, 0, 576));
				//addItem(new MushroomBlue(1, 0, 576));
				//addItem(new RockPotWater(1, 0, 576));
				//addItem(new RockPotWater(1, 0, 576));
				//addItem(new SheepMeat(1, 0, 576));
				//addItem(new RockSheepMeatTray(1, 0, 576));
				addItem(new IronOre(12, 0, 576));
				addItem(new Clay(12, 0, 576));
				addItem(new WoodPlank(12, 0, 576));
				addItem(new IronBasaltTray(1, 0, 576));
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
				renderItem(g, itemsHotbar[i], itemsHotbar[i].getX(), itemsHotbar[i].getY());
			}
		}
		
		if(inventoryTool != null)
		{
			renderItem(g, inventoryTool, inventoryTool.getX(), inventoryTool.getY());
		}
		
		if(UiManager.uiImage != null)
		{
			if(isFirstTick)
			{
				if(Game.mouseManager.isLeftPressed())
				{
					uiLeftPressed = true;
				}
				
				if(Game.mouseManager.isRightPressed())
				{
					uiRightPressed = true;
				}
				
				isFirstTick = false;
			}
		}
		else
		{
			isFirstTick = true;
		}
		
		if(UiManager.uiImage == Assets.inventory)
		{
			g.drawImage(UiManager.uiImage, 0, 64, 704, 576, null);
			
			int initialX = 20;
			int initialY = 57;
			ArrayList<BufferedImage> word =  UiManager.stringToImage("Inventory");
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 32), initialY, 128, 128, null);
			}
			
			g.drawImage(Assets.player, 160, 160, 64, 64, null);
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					renderItem(g, itemsHotbar[i], itemsHotbar[i].getX(), 512);
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						renderItem(g, itemsInventory[i][j], iInventorySlots[i][j].getX(), iInventorySlots[i][j].getY());
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					if(itemsCrafting[i][j] != null)
					{
						renderItem(g, itemsCrafting[i][j], cInventorySlots[i][j].getX(), cInventorySlots[i][j].getY());
					}
				}
			}
			
			if(itemCraftingTool != null)
			{
				renderItem(g, itemCraftingTool, ctInventorySlot.getX(), ctInventorySlot.getY());
			}
			
			if(itemCraftingResult != null)
			{
				renderItem(g, itemCraftingResult, crInventorySlot.getX(), crInventorySlot.getY());
			}
			
			if(inventoryTrashCan != null)
			{
				renderItem(g, inventoryTrashCan, tInventorySlot.getX(), tInventorySlot.getY());
			}
			
			if(inventoryTool != null)
			{
				renderItem(g, inventoryTool, toolInventorySlot.getX(), toolInventorySlot.getY());
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
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
					if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
						else if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
						if(cInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(cInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				if(crInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
														itemCraftingTool = itemCraftingTool.getNextItem();
													}
												}
												else
												{
													if(itemCraftingTool.getNextItem() == null)
													{
														itemCraftingTool.setCount(itemCraftingTool.getCount() - 1);
													}
													else
													{
														itemCraftingTool = itemCraftingTool.getNextItem();
													}
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
												itemCraftingTool = itemCraftingTool.getNextItem();
											}
										}
										else
										{
											if(itemCraftingTool.getNextItem() == null)
											{
												itemCraftingTool.setCount(itemCraftingTool.getCount() - 1);
											}
											else
											{
												itemCraftingTool = itemCraftingTool.getNextItem();
											}
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
				if(ctInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
				else if(ctInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				if(tInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
					else if(tInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
							else if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				renderItem(g, inventoryItemHolded, Game.mouseManager.getMouseX() - 32, Game.mouseManager.getMouseY() - 32);
			}
			
			itemCraftingResult = checkCraftings.checkCrafting(itemsCrafting, new Item[] {itemCraftingTool});
			crInventorySlot.setItem(itemCraftingResult);
		}
		else if(UiManager.uiImage == Assets.craftingtable)
		{
			g.drawImage(UiManager.uiImage, 0, 64, 704, 576, null);
			
			int initialX = 20;
			int initialY = 57;
			ArrayList<BufferedImage> word =  UiManager.stringToImage("Table");
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 32), initialY, 128, 128, null);
			}
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					renderItem(g, itemsHotbar[i], itemsHotbar[i].getX(), 512);
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						renderItem(g, itemsInventory[i][j], iInventorySlots[i][j].getX(), iInventorySlots[i][j].getY());
					}
				}
			}
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(itemsCraftingTable[i][j] != null)
					{
						renderItem(g, itemsCraftingTable[i][j], cTableSlots[i][j].getX(), cTableSlots[i][j].getY());
					}
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				if(itemsCraftingToolsTable[i] != null)
				{
					renderItem(g, itemsCraftingToolsTable[i], ctTableSlots[i].getX(), ctTableSlots[i].getY());
				}
			}
			
			if(inventoryTool != null)
			{
				renderItem(g, inventoryTool, toolInventorySlot.getX(), toolInventorySlot.getY());
			}
			
			if(itemCraftingResultTable != null)
			{
				renderItem(g, itemCraftingResultTable, crTableSlot.getX(), crTableSlot.getY());
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
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
					if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
						else if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(inventoryItemHolded != null)
					{
						inventoryItemHolded.setX(cTableSlots[i][j].getX());
					}
					
					if(!uiLeftPressed && !uiRightPressed)
					{
						if(cTableSlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
						{	
							try
							{
								if(itemsCraftingTable[i][j].getClass() == inventoryItemHolded.getClass() && itemsCraftingTable[i][j].isStack())
								{
									if(itemsCraftingTable[i][j].getCount() < 12)
									{
										if(itemsCraftingTable[i][j].getCount() + inventoryItemHolded.getCount() <= 12)
										{
											itemsCraftingTable[i][j].setCount(itemsCraftingTable[i][j].getCount() + inventoryItemHolded.getCount());
											inventoryItemHolded = null;
											cTableSlots[i][j].setItem(itemsCraftingTable[i][j]);
											uiLeftPressed = true;
										}
										else
										{
											int x;
											int xTop = 12 - itemsCraftingTable[i][j].getCount();
											
											for(x = 0; x < xTop; x++)
											{
												itemsCraftingTable[i][j].setCount(itemsCraftingTable[i][j].getCount() + 1);
											}
											
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
											cTableSlots[i][j].setItem(itemsCraftingTable[i][j]);
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
								itemsCraftingTable[i][j] = inventoryItemHolded;
								inventoryItemHolded = cTableSlots[i][j].getItem();
								cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
								uiLeftPressed = true;
							}
						}
						else if(cTableSlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
						{
							try
							{
								if(inventoryItemHolded == null)
								{
									inventoryItemHolded = cTableSlots[i][j].getItem().clone();
									inventoryItemHolded.setCount((itemsCraftingTable[i][j].getCount() / 2) + (itemsCraftingTable[i][j].getCount() % 2));
									itemsCraftingTable[i][j].setCount((itemsCraftingTable[i][j].getCount() / 2));
									
									if(itemsCraftingTable[i][j].getCount() == 0)
									{
										itemsCraftingTable[i][j] = null;
									}
									
									cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
									uiRightPressed = true;
								}
								else if(itemsCraftingTable[i][j].getClass() == inventoryItemHolded.getClass() && itemsCraftingTable[i][j].isStack())
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsCraftingTable[i][j].setCount(itemsCraftingTable[i][j].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
										uiRightPressed = true;
									}
									else
									{
										itemsCraftingTable[i][j].setCount(itemsCraftingTable[i][j].getCount() + 1);
										inventoryItemHolded = null;
										cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
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
										itemsCraftingTable[i][j] = inventoryItemHolded.clone();
										itemsCraftingTable[i][j].setCount(0);
										itemsCraftingTable[i][j].setCount(itemsCraftingTable[i][j].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
										uiRightPressed = true;
									}
									else
									{
										itemsCraftingTable[i][j] = inventoryItemHolded.clone();
										inventoryItemHolded = null;
										cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
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
				inventoryItemHolded.setX(crTableSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(crTableSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
				{	
					if(Game.mouseManager.isLeftPressed())
					{
						try
						{
							if(inventoryItemHolded != null)
							{
								if(itemCraftingResultTable != null)
								{
									if(itemCraftingResultTable.getClass() == inventoryItemHolded.getClass() && itemCraftingResultTable.isStack())
									{
										if((inventoryItemHolded.getCount() + itemCraftingResultTable.getCount()) <= 12)
										{
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() + itemCraftingResultTable.getCount());
											
											for(int y = 0; y < 3; y++)
											{
												for(int x = 0; x < 3; x++)
												{
													if(itemsCraftingTable[y][x] != null)
													{
														itemsCraftingTable[y][x].setCount(itemsCraftingTable[y][x].getCount() - 1);
														
														if(itemsCraftingTable[y][x].getCount() == 0)
														{
															itemsCraftingTable[y][x] = null;
														}
													}
													
													cTableSlots[y][x].setItem(itemsCraftingTable[y][x]);
												}
											}
											
											for(int i = 0; i < 2; i++)
											{
												if(itemsCraftingToolsTable[i] != null)
												{
													if((itemsCraftingToolsTable[i].getCount() - 1) == 0)
													{
														itemsCraftingToolsTable[i].setLife(itemsCraftingToolsTable[i].getLife() + 1);
														if(itemsCraftingToolsTable[i].getLife() == itemsCraftingToolsTable[i].getTopLife())
														{
															itemsCraftingToolsTable[i] = itemsCraftingToolsTable[i] = itemsCraftingToolsTable[i].getNextItem();
														}
													}
													else
													{
														if(itemsCraftingToolsTable[i].getNextItem() == null)
														{
															itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() - 1);
														}
														else
														{
															itemsCraftingToolsTable[i] = itemsCraftingToolsTable[i].getNextItem();
														}
													}
												}
												
												ctTableSlots[i].setItem(itemsCraftingToolsTable[i]);
												
												crTableSlot.setItem(itemCraftingResultTable);
											}
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
								if(inventoryItemHolded == null && itemCraftingResultTable != null)
								{
									inventoryItemHolded = crTableSlot.getItem().clone();
									
									for(int y = 0; y < 3; y++)
									{
										for(int x = 0; x < 3; x++)
										{
											if(itemsCraftingTable[y][x] != null)
											{
												itemsCraftingTable[y][x].setCount(itemsCraftingTable[y][x].getCount() - 1);
												
												if(itemsCraftingTable[y][x].getCount() == 0)
												{
													itemsCraftingTable[y][x] = null;
												}
											}
											
											cTableSlots[y][x].setItem(itemsCraftingTable[y][x]);
										}
									}
									
									for(int i = 0; i < 2; i++)
									{
										if(itemsCraftingToolsTable[i] != null)
										{
											if((itemsCraftingToolsTable[i].getCount() - 1) == 0)
											{
												itemsCraftingToolsTable[i].setLife(itemsCraftingToolsTable[i].getLife() + 1);
												if(itemsCraftingToolsTable[i].getLife() == itemsCraftingToolsTable[i].getTopLife())
												{
													itemsCraftingToolsTable[i] = itemsCraftingToolsTable[i].getNextItem();
												}
											}
											else
											{
												if(itemsCraftingToolsTable[i].getNextItem() == null)
												{
													itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() - 1);
												}
												else
												{
													itemsCraftingToolsTable[i] = itemsCraftingToolsTable[i].getNextItem();
												}
											}
										}
										
										ctTableSlots[i].setItem(itemsCraftingToolsTable[i]);
										
										crTableSlot.setItem(itemCraftingResultTable); 
									}
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
			
			for(int i = 0; i < 2; i++)
			{
				if(inventoryItemHolded != null)
				{
					inventoryItemHolded.setX(ctTableSlots[i].getX());
				}
				
				if(!uiLeftPressed && !uiRightPressed)
				{
					if(ctTableSlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
					{
						try
						{
							if(itemsCraftingToolsTable[i].getClass() == inventoryItemHolded.getClass() && itemsCraftingToolsTable[i].isStack())
							{
								if(itemsCraftingToolsTable[i].getCount() < 12)
								{
									if(itemsCraftingToolsTable[i].getCount() + inventoryItemHolded.getCount() <= 12)
									{
										itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() + inventoryItemHolded.getCount());
										inventoryItemHolded = null;
										ctTableSlots[i].setItem(itemsCraftingToolsTable[i]);
										uiLeftPressed = true;
									}
									else
									{
										int x;
										int xTop = 12 - itemsCraftingToolsTable[i].getCount();
										
										for(x = 0; x < xTop; x++)
										{
											itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() + 1);
										}
										
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
										ctTableSlots[i].setItem(itemsCraftingToolsTable[i]);
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
							itemsCraftingToolsTable[i] = inventoryItemHolded;
							inventoryItemHolded = ctTableSlots[i].getItem();
							ctTableSlots[i].setItem(itemsCraftingToolsTable[i]); 
							uiLeftPressed = true;
						}
					}
					else if(ctTableSlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
					{
						try
						{
							if(inventoryItemHolded == null)
							{
								inventoryItemHolded = ctTableSlots[i].getItem().clone();
								inventoryItemHolded.setCount((itemsCraftingToolsTable[i].getCount() / 2) + (itemsCraftingToolsTable[i].getCount() % 2));
								itemsCraftingToolsTable[i].setCount((itemsCraftingToolsTable[i].getCount() / 2));
								
								if(itemsCraftingToolsTable[i].getCount() == 0)
								{
									itemsCraftingToolsTable[i] = null;
								}
								
								ctTableSlots[i].setItem(itemsCraftingToolsTable[i]); 
								uiRightPressed = true;
							}
							else if(itemsCraftingToolsTable[i].getClass() == inventoryItemHolded.getClass() && itemsCraftingToolsTable[i].isStack())
							{
								if((inventoryItemHolded.getCount() - 1) > 0)
								{
									itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() + 1);
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
									ctTableSlots[i].setItem(itemsCraftingToolsTable[i]); 
									uiRightPressed = true;
								}
								else
								{
									itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() + 1);
									inventoryItemHolded = null;
									ctTableSlots[i].setItem(itemsCraftingToolsTable[i]); 
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
									itemsCraftingToolsTable[i] = inventoryItemHolded.clone();
									itemsCraftingToolsTable[i].setCount(0);
									itemsCraftingToolsTable[i].setCount(itemsCraftingToolsTable[i].getCount() + 1);
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
									ctTableSlots[i].setItem(itemsCraftingToolsTable[i]); 
									uiRightPressed = true;
								}
								else
								{
									itemsCraftingToolsTable[i] = inventoryItemHolded.clone();
									inventoryItemHolded = null;
									ctTableSlots[i].setItem(itemsCraftingToolsTable[i]); 
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
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(toolInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
							else if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				renderItem(g, inventoryItemHolded, Game.mouseManager.getMouseX() - 32, Game.mouseManager.getMouseY() - 32);
			}
			
			itemCraftingResultTable = checkCraftings.checkCraftingTable(itemsCraftingTable, itemsCraftingToolsTable);
			crTableSlot.setItem(itemCraftingResultTable);
		}
		else if(UiManager.uiImage == Assets.ovenUI)
		{
			try
			{
				if(itemOvenOutput != null)
				{
					oven.output = itemOvenOutput.clone();
				}
				else if(oven.output != null)
				{
					oven.output = null;
				}
				
				if(itemOvenFuel != null)
				{
					oven.fuel = itemOvenFuel.clone();
				}
				else if(oven.fuel != null)
				{
					oven.fuel = null;
				}
				
				if(itemOvenInput != null)
				{
					oven.input = itemOvenInput.clone();
				}
				else if(oven.input != null)
				{
					oven.input = null;
				}
				
				if(itemOvenOutputT != null)
				{
					oven.tray = itemOvenOutputT.clone();
				}
				else if(oven.tray != null)
				{
					oven.tray = null;
				}
			}
			catch (Exception e)
			{ }
			
			g.setColor(Color.GRAY);
			g.fillRect(338, 178, 48, 25);
			if(oven.fuel != null)
			{
				if(oven.fuel_int == 0)
				{
					g.setColor(Color.GRAY);
				}
				else if(oven.fuel_int > 0 && oven.fuel_int < oven.fuel.getOvenValue() / 4)
				{
					g.setColor(Color.RED);
				}
				else if(oven.fuel_int > oven.fuel.getOvenValue() / 4 && oven.fuel_int < oven.fuel.getOvenValue() / 2)
				{
					g.setColor(Color.ORANGE);
				}
				else if(oven.fuel_int > oven.fuel.getOvenValue() / 2)
				{
					g.setColor(Color.YELLOW);
				}
			}
			else
			{
				g.setColor(Color.GRAY);
			}
			g.fillRect(338, 178 + (int) oven.fuel_bar, 48, 25);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(328, 210, 46, 30);
			
			g.setColor(Color.WHITE);
			g.fillRect(328, 210, (int) oven.process_float, 30);
			
			g.drawImage(UiManager.uiImage, 0, 64, 704, 576, null);
			
			int initialX = 20;
			int initialY = 57;
			ArrayList<BufferedImage> word =  UiManager.stringToImage("Oven");
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 32), initialY, 128, 128, null);
			}
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					renderItem(g, itemsHotbar[i], itemsHotbar[i].getX(), 512);
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						renderItem(g, itemsInventory[i][j], iInventorySlots[i][j].getX(), iInventorySlots[i][j].getY());
					}
				}
			}
			
			if(itemOvenInput != null)
			{
				renderItem(g, itemOvenInput, oiOvenSlot.getX(), oiOvenSlot.getY());
			}
			
			if(itemOvenOutputT != null)
			{
				renderItem(g, itemOvenOutputT, ootOvenSlot.getX(), ootOvenSlot.getY());
			}
			
			if(itemOvenOutput != null)
			{
				renderItem(g, itemOvenOutput, ooOvenSlot.getX(), ooOvenSlot.getY());
			}
			
			if(itemOvenFuel != null)
			{
				renderItem(g, itemOvenFuel, ofOvenSlot.getX(), ofOvenSlot.getY());
			}
			
			if(inventoryTool != null)
			{
				renderItem(g, inventoryTool, toolInventorySlot.getX(), toolInventorySlot.getY());
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
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
					if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
						else if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(oiOvenSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(oiOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
				{	
					try
					{
						if(itemOvenInput.getClass() == inventoryItemHolded.getClass() && itemOvenInput.isStack())
						{
							if(itemOvenInput.getCount() < 12)
							{
								if(itemOvenInput.getCount() + inventoryItemHolded.getCount() <= 12)
								{
									itemOvenInput.setCount(itemOvenInput.getCount() + inventoryItemHolded.getCount());
									inventoryItemHolded = null;
									oiOvenSlot.setItem(itemOvenInput);
									uiLeftPressed = true;
								}
								else
								{
									int x;
									int xTop = 12 - itemOvenInput.getCount();
									
									for(x = 0; x < xTop; x++)
									{
										itemOvenInput.setCount(itemOvenInput.getCount() + 1);
									}
									
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
									oiOvenSlot.setItem(itemOvenInput);
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
						itemOvenInput = inventoryItemHolded;
						inventoryItemHolded = oiOvenSlot.getItem();
						oiOvenSlot.setItem(itemOvenInput); 
						uiLeftPressed = true;
					}
				}
				else if(oiOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
				{
					try
					{
						if(inventoryItemHolded == null)
						{
							inventoryItemHolded = oiOvenSlot.getItem().clone();
							inventoryItemHolded.setCount((itemOvenInput.getCount() / 2) + (itemOvenInput.getCount() % 2));
							itemOvenInput.setCount((itemOvenInput.getCount() / 2));
							
							if(itemOvenInput.getCount() == 0)
							{
								itemOvenInput = null;
							}
							
							oiOvenSlot.setItem(itemOvenInput); 
							uiRightPressed = true;
						}
						else if(itemOvenInput.getClass() == inventoryItemHolded.getClass() && itemOvenInput.isStack())
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemOvenInput.setCount(itemOvenInput.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								oiOvenSlot.setItem(itemOvenInput); 
								uiRightPressed = true;
							}
							else
							{
								itemOvenInput.setCount(itemOvenInput.getCount() + 1);
								inventoryItemHolded = null;
								oiOvenSlot.setItem(itemOvenInput); 
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
								itemOvenInput = inventoryItemHolded.clone();
								itemOvenInput.setCount(0);
								itemOvenInput.setCount(itemOvenInput.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								oiOvenSlot.setItem(itemOvenInput); 
								uiRightPressed = true;
							}
							else
							{
								itemOvenInput = inventoryItemHolded.clone();
								inventoryItemHolded = null;
								oiOvenSlot.setItem(itemOvenInput); 
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
				inventoryItemHolded.setX(ootOvenSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(ootOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
				{	
					try
					{
						if(itemOvenOutputT.getClass() == inventoryItemHolded.getClass() && itemOvenOutputT.isStack())
						{
							if(itemOvenOutputT.getCount() < 12)
							{
								if(itemOvenOutputT.getCount() + inventoryItemHolded.getCount() <= 12)
								{
									itemOvenOutputT.setCount(itemOvenOutputT.getCount() + inventoryItemHolded.getCount());
									inventoryItemHolded = null;
									ootOvenSlot.setItem(itemOvenOutputT);
									uiLeftPressed = true;
								}
								else
								{
									int x;
									int xTop = 12 - itemOvenOutputT.getCount();
									
									for(x = 0; x < xTop; x++)
									{
										itemOvenOutputT.setCount(itemOvenOutputT.getCount() + 1);
									}
									
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
									ootOvenSlot.setItem(itemOvenOutputT);
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
						itemOvenOutputT = inventoryItemHolded;
						inventoryItemHolded = ootOvenSlot.getItem();
						ootOvenSlot.setItem(itemOvenOutputT); 
						uiLeftPressed = true;
					}
				}
				else if(ootOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
				{
					try
					{
						if(inventoryItemHolded == null)
						{
							inventoryItemHolded = ootOvenSlot.getItem().clone();
							inventoryItemHolded.setCount((itemOvenOutputT.getCount() / 2) + (itemOvenOutputT.getCount() % 2));
							itemOvenOutputT.setCount((itemOvenOutputT.getCount() / 2));
							
							if(itemOvenOutputT.getCount() == 0)
							{
								itemOvenOutputT = null;
							}
							
							ootOvenSlot.setItem(itemOvenOutputT); 
							uiRightPressed = true;
						}
						else if(itemOvenOutputT.getClass() == inventoryItemHolded.getClass() && itemOvenOutputT.isStack())
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemOvenOutputT.setCount(itemOvenOutputT.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								ootOvenSlot.setItem(itemOvenOutputT); 
								uiRightPressed = true;
							}
							else
							{
								itemOvenOutputT.setCount(itemOvenOutputT.getCount() + 1);
								inventoryItemHolded = null;
								ootOvenSlot.setItem(itemOvenOutputT); 
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
								itemOvenOutputT = inventoryItemHolded.clone();
								itemOvenOutputT.setCount(0);
								itemOvenOutputT.setCount(itemOvenOutputT.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								ootOvenSlot.setItem(itemOvenOutputT); 
								uiRightPressed = true;
							}
							else
							{
								itemOvenOutputT = inventoryItemHolded.clone();
								inventoryItemHolded = null;
								ootOvenSlot.setItem(itemOvenOutputT); 
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
				inventoryItemHolded.setX(ofOvenSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(ofOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
				{	
					try
					{
						if(itemOvenFuel.getClass() == inventoryItemHolded.getClass() && itemOvenFuel.isStack())
						{
							if(itemOvenFuel.getCount() < 12)
							{
								if(itemOvenFuel.getCount() + inventoryItemHolded.getCount() <= 12)
								{
									itemOvenFuel.setCount(itemOvenFuel.getCount() + inventoryItemHolded.getCount());
									inventoryItemHolded = null;
									ofOvenSlot.setItem(itemOvenFuel);
									uiLeftPressed = true;
								}
								else
								{
									int x;
									int xTop = 12 - itemOvenFuel.getCount();
									
									for(x = 0; x < xTop; x++)
									{
										itemOvenFuel.setCount(itemOvenFuel.getCount() + 1);
									}
									
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
									ofOvenSlot.setItem(itemOvenFuel);
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
						itemOvenFuel = inventoryItemHolded;
						inventoryItemHolded = ofOvenSlot.getItem();
						ofOvenSlot.setItem(itemOvenFuel); 
						uiLeftPressed = true;
					}
				}
				else if(ofOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
				{
					try
					{
						if(inventoryItemHolded == null)
						{
							inventoryItemHolded = ofOvenSlot.getItem().clone();
							inventoryItemHolded.setCount((itemOvenFuel.getCount() / 2) + (itemOvenFuel.getCount() % 2));
							itemOvenFuel.setCount((itemOvenFuel.getCount() / 2));
							
							if(itemOvenFuel.getCount() == 0)
							{
								itemOvenFuel = null;
							}
							
							ofOvenSlot.setItem(itemOvenFuel); 
							uiRightPressed = true;
						}
						else if(itemOvenFuel.getClass() == inventoryItemHolded.getClass() && itemOvenFuel.isStack())
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemOvenFuel.setCount(itemOvenFuel.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								ofOvenSlot.setItem(itemOvenFuel); 
								uiRightPressed = true;
							}
							else
							{
								itemOvenFuel.setCount(itemOvenFuel.getCount() + 1);
								inventoryItemHolded = null;
								ofOvenSlot.setItem(itemOvenFuel); 
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
								itemOvenFuel = inventoryItemHolded.clone();
								itemOvenFuel.setCount(0);
								itemOvenFuel.setCount(itemOvenFuel.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								ofOvenSlot.setItem(itemOvenFuel); 
								uiRightPressed = true;
							}
							else
							{
								itemOvenFuel = inventoryItemHolded.clone();
								inventoryItemHolded = null;
								ofOvenSlot.setItem(itemOvenFuel); 
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
				inventoryItemHolded.setX(toolInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
							else if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				inventoryItemHolded.setX(ooOvenSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(ooOvenSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
				{	
					if(Game.mouseManager.isLeftPressed())
					{
						if(inventoryItemHolded != null)
						{
							if(itemOvenOutput != null)
							{
								if(itemOvenOutput.getClass() == inventoryItemHolded.getClass() && itemOvenOutput.isStack())
								{
									if((inventoryItemHolded.getCount() + itemOvenOutput.getCount()) <= 12)
									{
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() + itemOvenOutput.getCount());
										ooOvenSlot.setItem(itemOvenOutput);
										uiLeftPressed = true;
									}
								}
							}
						}
						else
						{
							if(inventoryItemHolded == null && itemOvenOutput != null)
							{
								itemOvenOutput = inventoryItemHolded;
								inventoryItemHolded = ooOvenSlot.getItem();
								ooOvenSlot.setItem(itemOvenOutput);
								uiLeftPressed = true;
							}
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
				renderItem(g, inventoryItemHolded, Game.mouseManager.getMouseX() - 32, Game.mouseManager.getMouseY() - 32);
			}
		}
		else if(UiManager.uiImage == Assets.anvilUI)
		{
			g.drawImage(UiManager.uiImage, 0, 64, 704, 576, null);
			
			int initialX = 20;
			int initialY = 57;
			ArrayList<BufferedImage> word =  UiManager.stringToImage("Anvil");
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 32), initialY, 128, 128, null);
			}
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					renderItem(g, itemsHotbar[i], itemsHotbar[i].getX(), 512);
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						renderItem(g, itemsInventory[i][j], iInventorySlots[i][j].getX(), iInventorySlots[i][j].getY());
					}
				}
			}
			
			if(itemAnvilInput != null)
			{
				renderItem(g, itemAnvilInput, aiAnvilSlot.getX(), aiAnvilSlot.getY());
			}
			
			if(itemAnvilTool != null)
			{
				renderItem(g, itemAnvilTool, atAnvilSlot.getX(), atAnvilSlot.getY());
			}
			
			if(itemAnvilOutput != null)
			{
				renderItem(g, itemAnvilOutput, aoAnvilSlot.getX(), aoAnvilSlot.getY());
			}
			
			if(inventoryTool != null)
			{
				renderItem(g, inventoryTool, toolInventorySlot.getX(), toolInventorySlot.getY());
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
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
					if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
						else if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
			
			if(inventoryTool != null)
			{
				renderItem(g, inventoryTool, toolInventorySlot.getX(), toolInventorySlot.getY());
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
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(aiAnvilSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(aiAnvilSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
				{	
					try
					{
						if(itemAnvilInput.getClass() == inventoryItemHolded.getClass() && itemAnvilInput.isStack())
						{
							if(itemAnvilInput.getCount() < 12)
							{
								if(itemAnvilInput.getCount() + inventoryItemHolded.getCount() <= 12)
								{
									itemAnvilInput.setCount(itemAnvilInput.getCount() + inventoryItemHolded.getCount());
									inventoryItemHolded = null;
									aiAnvilSlot.setItem(itemAnvilInput);
									uiLeftPressed = true;
								}
								else
								{
									int x;
									int xTop = 12 - itemAnvilInput.getCount();
									
									for(x = 0; x < xTop; x++)
									{
										itemAnvilInput.setCount(itemAnvilInput.getCount() + 1);
									}
									
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
									aiAnvilSlot.setItem(itemAnvilInput);
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
						itemAnvilInput = inventoryItemHolded;
						inventoryItemHolded = aiAnvilSlot.getItem();
						aiAnvilSlot.setItem(itemAnvilInput); 
						uiLeftPressed = true;
					}
				}
				else if(aiAnvilSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
				{
					try
					{
						if(inventoryItemHolded == null)
						{
							inventoryItemHolded = oiOvenSlot.getItem().clone();
							inventoryItemHolded.setCount((itemAnvilInput.getCount() / 2) + (itemAnvilInput.getCount() % 2));
							itemAnvilInput.setCount((itemAnvilInput.getCount() / 2));
							
							if(itemAnvilInput.getCount() == 0)
							{
								itemAnvilInput = null;
							}
							
							aiAnvilSlot.setItem(itemAnvilInput); 
							uiRightPressed = true;
						}
						else if(itemAnvilInput.getClass() == inventoryItemHolded.getClass() && itemAnvilInput.isStack())
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemAnvilInput.setCount(itemAnvilInput.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								aiAnvilSlot.setItem(itemAnvilInput); 
								uiRightPressed = true;
							}
							else
							{
								itemAnvilInput.setCount(itemAnvilInput.getCount() + 1);
								inventoryItemHolded = null;
								aiAnvilSlot.setItem(itemAnvilInput); 
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
								itemAnvilInput = inventoryItemHolded.clone();
								itemAnvilInput.setCount(0);
								itemAnvilInput.setCount(itemAnvilInput.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								aiAnvilSlot.setItem(itemAnvilInput); 
								uiRightPressed = true;
							}
							else
							{
								itemAnvilInput = inventoryItemHolded.clone();
								inventoryItemHolded = null;
								aiAnvilSlot.setItem(itemAnvilInput); 
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
				inventoryItemHolded.setX(atAnvilSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(atAnvilSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
				{	
					try
					{
						if(itemAnvilTool.getClass() == inventoryItemHolded.getClass() && itemAnvilTool.isStack())
						{
							if(itemAnvilTool.getCount() < 12)
							{
								if(itemAnvilTool.getCount() + inventoryItemHolded.getCount() <= 12)
								{
									itemAnvilTool.setCount(itemAnvilTool.getCount() + inventoryItemHolded.getCount());
									inventoryItemHolded = null;
									atAnvilSlot.setItem(itemAnvilTool);
									uiLeftPressed = true;
								}
								else
								{
									int x;
									int xTop = 12 - itemAnvilTool.getCount();
									
									for(x = 0; x < xTop; x++)
									{
										itemAnvilTool.setCount(itemAnvilTool.getCount() + 1);
									}
									
									inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
									atAnvilSlot.setItem(itemAnvilTool);
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
						itemAnvilTool = inventoryItemHolded;
						inventoryItemHolded = atAnvilSlot.getItem();
						atAnvilSlot.setItem(itemAnvilTool); 
						uiLeftPressed = true;
					}
				}
				else if(atAnvilSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
				{
					try
					{
						if(inventoryItemHolded == null)
						{
							inventoryItemHolded = atAnvilSlot.getItem().clone();
							inventoryItemHolded.setCount((itemAnvilTool.getCount() / 2) + (itemAnvilTool.getCount() % 2));
							itemAnvilTool.setCount((itemAnvilTool.getCount() / 2));
							
							if(itemAnvilTool.getCount() == 0)
							{
								itemAnvilTool = null;
							}
							
							atAnvilSlot.setItem(itemAnvilTool); 
							uiRightPressed = true;
						}
						else if(itemAnvilTool.getClass() == inventoryItemHolded.getClass() && itemAnvilTool.isStack())
						{
							if((inventoryItemHolded.getCount() - 1) > 0)
							{
								itemAnvilTool.setCount(itemAnvilTool.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								atAnvilSlot.setItem(itemAnvilTool); 
								uiRightPressed = true;
							}
							else
							{
								itemAnvilTool.setCount(itemAnvilTool.getCount() + 1);
								inventoryItemHolded = null;
								atAnvilSlot.setItem(itemAnvilTool); 
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
								itemAnvilTool = inventoryItemHolded.clone();
								itemAnvilTool.setCount(0);
								itemAnvilTool.setCount(itemAnvilTool.getCount() + 1);
								inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
								atAnvilSlot.setItem(itemAnvilTool); 
								uiRightPressed = true;
							}
							else
							{
								itemAnvilTool = inventoryItemHolded.clone();
								inventoryItemHolded = null;
								atAnvilSlot.setItem(itemAnvilTool); 
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
				inventoryItemHolded.setX(aoAnvilSlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(aoAnvilSlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
				{	
					if(Game.mouseManager.isLeftPressed())
					{
						try
						{
							if(inventoryItemHolded != null)
							{
								if(itemAnvilOutput != null)
								{
									if(itemAnvilOutput.getClass() == inventoryItemHolded.getClass() && itemAnvilOutput.isStack())
									{
										if((inventoryItemHolded.getCount() + itemAnvilOutput.getCount()) <= 12)
										{
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() + itemAnvilOutput.getCount());
											
											
											if(itemAnvilInput != null)
											{
												itemAnvilInput.setCount(itemAnvilInput.getCount() - 1);
												
												if(itemAnvilInput.getCount() == 0)
												{
													itemAnvilInput = null;
												}
											}
											
											aiAnvilSlot.setItem(itemAnvilInput);
											
											if(itemAnvilTool != null)
											{
												if((itemAnvilTool.getCount() - 1) == 0)
												{
													itemAnvilTool.setLife(itemAnvilTool.getLife() + 1);
													if(itemAnvilTool.getLife() == itemAnvilTool.getTopLife())
													{
														itemAnvilTool = null;
													}
												}
												else
												{
													itemAnvilTool.setCount(itemAnvilTool.getCount() - 1);
												}
											}
											
											atAnvilSlot.setItem(itemAnvilTool);
											
											aoAnvilSlot.setItem(itemAnvilOutput);
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
								if(inventoryItemHolded == null && itemAnvilOutput != null)
								{
									inventoryItemHolded = aoAnvilSlot.getItem().clone();
									
									if(itemAnvilInput != null)
									{
										itemAnvilInput.setCount(itemAnvilInput.getCount() - 1);
										
										if(itemAnvilInput.getCount() == 0)
										{
											itemAnvilInput = null;
										}
									}
									
									aiAnvilSlot.setItem(itemAnvilInput);
									
									if(itemAnvilTool != null)
									{
										if((itemAnvilTool.getCount() - 1) == 0)
										{
											itemAnvilTool.setLife(itemAnvilTool.getLife() + 1);
											if(itemAnvilTool.getLife() == itemAnvilTool.getTopLife())
											{
												itemAnvilTool = null;
											}
										}
										else
										{
											itemAnvilTool.setCount(itemAnvilTool.getCount() - 1);
										}
									}
									
									atAnvilSlot.setItem(itemAnvilTool);
									
									aoAnvilSlot.setItem(itemAnvilOutput); 
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
				inventoryItemHolded.setX(toolInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
							else if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				renderItem(g, inventoryItemHolded, Game.mouseManager.getMouseX() - 32, Game.mouseManager.getMouseY() - 32);
			}
			
			itemAnvilOutput = checkAnvil.checkAnvil(itemAnvilInput, itemAnvilTool);
			aoAnvilSlot.setItem(itemAnvilOutput);
		}
		else if(UiManager.uiImage == Assets.chestUI)
		{
			try
			{
				for(int i = 0; i < 8; i++)
				{
					if(itemsChest[i] != null)
					{
						chest.content[i] = itemsChest[i].clone();
					}
					else if(chest.content[i] != null)
					{
						chest.content[i] = null;
					}
				}
			}
			catch (Exception e)
			{ }
			
			g.drawImage(UiManager.uiImage, 0, 64, 704, 576, null);
			
			int initialX = 20;
			int initialY = 57;
			ArrayList<BufferedImage> word =  UiManager.stringToImage("Chest");
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 32), initialY, 128, 128, null);
			}
			
			for(int i = 0; i < ISIZE; i++)
			{
				if(itemsHotbar[i] != null)
				{
					renderItem(g, itemsHotbar[i], itemsHotbar[i].getX(), 512);
				}
			}
			
			for(int i = 0; i < 8; i++)
			{
				if(itemsChest[i] != null)
				{
					renderItem(g, itemsChest[i], itemsChest[i].getX(), chestInventorySlots[i].getY());
				}
			}
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < ISIZE; j++)
				{
					if(itemsInventory[i][j] != null)
					{
						renderItem(g, itemsInventory[i][j], iInventorySlots[i][j].getX(), iInventorySlots[i][j].getY());
					}
				}
			}
			
			if(inventoryTool != null)
			{
				renderItem(g, inventoryTool, toolInventorySlot.getX(), toolInventorySlot.getY());
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
						if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isLeftPressed())
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
						else if(iInventorySlots[i][j].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
					if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
						else if(hInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
			
			for(int i = 0; i < 8; i++)
			{
				if(inventoryItemHolded != null)
				{
					inventoryItemHolded.setX(chestInventorySlots[i].getX());
				}
				
				if(!uiLeftPressed && !uiRightPressed)
				{
					if(chestInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
					{	
						if(Game.mouseManager.isLeftPressed())
						{
							try
							{
								if(itemsChest[i].getClass() == inventoryItemHolded.getClass())
								{
									if(itemsChest[i].getCount() < 12 && itemsChest[i].isStack())
									{
										if(itemsChest[i].getCount() + inventoryItemHolded.getCount() <= 12)
										{
											itemsChest[i].setCount(itemsChest[i].getCount() + inventoryItemHolded.getCount());
											inventoryItemHolded = null;
											chestInventorySlots[i].setItem(itemsChest[i]);
											uiLeftPressed = true;
										}
										else
										{
											int x;
											int xTop = 12 - itemsChest[i].getCount();
											
											for(x = 0; x < xTop; x++)
											{
												itemsChest[i].setCount(itemsChest[i].getCount() + 1);
											}
											
											inventoryItemHolded.setCount(inventoryItemHolded.getCount() - x);
											chestInventorySlots[i].setItem(itemsChest[i]);
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
								itemsChest[i] = inventoryItemHolded;
								inventoryItemHolded = chestInventorySlots[i].getItem();
								chestInventorySlots[i].setItem(itemsChest[i]); 
								uiLeftPressed = true;
							}
						}
						else if(chestInventorySlots[i].mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
						{
							try
							{
								if(inventoryItemHolded == null)
								{
									inventoryItemHolded = chestInventorySlots[i].getItem().clone();
									inventoryItemHolded.setCount((itemsChest[i].getCount() / 2) + (itemsChest[i].getCount() % 2));
									itemsChest[i].setCount((itemsChest[i].getCount() / 2));
									
									if(itemsChest[i].getCount() == 0)
									{
										itemsChest[i] = null;
									}
									
									chestInventorySlots[i].setItem(itemsChest[i]); 
									uiRightPressed = true;
								}
								else if(itemsChest[i].getClass() == inventoryItemHolded.getClass() && itemsChest[i].isStack())
								{
									if((inventoryItemHolded.getCount() - 1) > 0)
									{
										itemsChest[i].setCount(itemsChest[i].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										chestInventorySlots[i].setItem(itemsChest[i]); 
										uiRightPressed = true;
									}
									else
									{
										itemsChest[i].setCount(itemsChest[i].getCount() + 1);
										inventoryItemHolded = null;
										chestInventorySlots[i].setItem(itemsChest[i]); 
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
										itemsChest[i] = inventoryItemHolded.clone();
										itemsChest[i].setCount(0);
										itemsChest[i].setCount(itemsChest[i].getCount() + 1);
										inventoryItemHolded.setCount(inventoryItemHolded.getCount() - 1);
										chestInventorySlots[i].setItem(itemsChest[i]); 
										uiRightPressed = true;
									}
									else
									{
										itemsChest[i] = inventoryItemHolded.clone();
										inventoryItemHolded = null;
										chestInventorySlots[i].setItem(itemsChest[i]); 
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
			
			if(inventoryItemHolded != null)
			{
				inventoryItemHolded.setX(toolInventorySlot.getX());
			}
			
			if(!uiLeftPressed && !uiRightPressed)
			{
				if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g))
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
							else if(toolInventorySlot.mouseCollision(Game.mouseManager.getMouseX(), Game.mouseManager.getMouseY(), g) && Game.mouseManager.isRightPressed())
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
				renderItem(g, inventoryItemHolded, Game.mouseManager.getMouseX() - 32, Game.mouseManager.getMouseY() - 32);
			}
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
			
			if(chest != null)
			{
				try
				{
					for(int i = 0; i < 8; i++)
					{
						if(itemsChest[i] != null)
						{
							chest.content[i] = itemsChest[i];
						}
						else if(itemsChest[i] == null)
						{
							chest.content[i] = null;
						}
					}
				}
				catch (Exception e)
				{ 
					System.err.println(e);
				}
			}
			
			if(oven != null)
			{
				try
				{
					if(itemOvenFuel != null)
					{
						oven.fuel = itemOvenFuel.clone();
					}
					else if(oven.fuel == null)
					{
						oven.fuel = null;
					}
					
					if(itemOvenInput != null)
					{
						oven.input = itemOvenInput.clone();
					}
					else if(oven.input != null)
					{
						oven.input = null;
					}
					
					if(itemOvenOutputT != null)
					{
						oven.tray = itemOvenOutputT.clone();
					}
					else if(oven.tray != null)
					{
						oven.tray = null;
					}
					
					if(itemOvenOutput != null)
					{
						oven.output = itemOvenOutput.clone();
					}
					else if(oven.output != null)
					{
						oven.output = null;
					}
				}
				catch (Exception e)
				{ 
					System.err.println(e);
				}
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
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(itemsCraftingTable[i][j] != null)
					{
						addItem(itemsCraftingTable[i][j]);
						itemsCraftingTable[i][j] = null;
						cTableSlots[i][j].setItem(itemsCraftingTable[i][j]); 
					}
				}
			}
			
			if(itemCraftingTool != null)
			{
				addItem(itemCraftingTool);
				itemCraftingTool = null;
				ctInventorySlot.setItem(itemCraftingTool);
			}
			
			for(int i = 0; i < 2; i++)
			{
				if(itemsCraftingToolsTable[i] != null)
				{
					addItem(itemsCraftingToolsTable[i]);
					itemsCraftingToolsTable[i] = null;
					ctTableSlots[i].setItem(itemsCraftingToolsTable[i]);
				}
			}
			
			if(itemAnvilInput != null)
			{
				addItem(itemAnvilInput);
				itemAnvilInput = null;
				aiAnvilSlot.setItem(itemAnvilInput);
			}
			
			if(itemAnvilTool != null)
			{
				addItem(itemAnvilTool);
				itemAnvilTool = null;
				atAnvilSlot.setItem(itemAnvilTool);
			}
			
			oven = null;
		}
	}
	
	public static void renderItem(Graphics g, Item item, int x, int y) // int x, int y
	{
		g.drawImage(item.getTexture(), x, y, 64, 64, null);
		if(item.getTopLife() != -1 && item.getLife() != 0)
		{
			g.setColor(Color.BLACK);
			g.fillRect(x + 13, y + 45, 40, 5);
			g.drawRect(x + 12, y + 44, 41, 6);
			
			g.setColor(Color.GREEN);
			g.fillRect(x + 13, y + 45, (int) ((1-(((item.getLife() * 100) / item.getTopLife())/100f)) * 40), 5);
		}
		
		if(item.getCount() < 10)
		{
			if(numHotBar[item.getCount()] != null)
			{
				if(item.getCount() != 1)
				{
					g.drawImage(numHotBar[item.getCount()], x + 17, y + 16, 64, 64, null);	
				}
			}
		}
		else
		{
			g.drawImage(numHotBar[1], x + 10, y + 16, 64, 64, null);
			g.drawImage(numHotBar[item.getCount() - 10], x + 17, y + 16, 64, 64, null);
		}
	}
	
	public static void addItem(Item item)
	{
		if(item == null)
		{
			return;
		}
		
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
			int i = 0;
			int count = item.getCount();
			
			int ncount = count;
			for(int y = 0; y < 2; y++)
			{
				for(i = 0; i < ncount; i++)
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
									count -= 1;
									iInventorySlots[y][x].setX((x + 3) * 64);
									iInventorySlots[y][x].setY((y + 5) * 64);
									
									if(i == item.getCount() - 1)
									{
										finish = true;
										isBreak3 = true;
									}
									
									break;
								}
							}
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
			
			if(!finish)
			{
				ncount = count;
				for(i = 0; i < ncount; i++)
				{
					for(int j = 0; j < ISIZE; j++)
					{
						if(itemsHotbar[j] != null)
						{
							if(itemsHotbar[j].getClass() == item.getClass() && itemsHotbar[j].isStack())
							{
								if(itemsHotbar[j].getCount() < 12)
								{
									itemsHotbar[j].setCount(itemsHotbar[j].getCount() + 1);
									count -= 1;
									itemsHotbar[j].setX((j + 3) * 64);
									
									if(i == item.getCount() - 1)
									{
										finish = true;
										isBreak2 = true;
									}
									
									break;
								}
							}
						}
					}
					
					if(isBreak2)
					{
						break;
					}
				}
			}
			
			if(!finish)
			{
				ncount = count;
				for(i = 0; i < ncount; i++)
				{
					for(int j = 0; j < ISIZE; j++)
					{
						if(itemsHotbar[j] == null)
						{
							item.setCount(count - i);
							item.setX((j + 3) * 64);
							itemsHotbar[j] = item;
							finish = true;
							isBreak2 = true;
							break;
						}
					}
					
					if(isBreak2)
					{
						break;
					}
				}
			}
			
			if(!finish)
			{
				ncount = count;
				for(int y = 0; y < 2; y++)
				{
					for(i = 0; i < ncount; i++)
					{
						for(int x = 0; x < ISIZE; x++)
						{
							if(itemsInventory[y][x] == null)
							{
								item.setCount(count - i);
								iInventorySlots[y][x].setX((x + 3) * 64);
								iInventorySlots[y][x].setY((y + 5) * 64);
								itemsInventory[y][x] = item;
								finish = true;
								isBreak1 = true;
								break;
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
	
	public static void openOven()
	{
		itemOvenInput = oven.input;
		oiOvenSlot.setItem(itemOvenInput);
		
		itemOvenOutputT = oven.tray;
		ootOvenSlot.setItem(itemOvenOutputT);
		
		itemOvenFuel = oven.fuel;
		ofOvenSlot.setItem(itemOvenFuel);
		
		itemOvenOutput = oven.output;
		ooOvenSlot.setItem(itemOvenOutput);
	}
	
	public static void openChest()
	{
		for(int i = 0; i < 8; i++)
		{
			itemsChest[i] = chest.content[i];
			chestInventorySlots[i].setItem(itemsChest[i]);
		}
	}
}
