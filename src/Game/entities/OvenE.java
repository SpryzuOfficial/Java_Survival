package Game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Game.Items.Item;
import Game.Items.Oven;
import Game.engine.gfx.Assets;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;

public class OvenE extends StaticEntity
{	
	private ArrayList<Smoke> smokes;
	
	public Item fuel;
	public Item tray;
	public Item input;
	public Item process;
	
	public int fuel_int = 0;
	public float process_float = 0;
	public boolean is_process;
	
	public OvenE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.ovenE, Gx, Gy, Vx, Vy, 64, 64, 420, 0, 0, 1);
		
		this.items.add(new Oven(1, 0, 576));
		
		this.smokes = new ArrayList<Smoke>();
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
			if(fuel_int == 0)
			{
				smokes.add(new Smoke(this));
			}
			
			fuel_int++;
			process_float += 48f/(240 * fuel.getOvenValue());
			
			if(process_float > 48)
			{
				process_float = 0;
			}
			
			if(fuel_int == 120)
			{
				smokes.add(new Smoke(this));
			}
			
			if(fuel_int > 240)
			{
				fuel_int = 0;
				fuel = null;
				is_process = false;
			}
		}
		else
		{
			process_float -= 46f/(240 * 1);
			if(process_float < 0)
			{
				process_float = 0;
			}
		}
	}
}
