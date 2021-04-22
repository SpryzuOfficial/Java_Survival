package Game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.engine.Game;
import Game.positionSpaces.VirtualSpace;
import Game.tiles.Tile;

public class Entity
{
	protected VirtualSpace virtualSpace;
	protected BufferedImage texture;
	protected int x;
	protected int y;
	protected int Vx;
	protected int Vy;
	protected int width;
	protected int height;
	protected int speed;
	
	public Entity(BufferedImage texture, int x, int y, int Vx, int Vy, int width, int height, int speed)
	{
		this.virtualSpace = Game.virtualSpace;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.Vx = Vx;
		this.Vy = Vy;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}

	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		
	}
	
	public BufferedImage getTexture() 
	{
		return texture;
	}

	public void setTexture(BufferedImage texture) 
	{
		this.texture = texture;
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
	
	public int getVx() 
	{
		return Vx;
	}

	public void setVx(int vx) 
	{
		Vx = vx;
	}

	public int getVy() 
	{
		return Vy;
	}

	public void setVy(int vy) 
	{
		Vy = vy;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public int getSpeed() 
	{
		return speed;
	}

	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
}
