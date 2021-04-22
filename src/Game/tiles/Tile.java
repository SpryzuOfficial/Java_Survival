package Game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.engine.Game;
import Game.positionSpaces.VirtualSpace;

public class Tile
{
	protected BufferedImage texture;
	protected VirtualSpace virtualSpace;
	protected int Gx;
	protected int Gy;
	protected int Vx;
	protected int Vy;
	protected int width;
	protected int height;
	
	public Tile(BufferedImage texture, int Vx, int Vy, int Gx, int Gy, int width, int height)
	{
		this.texture = texture;
		this.virtualSpace = Game.virtualSpace;
		this.Vx = Vx;
		this.Vy = Vy;
		this.Gx = Gx;
		this.Gy = Gy;
		this.width = width;
		this.height = height;
	}
	
	public void tick()
	{
		Gx = Vx - virtualSpace.getX();
		Gy = Vy - virtualSpace.getY();
	}
	
	public void render(Graphics g)
	{
		//if(Vx + width > virtualSpace.getX() && Vx < virtualSpace.getX() + virtualSpace.getWidth()
	  		//&& Vy + height > virtualSpace.getY() && Vy < virtualSpace.getY() + virtualSpace.getHeight())
		//{
			g.drawImage(texture, Gx, Gy, width, height, null);
		//}
	}

	public BufferedImage getTexture() 
	{
		return texture;
	}

	public void setTexture(BufferedImage texture) 
	{
		this.texture = texture;
	}

	public int getGx() 
	{
		return Gx;
	}

	public void setGx(int gx)
	{
		Gx = gx;
	}

	public int getGy() 
	{
		return Gy;
	}

	public void setGy(int gy) 
	{
		Gy = gy;
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
}
