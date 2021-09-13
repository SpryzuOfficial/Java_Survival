package Game.Items;

import java.util.ArrayList;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.entities.ChestE;
import Game.entities.StaticEntity;
import Game.tiles.Tile;
import Game.tiles.TileManager;

public class Chest extends Item
{
	public Chest(int count, int x, int y) 
	{
		super(Assets.chest, count, x, y, 1, 1, 1, true, -1, 0);
	}
	
	@Override
	public boolean place()
	{
		ArrayList<StaticEntity> sEntities = Game.generateWorld.getSEntities();
		Tile tile = Game.generateWorld.getFromTile(TileManager.y, TileManager.x);
		StaticEntity entity = new ChestE(tile.getVx(), tile.getVy(), tile.getGx(), tile.getGy());
		
		for(int i = 0;  i < Game.generateWorld.SESIZE; i++)
		{
			if(sEntities.get(i).getVx() == entity.getVx() && sEntities.get(i).getVy() == entity.getVy())
			{
				return false;
			}
		}
		
		Game.generateWorld.getSEntities().add(entity);
		Game.generateWorld.SESIZE++;
		
		return true;
	}
}
