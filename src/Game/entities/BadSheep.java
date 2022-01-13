package Game.entities;

import java.util.Random;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.noise.PerlinNoise;

public class BadSheep extends Animal
{
	private Entity target = null;
	private Random rnd = new Random();
	private int seed;
	
	public BadSheep(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.badSheep, Gx, Gy, Vx, Vy, 4, 20);
		
		this.seed = rnd.nextInt();
	}
	
	@Override
	public void tick()
	{
		if(isOnRange)
		{
			if(isPunched)
			{
				speed = 6;
				punchedTimer = 240;
				
				life -= damage;
				
				isPunched = false;
			}
			else if(punchedTimer <= 0)
			{
				speed = 4;
			}
			
			if(Math.sqrt(Math.pow(Math.abs(Game.player.getVx() - this.Vx), 2) + Math.pow(Math.abs(Game.player.getVy() - this.Vy), 2)) < 256)
			{
				speed = 5;
				target = Game.player;
			}
			else
			{
				target = null;
			}
			
			if(target == null)
			{
				if(punchedTimer > 0 && moveTimer <= 0)
				{
					PerlinNoise noise = new PerlinNoise(this.seed);
					
					int random = (int) (Math.random() * 10000 + 100);
					double v = noise.noise(random*4, random*4);
					
					if(v > 0.0 && v < 0.2)
					{
						dir = 0;
						
						moveTimer = 60;
					}
					else if(v > 0.2 && v < 0.4)
					{
						dir = 180;
						
						moveTimer = 60;
					}
					else if(v > 0.4 && v < 0.6)
					{
						dir = 90;
						
						moveTimer = 60;
					}
					else if(v > 0.6 && v < 0.8)
					{
						dir = 270;
						
						moveTimer = 60;
					}
					else if(v > 0.8 && v < 1)
					{
						dir = 180;
						
						moveTimer = 60;
					}
				}
				
				if(moveTimer <= 0 && pauseTimer <= 0 && punchedTimer <= 0)
				{
					PerlinNoise noise = new PerlinNoise(this.seed);
					
					int random = (int) (Math.random() * 10000 + 100);
					double v = noise.noise(random*3, random*3);
					
					if(v > 0.0 && v < 0.1)
					{
						moveTimer = 0;
						pauseTimer = 90;
					}
					else if(v > 0.1 && v < 0.2)
					{
						dir = 0;
						
						moveTimer = 120;
						pauseTimer = 180;
					}
					else if(v > 0.2 && v < 0.3)
					{
						moveTimer = 0;
						pauseTimer = 90;
					}
					else if(v > 0.3 && v < 0.4)
					{
						dir = 180;
						
						moveTimer = 120;
						pauseTimer = 180;
					}
					else if(v > 0.4 && v < 0.5)
					{
						moveTimer = 0;
						pauseTimer = 90;
					}
					else if(v > 0.5 && v < 0.6)
					{
						dir = 90;
						
						moveTimer = 120;
						pauseTimer = 180;
					}
					else if(v > 0.6 && v < 0.7)
					{
						moveTimer = 0;
						pauseTimer = 90;
					}
					else if(v > 0.7 && v < 0.8)
					{
						dir = 270;
						
						moveTimer = 120;
						pauseTimer = 180;
					}
					else if(v > 0.8 && v < 1)
					{
						moveTimer = 0;
						pauseTimer = 90;
					}
				}
				
				if(moveTimer != 0)
				{
					switch (dir) 
					{
						case 0:
							
							Vy += speed;
							
							break;
						
						case 180:
							
							Vy += -1 * speed;
							
							break;
							
						case 90:
		
							Vx += speed;
							
							break;
							
						case 270:
		
							Vx += -1 * speed;
							
							break;
					}
					
					moveTimer--;
				}
				else
				{
					pauseTimer--;
				}
				
				if(punchedTimer > 0)
				{
					punchedTimer--;
				}
			}
			else
			{
				if(target.Vx > this.Vx)
				{
					this.Vx += speed;
				}
				else if(target.Vx < this.Vx)
				{
					this.Vx -= speed;
				}
				
				if(target.Vy > this.Vy)
				{
					this.Vy += speed;
				}
				else if(target.Vy < this.Vy)
				{
					this.Vy -= speed;
				}
			}
		}
		
		x = Vx - virtualSpace.getX();
		y = Vy - virtualSpace.getY();
	}
}
