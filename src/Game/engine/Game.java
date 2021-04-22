package Game.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

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
	private static final int TVSWIDTH = 61952, TVSHEIGHT = 61952;
	private static final int TAWIDTH = TVSWIDTH / 64, TAHEIGHT = TVSHEIGHT / 64;
	private static final int VSWIDTH = 704, VSHEIGHT = 704; 
	
	private Display display;
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
	
	public static int lastX = 30656, lastY = 30656;
	
	public static boolean colliding;
	
	public Game(String title, int width, int heigth)
	{
		this.title = title;
		this.width = width;
		this.height = heigth;
	}
	
	private void init()
	{
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		virtualSpace = new VirtualSpace(((TVSWIDTH / 2) - (VSWIDTH / 2)) + 32, ((TVSHEIGHT / 2) - (VSHEIGHT / 2)) + 32, VSWIDTH, VSHEIGHT, TVSWIDTH, TVSHEIGHT, 4, keyManager, mouseManager);
		
		generateWorld = new GenerateWorld(TAWIDTH, TAHEIGHT);
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
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
			
			TileManager.tick();
			StaticEntitiesManager.tick();
			AnimalsManager.tick();
			UiInventoryManager.tick();
			
			pointer.setX(pointerX);
			pointer.setY(pointerY);
			
			colliding = false;
			
			//lastX = virtualSpace.getX();
			//lastY = virtualSpace.getY();
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
		g.fillRect(pointer.getX(), pointer.getY() - 10, pointer.getWidth(), 10);
		
		g.setColor(Color.GREEN);
		g.fillRect(pointer.getX(), pointer.getY() - 10, (int) StaticEntitiesManager.destructionBarValue, 10);
		
		player.render(g);
		
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
				tick();
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
