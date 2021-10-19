package Game.Items;

public class CraftingItemsSlots 
{
	private Item[][] item;
	private Item[] tools;
	private Item target;
	
	public CraftingItemsSlots(Item[][] item, Item[] tools, Item target)
	{
		this.item = item;
		this.tools = tools;
		this.target = target;
	}

	public Item getItem(int y, int x) 
	{
		return item[y][x];
	}
	
	public Item getTool(int i) 
	{
		return tools[i];
	}
	
	public Item[] getTools()
	{
		return tools;
	}

	public Item getTarget()
	{
		return target;
	}
}
