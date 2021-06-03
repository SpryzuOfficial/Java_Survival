package Game.entities;

import Game.Items.Oven;
import Game.engine.gfx.Assets;
import Game.ui.UiManager;

public class OvenE extends StaticEntity
{
	public OvenE(int Vx, int Vy, int Gx, int Gy)
	{
		super(Assets.ovenE, Gx, Gy, Vx, Vy, 64, 64, 420, 0, 0, 1);
		
		this.items.add(new Oven(1, 0, 576));
	}
	
	@Override
	public void use()
	{
		UiManager.uiImage = Assets.ovenUI;
	}
}
