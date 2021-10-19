package Game.engine;

import java.util.ArrayList;

import Game.Items.*;

public class CheckOven 
{
	private OvenItemSlots ironRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new BasaltTray(1, 0, 576)}, new IronBasaltTray(1, 0, 576));
	
	private OvenItemSlots ironSwordClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldSword(1, 0, 576)}, new IronSwordClay(1, 0, 576));
	
	private OvenItemSlots ironOreSwordClayRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new ClayMoldSword(1, 0, 576)}, new IronSwordClay(1, 0, 576));
	
	private OvenItemSlots sheepMeatRecipe = new OvenItemSlots(new SheepRawMeat(1, 0, 576), new Item[] {new RockFoodTray(1, 0, 576)}, new RockSheepMeatTray(1, 0, 576));
	
	private OvenItemSlots herbRecipe = new OvenItemSlots(new Herbs(1, 0, 576), new Item[] {new RockPotWater(1, 0, 576)}, new RockPotHerb(1, 0, 576));
	
	private OvenItemSlots mushroomRedRecipe = new OvenItemSlots(new MushroomRed(1, 0, 576), new Item[] {new RockPotWater(1, 0, 576)}, new RockPotMushroomRed(1, 0, 576));
	
	private OvenItemSlots mushroomBlueRecipe = new OvenItemSlots(new MushroomBlue(1, 0, 576), new Item[] {new RockPotWater(1, 0, 576)}, new RockPotMushroomBlue(1, 0, 576));
	
	private OvenItemSlots ironPickaxeClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldPickaxe(1, 0, 576)}, new IronPickaxeClay(1, 0, 576));
	
	private OvenItemSlots ironOrePickaxeClayRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new ClayMoldPickaxe(1, 0, 576)}, new IronPickaxeClay(1, 0, 576));
	
	private OvenItemSlots ironAxeClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldAxe(1, 0, 576)}, new IronAxeClay(1, 0, 576));
	
	private OvenItemSlots ironOreAxeClayRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new ClayMoldAxe(1, 0, 576)}, new IronAxeClay(1, 0, 576));
	
	public OvenItemSlots[] recipes = new OvenItemSlots[] {ironRecipe, ironSwordClayRecipe, ironOreSwordClayRecipe, sheepMeatRecipe,
			herbRecipe, mushroomRedRecipe, mushroomBlueRecipe, ironPickaxeClayRecipe, ironOrePickaxeClayRecipe, ironAxeClayRecipe,
			ironOreAxeClayRecipe};
	
	public Item checkOven(Item input, Item tray)
	{
		try
		{
			for(int i = 0; i < recipes.length; i++)
			{
				if(updateOven(input, tray, recipes[i]))
				{
					return recipes[i].getTarget().clone();
				}
			}
		}
		catch (Exception e) 
		{
		
		}
		
		return null;
	}
	
	public ArrayList<OvenItemSlots> itemOnOvensRecipes(Item item)
	{
		ArrayList<OvenItemSlots> items = new ArrayList<OvenItemSlots>();
		
		for(int i = 0; i < recipes.length; i++)
		{
			if(recipes[i].getInput().getClass() == item.getClass())
			{
				items.add(recipes[i]);
				continue;
			}
			
			for(int j = 0; j < recipes[i].getTrays().length; j++)
			{
				if(recipes[i].getTray(j).getClass() == item.getClass())
				{
					items.add(recipes[i]);
					break;
				}
			}
		}
		
		return items;
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
