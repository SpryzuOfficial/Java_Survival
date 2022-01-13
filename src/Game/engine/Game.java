package Game.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.engine.input.*;
import Game.entities.*;
import Game.positionSpaces.*;
import Game.tiles.*;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;
import Game.engine.gfx.*;

public class Game implements Runnable
{
	//FINALS
	public static final int WORLD_SIZE = 968 * 2;
	private static final int TVSWIDTH = WORLD_SIZE * 64, TVSHEIGHT = WORLD_SIZE * 64;
	private static final int VSWIDTH = 704, VSHEIGHT = 704;
	
	public static Display display;
	public static int width, height;
	public static String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Generate World
	public static GenerateWorld generateWorld;
	
	//Input
	public static KeyManager keyManager;
	public static MouseManager mouseManager;
	
	//Virtual space
	public static VirtualSpace virtualSpace;
	
	//Player
	public static Player player;

	//Pointer
	private Pointer pointer;
	public static int pointerX = 768, pointerY = 768;
	
	public static int lastX = (TVSWIDTH / 2) - (VSWIDTH / 2) + 32, lastY = (TVSHEIGHT / 2) - (VSHEIGHT / 2) + 32;
	
	public static boolean colliding;
	
	// Time cycle
	private int tickC = 0;
	private int alpha = 0;
	private boolean isDay = true;
	
	public Game(String title, int width, int heigth)
	{
		Game.title = title;
		Game.width = width;
		Game.height = heigth;
	}
	
	private void init()
	{
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		virtualSpace = new VirtualSpace(((TVSWIDTH / 2) - (VSWIDTH / 2)) + 32, ((TVSHEIGHT / 2) - (VSHEIGHT / 2)) + 32, VSWIDTH, VSHEIGHT, TVSWIDTH, TVSHEIGHT, 4);
		
		generateWorld = new GenerateWorld();
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseWheelListener(mouseManager);
		
		Assets.init();
		UiInventoryManager.init();
		
		player = new Player((width / 2) - (64 / 2), (height / 2) - (64 / 2), (((virtualSpace.getWidth() / 2) - (64 / 2)) + virtualSpace.getX()), (((virtualSpace.getHeight() / 2) - (64 / 2)) + virtualSpace.getY()));
		pointer = new Pointer(player.getX() + 64, player.getY());
		
		generateWorld.generate();
		
		System.out.println(player.getX());
		System.out.println(player.getX() + (player.getWidth()));
	}
	
