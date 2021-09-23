package Game.engine.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets 
{
	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static ArrayList<BufferedImage> font = new ArrayList<BufferedImage>();
	
	public static BufferedImage player, pointer, cow, player_water;
	
	public static BufferedImage dirt, grass, sand, water, rocks, magma;
	
	public static BufferedImage tree, rock, tableE, woodPlankE, basaltE, polishedBasaltE, ovenE, anvilE, clayE, ironOreE, plant, mushroomRedE, mushroomBlueE,
	chestE, fruitBush, bush;
	
	public static BufferedImage nameFrameF, nameFrameI, nameFrameII, nameFrameE;
	
	public static BufferedImage hotbar, hotbarSelected, num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
	
	public static BufferedImage wood, stone, wool, string, woodTable, nail, table, woodPlank, basalt, polishedBasalt, oven, anvil, clay, stick, 
	clayMold, ironOre, basaltTray, ironBasaltTray, iron, woodSwordTemplate, clayMoldSword, ironSwordClay, sheepRawMeat, sheepMeat, 
	rockFoodTray, rockSheepMeatTray, rockPot, rockPotWater, herbs, woodPot, woodPotHerb, rockPotHerb, mushroomRed, rockPotMushroomRed, 
	woodPotMushroomRed, mushroomBlue, rockPotMushroomBlue, woodPotMushroomBlue, woodPickaxeTemplate, clayMoldPickaxe, ironPickaxeClay,
	woodAxeTemplate, clayMoldAxe, ironAxeClay, chest, fruit, rootenFruit;
	
	public static BufferedImage sandpaper, axe, pickaxe, kinfe, hammer, basaltHammer, ironSword, ironPickaxe, ironAxe;
	
	public static BufferedImage inventory, craftingtable, ovenUI, anvilUI, chestUI, nameFrame, pride;
	
	public static void init()
	{
		SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		SpriteSheet tilesSESheet = new SpriteSheet(ImageLoader.loadImage("/textures/tilesStaticEntities_sheet.png"));
		SpriteSheet entitiesSheet = new SpriteSheet(ImageLoader.loadImage("/textures/entities_sheet.png"));
		SpriteSheet itemsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/items_sheet.png"));
		SpriteSheet fontSheet = new SpriteSheet(ImageLoader.loadImage("/textures/font.png"));
		SpriteSheet nameFrame = new SpriteSheet(ImageLoader.loadImage("/textures/name_frame3.png"));
		
		inventory = ImageLoader.loadImage("/textures/inventory_sheet.png");
		craftingtable = ImageLoader.loadImage("/textures/craftingTable_sheet.png");
		ovenUI = ImageLoader.loadImage("/textures/oven_sheet.png");
		anvilUI = ImageLoader.loadImage("/textures/anvil_sheet.png");
		chestUI = ImageLoader.loadImage("/textures/chest_sheet.png");
		pride = ImageLoader.loadImage("/textures/pride.png");
		
		//Font
		int x = 0;
		int y = 0;
		for(int i = (int) "A".charAt(0); i < (int) "Z".charAt(0); i++)
		{
			font.add(fontSheet.crop(WIDTH * x, HEIGHT * y, WIDTH, HEIGHT));
			
			if(x == 7)
			{
				y++;
				x = 0;
			}
			else
			{
				x++;
			}
		}
		
		//Name Frame
		nameFrameF = nameFrame.crop(0, 0, 15, 15);
		nameFrameI = nameFrame.crop(16, 0, 7, 15);
		nameFrameII = nameFrame.crop(24, 0, 9, 15);
		nameFrameE = nameFrame.crop(34, 0, 15, 15);
		
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
		plant = tilesSESheet.crop(WIDTH * 14, 0, WIDTH, HEIGHT);
		mushroomRedE = tilesSESheet.crop(WIDTH * 15, 0, WIDTH, HEIGHT);
		mushroomBlueE = tilesSESheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
		chestE = tilesSESheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);
		fruitBush = tilesSESheet.crop(WIDTH * 7, HEIGHT, WIDTH, HEIGHT);
		bush = tilesSESheet.crop(WIDTH * 8, HEIGHT, WIDTH, HEIGHT);
		
		//Entities
		player = entitiesSheet.crop(0, 0, WIDTH, HEIGHT);
		pointer = entitiesSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		cow = entitiesSheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		player_water = entitiesSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		
		//Items
		hotbar = itemsSheet.crop(0, 0, WIDTH, HEIGHT);
		hotbarSelected = itemsSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		num0 = fontSheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
		num1 = fontSheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
		num2 = fontSheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
		num3 = fontSheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
		num4 = fontSheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
		num5 = fontSheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);
		num6 = fontSheet.crop(WIDTH * 7, HEIGHT * 3, WIDTH, HEIGHT);
		num7 = fontSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
		num8 = fontSheet.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT);
		num9 = fontSheet.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT);
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
		ironPickaxe = itemsSheet.crop(WIDTH * 12, HEIGHT * 3, WIDTH, HEIGHT);
		ironAxe = itemsSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
		sheepRawMeat = itemsSheet.crop(WIDTH * 9, HEIGHT * 2, WIDTH, HEIGHT);
		sheepMeat = itemsSheet.crop(WIDTH * 10, HEIGHT * 2, WIDTH, HEIGHT);
		rockFoodTray = itemsSheet.crop(WIDTH * 11, HEIGHT * 2, WIDTH, HEIGHT);
		rockSheepMeatTray = itemsSheet.crop(WIDTH * 12, HEIGHT * 2, WIDTH, HEIGHT);
		rockPot = itemsSheet.crop(WIDTH * 13, HEIGHT * 2, WIDTH, HEIGHT);
		rockPotWater = itemsSheet.crop(WIDTH * 14, HEIGHT * 2, WIDTH, HEIGHT);
		herbs = itemsSheet.crop(WIDTH * 15, HEIGHT * 2, WIDTH, HEIGHT);
		woodPot = itemsSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
		woodPotHerb = itemsSheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
		rockPotHerb = itemsSheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
		mushroomRed = itemsSheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
		rockPotMushroomRed = itemsSheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);
		woodPotMushroomRed = itemsSheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
		mushroomBlue = itemsSheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);
		rockPotMushroomBlue = itemsSheet.crop(WIDTH * 7, HEIGHT * 3, WIDTH, HEIGHT);
		woodPotMushroomBlue = itemsSheet.crop(WIDTH * 8, HEIGHT * 3, WIDTH, HEIGHT);
		woodPickaxeTemplate = itemsSheet.crop(WIDTH * 9, HEIGHT * 3, WIDTH, HEIGHT);
		clayMoldPickaxe = itemsSheet.crop(WIDTH * 10, HEIGHT * 3, WIDTH, HEIGHT);
		ironPickaxeClay = itemsSheet.crop(WIDTH * 11, HEIGHT * 3, WIDTH, HEIGHT);
		woodAxeTemplate = itemsSheet.crop(WIDTH * 13, HEIGHT * 3, WIDTH, HEIGHT);
		clayMoldAxe = itemsSheet.crop(WIDTH * 14, HEIGHT * 3, WIDTH, HEIGHT);
		ironAxeClay = itemsSheet.crop(WIDTH * 15, HEIGHT * 3, WIDTH, HEIGHT);
		chest = itemsSheet.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT);
		fruit = itemsSheet.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT);
		rootenFruit = itemsSheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
	}
}
