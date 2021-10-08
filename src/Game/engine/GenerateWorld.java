package Game.engine;

import java.io.FileWriter;
import java.util.ArrayList;

import Game.biomes.*;
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
	private ArrayList<OvenE> ovens;
	private ArrayList<ChestE> chests;
	
	public Double[][] worldNoises;
	public Double[][] worldMoisture;
	public Double[][] blueNoise;
	
	//Biomes
	private Forest forest;
	private WetForest wetForest;
	private Ocean ocean;
	private Desert desert;
	
	private boolean istickocuped = false;
	
	public GenerateWorld(int W, int H)
	{
		this.tiles = new Tile[H][W];
		this.sEntities = new ArrayList<StaticEntity>();
		this.animals = new ArrayList<Animal>();
		this.ovens = new ArrayList<OvenE>();
		this.chests = new ArrayList<ChestE>();
		
		worldNoises = new Double[968][968];
		worldMoisture = new Double[968][968];
		blueNoise = new Double[968][968];
		
		this.forest = new Forest();
		this.wetForest = new WetForest();
		this.ocean = new Ocean();
		this.desert = new Desert(); 
	}
	
	public void generate()
	{
		PerlinNoise noise = new PerlinNoise();
		PerlinNoise noiseMoisture = new PerlinNoise();
		PerlinNoise bluenoise = new PerlinNoise();
		
		try
		{
			FileWriter world = new FileWriter("world.txt");
			FileWriter chunksValues = new FileWriter("chunksV.txt");
			FileWriter chunksMoisture = new FileWriter("chunksM.txt");
			FileWriter tilesFile = new FileWriter("tiles.txt");
			
			for(int i = 0; i < 968; i++)
			{
				for(int j = 0; j < 968; j++)
				{
					blueNoise[i][j] = bluenoise.noise(50*i, 50*j);
				}
			}
			
			for(int i = 0; i < 968; i++)
			{
				for(int j = 0; j < 968; j++)
				{
					double v = noise.noise(i/3, j/3);
					double moisture = noiseMoisture.noise(i/6, j/6);
					
					if(v > 0.6)
					{
						v = 0.0;
					}
					
					worldNoises[i][j] = v;
					worldMoisture[i][j] = moisture;
					
					if((i >= 71 && j >= 71) && (i <= 904 && j <= 904))
					{
						if(v < 0.1)
						{
							if(moisture < 0.4)
							{
								if(generateEntitiesByR(i, j, 5) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new IronOreE((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 4) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new BasaltE((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 3) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Rock((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("S");
							}
							else
							{
								tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("W");
							}
						}
						else if(v < 0.5)
						{
							if(moisture < 0.42)
							{
								if(generateEntitiesByR(i, j, 13) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new MushroomBlueE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 9) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new MushroomRedE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 4) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new ClayE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 1) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Tree(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								tiles[i][j] = new Dirt(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write(":");
								
							}
							else if(moisture < 0.46)
							{
								if(generateEntitiesByR(i, j, 3) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Rock(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("^");
							}
							else if(moisture < 0.7)
							{
								if(generateEntitiesByR(i, j, 9) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Plant(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 7) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new FruitBush(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 5) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Rock(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 4) && !istickocuped)
								{
									istickocuped = true;
									animals.add(new Sheep(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									ASIZE++;
									tilesFile.write("X");
								}
								else
								{
									tilesFile.write("+");
								}
								
								if(generateEntitiesByR(i, j, 2) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Tree(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								tiles[i][j] = new Grass(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								
							}
							else if(moisture < 0.72)
							{
								tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("^");
							}
							else if(moisture < 0.76)
							{
								tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("-");
							}
							else if(moisture < 0.77)
							{
								tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("W");
							}
							else if(moisture < 0.85)
							{
								tiles[i][j] = new Magma(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("_");
							}
							else
							{
								if(generateEntitiesByR(i, j, 5) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new IronOreE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 4) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new BasaltE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								if(generateEntitiesByR(i, j, 3) && !istickocuped)
								{
									istickocuped = true;
									sEntities.add(new Rock(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
									SESIZE++;
								}
								
								tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("S");
							}
						}
						else if(v < 0.6)
						{
							if(generateEntitiesByR(i, j, 4) && !istickocuped)
							{
								istickocuped = true;
								sEntities.add(new Rock(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
								SESIZE++;
							}
							
							if(generateEntitiesByR(i, j, 2) && !istickocuped)
							{
								istickocuped = true;
								sEntities.add(new BasaltE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
								SESIZE++;
							}
							
							if(generateEntitiesByR(i, j, 2) && !istickocuped)
							{
								istickocuped = true;
								sEntities.add(new IronOreE(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
								SESIZE++;
							}
							
							tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write("^");
						}
					}
					else
					{
						sEntities.add(new Rock(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
						SESIZE++;
						
						tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
						tilesFile.write("R");
					}
					
					if(j % 11 == 0 && j != 0)
					{
						chunksValues.write(" ");
					}
					
					///*
					if(v < 0.1)
					{
						world.write("0");
						chunksValues.write("0");
					}
					else if(v < 0.2)
					{
						world.write("1");
						chunksValues.write("1");
					}
					else if(v < 0.3)
					{
						world.write("2");
						chunksValues.write("2");
					}
					else if(v < 0.4)
					{
						world.write("3");
						chunksValues.write("3");
					}
					else if(v < 0.5)
					{
						world.write("4");
						chunksValues.write("4");
					}
					else if(v < 0.6)
					{
						world.write("5");
						chunksValues.write("5");
					}
					else if(v < 0.7)
					{
						world.write("6");
						chunksValues.write("6");
					}
					else if(v < 0.8)
					{
						world.write("7");
						chunksValues.write("7");
					}
					else if(v < 0.9)
					{
						world.write("8");
						chunksValues.write("8");
					}
					else
					{
						world.write("9");
						chunksValues.write("9");
					}
					//*/
					
					if(moisture < 0.1)
					{
						chunksMoisture.write("0");
					}
					else if(moisture < 0.2)
					{
						chunksMoisture.write("1");
					}
					else if(moisture < 0.3)
					{
						chunksMoisture.write("2");
					}
					else if(moisture < 0.4)
					{
						chunksMoisture.write("3");
					}
					else if(moisture < 0.5)
					{
						chunksMoisture.write("4");
					}
					else if(moisture < 0.6)
					{
						chunksMoisture.write("5");
					}
					else if(moisture < 0.7)
					{
						chunksMoisture.write("6");
					}
					else if(moisture < 0.8)
					{
						chunksMoisture.write("7");
					}
					else if(moisture < 0.9)
					{
						chunksMoisture.write("8");
					}
					else
					{
						chunksMoisture.write("9");
					}
					
					istickocuped = false;
				}
				world.write("\n");
				chunksValues.write("\n");
				chunksMoisture.write("\n");
				tilesFile.write("\n");
				if(i % 11 == 0 && i != 0)
				{
					chunksValues.write("\n");
				}
			}
			
			world.close();
			chunksValues.close();
			chunksMoisture.close();
			tilesFile.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
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
	
	public ArrayList<OvenE> getOvens()
	{
		return ovens;
	}
	
	public OvenE getFromOven(int i)
	{
		return ovens.get(i);
	}
	
	public ArrayList<ChestE> getChests()
	{
		return chests;
	}
	
	public ChestE getFromChest(int i)
	{
		return chests.get(i);
	}
	
	public boolean generateEntitiesByR(int i, int j, int R)
	{
		if(i != 484 || j != 484)
		{
			double max = 0;
			for (int y = i - R; y <= i + R; y++) 
			{
				for (int x = j - R; x <= j + R; x++) 
				{
					if (0 <= y && y < 968 && 0 <= x && x < 968) 
					{
						double e = blueNoise[y][x];
						if (e > max) 
						{
							max = e; 
						}
					}
				}
			}
			
			if (Math.abs(blueNoise[i][j] - max) < (max * Math.random() * 0.03))
			{
				return true;
		    }
		}
		
		return false;
	}
}
