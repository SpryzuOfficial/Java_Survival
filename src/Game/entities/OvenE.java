package Game.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import Game.Items.Item;
import Game.Items.Oven;
import Game.engine.CheckOven;
import Game.engine.Game;
import Game.engine.GenerateWorld;
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
	public float fuel_bar = 0;
	public boolean is_process;
	
	public OvenE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.ovenE, Gx, Gy, Vx, Vy, 64, 64, 420, 0, 0, 1);
		
		this.smokes = new ArrayList<Smoke>();
		checkOven = new CheckOven();
		Game.generateWorld.getOvens().add(this);
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
		
		this.items.clear();
		this.items.add(new Oven(1, 0, 576));
		this.items.add(output);
		this.items.add(input);
		this.items.add(tray);
		this.items.add(fuel);
		
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
		
		if(fuel != null)
		{
			if(fuel.getOvenValue() != 0)
			{
				if(checkOven.checkOven(input, tray) != null || is_process)
				{
					boolean band = true;
					if(output != null)
					{
						try
						{
							if(output.getClass() != checkOven.checkOven(input, tray).getClass())
							{
								band = false;
							}
						}
						catch(Exception e)
						{
							band = true;
						}
					}
					
					if(band)
					{	
						is_process = true;
					}
					else
					{
						is_process = false;
					}
				}
				else
				{
					is_process = false;
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
				fuel_bar += 25 / (fuel.getOvenValue() * 1);
				process_float += (48f/(240 * 1)) * (input == null || tray == null ? 0 : 1);
				
				if(process_float > 48)
				{
					try
					{
						if(output == null)
						{
							output = checkOven.checkOven(input, tray).clone();
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenOutput = output.clone();
							}
						}
						else if(output.getClass() == checkOven.checkOven(input, tray).getClass())
						{
							output.setCount(output.getCount() + 1);
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenOutput = output.clone();
							}
						}
						
						if((input.getCount() - 1) == 0)
						{
							input = null;
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenInput = input;
							}
						}
						else
						{
							input.setCount(input.getCount() - 1);
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenInput = input.clone();
							}
						}
						
						if((tray.getCount() - 1) == 0)
						{
							tray = null;
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenOutputT = tray;
							}
						}
						else
						{
							tray.setCount(tray.getCount() - 1);
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenOutputT = tray.clone();
							}
						}
						
						if(UiInventoryManager.oven == this)
						{
							UiInventoryManager.oiOvenSlot.setItem(UiInventoryManager.itemOvenInput);
							UiInventoryManager.ootOvenSlot.setItem(UiInventoryManager.itemOvenOutputT);
							UiInventoryManager.ooOvenSlot.setItem(UiInventoryManager.itemOvenOutput);
						}
					}
					catch(Exception e) {  }
					
					process_float = 0;
				}
				
				if(fuel_int == fuel.getOvenValue() / 2)
				{
					smokes.add(new Smoke(this));
				}
				
				if(fuel_int > fuel.getOvenValue() - 1)
				{
					fuel_int = 0;
					fuel_bar = 0;
					
					try
					{
						if((fuel.getCount() - 1) == 0)
						{
							fuel = null;
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenFuel = fuel;
							}
						}
						else
						{
							fuel.setCount(fuel.getCount() - 1);
							
							if(UiInventoryManager.oven == this)
							{
								UiInventoryManager.itemOvenFuel = fuel.clone();
							}
						}
						
						if(UiInventoryManager.oven == this)
						{
							UiInventoryManager.ofOvenSlot.setItem(UiInventoryManager.itemOvenFuel);
						}
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
			fuel_bar = 0;
			process_float -= 48f/(240 * 1);
			if(process_float < 0)
			{
				process_float = 0;
			}
		}
	}
}
