package Game.biomes;

import Game.engine.Game;
import Game.entities.*;
import Game.tiles.*;

public class Desert extends Biome
{
	public Desert()
	{
		
	}
	
	@Override
	public Tile generateTiles(double f, double v, int x, int y)
	{
		if(f < 0.6)
		{
			if(v > 0.55 && v < 0.7)
			{
				return new Sand(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
			}
			else
			{
				return new Water(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
			}
		}
		else
		{
			if(v > 0.3 && v < 0.4)
			{
				return new Sand(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
			}
			else
			{
				return new Water(x * 64, y * 64, x * 64 - Game.virtualSpace.getX(), y * 64 - Game.virtualSpace.getY(), 64, 64);
			}
		}
	}
	
	@Override
	public Entity generateEntities(double f, double v, int x, int y)
	{
		return null;
	}
}
