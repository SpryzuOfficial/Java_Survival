package Game.engine;

import Game.Items.*;

public class CheckCraftings 
{
	private CraftingItemsSlots[] stringRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wool(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wool(1, 0, 576)}, 
														   			        {null, null}
																		  },
															 			  new Item[] {null}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new Wool(1, 0, 576), null}
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Wool(1, 0, 576)}
																		  },
															 			  new Item[] {null} 
																		  )
												};
	
	private CraftingItemsSlots[] sandpaperRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576),  null}
																		  },
												 			  			  new Item[] {new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
														 				  new Item[] {new StringItem(1, 0, 576)}  
																		  )
													};
	
	private CraftingItemsSlots[] axeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576),  new Wood(1, 0, 576)}
																		  },
														 				  new Item[] {new Sandpaper(0, 576)} 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Stone(1, 0, 576)}
																		  },
															 			  new Item[] {new Sandpaper(0, 576)}   
																		  )
													};
	
	private CraftingItemsSlots[] pickaxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
															 			  new Item[] {new Sandpaper(0, 576)} 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Item[] {new Sandpaper(0, 576)}   
																		  )
													};
	
	private CraftingItemsSlots[] knifeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
														 			      new Item[] {new Sandpaper(0, 576)} 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															        	  new Item[] {new Sandpaper(0, 576)}   
																		  )
													};
	
	private CraftingItemsSlots[] hammerRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576),  new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)}
																		  )
													};
	
	private CraftingItemsSlots[] woodTableRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)} 
																		  )
												};
	private CraftingItemsSlots[] nailsRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {new Stone(1, 0, 576),  null}
																		  },
												              		      new Item[] {new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Stone(1, 0, 576)}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {null, null}
																		  },
											              				  new Item[] {new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null, null}
																		  },
											              				  new Item[] {new Sandpaper(0, 576)} 
																		  )
												};
	private CraftingItemsSlots[] tableRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576),  new Wood(1, 0, 576)}
																		  },
												              			  new Item[] {new Hammer(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] stringRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wool(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wool(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wool(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wool(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wool(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wool(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Wool(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Wool(1, 0, 576), null},
																		  },
															 			  new Item[] {null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Wool(1, 0, 576)},
																		  },
															 			  new Item[] {null}
																		  )
												};
	
	private CraftingItemsSlots[] sandpaperRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] axeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] pickaxeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] knifeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] hammerRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodTableRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] nailsRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Stone(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Stone(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] tableRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodPlankRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)}
																		  )
												};
	
	public Item checkCrafting(Item[][] craftingItems, Item[] tools)
	{
		if(updateCrafting(craftingItems, tools, stringRecipes))
		{
			return new StringItem(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, sandpaperRecipes))
		{
			return new Sandpaper(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, axeRecipes))
		{
			return new Axe(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, pickaxeRecipes))
		{
			return new Pickaxe(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, knifeRecipes))
		{
			return new Knife(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, hammerRecipes))
		{
			return new Hammer(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodTableRecipes))
		{
			return new WoodTable(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, nailsRecipes))
		{
			return new Nail(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, tableRecipes))
		{
			return new Table(1, 0, 576);
		}
		
		return null;
	}
	
	public Item checkCraftingTable(Item[][] craftingItems, Item[] tools)
	{
		if(updateCrafting(craftingItems, tools, stringRecipesTable))
		{
			return new StringItem(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, sandpaperRecipesTable))
		{
			return new Sandpaper(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, axeRecipesTable))
		{
			return new Axe(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, pickaxeRecipesTable))
		{
			return new Pickaxe(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, knifeRecipesTable))
		{
			return new Knife(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, hammerRecipesTable))
		{
			return new Hammer(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodTableRecipesTable))
		{
			return new WoodTable(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, nailsRecipesTable))
		{
			return new Nail(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, tableRecipesTable))
		{
			return new Table(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPlankRecipesTable))
		{
			return new WoodPlank(1, 0, 576);
		}
		
		return null;
	}
	
	public boolean updateCrafting(Item[][] craftingItems, Item[] tools, CraftingItemsSlots[] recipes)
	{
		boolean band = true;
        
		for(int i = 0;  i < recipes.length; i++)
		{
	        for(int y = 0; y < craftingItems.length; y++)
	        {
	            for(int x = 0; x < craftingItems.length; x++)
	            {
	            	for(int j = 0; j < recipes[i].getTools().length; j++)
	            	{
		            	if(tools[j] == null && recipes[i].getTool(j) == null)
		        		{
		            		band = true;
		        		}
		        		else
		        		{
		        			if(tools[j] != null && recipes[i].getTool(j) != null)
		        			{
		        				if(tools[j].getClass() == recipes[i].getTool(j).getClass())
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
