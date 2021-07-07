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
	
	public Double[][] worldNoises;
	public Double[][] worldMoisture;
	
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
		worldMoisture = new Double[968][968];
		
		this.forest = new Forest();
		this.wetForest = new WetForest();
		this.ocean = new Ocean();
		this.desert = new Desert(); 
	}
	
	public void generate()
	{
		PerlinNoise noise = new PerlinNoise();
		PerlinNoise noiseMoisture = new PerlinNoise();
		
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
					double v = noise.noise(i/2, j/2);
					double moisture = noiseMoisture.noise(i, j);
					
					if(v > 0.55)
					{
						v = 0.0;
					}
					
					worldNoises[i][j] = v;
					worldMoisture[i][j] = moisture;
					
					if(v < 0.1)
					{
						if(moisture < 0.4)
						{
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
							tiles[i][j] = new Dirt(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write(":");
							
						}
						else if(moisture < 0.46)
						{
							tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write("^");
						}
						else if(moisture < 0.7)
						{
							tiles[i][j] = new Grass(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write("+");
						}
						else
						{
							tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write("S");
						}
					}
					else if(v < 0.6)
					{
						tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
						tilesFile.write("^");
					}
					
					
					if(j % 11 == 0 && j != 0)
					{
						chunksValues.write(" ");
					}
					
					/*
					if(v == 0)
					{
						world.write("0");
						chunksValues.write("0");
					}
					else
					{
						world.write(".");
						chunksValues.write(".");
					}//*/
					
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
}
