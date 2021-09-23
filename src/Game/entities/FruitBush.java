package Game.entities;

import Game.Items.Fruit;
import Game.Items.RootenFruit;
import Game.engine.gfx.Assets;

public class FruitBush extends StaticEntity
{
	public FruitBush(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.fruitBush, Gx, Gy, Vx, Vy, 64, 64, 40, 0, 0, 0);
		
		this.items.add(new Fruit(1, 0, 576));
		this.items.add(new RootenFruit(1, 0, 576));
		this.probs.add(0.0);
		this.probs.add(0.9);
		this.entityReplace = new Bush(this.Vx, this.Vy, this.getX(), this.getY());
	}
}
