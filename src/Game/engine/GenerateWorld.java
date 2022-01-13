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

import Game.Items.Item;
import Game.entities.*;
import Game.noise.PerlinNoise;
import Game.noise.PerlinNoiseGenerator;
import Game.tiles.*;

public class GenerateWorld
{	
	public static BufferedImage WorldImage;
	public static int ASIZE = 0;
	public static int SESIZE = 0;
	
	private Tile[][] tiles;
	private ArrayList<Animal> animals;
	private ArrayList<StaticEntity> sEntities;
	private ArrayList<OvenE> ovens;
	private ArrayList<ChestE> chests;
	private ArrayList<Item> items;
	
	public Double[][] worldNoises;
	public Double[][] worldMoisture;
	public Double[][] blueNoise;
	public int[][] temperature;
	
	private boolean istickocuped = false;
	
	private Random random_blue;
	
	public GenerateWorld()
	{
		this.tiles = new Tile[Game.WORLD_SIZE][Game.WORLD_SIZE];
		this.sEntities = new ArrayList<StaticEntity>();
		this.animals = new ArrayList<Animal>();
		this.ovens = new ArrayList<OvenE>();
		this.chests = new ArrayList<ChestE>();
		this.items = new ArrayList<Item>();
		
		worldNoises = new Double[Game.WORLD_SIZE][Game.WORLD_SIZE];
		worldMoisture = new Double[Game.WORLD_SIZE][Game.WORLD_SIZE];
		blueNoise = new Double[Game.WORLD_SIZE][Game.WORLD_SIZE];
		temperature = new int[Game.WORLD_SIZE][Game.WORLD_SIZE];
	}
	
