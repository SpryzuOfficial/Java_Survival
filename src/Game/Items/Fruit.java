package Game.Items;

import Game.engine.gfx.Assets;

public class Fruit extends Food
{
	public Fruit(int count, int x, int y) 
	{
		super(Assets.fruit, count, x, y, 0.5, null);
	}
	
	@Override
	public String toString()
	{
		return "Fruit";
	}
}
