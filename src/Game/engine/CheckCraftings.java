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
	
	private CraftingItemsSlots[] polishedBasaltRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576)}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] stickRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576),  null}
																		  },
												 			  			  new Item[] {new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
														 				  new Item[] {new Sandpaper(0, 576)}  
																		  )
													};
	
	private CraftingItemsSlots[] clayMoldRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Clay(1, 0, 576), new Clay(1, 0, 576)}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576)}
																		  },
												              			  new Item[] {new Stick(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] basaltHammerRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576),  new PolishedBasalt(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)}
																		  )
													};
	
	private CraftingItemsSlots[] clayMoldSwordRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new WoodSwordTemplate(1, 0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new ClayMold(1, 0, 576), null}
																		  },
												              			  new Item[] {new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new ClayMold(1, 0, 576)}
																		  },
												              			  new Item[] {new WoodSwordTemplate(1, 0, 576)} 
																		  )
												};
	
	private CraftingItemsSlots[] woodPotHerbRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new RockPotHerb(1, 0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new WoodPot(1, 0, 576), null}
																		  },
												              			  new Item[] {new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new WoodPot(1, 0, 576)}
																		  },
												              			  new Item[] {new RockPotHerb(1, 0, 576)} 
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomRedRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new RockPotMushroomRed(1, 0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new WoodPot(1, 0, 576), null}
																		  },
												              			  new Item[] {new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new WoodPot(1, 0, 576)}
																		  },
												              			  new Item[] {new RockPotMushroomRed(1, 0, 576)} 
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomBlueRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new RockPotMushroomBlue(1, 0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new WoodPot(1, 0, 576), null}
																		  },
												              			  new Item[] {new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new WoodPot(1, 0, 576)}
																		  },
												              			  new Item[] {new RockPotMushroomBlue(1, 0, 576)} 
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldPickaxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new WoodPickaxeTemplate(1, 0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new ClayMold(1, 0, 576), null}
																		  },
												              			  new Item[] {new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new ClayMold(1, 0, 576)}
																		  },
												              			  new Item[] {new WoodPickaxeTemplate(1, 0, 576)} 
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldAxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new WoodAxeTemplate(1, 0, 576)}	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new ClayMold(1, 0, 576), null}
																		  },
												              			  new Item[] {new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new ClayMold(1, 0, 576)}
																		  },
												              			  new Item[] {new WoodAxeTemplate(1, 0, 576)} 
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
	
	private CraftingItemsSlots[] polishedBasaltRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] ovenRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Pickaxe(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Pickaxe(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] anvilRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Pickaxe(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Pickaxe(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] stickRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Clay(1, 0, 576), new Clay(1, 0, 576)}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Clay(1, 0, 576), new Clay(1, 0, 576), null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Clay(1, 0, 576), new Clay(1, 0, 576)}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Clay(1, 0, 576), new Clay(1, 0, 576), null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] basaltHammerRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] basaltTrayRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Sandpaper(0, 576)}
																		  ),
													
												};
	
	private CraftingItemsSlots[] woodSwordTemplateRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldSwordRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] rockFoodTrayRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
												};
	
	private CraftingItemsSlots[] rockPotRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodPotRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, new Wood(1, 0, 576)},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, new Wood(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, new Wood(1, 0, 576)},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, new Wood(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodPotHerbRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomRedRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomBlueRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodPickaxeTemplateRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldPickaxeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] woodAxeTemplateRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)}
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)}
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldAxeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)}
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
		
		if(updateCrafting(craftingItems, tools, polishedBasaltRecipes))
		{
			return new PolishedBasalt(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, stickRecipes))
		{
			return new Stick(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldRecipes))
		{
			return new ClayMold(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, basaltHammerRecipes))
		{
			return new BasaltHammer(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldSwordRecipes))
		{
			return new ClayMoldSword(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPotHerbRecipes))
		{
			return new WoodPotHerb(1, 0, 576);
		}

		if(updateCrafting(craftingItems, tools, woodPotMushroomRedRecipes))
		{
			return new WoodPotMushroomRed(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPotMushroomBlueRecipes))
		{
			return new WoodPotMushroomBlue(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldPickaxeRecipes))
		{
			return new ClayMoldPickaxe(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldAxeRecipes))
		{
			return new ClayMoldAxe(1, 0, 576);
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
		
		if(updateCrafting(craftingItems, tools, polishedBasaltRecipesTable))
		{
			return new PolishedBasalt(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, ovenRecipesTable))
		{
			return new Oven(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, anvilRecipesTable))
		{
			return new Anvil(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, stickRecipesTable))
		{
			return new Stick(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldRecipesTable))
		{
			return new ClayMold(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, basaltHammerRecipesTable))
		{
			return new BasaltHammer(0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, basaltTrayRecipesTable))
		{
			return new BasaltTray(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodSwordTemplateRecipesTable))
		{
			return new WoodSwordTemplate(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldSwordRecipesTable))
		{
			return new ClayMoldSword(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, rockFoodTrayRecipesTable))
		{
			return new RockFoodTray(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, rockPotRecipesTable))
		{
			return new RockPot(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPotRecipesTable))
		{
			return new WoodPot(4, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPotHerbRecipesTable))
		{
			return new WoodPotHerb(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPotMushroomRedRecipesTable))
		{
			return new WoodPotMushroomRed(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPotMushroomBlueRecipesTable))
		{
			return new WoodPotMushroomBlue(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodPickaxeTemplateRecipesTable))
		{
			return new WoodPickaxeTemplate(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldPickaxeRecipesTable))
		{
			return new ClayMoldPickaxe(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, woodAxeTemplateRecipesTable))
		{
			return new WoodAxeTemplate(1, 0, 576);
		}
		
		if(updateCrafting(craftingItems, tools, clayMoldAxeRecipesTable))
		{
			return new ClayMoldAxe(1, 0, 576);
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
