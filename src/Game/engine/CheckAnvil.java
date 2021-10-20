package Game.engine;

import java.util.ArrayList;

import Game.Items.*;

public class CheckAnvil
{
	private AnvilItemSlots ironRecipe = new AnvilItemSlots(new IronBasaltTray(1, 0, 576), new BasaltHammer(0, 576), new Iron(1, 0, 576));
	
	private AnvilItemSlots ironSwordRecipe = new AnvilItemSlots(new IronSwordClay(1, 0, 576), new BasaltHammer(0, 576), new IronSword(0, 576));
	
	private AnvilItemSlots ironPickaxeRecipe = new AnvilItemSlots(new IronPickaxeClay(1, 0, 576), new BasaltHammer(0, 576), new IronPickaxe(0, 576));
	
	private AnvilItemSlots ironAxeRecipe = new AnvilItemSlots(new IronAxeClay(1, 0, 576), new BasaltHammer(0, 576), new IronAxe(0, 576));
	
	public AnvilItemSlots[] recipes = new AnvilItemSlots[] {ironRecipe, ironSwordRecipe, ironPickaxeRecipe, ironAxeRecipe};
	
	public Item checkAnvil(Item input, Item tool)
	{
		try
		{
			for(int i = 0; i < recipes.length; i++)
			{
				if(updateAnvil(input, tool, recipes[i]))
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
	
	public ArrayList<AnvilItemSlots> itemOnAnvilsRecipes(Item item)
	{
		ArrayList<AnvilItemSlots> items = new ArrayList<AnvilItemSlots>();
		
		for(int i = 0; i < recipes.length; i++)
		{
			if(recipes[i].getInput().getClass() == item.getClass())
			{
				items.add(recipes[i]);
				continue;
			}
			
			if(recipes[i].getTool().getClass() == item.getClass())
			{
				items.add(recipes[i]);
				continue;
			}
		}
		
		return items;
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
