package Game.Items;

public class CraftingItemsSlots 
{
	private Item[][] item;
	private Item[] tools;
	
	public CraftingItemsSlots(Item[][] item, Item[] tools)
	{
		this.item = item;
		this.tools = tools;
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
}
