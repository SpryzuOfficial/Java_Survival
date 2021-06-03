package Game.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static BufferedImage player, pointer, cow, player_water;
	
	public static BufferedImage dirt, grass, sand, water;
	
	public static BufferedImage tree, rock, tableE, woodPlankE, basaltE, polishedBasaltE, ovenE, anvilE, clayE, ironOreE;
	
	public static BufferedImage hotbar, hotbarSelected, num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
	
	public static BufferedImage wood, stone, wool, string, woodTable, nail, table, woodPlank, basalt, polishedBasalt, oven, anvil, clay, stick, clayMold, ironOre, basaltTray;
	
	public static BufferedImage sandpaper, axe, pickaxe, kinfe, hammer, basaltHammer;
	
	public static BufferedImage inventory, craftingtable, ovenUI;
	
	public static void init()
	{
		SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		inventory = ImageLoader.loadImage("/textures/inventory_sheet.png");
		craftingtable = ImageLoader.loadImage("/textures/craftingTable_sheet.png");
		ovenUI = ImageLoader.loadImage("/textures/oven_sheet.png");
		
		player = spriteSheet.crop(0, 0, WIDTH, HEIGHT);
		player_water = spriteSheet.crop(WIDTH * 7, HEIGHT * 2, WIDTH, HEIGHT);
		
		dirt = spriteSheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		grass = spriteSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		sand = spriteSheet.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
		water = spriteSheet.crop(WIDTH * 6, HEIGHT * 2, WIDTH, HEIGHT);
		
		pointer = spriteSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		
		cow = spriteSheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
		
		tree = spriteSheet.crop(0, HEIGHT, WIDTH, HEIGHT * 2);
		rock = spriteSheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
		tableE = spriteSheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
		woodPlankE = spriteSheet.crop(WIDTH * 5, HEIGHT * 4, WIDTH, HEIGHT);
		basaltE = spriteSheet.crop(0, HEIGHT * 5, WIDTH, HEIGHT);
		polishedBasaltE = spriteSheet.crop(WIDTH * 3, HEIGHT * 5, WIDTH, HEIGHT);
		ovenE = spriteSheet.crop(WIDTH * 7, HEIGHT * 4, WIDTH, HEIGHT);
		anvilE = spriteSheet.crop(WIDTH * 5, HEIGHT * 5, WIDTH, HEIGHT);
		clayE = spriteSheet.crop(WIDTH * 6, HEIGHT * 5, WIDTH, HEIGHT);
		ironOreE = spriteSheet.crop(WIDTH * 2, HEIGHT * 6, WIDTH, HEIGHT);
		
		hotbar = spriteSheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);
		hotbarSelected = spriteSheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);
		
		wood = spriteSheet.crop(WIDTH * 7, 0, WIDTH, HEIGHT);
		stone = spriteSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
		wool = spriteSheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
		string = spriteSheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
		woodTable = spriteSheet.crop(WIDTH * 7, HEIGHT * 3, WIDTH, HEIGHT);
		nail = spriteSheet.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT);
		table = spriteSheet.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT);
		woodPlank = spriteSheet.crop(WIDTH * 4, HEIGHT * 4, WIDTH, HEIGHT);
		basalt = spriteSheet.crop(WIDTH, HEIGHT * 5, WIDTH, HEIGHT);
		polishedBasalt = spriteSheet.crop(WIDTH * 2, HEIGHT * 5, WIDTH, HEIGHT);
		oven = spriteSheet.crop(WIDTH * 6, HEIGHT * 4, WIDTH, HEIGHT);
		anvil = spriteSheet.crop(WIDTH * 4, HEIGHT * 5, WIDTH, HEIGHT);
		clay = spriteSheet.crop(WIDTH * 7, HEIGHT * 5, WIDTH, HEIGHT);
		stick = spriteSheet.crop(0, HEIGHT * 6, WIDTH, HEIGHT);
		clayMold = spriteSheet.crop(WIDTH, HEIGHT * 6, WIDTH, HEIGHT);
		ironOre = spriteSheet.crop(WIDTH * 3, HEIGHT * 6, WIDTH, HEIGHT);
		basaltTray = spriteSheet.crop(WIDTH * 4, HEIGHT * 6, WIDTH, HEIGHT);
		
		sandpaper = spriteSheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
		axe = spriteSheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
		pickaxe = spriteSheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
		kinfe = spriteSheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);
		hammer = spriteSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
		basaltHammer = spriteSheet.crop(WIDTH * 5, HEIGHT * 6, WIDTH, HEIGHT);
		
		num0 = spriteSheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
		num1 = spriteSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		num2 = spriteSheet.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
		num3 = spriteSheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
		num4 = spriteSheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
		num5 = spriteSheet.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
		num6 = spriteSheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);
		num7 = spriteSheet.crop(WIDTH * 7, HEIGHT, WIDTH, HEIGHT);
		num8 = spriteSheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
		num9 = spriteSheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
	}
}
