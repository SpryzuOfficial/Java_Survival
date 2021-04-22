package Game.Items;

public class CraftingItemsSlots 
{
	private Item[][] item;
	private Item tool;
	
	public CraftingItemsSlots(Item[][] item, Item tool)
	{
		this.item = item;
		this.tool = tool;
	}

	public Item getItem(int y, int x) 
	{
		return item[y][x];
	}
	
	public Item getTool() 
	{
		return tool;
	}
}
