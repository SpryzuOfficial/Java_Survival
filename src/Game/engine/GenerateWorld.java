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
	
	public static Double[][] worldNoises;
	private Double[][] biomesNoises;
	private Double[][] tempsNoises;
	
	//Biomes
	private Forest forest;
	private WetForest wetForest;
	private Ocean ocean;
	private Desert desert;
	
	public GenerateWorld(int W, int H)
	{
		this.tiles = new Tile[H][W];
		this.sEntities = new ArrayList<StaticEntity>();
		this.animals = new ArrayList<Animal>();
		this.ovens = new ArrayList<OvenE>();
		
		worldNoises = new Double[968][968];
		
		this.biomesNoises = new Double[88][88];
		this.tempsNoises = new Double[968][968];
		
		this.forest = new Forest();
		this.wetForest = new WetForest();
		this.ocean = new Ocean();
		this.desert = new Desert(); 
	}
	
	public void generate()
	{
		PerlinNoise noise = new PerlinNoise();
		PerlinNoise noiseTemp = new PerlinNoise();
		
		try
		{
			FileWriter world = new FileWriter("world.txt");
			FileWriter chunks = new FileWriter("chunks.txt");
			FileWriter biomes = new FileWriter("biomes.txt");
			FileWriter chunksTemp = new FileWriter("chunksTemp.txt");
			FileWriter chunksValues = new FileWriter("chunksV.txt");
			
			for(int i = 0; i < 88; i++)
			{
				for(int j = 0; j < 88; j++)
				{
					double fact = noise.noise(i, j);
					double temp = noiseTemp.noise(i, j);
					
					biomesNoises[i][j] = fact;
					tempsNoises[i][j] = temp;
					
					if(temp < 0.1)
					{
						chunksTemp.write("0");
					}
					else if(temp < 0.2)
					{
						chunksTemp.write("1");
					}
					else if(temp < 0.3)
					{
						chunksTemp.write("2");
					}
					else if(temp < 0.4)
					{
						chunksTemp.write("3");
					}
					else if(temp < 0.5)
					{
						chunksTemp.write("4");
					}
					else if(temp < 0.6)
					{
						chunksTemp.write("5");
					}
					else if(temp < 0.7)
					{
						chunksTemp.write("6");
					}
					else if(temp < 0.8)
					{
						chunksTemp.write("7");
					}
					else if(temp < 0.9)
					{
						chunksTemp.write("8");
					}
					else
					{
						chunksTemp.write("9");
					}
					
					if(fact < 0.4)
					{
						if(temp < 0.5)
						{
							biomes.write("}");
						}
						else if(temp < 0.6)
						{
							biomes.write("/");
						}
						else if(temp < 0.7)
						{
							biomes.write("R");
						}
						else 
						{
							biomes.write("V");
						}
					}
					else if(fact < 0.44)
					{
						biomes.write("_");
					}
					else if(fact > 0.42 && fact < 0.58)
					{
						biomes.write("O");
					}
					else
					{
						if(temp < 0.6)
						{
							biomes.write("M");
						}
						else if(temp < 0.74)
						{
							biomes.write("R");
						}
						else
						{
							biomes.write("V");
						}
					}
					
					if(fact < 0.1)
					{
						chunks.write("0");
					}
					else if(fact < 0.2)
					{
						chunks.write("1");
					}
					else if(fact < 0.3)
					{
						chunks.write("2");
					}
					else if(fact < 0.4)
					{
						chunks.write("3");
					}
					else if(fact < 0.5)
					{
						chunks.write("4");
					}
					else if(fact < 0.6)
					{
						chunks.write("5");
					}
					else if(fact < 0.7)
					{
						chunks.write("6");
					}
					else if(fact < 0.8)
					{
						chunks.write("7");
					}
					else if(fact < 0.9)
					{
						chunks.write("8");
					}
					else
					{
						chunks.write("9");
					}
				}
				chunks.write("\n");
				biomes.write("\n");
				chunksTemp.write("\n");
			}
			
			int x=0, y=0;
			for(int i = 0; i < 968; i++)
			{
				for(int j = 0; j < 968; j++)
				{
					double v = noise.noise(i/5, j/5);
					//double temp = noiseTemp.noise(i/5, j/5);
					
					//tempsNoises[i][j] = temp;
					worldNoises[i][j] = v;
					
					/*
					if(temp < 0.1)
					{
						chunksTemp.write("0");
					}
					else if(temp < 0.2)
					{
						chunksTemp.write("1");
					}
					else if(temp < 0.3)
					{
						chunksTemp.write("2");
					}
					else if(temp < 0.4)
					{
						chunksTemp.write("3");
					}
					else if(temp < 0.5)
					{
						chunksTemp.write("4");
					}
					else if(temp < 0.6)
					{
						chunksTemp.write("5");
					}
					else if(temp < 0.7)
					{
						chunksTemp.write("6");
					}
					else if(temp < 0.8)
					{
						chunksTemp.write("7");
					}
					else if(temp < 0.9)
					{
						chunksTemp.write("8");
					}
					else
					{
						chunksTemp.write("9");
					}
					*/
					
					if(j % 11 == 0 && j != 0)
					{
						chunksValues.write(" ");
					}
					
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
				}
				world.write("\n");
				chunksTemp.write("\n");
				chunksValues.write("\n");
				if(i % 11 == 0 && i != 0)
				{
					chunksValues.write("\n");
				}
			}
			
			world.close();
			chunks.close();
			biomes.close();
			chunksTemp.close();
			chunksValues.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		
		for(int yC = 0; yC < 88; yC++)
		{
			for(int xC = 0; xC < 88; xC++)
			{
				double fact = biomesNoises[yC][xC];
				double temp = tempsNoises[yC][xC];
				
				for(int y = yC * 11; y < ((yC + 1) * 11); y++) 
				{
					for(int x = xC * 11; x < ((xC + 1) * 11); x++)
					{
						double v = worldNoises[y][x];
						
						if(fact < 0.4)
						{
							if(temp < 0.5)
							{
								tiles[y][x] = forest.generateTiles(fact, v, x, y);
								forest.generateEntities(fact, v, x, y);
							}
							else if(temp < 0.6)
							{
								tiles[y][x] = wetForest.generateTiles(fact, v, x, y);
								wetForest.generateEntities(fact, v, x, y);
							}
							else if(temp < 0.7)
							{
								
							}
							else 
							{
								
							}
						}
						else if(fact < 0.44)
						{
							tiles[y][x] = desert.generateTiles(fact, v, x, y);
							desert.generateEntities(fact, v, x, y);
						}
						else if(fact > 0.44 && fact < 0.58)
						{
							tiles[y][x] = ocean.generateTiles(fact, v, x, y);
							ocean.generateEntities(fact, v, x, y);
						}
						else
						{
							if(temp < 0.6)
							{
								tiles[y][x] = desert.generateTiles(fact, v, x, y);
								desert.generateEntities(fact, v, x, y);
							}
							else if(temp < 0.74)
							{
								
							}
							else
							{
								
							}
						}
					}
				}
			}
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
}
