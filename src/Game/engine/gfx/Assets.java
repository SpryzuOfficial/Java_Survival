package Game.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static BufferedImage player, pointer, cow, player_water;
	
	public static BufferedImage dirt, grass, sand, water, rocks, magma;
	
	public static BufferedImage tree, rock, tableE, woodPlankE, basaltE, polishedBasaltE, ovenE, anvilE, clayE, ironOreE;
	
	public static BufferedImage hotbar, hotbarSelected, num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
	
	public static BufferedImage wood, stone, wool, string, woodTable, nail, table, woodPlank, basalt, polishedBasalt, oven, anvil, clay, stick, clayMold, ironOre, basaltTray, ironBasaltTray, iron, woodSwordTemplate, clayMoldSword, ironSwordClay, ironSword, sheepRawMeat, sheepMeat;
	
	public static BufferedImage sandpaper, axe, pickaxe, kinfe, hammer, basaltHammer;
	
	public static BufferedImage inventory, craftingtable, ovenUI, anvilUI;
	
	public static void init()
	{
		SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		SpriteSheet tilesSESheet = new SpriteSheet(ImageLoader.loadImage("/textures/tilesStaticEntities_sheet.png"));
		SpriteSheet entitiesSheet = new SpriteSheet(ImageLoader.loadImage("/textures/entities_sheet.png"));
		SpriteSheet itemsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/items_sheet.png"));
		
		inventory = ImageLoader.loadImage("/textures/inventory_sheet.png");
		craftingtable = ImageLoader.loadImage("/textures/craftingTable_sheet.png");
		ovenUI = ImageLoader.loadImage("/textures/oven_sheet.png");
		anvilUI = ImageLoader.loadImage("/textures/anvil_sheet.png");
		
		//Tiles
		grass = tilesSESheet.crop(0, 0, WIDTH, HEIGHT);
		dirt = tilesSESheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		sand = tilesSESheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		water = tilesSESheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		rocks = tilesSESheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		magma = tilesSESheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		
		//Static entities
		rock = tilesSESheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
		tree = tilesSESheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT * 2);
		basaltE = tilesSESheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);
		tableE = tilesSESheet.crop(WIDTH * 7, 0, WIDTH, HEIGHT);
		woodPlankE = tilesSESheet.crop(WIDTH * 8, 0, WIDTH, HEIGHT);
		polishedBasaltE = tilesSESheet.crop(WIDTH * 9, 0, WIDTH, HEIGHT);
		anvilE = tilesSESheet.crop(WIDTH * 10, 0, WIDTH, HEIGHT);
		clayE = tilesSESheet.crop(WIDTH * 11, 0, WIDTH, HEIGHT);
		ironOreE = tilesSESheet.crop(WIDTH * 12, 0, WIDTH, HEIGHT);
		ovenE = tilesSESheet.crop(WIDTH * 13, 0, WIDTH, HEIGHT);
		
		//Entities
		player = entitiesSheet.crop(0, 0, WIDTH, HEIGHT);
		pointer = entitiesSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		cow = entitiesSheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		player_water = entitiesSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		
		//Items
		hotbar = itemsSheet.crop(0, 0, WIDTH, HEIGHT);
		hotbarSelected = itemsSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		num0 = itemsSheet.crop(WIDTH * 11, 0, WIDTH, HEIGHT);
		num1 = itemsSheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		num2 = itemsSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		num3 = itemsSheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
		num4 = itemsSheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);
		num5 = itemsSheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);
		num6 = itemsSheet.crop(WIDTH * 7, 0, WIDTH, HEIGHT);
		num7 = itemsSheet.crop(WIDTH * 8, 0, WIDTH, HEIGHT);
		num8 = itemsSheet.crop(WIDTH * 9, 0, WIDTH, HEIGHT);
		num9 = itemsSheet.crop(WIDTH * 10, 0, WIDTH, HEIGHT);
		wood = itemsSheet.crop(WIDTH * 12, 0, WIDTH, HEIGHT);
		stone = itemsSheet.crop(WIDTH * 13, 0, WIDTH, HEIGHT);
		wool = itemsSheet.crop(WIDTH * 14, 0, WIDTH, HEIGHT);
		string = itemsSheet.crop(WIDTH * 15, 0, WIDTH, HEIGHT);
		woodTable = itemsSheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);
		nail = itemsSheet.crop(WIDTH * 7, HEIGHT, WIDTH, HEIGHT);
		basalt = itemsSheet.crop(WIDTH * 8, HEIGHT, WIDTH, HEIGHT);
		polishedBasalt = itemsSheet.crop(WIDTH * 9, HEIGHT, WIDTH, HEIGHT);
		table = itemsSheet.crop(WIDTH * 10, HEIGHT, WIDTH, HEIGHT);
		oven = itemsSheet.crop(WIDTH * 11, HEIGHT, WIDTH, HEIGHT);
		anvil = itemsSheet.crop(WIDTH * 12, HEIGHT, WIDTH, HEIGHT);
		woodPlank = itemsSheet.crop(WIDTH * 13, HEIGHT, WIDTH, HEIGHT);
		stick = itemsSheet.crop(WIDTH * 14, HEIGHT, WIDTH, HEIGHT);
		basaltTray = itemsSheet.crop(WIDTH * 15, HEIGHT, WIDTH, HEIGHT);
		clay = itemsSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
		ironOre = itemsSheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
		clayMold = itemsSheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
		ironBasaltTray = itemsSheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
		iron = itemsSheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);
		woodSwordTemplate = itemsSheet.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
		clayMoldSword = itemsSheet.crop(WIDTH * 6, HEIGHT * 2, WIDTH, HEIGHT);
		ironSwordClay = itemsSheet.crop(WIDTH * 7, HEIGHT * 2, WIDTH, HEIGHT);
		sandpaper = itemsSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		axe = itemsSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		pickaxe = itemsSheet.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
		kinfe = itemsSheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
		hammer = itemsSheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
		basaltHammer = itemsSheet.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
		ironSword = itemsSheet.crop(WIDTH * 8, HEIGHT * 2, WIDTH, HEIGHT);
		sheepRawMeat = itemsSheet.crop(WIDTH * 9, HEIGHT * 2, WIDTH, HEIGHT);
		sheepMeat = itemsSheet.crop(WIDTH * 10, HEIGHT * 2, WIDTH, HEIGHT);
	}
}
