package Game.Items;

public class AnvilItemSlots 
{
	private Item input;
	private Item tool;
	
	public AnvilItemSlots(Item input, Item tool) 
	{
		this.input = input;
		this.tool = tool;
	}

	public Item getInput() 
	{
		return input;
	}

	public Item getTool() 
	{
		return tool;
	}
}
