package Game.entities;

import Game.Items.Anvil;
import Game.engine.gfx.Assets;
import Game.ui.UiManager;

public class AnvilE extends StaticEntity
{
	public AnvilE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.anvilE, Gx, Gy, Vx, Vy, 64, 64, 780, 0, 0, 1);
		
		this.items.add(new Anvil(1, 0, 576));
	}
	
	@Override
	public void use()
	{
		UiManager.uiImage = Assets.anvilUI;
	}
}
