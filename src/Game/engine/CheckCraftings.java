package Game.engine;

import Game.Items.*;

public class CheckCraftings 
{
	private CraftingItemsSlots[] stringRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wool(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															 			  null
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wool(1, 0, 576)}, 
														   			        {null, null}
																		  },
												 			  			  null	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new Wool(1, 0, 576), null}
																		  },
												 			              null
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Wool(1, 0, 576)}
																		  },
												 			  		      null 
																		  )
												};
	
	private CraftingItemsSlots[] sandpaperRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576),  null}
																		  },
												 			  			  new StringItem(1, 0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
															     	 	  new StringItem(1, 0, 576)  
																		  )
													};
	
	private CraftingItemsSlots[] axeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576),  new Wood(1, 0, 576)}
																		  },
												 			  			  new Sandpaper(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Stone(1, 0, 576)}
																		  },
														 				  new Sandpaper(0, 576)   
																		  )
													};
	
	private CraftingItemsSlots[] pickaxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
												 			  			  new Sandpaper(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
														 				  new Sandpaper(0, 576)   
																		  )
													};
	
	private CraftingItemsSlots[] knifeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
												 			  			  new Sandpaper(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
														 				  new Sandpaper(0, 576)   
																		  )
													};
	
	private CraftingItemsSlots[] hammerRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576),  new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
												 			  			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
														 				  new StringItem(1, 0, 576)
																		  )
													};
	
	private CraftingItemsSlots[] woodTableRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576)}, 
														   			        {null, null}
																		  },
															    		  new Sandpaper(0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
															 			  new Sandpaper(0, 576) 
																		  )
												};
	private CraftingItemsSlots[] nailsRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {new Stone(1, 0, 576),  null}
																		  },
												 			  			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Stone(1, 0, 576)}
																		  },
														 				  new Sandpaper(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {null, null}
																		  },
														 				  new Sandpaper(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null, null}
																		  },
														 				  new Sandpaper(0, 576) 
																		  )
												};
	private CraftingItemsSlots[] tableRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576),  new Wood(1, 0, 576)}
																		  },
												 			  			  new Hammer(0, 576)
																		  )
												};
	
	public Item checkCrafting(Item[][] craftingItems, Item tool)
	{
		if(updateCrafting(craftingItems, tool, stringRecipes))
		{
			return new StringItem(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, sandpaperRecipes))
		{
			return new Sandpaper(0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, axeRecipes))
		{
			return new Axe(0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, pickaxeRecipes))
		{
			return new Pickaxe(0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, knifeRecipes))
		{
			return new Knife(0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, hammerRecipes))
		{
			return new Hammer(0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, woodTableRecipes))
		{
			return new WoodTable(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, nailsRecipes))
		{
			return new Nail(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tool, tableRecipes))
		{
			return new Table(1, 0, 576);
		}
		
		return null;
	}
	
	public boolean updateCrafting(Item[][] craftingItems, Item tool, CraftingItemsSlots[] recipes)
	{
		boolean band = true;
        
		for(int i = 0;  i < recipes.length; i++)
		{
	        for(int y = 0; y < 2; y++)
	        {
	            for(int x = 0; x < 2; x++)
	            {
	            	if(tool == null && recipes[i].getTool() == null)
	        		{
	            		band = true;
	        		}
	        		else
	        		{
	        			if(tool != null && recipes[i].getTool() != null)
	        			{
	        				if(tool.getClass() == recipes[i].getTool().getClass())
	        				{
	        					band = true;
	        				}
	        				else
	        				{
	        					band = false;   
			                    break;
	        				}
	        			}
	        			else
	        			{
	        				band = false;   
		                    break;
	        			}
	        		}
	            	
	            	if(craftingItems[y][x] == null && recipes[i].getItem(y, x) == null)
	            	{
	            		band = true;
	            	}
	            	else
	            	{
	            		if(craftingItems[y][x] != null && recipes[i].getItem(y, x) != null)
	            		{
		            		if(craftingItems[y][x].getClass() == recipes[i].getItem(y, x).getClass())
			                {
			                    band = true;
			                }
			                else
			                {
			                    band = false;   
			                    break;
			                }
	            		}
	            		else
            			{
            			 	band = false;   
		                    break;
            			}
	            	}
	            }
	            
	            if(!band)
	            {
	                break;
	            }
	        }
	        
	        if(band)
        	{
        		break;
        	}
		}
        
        return band;
	}
}
