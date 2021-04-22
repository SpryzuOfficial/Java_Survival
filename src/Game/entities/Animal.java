package Game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animal extends Entity
{
	protected boolean isOnRange;
	protected boolean isPunched;
	protected int pauseTimer;
	protected int moveTimer;
	protected int punchedTimer;
	protected int dir;
	protected int life;
	protected int type;
	protected int damage;
	
	public Animal(BufferedImage texture, int x, int y, int Vx, int Vy, int speed, int life)
	{
		super(texture, x, y, Vx, Vy, 64, 64, speed);
		
		this.dir = 180;
		this.pauseTimer = 0;
		this.moveTimer = 0;
		this.punchedTimer = 0;
		this.isPunched = false;
		this.isOnRange = false;
		this.life = life;
		this.type = 2;
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, width, height, null);
	}

	public boolean isPunched() 
	{
		return isPunched;
	}

	public void setPunched(boolean isPunched) 
	{
		this.isPunched = isPunched;
	}

	public int getLife() 
	{
		return life;
	}

	public void setLife(int life) 
	{
		this.life = life;
	}

	public boolean isOnRange()
	{
		return isOnRange;
	}

	public void setOnRange(boolean isOnRange) 
	{
		this.isOnRange = isOnRange;
	}

	public int getType() 
	{
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}

	public int getDamage() 
	{
		return damage;
	}

	public void setDamage(int damage) 
	{
		this.damage = damage;
	}
}
