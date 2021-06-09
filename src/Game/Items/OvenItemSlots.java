package Game.Items;

public class OvenItemSlots
{
	private Item input;
	private Item[] trays;
	
	public OvenItemSlots(Item input, Item[] trays)
	{
		this.input = input;
		this.trays = trays;
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
}
