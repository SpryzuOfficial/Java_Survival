package Game.entities;

import Game.engine.gfx.Assets;
import Game.noise.PerlinNoise;

public class Sheep extends Animal
{
	public Sheep(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.cow, Gx, Gy, Vx, Vy, 2, 10);
	}
	
	@Override
	public void tick()
	{
		if(isOnRange)
		{
			if(isPunched)
			{
				speed = 5;
				punchedTimer = 240;
				
				life -= damage;
				
				isPunched = false;
			}
			else if(punchedTimer <= 0)
			{
				speed = 2;
			}
			
			if(punchedTimer > 0 && moveTimer <= 0)
			{
				PerlinNoise noise = new PerlinNoise();
				
				int random = (int) (Math.random() * 10000 + 100);
				double v = noise.noise(random, random);
				
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
				PerlinNoise noise = new PerlinNoise();
				
				int random = (int) (Math.random() * 10000 + 100);
				double v = noise.noise(random, random);
				
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
						
						Vy += Math.cos(dir) * speed;
						
						break;
					
					case 180:
						
						Vy += Math.cos(dir) * speed;
						
						break;
						
					case 90:
	
						Vx += Math.sin(dir) * speed;
						
						break;
						
					case 270:
	
						Vx += Math.sin(dir) * speed;
						
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
		
		x = Vx - virtualSpace.getX();
		y = Vy - virtualSpace.getY();
	}
}
