package Game.biomes;

import Game.engine.Game;
import Game.entities.*;
import Game.tiles.*;

public class WetForest extends Biome
{
	public WetForest()
	{
		
	}
	
	@Override
	public Tile generateTiles(double f, double v, int x, int y)
	{
		return new Dirt(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
	}
	
	@Override
	public Entity generateEntities(double f, double v, int x, int y)
	{
		return null;
	}
}
