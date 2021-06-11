package Game.engine;

import Game.Items.AnvilItemSlots;
import Game.Items.*;

public class CheckAnvil
{
	private AnvilItemSlots ironRecipe = new AnvilItemSlots(new IronBasaltTray(1, 0, 576), new BasaltHammer(0, 576));
	
	private AnvilItemSlots ironSwordRecipe = new AnvilItemSlots(new IronSwordClay(1, 0, 576), new BasaltHammer(0, 576));
	
	public Item checkAnvil(Item input, Item tool)
	{
		if(updateAnvil(input, tool, ironRecipe))
		{
			return new Iron(1, 0, 576);
		}
		
		if(updateAnvil(input, tool, ironSwordRecipe))
		{
			return new IronSword(0, 576);
		}
		
		return null;
	}
	
	public boolean updateAnvil(Item input, Item tool, AnvilItemSlots recipe)
	{
		if(input == null || tool == null)
		{
			return false;
		}
		
		if(input.getClass() != recipe.getInput().getClass())
		{
			return false;
		}
		
		if(tool.getClass() == recipe.getTool().getClass())
		{
			return true;
		}
		
		return false;
	}
}
