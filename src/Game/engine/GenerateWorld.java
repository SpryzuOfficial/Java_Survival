package Game.engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import Game.biomes.*;
import Game.entities.*;
import Game.noise.PerlinNoise;
import Game.noise.PerlinNoiseGenerator;
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
	public int[][] temperature;
	
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
		temperature = new int[968][968];
		
		this.forest = new Forest();
		this.wetForest = new WetForest();
		this.ocean = new Ocean();
		this.desert = new Desert(); 
	}
	
	public void generate()
	{
		PerlinNoiseGenerator noise = new PerlinNoiseGenerator();
		PerlinNoiseGenerator noiseMoisture = new PerlinNoiseGenerator();
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
			
			int px[], py[], cells = 20, size = 968;
			int color[];
			int n = 0;
			Random rand = new Random();
			BufferedImage I = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
			px = new int[cells];
			py = new int[cells];
			color = new int[cells];
			
			for (int k = 0; k < cells; k++) 
			{
				px[k] = rand.nextInt(size);
				py[k] = rand.nextInt(size);
				color[k] = rand.nextInt(100);
			}
			
			for (int x = 0; x < size; x++) 
			{
				for (int y = 0; y < size; y++) 
				{
					n = 0;
					for (byte k = 0; k < cells; k++) 
					{
						if (distanceV(px[k], x, py[k], y) < distanceV(px[n], x, py[n], y)) 
						{
							n = k;
						}
					}
					if(color[n] < 20)
					{
						I.setRGB(x, y, Color.BLUE.getRGB());
						temperature[y][x] = 0;
					}
					else if(color[n] < 40)
					{
						I.setRGB(x, y, Color.CYAN.getRGB());
						temperature[y][x] = 1;
					}
					else if(color[n] < 60)
					{
						I.setRGB(x, y, Color.GREEN.getRGB());
						temperature[y][x] = 2;
					}
					else if(color[n] < 70)
					{
						I.setRGB(x, y, Color.GRAY.getRGB());
						temperature[y][x] = 3;
					}
					else if(color[n] < 80)
					{
						I.setRGB(x, y, Color.ORANGE.getRGB());
						temperature[y][x] = 4;
					}
					else
					{
						I.setRGB(x, y, Color.RED.getRGB());
						temperature[y][x] = 5;
					}
				}
			}
			
			for(int k = 0; k < cells; k++)
			{
				System.out.println(color[k]);
			}
			
			Graphics2D g = I.createGraphics();
			g.setColor(Color.BLACK);
			for (int i = 0; i < cells; i++) 
			{
				g.fill(new Ellipse2D .Double(px[i] - 2.5, py[i] - 2.5, 5, 5));
			}
			
			ImageIO.write(I, "png", new File("voronoi.png"));
			
			for(int i = 0; i < 968; i++)
			{
				for(int j = 0; j < 968; j++)
				{
					double v = noise.turbulence2(i/120.6f, j/120.6f, 18.3f);
					//double moisture = noiseMoisture.turbulence2(i*0.002f, j*0.002f, 0.38f);
					
					float c = 0.5f;
					float f = 0.6f;
					
					float a = 0.4f;
					
					float[] w = new float[] {0.99f, 0.995f, 1f, 1.05f, 1.01f, 1.015f, 1.02f, 1.025f};
					
					double moisture = (w[0] * (noiseMoisture.turbulence2( 0.014f * i,  0.01f * j, a)/f + c)
					           + w[1] * (noiseMoisture.turbulence2( 0.012f * i,  0.002f * j, a)/f + c)
					           + w[2] * (noiseMoisture.turbulence2( 0.010f * i,  0.004f * j, a)/f + c)
					           + w[3] * (noiseMoisture.turbulence2( 0.008f * i,  0.006f * j, a)/f + c)
					           + w[4] * (noiseMoisture.turbulence2(0.006f * i, 0.008f * j, a)/f + c)
					           + w[5] * (noiseMoisture.turbulence2(0.004f * i, 0.010f * j, a)/f + c)
					           + w[6] * (noiseMoisture.turbulence2(0.002f * i, 0.012f * j, a)/f + c)
					           + w[7] * (noiseMoisture.turbulence2(0.01f * i, 0.014f * j, a)/f + c));
					moisture /= (w[0] + w[1] + w[2] + w[3] + w[4] + w[5] + w[6] + w[7]);
					
					worldNoises[i][j] = v;
					worldMoisture[i][j] = moisture;
					
					if((i >= 71 && j >= 71) && (i <= 904 && j <= 904))
					{
						if(v < 0.1)
						{
							tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write("W");
						}
						else if(v < 1)
						{
							if(temperature[i][j] == 0)
							{
								if(v < 0.2)
								{
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("^");
								}
								else if(v < 0.5)
								{
									tiles[i][j] = new Dirt(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("$");
								}
								else
								{
									tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("W");
								}
							}
							else if(temperature[i][j] == 1)
							{
								if(v < 0.2)
								{
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("^");
								}
								else
								{
									tiles[i][j] = new Dirt(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("$");
								}
							}
							else if(temperature[i][j] == 2)
							{
								if(v < 0.2)
								{
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("^");
								}
								else if(v < 0.4)
								{
									tiles[i][j] = new Grass(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("G");
								}
								else
								{
									tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("+");
								}
							}
							else if(temperature[i][j] == 3)
							{
								if(v < 0.2)
								{
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("^");
								}
								else
								{
									tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("+");
								}
							}
							else if(temperature[i][j] == 4)
							{
								tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
								tilesFile.write("^");
							}
							else if(temperature[i][j] == 5)
							{
								if(v < 0.2)
								{
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("^");
								}
								else if(v < 0.3)
								{
									tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("+");
								}
								else
								{
									tiles[i][j] = new Magma(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									tilesFile.write("*");
								}
							}
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
						chunksMoisture.write("-");
					}
					else if(moisture < 0.3)
					{
						chunksMoisture.write("-");
					}
					else if(moisture < 0.4)
					{
						chunksMoisture.write("-");
					}
					else if(moisture < 0.5)
					{
						chunksMoisture.write(".");
					}
					else if(moisture < 0.6)
					{
						chunksMoisture.write(".");
					}
					else if(moisture < 0.7)
					{
						chunksMoisture.write(".");
					}
					else if(moisture < 0.8)
					{
						chunksMoisture.write("^");
					}
					else if(moisture < 0.9)
					{
						chunksMoisture.write("^");
					}
					else
					{
						chunksMoisture.write("^");
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
	
	static double distanceV(int x1, int x2, int y1, int y2) 
	{
		double d;
		d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); // Euclidian
	//  d = Math.abs(x1 - x2) + Math.abs(y1 - y2); // Manhattan
	//	d = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), (1 / p)); // Minkovski
	  	return d;
	}
}
