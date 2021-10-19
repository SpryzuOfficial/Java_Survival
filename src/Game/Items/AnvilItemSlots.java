package Game.Items;

public class AnvilItemSlots 
{
	private Item input;
	private Item tool;
	private Item target;
	
	public AnvilItemSlots(Item input, Item tool, Item target) 
	{
		this.input = input;
		this.tool = tool;
		this.target = target;
	}

	public Item getInput() 
	{
		return input;
	}

	public Item getTool() 
	{
		return tool;
	}

	public Item getTarget() 
	{
		return target;
	}
}
