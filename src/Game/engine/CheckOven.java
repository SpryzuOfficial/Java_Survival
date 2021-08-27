package Game.engine;

import Game.Items.*;
import Game.Items.OvenItemSlots;

public class CheckOven 
{
	private OvenItemSlots ironRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new BasaltTray(1, 0, 576)});
	
	private OvenItemSlots ironSwordClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldSword(1, 0, 576)});
	
	private OvenItemSlots ironOreSwordClayRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new ClayMoldSword(1, 0, 576)});
	
	private OvenItemSlots sheepMeatRecipe = new OvenItemSlots(new SheepRawMeat(1, 0, 576), new Item[] {new RockFoodTray(1, 0, 576)});
	
	private OvenItemSlots herbRecipe = new OvenItemSlots(new Herbs(1, 0, 576), new Item[] {new RockPotWater(1, 0, 576)});
	
	private OvenItemSlots mushroomRedRecipe = new OvenItemSlots(new MushroomRed(1, 0, 576), new Item[] {new RockPotWater(1, 0, 576)});
	
	private OvenItemSlots mushroomBlueRecipe = new OvenItemSlots(new MushroomBlue(1, 0, 576), new Item[] {new RockPotWater(1, 0, 576)});
	
	private OvenItemSlots ironPickaxeClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldPickaxe(1, 0, 576)});
	
	private OvenItemSlots ironOrePickaxeClayRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new ClayMoldPickaxe(1, 0, 576)});
	
	private OvenItemSlots ironAxeClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldAxe(1, 0, 576)});
	
	private OvenItemSlots ironOreAxeClayRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new ClayMoldAxe(1, 0, 576)});
	
	public Item checkOven(Item input, Item tray)
	{
		if(updateOven(input, tray, ironRecipe))
		{
			return new IronBasaltTray(1, 0, 576);
		}
		
		if(updateOven(input, tray, ironSwordClayRecipe))
		{
			return new IronSwordClay(1, 0, 576);
		}
		
		if(updateOven(input, tray, ironOreSwordClayRecipe))
		{
			return new IronSwordClay(1, 0, 576);
		}
		
		if(updateOven(input, tray, sheepMeatRecipe))
		{
			return new RockSheepMeatTray(1, 0, 576);
		}
		
		if(updateOven(input, tray, herbRecipe))
		{
			return new RockPotHerb(1, 0, 576);
		}
		
		if(updateOven(input, tray, mushroomRedRecipe))
		{
			return new RockPotMushroomRed(1, 0, 576);
		}
		
		if(updateOven(input, tray, mushroomBlueRecipe))
		{
			return new RockPotMushroomBlue(1, 0, 576);
		}
		
		if(updateOven(input, tray, ironPickaxeClayRecipe))
		{
			return new IronPickaxeClay(1, 0, 576);
		}
		
		if(updateOven(input, tray, ironOrePickaxeClayRecipe))
		{
			return new IronPickaxeClay(1, 0, 576);
		}
		
		if(updateOven(input, tray, ironAxeClayRecipe))
		{
			return new IronAxeClay(1, 0, 576);
		}
		
		if(updateOven(input, tray, ironOreAxeClayRecipe))
		{
			return new IronAxeClay(1, 0, 576);
		}
		
		return null;
	}
	
	private boolean updateOven(Item input, Item tray, OvenItemSlots recipes)
	{
		if(input == null || tray == null)
		{
			return false;
		}
		
		if(input.getClass() != recipes.getInput().getClass())
		{
			return false;
		}
		
		for(int i = 0; i < recipes.getTrays().length; i++)
		{
			if(tray.getClass() == recipes.getTray(i).getClass())
			{
				return true;
			}
		}
		
		return false;
	}
}
