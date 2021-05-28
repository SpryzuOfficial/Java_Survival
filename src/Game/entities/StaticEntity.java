package Game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Items.Item;

public class StaticEntity extends Entity
{
	protected ArrayList<Item> items;
	protected boolean isMining;
	protected int miningTime;
	protected int pointerOffx;
	protected int pointerOffy;
	protected int type;
	
	public StaticEntity(BufferedImage texture, int Gx, int Gy, int Vx, int Vy, int widht, int height, int miningTime, int pointerOffx, int pointerOffy, int type) 
	{
		super(texture, Gx, Gy, Vx, Vy, widht, height, 0);
		
		this.isMining = false;
		this.miningTime = miningTime;
		this.pointerOffx = pointerOffx;
		this.pointerOffy = pointerOffy;
		this.items = new ArrayList<Item>();
		this.type = type;
	}
	
	@Override
	public void tick()
	{
		x = Vx - virtualSpace.getX();
		y = Vy - virtualSpace.getY();
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public void use()
	{
		
	}
	
	public boolean isMining() 
	{
		return isMining;
	}

	public void setMining(boolean isMining) 
	{
		this.isMining = isMining;
	}

	public int getMiningTime() 
	{
		return miningTime;
	}

	public void setMiningTime(int miningTime) 
	{
		this.miningTime = miningTime;
	}

	public ArrayList<Item> getItems() 
	{
		return items;
	}

	public void setItems(ArrayList<Item> items) 
	{
		this.items = items;
	}

	public int getPointerOffx() 
	{
		return pointerOffx;
	}

	public void setPointerOffx(int pointerOffx) 
	{
		this.pointerOffx = pointerOffx;
	}

	public int getPointerOffy() 
	{
		return pointerOffy;
	}

	public void setPointerOffy(int pointerOffy)
	{
		this.pointerOffy = pointerOffy;
	}

	public int getType() 
	{
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}
}