	private void tick()
	{
		keyManager.tick();
		
		UiManager.tick();
		
	 	if(UiManager.uiImage == null)
	 	{
	 		virtualSpace.tick();
	 		player.tick();
	 		
			if(colliding)
			{
				virtualSpace.setX(lastX);
				virtualSpace.setY(lastY);
			}
			else
			{
				lastX = virtualSpace.getX();
				lastY = virtualSpace.getY();
			}
			
			if(!Game.mouseManager.isLeftPressed())
			{
				if(Game.keyManager.up || Game.keyManager.down || Game.keyManager.right || Game.keyManager.left)
				{
					if(!Game.keyManager.shift)
					{
						player.setStaminaPerF(-0.5);
						player.setFoodPerF(0.003);
					}
					else
					{
						player.setStaminaPerF(0.65);
						player.setFoodPerF(0.004);
					}
				}
				else
				{
					player.setStaminaPerF(-0.6);
					player.setFoodPerF(0.002);
				}
			}
			
		}
	 	
	 	if(UiManager.uiImage != Assets.pause)
	 	{
		 	if(player.getFood() > 0)
		 	{
		 		player.setFood(player.getFood() - player.getFoodPerF());
		 		player.setLifePerF(0.0);
		 	}
		 	else
		 	{
		 		player.setFood(0);
		 		player.setLifePerF(0.01);
		 	}
		 	
		 	if(player.getLife() > 0)
		 	{
		 		player.setLife(player.getLife() - player.getLifePerF());
		 	}
		 	else
		 	{
		 		player.setLife(0);
		 		player.setGameOver(true);
		 		UiManager.uiImage = Assets.pause;
		 	}
		 	
		 	player.setStamina(player.getStamina() - player.getStaminaPerF());
		 	
		 	if(player.getStamina() > 100)
		 	{
		 		player.setStamina(100);
		 	}
		 	
		 	if(player.getStamina() < 0)
		 	{
		 		player.setStamina(0);
		 	}
		 	
		 	if(UiManager.uiImage == null)
		 	{
		 		TileManager.tick();
		 	}
		 	
			AnimalsManager.tick();
			ItemEntityManager.tick();
			
	 		if(UiManager.uiImage != null)
	 		{
		 		for(int i = 0; i < generateWorld.getOvens().size(); i++)
		 		{
		 			generateWorld.getFromOven(i).tick();
		 		}
	 		}
	 		
	 		if(tickC == 240)
			{
				if(isDay)
				{
					if(alpha == 220)
					{
						isDay = false;
					}
					else
					{
						alpha++;
					}
				}
				else
				{
					if(alpha == 0)
					{
						isDay = true;
					}
					else
					{
						alpha--;
					}
				}
				
				tickC = 0;
			}
			else
			{
				tickC++;
			}
	 	}
	 	
 		if(UiManager.uiImage == null)
	 	{
 			StaticEntitiesManager.tick();
 			UiInventoryManager.tick();
			
			pointer.setX(pointerX);
			pointer.setY(pointerY);
			
			colliding = false;
	 	}
 		
 		for(int i = 0; i < 2; i++)
		{
			if(UiInventoryManager.itemsClothes[i] != null)
			{
				player.addExtraLayer(UiInventoryManager.itemsClothes[i].getCostumeId());
			}
		}
 	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		//Draw Here!
		TileManager.render(g);
		StaticEntitiesManager.render(g);
		AnimalsManager.render(g);
		
		pointer.render(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(pointer.getX(), pointer.getY() - 21, pointer.getWidth(), 10);
		
		g.setColor(Color.RED);
		g.fillRect(pointer.getX(), pointer.getY() - 21, (int) AnimalsManager.destructionBarValue, 10);
		
		g.setColor(Color.BLACK);
		g.fillRect(pointer.getX(), pointer.getY() - 10, pointer.getWidth(), 10);
		
		g.setColor(Color.GREEN);
		g.fillRect(pointer.getX(), pointer.getY() - 10, (int) StaticEntitiesManager.destructionBarValue, 10);
		
		player.render(g);
		
		ItemEntityManager.render(g);
		
		Color skyColor = new Color(68, 51, 85, alpha);
		g.setColor(skyColor);
		g.fillRect(0, 0, width, height);
		
		///*
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(23, 1, 210, 163);
		
		g.setColor(Color.BLACK);
		//g.drawChars("Life".toCharArray(), 0, 4, 32, 16);
		
		int initialX = 1;
		int initialY = -17;
		ArrayList<BufferedImage> word =  UiManager.stringToImage("Life");
		
		for(int i = 0; i < word.size(); i++)
		{
			g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(27, 27, 202, 26);
		
		g.setColor(Color.BLACK);
		g.fillRect(32, 32, 192, 16);
		
		g.setColor(Color.GREEN);
		g.fillRect(32, 32, (int) (192 * (player.getLife() / 100f)), 16);
		
		g.setColor(Color.BLACK);
		//g.drawChars("Food".toCharArray(), 0, 4, 32, 68);
		
		initialX = 1;
		initialY = 35;
		word =  UiManager.stringToImage("Food");
		
		for(int i = 0; i < word.size(); i++)
		{
			g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(27, 79, 202, 26);
		
		g.setColor(Color.BLACK);
		g.fillRect(32, 84, 192, 16);
		
		g.setColor(Color.BLUE);
		g.fillRect(32, 84, (int) (192 * (player.getFood() / 100f)), 16);
		
		g.setColor(Color.BLACK);
		//g.drawChars("Stamina".toCharArray(), 0, 7, 32, 120);
		
		initialX = 1;
		initialY = 87;
		word =  UiManager.stringToImage("Stamina");
		
		for(int i = 0; i < word.size(); i++)
		{
			g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(27, 131, 202, 26);
		
		g.setColor(Color.BLACK);
		g.fillRect(32, 136, 192, 16);
		
		g.setColor(Color.YELLOW);
		g.fillRect(32, 136, (int) (192 * (player.getStamina() / 100f)), 16);
		
		
		g.setColor(Color.GRAY);
		g.fillRect(240, 2, 128, 24);
		
		g.setColor(Color.WHITE);
		//g.drawChars("X".toCharArray(), 0, 1, 256, 18);
		
		initialX = 220;
		initialY = -17;
		word =  UiManager.stringToImage("X");
		
		for(int i = 0; i < word.size(); i++)
		{
			g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
		}
		
		//g.drawChars(String.valueOf(player.getVx() / 64).toCharArray(), 0, String.valueOf(player.getVx() / 64).toCharArray().length, 262, 18);
		
		initialX = 236;
		initialY = -17;
		ArrayList<BufferedImage> numbers =  UiManager.intToImage(player.getVx() / 64);
		
		for(int i = 0; i < numbers.size(); i++)
		{
			g.drawImage(numbers.get(i), initialX + (i * 8), initialY, 64, 64, null);
		}
		
		g.setColor(Color.WHITE);
		//g.drawChars("Y".toCharArray(), 0, 1, 288, 18);
		initialX = 270;
		initialY = -17;
		word =  UiManager.stringToImage("Y");
		
		for(int i = 0; i < word.size(); i++)
		{
			g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
		}
		
		//g.drawChars(String.valueOf(player.getVy() / 64).toCharArray(), 0, String.valueOf(player.getVy() / 64).toCharArray().length, 294, 18);
		
		initialX = 286;
		initialY = -17;
		numbers =  UiManager.intToImage(player.getVy() / 64);
		
		for(int i = 0; i < numbers.size(); i++)
		{
			g.drawImage(numbers.get(i), initialX + (i * 8), initialY, 64, 64, null);
		}
		
		g.drawImage(Assets.pride, 656, 16, 32, 32, null);
		
		g.setColor(Color.BLACK);
		g.fillRect(520, 50, 180, 180);
		g.drawImage(Game.generateWorld.WorldImage.getSubimage(Game.player.getVx() / 64 - 20, Game.player.getVy() / 64 - 20, 40, 40), 530, 60, 160, 160, null);
		g.fillRect(610, 140, 4, 4);
		
		if(UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3] != null)
		{
			String itemName = UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].toString();
			
			initialX = UiInventoryManager.itemsHotbar[UiInventoryManager.hotbarSelected - 3].getX() - 16;
			initialY = 540;
			word =  UiManager.stringToImage(itemName);
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
			}
		}
		
		if(UiInventoryManager.inventoryTool != null)
		{
			String itemName = UiInventoryManager.inventoryTool.toString();
			
			initialX = UiInventoryManager.inventoryTool.getX() - 32;
			initialY = 540;
			word =  UiManager.stringToImage(itemName);
			
			for(int i = 0; i < word.size(); i++)
			{
				g.drawImage(word.get(i), initialX + (i * 16), initialY, 64, 64, null);
			}
		}
		
		//*/
		
		UiInventoryManager.render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				if(!player.isGameOver())
				{
					tick();
				}
				
				render();
				
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				//System.out.println("X: " + player.getVx() + " " + "Y: " + player.getVy());
				//System.out.println("X: " + virtualSpace.getX() + " " + "Y: " + virtualSpace.getY());
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start()
	{
		if(running)
		{
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		
		running = false;
		
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
