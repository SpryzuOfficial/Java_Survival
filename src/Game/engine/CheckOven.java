package Game.engine;

import Game.Items.*;
import Game.Items.OvenItemSlots;

public class CheckOven 
{
	private OvenItemSlots ironRecipe = new OvenItemSlots(new IronOre(1, 0, 576), new Item[] {new BasaltTray(1, 0, 576)});
	
	private OvenItemSlots ironSwordClayRecipe = new OvenItemSlots(new Iron(1, 0, 576), new Item[] {new ClayMoldSword(1, 0, 576)});
	
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
