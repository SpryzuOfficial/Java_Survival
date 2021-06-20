package Game.biomes;

import Game.engine.Game;
import Game.entities.*;
import Game.tiles.*;

public class Forest extends Biome
{
	public Forest()
	{
		
	}
	
	@Override
	public Tile generateTiles(double f, double v, int x, int y)
	{
		return new Grass(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
	}
	
	@Override
	public Entity generateEntities(double f, double v, int x, int y)
	{
		return null;
	}
}
