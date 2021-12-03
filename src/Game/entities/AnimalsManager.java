package Game.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import Game.Items.Item;
import Game.engine.Game;
import Game.ui.UiInventoryManager;
import Game.ui.UiManager;

public class AnimalsManager 
{
	public static ArrayList<Integer> index = new ArrayList<Integer>();
	public static int framesLastUpdate = 320;
	
	private static boolean animalLeftPressed;
	public static float destructionBarValue = 0;
	
	private static int otherFocusId = -999999;
	
	public AnimalsManager() 
	{
		
	}
	
	public static void tick()
	{
		try
		{
			if(framesLastUpdate == 320)
			{
				index = new ArrayList<Integer>();
				for(int i = 0; i < Game.generateWorld.ASIZE; i++)
				{
					double c = Math.sqrt(Math.pow(Math.abs(Game.generateWorld.getAnimals().get(i).Vx - Game.virtualSpace.getX()), 2) + Math.pow(Math.abs(Game.generateWorld.getAnimals().get(i).Vx - Game.virtualSpace.getX()), 2));
					
					c /= 64;
					
					if(c < 32)
					{
						index.add(i);
					}
				}
				
				framesLastUpdate = 0;
			}
			
			framesLastUpdate++;
			
			for(int i = 0; i < index.size(); i++)
			{
				Animal animal = Game.generateWorld.getAnimals().get(index.get(i));
				
				if(animal.getVx() + animal.getWidth() > Game.player.getVx() - 1000 && animal.getVx() < (Game.player.getVx() + Game.player.getWidth()) + 1000
				   && animal.getVy() + animal.getHeight() < Game.player.getVy() + 1000 && animal.getVy() > (Game.player.getVy() + Game.player.getHeight()) - 1000)
				{
					animal.setOnRange(true);
				}
				else
				{
					animal.setOnRange(false);
				}
				
				animal.tick();
				
				boolean animalCol = false;
				for(int j = 0; j < StaticEntitiesManager.index.size(); j++)
				{
					if((animal.getVx() + animal.getWidth() > Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(j)).getVx() && animal.getVx() < Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(j)).getVx() + Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(j)).getWidth()
					   && animal.getVy() + animal.getHeight() > Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(j)).getVy() && animal.getVy() < Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(j)).getVy() + Game.generateWorld.getSEntities().get(StaticEntitiesManager.index.get(j)).getHeight())
					   || 
					   (animal.getVx() + animal.getWidth() > Game.player.getVx() && animal.getVx() < Game.player.getVx() + Game.player.getWidth()
					   && animal.getVy() + animal.getHeight() > Game.player.getVy() && animal.getVy() < Game.player.getVy() + Game.player.getHeight()))
					{
						animalCol = true;
						animal.setVx(animal.getLastX());
						animal.setVy(animal.getLastY());
						break;
					}
					else
					{
						animalCol = false;
					}
				}
				
				if(!animalCol)
				{
					animal.setLastX(animal.getVx());
					animal.setLastY(animal.getVy());
				}
				
				if(Game.mouseManager.getMouseX() >= animal.getX() &&
					Game.mouseManager.getMouseX() <= animal.getX() + animal.getWidth() &&
					Game.mouseManager.getMouseY() >= animal.getY() &&
					Game.mouseManager.getMouseY() <= animal.getY() + animal.getHeight())
				{
					otherFocusId = i;
					Game.pointerX = animal.getX();	
					Game.pointerY = animal.getY();
					
					destructionBarValue = (int) (((((animal.getLife() * 100) / animal.getTopLife())/100f)) * 64);
					
					if(!animalLeftPressed)
					{
						if(UiManager.uiImage == null)
						{
							if(Game.mouseManager.isLeftPressed())
							{
								if(UiInventoryManager.inventoryTool != null)
								{
									animal.setDamage(UiInventoryManager.inventoryTool.getMiningValue(2));
								}
								else
								{
									animal.setDamage(1);
								}
								
								animal.setPunched(true);
								animalLeftPressed = true;
							}
						}
					}
					else if(!Game.mouseManager.isLeftPressed())
					{
						animalLeftPressed = false;
					}
					
					if(animal.getLife() <= 0)
					{
						for (int j = 0; j < animal.getItems().size(); j++)
						{
							if(animal.getItems().get(j) != null)
							{
								Item dropItem = animal.getItems().get(j).clone();
								dropItem.setX(animal.getX());
								dropItem.setY(animal.getY());
								dropItem.setVx(animal.getVx());
								dropItem.setVy(animal.getVy());
								Game.generateWorld.getItems().add(dropItem);
							}
						}
						
						Game.generateWorld.getAnimals().remove((int) index.get(i));
						Game.generateWorld.ASIZE--;
						index.remove(i);
						
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
		catch(Exception e)
		{
			System.err.println(e);
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
