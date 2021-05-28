package Game.Items;

import java.awt.Graphics;
import java.util.ArrayList;

import Game.engine.Game;
import Game.engine.gfx.Assets;
import Game.entities.*;
import Game.tiles.Tile;
import Game.tiles.TileManager;

public class WoodPlank extends Item
{
	public WoodPlank(int count, int x, int y) 
	{
		super(Assets.woodPlank, count, x, y, 1, 1, 1, true, -1);
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(texture, x, y, 64, 64, null);
	}
	
	@Override
	public boolean use()
	{
		ArrayList<StaticEntity> sEntities = Game.generateWorld.getSEntities();
		Tile tile = Game.generateWorld.getFromTile(TileManager.y, TileManager.x);
		StaticEntity entity = new WoodPlankE(tile.getVx(), tile.getVy(), tile.getGx(), tile.getGy());
		
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