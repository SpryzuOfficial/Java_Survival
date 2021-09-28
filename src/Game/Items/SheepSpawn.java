package Game.Items;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.entities.Sheep;

public class SheepSpawn extends Item
{
	public SheepSpawn(int count, int x, int y) 
	{
		super(Assets.sheepSpawn, count, x, y, 1, 1, 1, false, -1, 1);
	}
	
	@Override
	public boolean use()
	{	
		Game.generateWorld.getAnimals().add(new Sheep(Game.player.getVx() + 64, Game.player.getVy(), Game.player.getVx() + 64 - Game.virtualSpace.getX(), Game.player.getVy() + 64 - Game.virtualSpace.getY()));
		Game.generateWorld.ASIZE++;
		
		this.refreshAnimals();
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Sheep Spawn";
	}
}