	public void generate()
	{
		//int seed = new Random().nextInt();
		int seed = 666;
		
		System.out.println(seed);
		
		random_blue = new Random(seed);
		PerlinNoiseGenerator noise = new PerlinNoiseGenerator(seed);
		PerlinNoiseGenerator noiseMoisture = new PerlinNoiseGenerator(seed);
		PerlinNoise bluenoise = new PerlinNoise(seed);
		
		try
		{
			FileWriter world = new FileWriter("world.txt");
			FileWriter chunksValues = new FileWriter("chunksV.txt");
			FileWriter chunksMoisture = new FileWriter("chunksM.txt");
			FileWriter tilesFile = new FileWriter("tiles.txt");
			FileWriter blueNoiseFile = new FileWriter("blue.txt");
			
			for(int i = 0; i < Game.WORLD_SIZE; i++)
			{
				for(int j = 0; j < Game.WORLD_SIZE; j++)
				{
					blueNoise[i][j] = bluenoise.noise(50 * i, 50 * j);
					double b = blueNoise[i][j];
					
					if(b < 0.1)
					{
						blueNoiseFile.write("/");
					}
					else if(b < 0.2)
					{
						blueNoiseFile.write("1");
					}
					else if(b < 0.3)
					{
						blueNoiseFile.write("2");
					}
					else if(b < 0.4)
					{
						blueNoiseFile.write("3");
					}
					else if(b < 0.5)
					{
						blueNoiseFile.write("4");
					}
					else if(b < 0.6)
					{
						blueNoiseFile.write("5");
					}
					else if(b < 0.7)
					{
						blueNoiseFile.write("6");
					}
					else if(b < 0.8)
					{
						blueNoiseFile.write("7");
					}
					else if(b < 0.9)
					{
						blueNoiseFile.write("8");
					}
					else
					{
						blueNoiseFile.write("9");
					}
				}
				blueNoiseFile.write("\n");
			}
			blueNoiseFile.close();
			
			int px[], py[], cells = 60;
			int color[];
			int n = 0;
			Random rand = new Random(seed);
			BufferedImage I = new BufferedImage(Game.WORLD_SIZE, Game.WORLD_SIZE, BufferedImage.TYPE_INT_RGB);
			px = new int[cells];
			py = new int[cells];
			color = new int[cells];
			
			for (int k = 0; k < cells; k++) 
			{
				px[k] = rand.nextInt(Game.WORLD_SIZE);
				py[k] = rand.nextInt(Game.WORLD_SIZE);
				color[k] = (int)((k / (float) cells) * 100);
			}
			
			for (int x = 0; x < Game.WORLD_SIZE; x++) 
			{
				for (int y = 0; y < Game.WORLD_SIZE; y++)
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
			
			Graphics2D g = I.createGraphics();
			g.setColor(Color.BLACK);
			for (int i = 0; i < cells; i++) 
			{
				g.fill(new Ellipse2D .Double(px[i] - 2.5, py[i] - 2.5, 5, 5));
			}
			
			ImageIO.write(I, "png", new File("voronoi.png"));
			
			for(int i = 0; i < Game.WORLD_SIZE; i++)
			{
				for(int j = 0; j < Game.WORLD_SIZE; j++)
				{
					double v = noise.turbulence2(i/120.6f, j/120.6f, 18.3f);
					//double moisture = noiseMoisture.turbulence2(i*0.002f, j*0.002f, 0.38f);
					
					float c = 0.36f;
					float f = 0.88f;
					
					float a = 0.35f;
					
					float[] w = new float[] {1f, 1f, 1f, 1f, 1f, 1f};
					
					double moisture = (w[0] * (noiseMoisture.turbulence2( 0.001f * i,  0.001f * j, a)/f + c)
					           + w[1] * (noiseMoisture.turbulence2( 0.002f * i,  0.002f * j, a)/f + c)
					           + w[2] * (noiseMoisture.turbulence2( 0.004f * i,  0.004f * j, a)/f + c)
					           + w[3] * (noiseMoisture.turbulence2( 0.008f * i,  0.008f * j, a)/f + c)
					           + w[4] * (noiseMoisture.turbulence2(0.016f * i, 0.016f * j, a)/f + c)
					           + w[5] * (noiseMoisture.turbulence2(0.032f * i, 0.032f * j, a)/f + c));
					moisture /= (w[0] + w[1] + w[2] + w[3] + w[4] + w[5]);
					
					worldNoises[i][j] = v;
					worldMoisture[i][j] = moisture;
				}
			}
			
			WorldImage = new BufferedImage(Game.WORLD_SIZE, Game.WORLD_SIZE, BufferedImage.TYPE_INT_RGB);
			for(int i = 0; i < Game.WORLD_SIZE; i++)
			{
				for(int j = 0; j < Game.WORLD_SIZE; j++)
				{
					double v = worldNoises[i][j];
					double moisture = worldMoisture[i][j];
					
					if((i >= 71 && j >= 71) && (i <= Game.WORLD_SIZE-64 && j <= Game.WORLD_SIZE-64))
					{
						if(v < 0.1)
						{
							tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							WorldImage.setRGB(j, i, Color.BLUE.getRGB());
							tilesFile.write("W");
						}
						else if(v < 1)
						{
							if(temperature[i][j] == 0)
							{
								if(moisture < 0.4)
								{
									if(v < 0.1)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else if(v < 0.5)
									{
										tiles[i][j] = new Snow(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.WHITE.getRGB());
										tilesFile.write("_");
									}
									else
									{
										tiles[i][j] = new Ice(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.CYAN.getRGB());
										tilesFile.write("I");
									}
								}
								else if(moisture < 0.7)
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else if(v < 0.5)
									{
										generateWetForestEntities(j, i);
										
										tiles[i][j] = new Dirt(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.GRAY.getRGB());
										tilesFile.write("$");
									}
									else
									{
										tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.BLUE.getRGB());
										tilesFile.write("W");
									}
								}
								else
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
								}
							}
							else if(temperature[i][j] == 1)
							{
								if(moisture < 0.4)
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else
									{
										generateWetForestEntities(j, i);
										
										tiles[i][j] = new Dirt(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.GRAY.getRGB());
										tilesFile.write("$");
									}
								}
								else if(moisture < 0.7)
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else if(v < 0.4)
									{
										generateForestEntities(j, i);
										
										tiles[i][j] = new Grass(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.GREEN.getRGB());
										tilesFile.write("G");
									}
									else
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
								}
								else
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else
									{
										generateForestEntities(j, i);
										
										tiles[i][j] = new Grass(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.GREEN.getRGB());
										tilesFile.write("G");
									}
								}
							}
							else if(temperature[i][j] == 2)
							{
								if(moisture < 0.7)
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else if(v < 0.4)
									{
										generateForestEntities(j, i);
										
										tiles[i][j] = new Grass(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.GREEN.getRGB());
										tilesFile.write("G");
									}
									else
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
								}
								else
								{
									generateDesertEntities(j, i);
									
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
									tilesFile.write("^");
								}
							}
							else if(temperature[i][j] == 3)
							{
								if(moisture < 0.7)
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
								}
								else
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else if(v < 0.3)
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
									else
									{
										tiles[i][j] = new Magma(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.RED.getRGB());
										tilesFile.write("*");
									}
								}
							}
							else if(temperature[i][j] == 4)
							{
								if(moisture < 0.5)
								{
									generateDesertEntities(j, i);
									
									tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
									WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
									tilesFile.write("^");
								}
								else
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
								}
							}
							else if(temperature[i][j] == 5)
							{
								if(moisture < 0.7)
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else if(v < 0.3)
									{
										generateRockEntities(j, i);									
										tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.DARK_GRAY.getRGB());
										tilesFile.write("+");
									}
									else
									{
										tiles[i][j] = new Magma(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.RED.getRGB());
										tilesFile.write("*");
									}
								}
								else
								{
									if(v < 0.2)
									{
										generateEdgeEntities(j, i);
										
										tiles[i][j] = new Sand(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
										WorldImage.setRGB(j, i, Color.ORANGE.getRGB());
										tilesFile.write("^");
									}
									else
									{
										if(v < 0.5)
										{
											if(v > 0.48)
											{
												istickocuped = true;
												sEntities.add(new ObsidianWall((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY()));
												SESIZE++;
												
												tiles[i][j] = new ObsidianRocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
												WorldImage.setRGB(j, i, Color.BLACK.getRGB());
												tilesFile.write("?");
											}
											else
											{
												tiles[i][j] = new Magma(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
												WorldImage.setRGB(j, i, Color.RED.getRGB());
												tilesFile.write("*");
											}
										}
										else
										{
											tiles[i][j] = new Water(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
											WorldImage.setRGB(j, i, Color.BLUE.getRGB());
											tilesFile.write("W");
										}
									}
								}
							}
						}
					}
					else
					{
						sEntities.add(new SuperRock(j*64, i*64, j*64 - Game.virtualSpace.getX(), i*64 - Game.virtualSpace.getY()));
						SESIZE++;
						
						tiles[i][j] = new Rocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
						WorldImage.setRGB(j, i, Color.BLACK.getRGB());
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
			
			int world_size = Game.WORLD_SIZE / 16;
			int n_structures = (int) (Math.pow(world_size, 2) / 4);
			int[] structure_x = new int[n_structures], structure_y = new int[n_structures];
			Random rand_structure = new Random(seed);
			
			System.out.println(n_structures);
			
			Graphics2D structures_g = WorldImage.createGraphics();
			structures_g.setColor(Color.MAGENTA);
			
			for(int i = 0; i < n_structures; i++)
			{
				structure_x[i] = rand_structure.nextInt(world_size);
				structure_y[i] = rand_structure.nextInt(world_size);
			}
			
			for(int i = 0; i < n_structures; i++)
			{
				int sY = (structure_y[i] * 16);
				int sX = (structure_x[i] * 16);
				if(tiles[sY + 8][sX + 8] instanceof Sand)
				{
					int n_chunks = rand_structure.nextInt(12) * 2;
					
					if(n_chunks > 0)
					{
						int bad_chunks = 0;
						for(int k = 0; k < 4; k++)
						{
							boolean band = true;
							
							int sYM = sY;
							int sXM = sX;
							
							switch(k)
							{
								case 0:
									sYM += 16;
									break;
								case 1:
									sXM += 16;
									break;
								case 2:
									sYM -= 16;
									break;
								case 3:
									sXM -= 16;
									break;
							}
							
							for(int y = sYM; y < sYM + 16; y++)
							{
								for(int x = sXM; x < sXM + 16; x++)
								{
									if(!(tiles[sYM][sXM] instanceof Sand))
									{
										band = false;
										bad_chunks++;
										break;
									}
								}
								
								if(!band)
								{
									break;
								}
							}
						}
						
						if(bad_chunks < 2)
						{
							generateStructure(sY, sX);
							
							int new_room = rand_structure.nextInt(1) + 1;
							
							for(int k = 0; k < 4; k++)
							{
								if(new_room != 0)
								{
									if(rand_structure.nextInt(1) == 0 || (k - 3) == new_room)
									{
										int sYM = sY;
										int sXM = sX;
										
										switch(k)
										{
											case 0:
												sYM += 16;
												break;
											case 1:
												sXM += 16;
												break;
											case 2:
												sYM -= 16;
												break;
											case 3:
												sXM -= 16;
												break;
										}
										
										int tiles_c = 0;
										for(int y = sYM; y < sYM + 16; y++)
										{
											for(int x = sXM; x < sXM + 16; x++)
											{
												if(tiles[sYM][sXM] instanceof Sand)
												{
													tiles_c++;
												}
											}
										}
										
										if((256 - tiles_c) < 65)
										{
											generateStructure(sYM, sXM);
											new_room--;
										}
									}
								}
							}
							
							//structures_g.fill(new Ellipse2D .Double(((structure_x[i] * 16) + 8) - 2.5, ((structure_y[i] * 16) + 8) - 2.5, 5, 5));
						}
					}
				}
			}
			
			world.close();
			chunksValues.close();
			chunksMoisture.close();
			tilesFile.close();
			ImageIO.write(WorldImage, "png", new File("world.png"));
			
			for(int i = 0; i < Game.WORLD_SIZE; i++)
			{
				for(int j = 0; j < Game.WORLD_SIZE; j++)
				{
					try
					{
						generateCustomeBiomeEdges(j, i, new Rocks(0, 0, 0, 0, 64, 64), new Magma(0, 0, 0, 0, 64, 64), new BasaltE((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY()));
						generateCustomeBiomeEdges(j, i, new Grass(0, 0, 0, 0, 64, 64), new Magma(0, 0, 0, 0, 64, 64), new Rock((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY()));
					
						if(generateCustomeBiomeEdges(j, i, new Magma(0, 0, 0, 0, 64, 64), new Water(0, 0, 0, 0, 64, 64), new ObsidianWall((j*64), (i*64), (j*64) - Game.virtualSpace.getX(), (i*64) - Game.virtualSpace.getY())))
						{
							tiles[i][j] = new ObsidianRocks(j * 64, i * 64, j * 64 - Game.virtualSpace.getX(), i * 64 - Game.virtualSpace.getY(), 64, 64);
							tilesFile.write("?");
						}
					}
					catch(Exception e)
					{
						
					}
				}
			}
			
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
	
	private void generateStructure(int yM, int xM)
	{
		for(int y = yM; y < yM + 16; y++)
		{
			for(int x = xM; x < xM + 16; x++)
			{
				if(y == yM || y == (yM + 16) - 1 || x == xM || x == (xM + 16) - 1)
				{
					sEntities.add(new SandStoneE((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
					SESIZE++;
					
					//WorldImage.setRGB(x, y, Color.BLACK.getRGB());
				}
			}
		}
	}
	
	private boolean generateCustomeBiomeEdges(int x, int y, Tile f_tile, Tile s_tile, StaticEntity replacement) throws CloneNotSupportedException
	{
		if(tiles[y][x].getClass() == f_tile.getClass())
		{
			if(tiles[y][x-1].getClass() == s_tile.getClass() || tiles[y][x+1].getClass() == s_tile.getClass() || tiles[y-1][x].getClass() == s_tile.getClass() || tiles[y+1][x].getClass() == s_tile.getClass())
			{
				istickocuped = true;
				sEntities.add(replacement.clone());
				SESIZE++;
				
				return true;
			}
		}
		
		return false;
	}
	
	private void generateForestEntities(int x, int y)
	{
		if(generateEntitiesByR(y, x, 9) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Plant(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 7) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new FruitBush(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 6) && !istickocuped)
		{
			istickocuped = true;
			animals.add(new BadSheep(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			ASIZE++;
		}
		
		if(generateEntitiesByR(y, x, 5) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Rock(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 4) && !istickocuped)
		{
			istickocuped = true;
			animals.add(new Sheep(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			ASIZE++;
		}
		
		if(generateEntitiesByR(y, x, 2) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Tree(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
	}
	
	private void generateWetForestEntities(int x, int y)
	{
		if(generateEntitiesByR(y, x, 13) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new MushroomBlueE(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 9) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new MushroomRedE(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 4) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new ClayE(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 1) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Tree(x*64, y*64, x*64 - Game.virtualSpace.getX(), y*64 - Game.virtualSpace.getY()));
			SESIZE++;
		}
	}
	
	private void generateRockEntities(int x, int y)
	{
		if(generateEntitiesByR(y, x, 12) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new IronOreE((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 6) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new BasaltE((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 2) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Rock((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
	}
	
	private void generateDesertEntities(int x, int y)
	{
		if(generateEntitiesByR(y, x, 17) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new SandStoneE((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 6) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Cactus((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
		
		if(generateEntitiesByR(y, x, 3) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Rock((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
	}
	
	private void generateEdgeEntities(int x, int y)
	{
		if(generateEntitiesByR(y, x, 4) && !istickocuped)
		{
			istickocuped = true;
			sEntities.add(new Rock((x*64), (y*64), (x*64) - Game.virtualSpace.getX(), (y*64) - Game.virtualSpace.getY()));
			SESIZE++;
		}
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
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	public Item getFromItem(int i)
	{
		return items.get(i);
	}
	
	public boolean generateEntitiesByR(int i, int j, int R)
	{
		if(i != (Game.WORLD_SIZE / 2) || j != (Game.WORLD_SIZE / 2))
		{
			double max = 0;
			for (int y = i - R; y <= i + R; y++) 
			{
				for (int x = j - R; x <= j + R; x++) 
				{
					if (0 <= y && y < Game.WORLD_SIZE && 0 <= x && x < Game.WORLD_SIZE) 
					{
						double e = blueNoise[y][x];
						if (e > max) 
						{
							max = e; 
						}
					}
				}
			}
			
			if (Math.abs(blueNoise[i][j] - max) < (max * random_blue.nextDouble() * 0.03))
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
	//	d = Math.abs(x1 - x2) + Math.abs(y1 - y2); // Manhattan
	//	d = Math.pow(Math.pow(Math.abs(x1 - x2), 3) + Math.pow(Math.abs(y1 - y2), 3), (1 / 3)); // Minkovski
	  	return d;
	}
}
