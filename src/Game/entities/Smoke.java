package Game.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Smoke extends Entity
{
	private int timer = 0;
	private int super_timer = 0;
	private OvenE oven;
	
	private int x1, y1, x2, y2;
	
	private int alpha = 200;
	
	public boolean is_time = false;
	
	public Smoke(OvenE oven)
	{
		super(null, oven.getX(), oven.getY(), oven.getVx(), oven.getVy(), 32, 32, 2);
		
		this.oven = oven;
		this.x1 = (int) ((Math.random() * (20 - (-20))) + (-20));
		this.y1 = (int) ((Math.random() * (20 - (-20))) + (-20));
		this.x2 = (int) ((Math.random() * (20 - (-20))) + (-20));
		this.y2 = (int) ((Math.random() * (20 - (-20))) + (-20));
	}
	
	@Override
	public void render(Graphics g)
	{	
		Color smoke_color = new Color(150, 150, 150, alpha);
		g.setColor(smoke_color);
		g.fillRect(x + x1, y + y1, 32, 32);
		g.fillRect(x, y, 32, 32);
		g.fillRect(x + x2, y + y2, 32, 32);
	}
	
	@Override
	public void tick()
	{
		x = Vx - virtualSpace.getX();
		y = Vy - virtualSpace.getY();
		
		timer++;
		super_timer++;
		if(timer > 60)
		{	
			Vx += x1;
			Vy += y1;
			timer = 0;
		}
		
		alpha -= super_timer / 200;
		
		if(alpha < 0)
		{
			alpha = 0;
		}
		
		if(super_timer > 900)
		{
			is_time = true;
		}
	}
}
