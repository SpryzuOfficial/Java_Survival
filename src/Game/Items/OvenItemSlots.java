package Game.Items;

public class OvenItemSlots
{
	private Item input;
	private Item[] trays;
	private Item target;
	
	public OvenItemSlots(Item input, Item[] trays, Item target)
	{
		this.input = input;
		this.trays = trays;
		this.target = target;
	}
	
	public Item getInput() 
	{
		return input;
	}
	
	public Item getTray(int i)
	{
		return trays[i];
	}
	
	public Item[] getTrays()
	{
		return trays;
	}

	public Item getTarget()
	{
		return target;
	}
}
