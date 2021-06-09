package Game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Game.Items.Item;
import Game.Items.Oven;
import Game.engine.CheckOven;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;

public class OvenE extends StaticEntity
{	
	private ArrayList<Smoke> smokes;
	private static CheckOven checkOven;
	
	public Item fuel;
	public Item tray;
	public Item input;
	public Item output;
	
	public int fuel_int = 0;
	public float process_float = 0;
	public boolean is_process;
	
	public OvenE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.ovenE, Gx, Gy, Vx, Vy, 64, 64, 420, 0, 0, 1);
		
		this.items.add(new Oven(1, 0, 576));
		
		this.smokes = new ArrayList<Smoke>();
		checkOven = new CheckOven();
	}
	
	@Override
	public void use()
	{
		UiManager.uiImage = Assets.ovenUI;
		UiInventoryManager.oven = this;
		
		UiInventoryManager.openOven();
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, width, height, null);
		
		for(int i = 0; i < smokes.size(); i++)
		{
			if(smokes.get(i) != null)
			{
				smokes.get(i).render(g);
			}
		}
	}
	
	@Override
	public void tick()
	{
		x = Vx - virtualSpace.getX();
		y = Vy - virtualSpace.getY();
		
		for(int i = 0; i < smokes.size(); i++)
		{
			if(smokes.get(i) != null)
			{
				if(smokes.get(i).is_time)
				{
					smokes.remove(i);
				}
				else
				{
					smokes.get(i).tick();
				}
			}
		}
		
		if(is_process)
		{
			if(fuel != null)
			{
				if(fuel_int == 0)
				{
					smokes.add(new Smoke(this));
				}
				
				fuel_int++;
				process_float += 48f/(240 * fuel.getOvenValue());
				
				if(process_float > 48)
				{
					try
					{
						if(output == null)
						{
							output = checkOven.checkOven(input, tray).clone();
							UiInventoryManager.itemOvenOutput = output.clone();
						}
						else if(output.getClass() == checkOven.checkOven(input, tray).getClass())
						{
							output.setCount(output.getCount() + 1);
							UiInventoryManager.itemOvenOutput = output.clone();
						}
						
						if((input.getCount() - 1) == 0)
						{
							input = null;
							UiInventoryManager.itemOvenInput = input;
						}
						else
						{
							input.setCount(input.getCount() - 1);
							UiInventoryManager.itemOvenInput = input.clone();
						}
						
						if((tray.getCount() - 1) == 0)
						{
							tray = null;
							UiInventoryManager.itemOvenOutputT = tray;
						}
						else
						{
							tray.setCount(tray.getCount() - 1);
							UiInventoryManager.itemOvenOutputT = tray.clone();
						}
						
						UiInventoryManager.oiOvenSlot.setItem(UiInventoryManager.itemOvenInput);
						UiInventoryManager.ootOvenSlot.setItem(UiInventoryManager.itemOvenOutputT);
						UiInventoryManager.ooOvenSlot.setItem(UiInventoryManager.itemOvenOutput);
					}
					catch(Exception e)
					{ }
					
					process_float = 0;
				}
				
				if(fuel_int == 120)
				{
					smokes.add(new Smoke(this));
				}
				
				if(fuel_int > 239)
				{
					fuel_int = 0;
					
					try
					{
						if((fuel.getCount() - 1) == 0)
						{
							fuel = null;
							UiInventoryManager.itemOvenFuel = fuel;
						}
						else
						{
							fuel.setCount(fuel.getCount() - 1);
							UiInventoryManager.itemOvenFuel = fuel.clone();
						}
						
						UiInventoryManager.ofOvenSlot.setItem(UiInventoryManager.itemOvenFuel);
					}
					catch(Exception e)
					{ }
					
					is_process = false;
				}
			}
			else
			{
				is_process = false;
			}
		}
		else
		{
			fuel_int = 0;
			process_float -= 46f/(240 * 1);
			if(process_float < 0)
			{
				process_float = 0;
			}
		}
	}
}
