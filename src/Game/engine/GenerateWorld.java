package Game.engine;

import java.util.ArrayList;

import Game.entities.*;
import Game.noise.PerlinNoise;
import Game.tiles.*;

public class GenerateWorld 
{	
	public static int ASIZE = 0;
	public static int SESIZE = 0;
	
	private Tile[][] tiles;
	private ArrayList<Animal> animals;
	private ArrayList<StaticEntity> sEntities;
	
	public GenerateWorld(int W, int H)
	{
		this.tiles = new Tile[H][W];
		this.sEntities = new ArrayList<StaticEntity>();
		this.animals = new ArrayList<Animal>();
	}
	
	public void generate()
	{
		PerlinNoise noise = new PerlinNoise();
		
		for(int yC = 0; yC < 88; yC++)
		{
			for(int xC = 0; xC < 88; xC++)
			{
				double fact = noise.noise(xC, yC);
				
				if(fact < 0.4)
				{
					//"O"
					System.out.print("O");
				}
				else if(fact < 0.5)
				{
					//"D"
					System.out.print("D");
				}
				else
				{
					//"F"
					System.out.print("F");
				}
				
				for(int y = yC * 11; y < ((yC + 1) * 11); y++) 
				{
					for(int x = xC * 11; x < ((xC + 1) * 11); x++)
					{
						double v = noise.noise(x, y);
						
						if(fact < 0.4)
						{
							if(v < 0.4)
							{
								tiles[y][x] = new Water(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							else if(v < 0.5)
							{
								tiles[y][x] = new Sand(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							else
							{
								tiles[y][x] = new Water(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							
							if(v > 0.4 && v < 0.5)
							{
								int entityX = x * 64;
								int entityY = y * 64;
								
								if(entityX + 64 > Game.player.getVx() && entityX < Game.player.getVx() + Game.player.getWidth()
								   && entityY + 64 > Game.player.getVy() && entityY < Game.player.getVy() + Game.player.getHeight())
								{
									continue;
								}
								else
								{
									if(v > 0.4 && v < 0.5)
									{
										if((int) (Math.random() * (10 - 1 + 1) + 1) == 1)
										{
											sEntities.add(new Rock(entityX, entityY, entityX - Game.virtualSpace.getX(), entityY - Game.virtualSpace.getY()));
											SESIZE++;
										}
									}
								}
							}
						}
						else if(fact < 0.5)
						{
							if(v < 0.4)
							{
								tiles[y][x] = new Water(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							else
							{
								tiles[y][x] = new Sand(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							
							if(v > 0.4 && v < 1)
							{
								int entityX = x * 64;
								int entityY = y * 64;
								
								if(entityX + 64 > Game.player.getVx() && entityX < Game.player.getVx() + Game.player.getWidth()
								   && entityY + 64 > Game.player.getVy() && entityY < Game.player.getVy() + Game.player.getHeight())
								{
									continue;
								}
								else
								{
									if(v > 0.4 && v < 0.9)
									{
										if((int) (Math.random() * (10 - 1 + 1) + 1) == 1)
										{
											sEntities.add(new Rock(entityX, entityY, entityX - Game.virtualSpace.getX(), entityY - Game.virtualSpace.getY()));
											SESIZE++;
										}
									}
								}
							}
						}
						else
						{
							if(v < 0.4)
							{
								tiles[y][x] = new Water(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							else if(v < 0.5)
							{
								tiles[y][x] = new Sand(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							else
							{
								tiles[y][x] = new Grass(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
							}
							
							if(v > 0.4 && v < 1)
							{
								int entityX = x * 64;
								int entityY = y * 64;
								
								if(entityX + 64 > Game.player.getVx() && entityX < Game.player.getVx() + Game.player.getWidth()
								   && entityY + 64 > Game.player.getVy() && entityY < Game.player.getVy() + Game.player.getHeight())
								{
									continue;
								}
								else
								{
									if(v > 0.6 && v < 0.9)
									{
										if(!(v > 0.6 && v < 0.62))
										{
											if(!(v > 0.65 && v < 0.75))
											{
												if(!(v > 0.78 && v < 0.8))
												{
													sEntities.add(new Tree(entityX, entityY, entityX - Game.virtualSpace.getX(), entityY - Game.virtualSpace.getY()));
													SESIZE++;
												}
											}
										}
									}
									else if(v > 0.48 && v < 0.5)
									{
										//if((int) (Math.random() * (10 - 1 + 1) + 1) == 1)
										//{
											sEntities.add(new Rock(entityX, entityY, entityX - Game.virtualSpace.getX(), entityY - Game.virtualSpace.getY()));
											SESIZE++;
										//}
									}
									
									if(v > 0.6 && v < 0.605)
									{
										//if((int) (Math.random() * (100 - 1 + 1) + 1) == 1)
										//{
											animals.add(new Sheep(entityX, entityY, entityX - Game.virtualSpace.getX(), entityY - Game.virtualSpace.getY()));
											ASIZE++;
										//}
									}
								}
							}
						}
					}
				}
			}
			System.out.println("");
		}
		
		System.out.println(ASIZE);
	}
	
	public Tile[][] getTiles()
	{
		return tiles;
	}
	
	public Tile getFromTile(int i, int j)
	{
		return tiles[i][j];
	}
	
	public ArrayList<StaticEntity> getSEntities()
	{
		return sEntities;
	}
	
	public StaticEntity getFromSEntities(int i)
	{
		return sEntities.get(i);
	}
	
	public ArrayList<Animal> getAnimals()
	{
		return animals;
	}
	
	public Animal getFromAnimals(int i)
	{
		return animals.get(i);
	}
}
