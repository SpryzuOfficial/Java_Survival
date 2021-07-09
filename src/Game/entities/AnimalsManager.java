package Game.entities;

import java.awt.Graphics;

import Game.Items.Wool;
import Game.engine.Game;
import Game.ui.UiInventoryManager;

public class AnimalsManager 
{
	private static boolean animalLeftPressed;
	public static float destructionBarValue = 0;
	
	private static int otherFocusId = -999999;
	
	public AnimalsManager() 
	{
		
	}
	
	public static void tick()
	{
		for(int i = 0; i < Game.generateWorld.ASIZE; i++)
		{
			if(Game.generateWorld.getAnimals().get(i).getVx() + Game.generateWorld.getAnimals().get(i).getWidth() > Game.player.getVx() - 1000 && Game.generateWorld.getAnimals().get(i).getVx() < (Game.player.getVx() + Game.player.getWidth()) + 1000
			   && Game.generateWorld.getAnimals().get(i).getVy() + Game.generateWorld.getAnimals().get(i).getHeight() < Game.player.getVy() + 1000 && Game.generateWorld.getAnimals().get(i).getVy() > (Game.player.getVy() + Game.player.getHeight()) - 1000)
			{
				Game.generateWorld.getAnimals().get(i).setOnRange(true);
			}
			else
			{
				Game.generateWorld.getAnimals().get(i).setOnRange(false);
			}
			Game.generateWorld.getAnimals().get(i).tick();
			
			if(Game.mouseManager.getMouseX() >= Game.generateWorld.getAnimals().get(i).getX() &&
				Game.mouseManager.getMouseX() <= Game.generateWorld.getAnimals().get(i).getX() + Game.generateWorld.getAnimals().get(i).getWidth() &&
				Game.mouseManager.getMouseY() >= Game.generateWorld.getAnimals().get(i).getY() &&
				Game.mouseManager.getMouseY() <= Game.generateWorld.getAnimals().get(i).getY() + Game.generateWorld.getAnimals().get(i).getHeight())
			{
				otherFocusId = i;
				Game.pointerX = Game.generateWorld.getAnimals().get(i).getX();	
				Game.pointerY = Game.generateWorld.getAnimals().get(i).getY();
				
				destructionBarValue = (int) (((((Game.generateWorld.getAnimals().get(i).getLife() * 100) / Game.generateWorld.getAnimals().get(i).getTopLife())/100f)) * 64);
				
				if(!animalLeftPressed)
				{
					if(Game.mouseManager.isLeftPressed())
					{
						if(UiInventoryManager.inventoryTool != null)
						{
							Game.generateWorld.getAnimals().get(i).setDamage(UiInventoryManager.inventoryTool.getMiningValue(2));
						}
						else
						{
							Game.generateWorld.getAnimals().get(i).setDamage(1);
						}
						
						Game.generateWorld.getAnimals().get(i).setPunched(true);
						animalLeftPressed = true;
					}
				}
				else if(!Game.mouseManager.isLeftPressed())
				{
					animalLeftPressed = false;
				}
				
				if(Game.generateWorld.getAnimals().get(i).getLife() <= 0)
				{
					for (int j = 0; j < Game.generateWorld.getAnimals().get(i).getItems().size(); j++)
					{
						if(Game.generateWorld.getAnimals().get(i).getItems().get(j) != null)
						{
							UiInventoryManager.addItem(Game.generateWorld.getAnimals().get(i).getItems().get(j));
						}
					}
					
					Game.generateWorld.getAnimals().remove(i);
					Game.generateWorld.ASIZE--;
					if(UiInventoryManager.inventoryTool != null)
					{
						UiInventoryManager.inventoryTool.setLife(UiInventoryManager.inventoryTool.getLife() + 1);
						if(UiInventoryManager.inventoryTool.getLife() == UiInventoryManager.inventoryTool.getTopLife())
						{
							UiInventoryManager.inventoryTool = null;
							UiInventoryManager.toolInventorySlot.setItem(UiInventoryManager.inventoryTool);
						}
					}
				}
			}
			else if(otherFocusId == i)
			{
				destructionBarValue = 0;
			}
		}
	}
	
	public static void render(Graphics g)
	{
		for(int i = 0; i < Game.generateWorld.ASIZE; i++)
		{
			if(Game.generateWorld.getAnimals().get(i).getX() + Game.generateWorld.getAnimals().get(i).getWidth() > 0 && Game.generateWorld.getAnimals().get(i).getX() < 0 + Game.width
			   && Game.generateWorld.getAnimals().get(i).getY() + Game.generateWorld.getAnimals().get(i).getHeight() > 0 && Game.generateWorld.getAnimals().get(i).getY() < 0 + Game.height)
			{
				Game.generateWorld.getAnimals().get(i).render(g);
			}
		}
	}
}
