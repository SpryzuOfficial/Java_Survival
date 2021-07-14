package Game.Items;

import java.awt.image.BufferedImage;

public class Tool extends Item
{
	public Tool(BufferedImage texture, int x, int y, int miningValue1, int miningValue2, int miningValue3, int topLife) 
	{
		super(texture, 1, x, y, miningValue1, miningValue2, miningValue3, false, topLife, 0);
	}
}
