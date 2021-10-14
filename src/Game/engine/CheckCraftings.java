package Game.engine;

import java.util.ArrayList;

import Game.Items.*;

public class CheckCraftings 
{
	private CraftingItemsSlots[] stringRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wool(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wool(1, 0, 576)}, 
														   			        {null, null}
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new Wool(1, 0, 576), null}
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Wool(1, 0, 576)}
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576) 
																		  )
												};
	
	private CraftingItemsSlots[] sandpaperRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576),  null}
																		  },
												 			  			  new Item[] {new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
														 				  new Item[] {new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576) 
																		  )
													};
	
	private CraftingItemsSlots[] axeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576),  new Wood(1, 0, 576)}
																		  },
														 				  new Item[] {new Sandpaper(0, 576)},
															 			  new Axe(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Stone(1, 0, 576)}
																		  },
															 			  new Item[] {new Sandpaper(0, 576)},
															 			  new Axe(0, 576)   
																		  )
													};
	
	private CraftingItemsSlots[] pickaxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
															 			  new Item[] {new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Item[] {new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)   
																		  )
													};
	
	private CraftingItemsSlots[] knifeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
														 			      new Item[] {new Sandpaper(0, 576)},
															 			  new Knife(0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															        	  new Item[] {new Sandpaper(0, 576)},
															 			  new Knife(0, 576)   
																		  )
													};
	
	private CraftingItemsSlots[] hammerRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576),  new Stone(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  )
													};
	
	private CraftingItemsSlots[] woodTableRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] nailsRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {new Stone(1, 0, 576),  null}
																		  },
												              		      new Item[] {new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new Stone(1, 0, 576)}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null}, 
														   			        {null, null}
																		  },
											              				  new Item[] {new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576)}, 
														   			        {null, null}
																		  },
											              				  new Item[] {new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576) 
																		  )
												};
	private CraftingItemsSlots[] tableRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576),  new Wood(1, 0, 576)}
																		  },
												              			  new Item[] {new Hammer(0, 576)},
															 			  new Table(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] polishedBasaltRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576)}
																		  },
												              			  new Item[] {new Sandpaper(0, 576)},
															 			  new PolishedBasalt(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] stickRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576),  null}
																		  },
												 			  			  new Item[] {new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576)}
																		  },
														 				  new Item[] {new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)  
																		  )
													};
	
	private CraftingItemsSlots[] clayMoldRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Clay(1, 0, 576), new Clay(1, 0, 576)}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576)}
																		  },
												              			  new Item[] {new Stick(1, 0, 576)},
															 			  new ClayMold(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] basaltHammerRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576),  new PolishedBasalt(1, 0, 576)}, 
														   			        {null,  new Wood(1, 0, 576)}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), null}
																		  },
															 			  new Item[] {new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  )
													};
	
	private CraftingItemsSlots[] clayMoldSwordRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new ClayMold(1, 0, 576), null}
																		  },
												              			  new Item[] {new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new ClayMold(1, 0, 576)}
																		  },
												              			  new Item[] {new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576) 
																		  )
												};
	
	private CraftingItemsSlots[] woodPotHerbRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new WoodPot(1, 0, 576), null}
																		  },
												              			  new Item[] {new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new WoodPot(1, 0, 576)}
																		  },
												              			  new Item[] {new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576) 
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomRedRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new WoodPot(1, 0, 576), null}
																		  },
												              			  new Item[] {new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new WoodPot(1, 0, 576)}
																		  },
												              			  new Item[] {new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576) 
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomBlueRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new WoodPot(1, 0, 576), null}
																		  },
												              			  new Item[] {new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new WoodPot(1, 0, 576)}
																		  },
												              			  new Item[] {new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576) 
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldPickaxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new ClayMold(1, 0, 576), null}
																		  },
												              			  new Item[] {new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new ClayMold(1, 0, 576)}
																		  },
												              			  new Item[] {new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldAxeRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null}
																		  },
															              new Item[] {new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576)}, 
														   			        {null, null}
																		  },
												              			  new Item[] {new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)	 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null,                null}, 
														   			        {new ClayMold(1, 0, 576), null}
																		  },
												              			  new Item[] {new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null}, 
														   			        {null, new ClayMold(1, 0, 576)}
																		  },
												              			  new Item[] {new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576) 
																		  )
												};
	
	private CraftingItemsSlots[] needleRecipes = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576)}, 
														   			        {null,  new Stone(1, 0, 576)}
																		  },
														 			      new Item[] {new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576) 
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null}, 
														   			        {new Stone(1, 0, 576), null}
																		  },
															        	  new Item[] {new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)   
																		  )
												};
	
	public CraftingItemsSlots[][] recipes4 = new CraftingItemsSlots[][] {stringRecipes, sandpaperRecipes, axeRecipes, pickaxeRecipes, knifeRecipes, 
		hammerRecipes, woodTableRecipes, nailsRecipes, tableRecipes, polishedBasaltRecipes, stickRecipes, clayMoldRecipes, basaltHammerRecipes,
		clayMoldSwordRecipes, woodPotHerbRecipes, woodPotMushroomRedRecipes, woodPotMushroomBlueRecipes, clayMoldPickaxeRecipes, clayMoldAxeRecipes,
		needleRecipes};
	
	private CraftingItemsSlots[] stringRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wool(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wool(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wool(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wool(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wool(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wool(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Wool(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Wool(1, 0, 576), null},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Wool(1, 0, 576)},
																		  },
															 			  new Item[] {null},
															 			  new StringItem(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] sandpaperRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Sandpaper(0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Sandpaper(0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] axeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Stone(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Axe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Axe(0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] pickaxeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Pickaxe(0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] knifeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Knife(0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Knife(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Knife(0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] hammerRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new Hammer(0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodTableRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodTable(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] nailsRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Stone(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stone(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stone(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new Stone(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Nail(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] tableRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), null},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), null},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), null},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), null},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)},
															 			  new Table(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Hammer(0, 576)},
															 			  new Table(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodPlankRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)}, 
														   			        {null, new WoodTable(1, 0, 576), new WoodTable(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null}, 
														   			        {new WoodTable(1, 0, 576), new WoodTable(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)},
															 			  new WoodPlank(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] polishedBasaltRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {null, new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new PolishedBasalt(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new PolishedBasalt(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] ovenRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Pickaxe(0, 576), new Hammer(0, 576)},
															 			  new Oven(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Pickaxe(0, 576)},
															 			  new Oven(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] anvilRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Pickaxe(0, 576), new Hammer(0, 576)},
															 			  new Anvil(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Pickaxe(0, 576)},
															 			  new Anvil(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] stickRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Stick(1, 0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Stick(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Clay(1, 0, 576), new Clay(1, 0, 576)}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Clay(1, 0, 576), new Clay(1, 0, 576), null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Stick(1, 0, 576), null},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Clay(1, 0, 576), new Clay(1, 0, 576)}, 
														   			        {null, new Clay(1, 0, 576), new Clay(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)},
															 			  new ClayMold(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Clay(1, 0, 576), new Clay(1, 0, 576), null}, 
														   			        {new Clay(1, 0, 576), new Clay(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Stick(1, 0, 576)},
															 			  new ClayMold(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] basaltHammerRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), null},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, null, new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {null, new Wood(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null},
														   			        {new Wood(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576)}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new PolishedBasalt(1, 0, 576), new PolishedBasalt(1, 0, 576), null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new StringItem(1, 0, 576)},
															 			  new BasaltHammer(0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] basaltTrayRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), new Hammer(0, 576)},
															 			  new BasaltTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), new Hammer(0, 576)},
															 			  new BasaltTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), new Hammer(0, 576)},
															 			  new BasaltTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Sandpaper(0, 576)},
															 			  new BasaltTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Basalt(1, 0, 576), new Basalt(1, 0, 576), new Basalt(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Sandpaper(0, 576)},
															 			  new BasaltTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Basalt(1, 0, 576), new Basalt(1, 0, 576), new Basalt(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Sandpaper(0, 576)},
															 			  new BasaltTray(1, 0, 576)
																		  ),
													
												};
	
	private CraftingItemsSlots[] woodSwordTemplateRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), null, null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodSwordTemplate(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldSwordRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {new WoodSwordTemplate(1, 0, 576), null},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {null, new WoodSwordTemplate(1, 0, 576)},
															 			  new ClayMoldSword(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] rockFoodTrayRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new RockFoodTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new RockFoodTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new RockFoodTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new RockFoodTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new RockFoodTray(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)}, 
														   			        {null, null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new RockFoodTray(1, 0, 576)
																		  ),
													
												};
	
	private CraftingItemsSlots[] rockPotRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new RockPot(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new RockPot(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stone(1, 0, 576), null, new Stone(1, 0, 576)},
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new RockPot(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stone(1, 0, 576), null, new Stone(1, 0, 576)}, 
														   			        {new Stone(1, 0, 576), new Stone(1, 0, 576), new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new RockPot(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodPotRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, new Wood(1, 0, 576)},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodPot(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, new Wood(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new WoodPot(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, new Wood(1, 0, 576)},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodPot(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, new Wood(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new WoodPot(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodPotHerbRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {new RockPotHerb(1, 0, 576), null},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {null, new RockPotHerb(1, 0, 576)},
															 			  new WoodPotHerb(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomRedRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {new RockPotMushroomRed(1, 0, 576), null},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {null, new RockPotMushroomRed(1, 0, 576)},
															 			  new WoodPotMushroomRed(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodPotMushroomBlueRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {new RockPotMushroomBlue(1, 0, 576), null},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new WoodPot(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new WoodPot(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new WoodPot(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new WoodPot(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new WoodPot(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new WoodPot(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new WoodPot(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new WoodPot(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new WoodPot(1, 0, 576)},
																		  },
															 			  new Item[] {null, new RockPotMushroomBlue(1, 0, 576)},
															 			  new WoodPotMushroomBlue(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodPickaxeTemplateRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {null, new Stick(1, 0, 576), null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), null},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {null, new Stick(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), null}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodPickaxeTemplate(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldPickaxeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {new WoodPickaxeTemplate(1, 0, 576), null},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {null, new WoodPickaxeTemplate(1, 0, 576)},
															 			  new ClayMoldPickaxe(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] woodAxeTemplateRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Knife(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {null, null, new Stick(1, 0, 576)},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)},
														   			        {new Stick(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {null, null, new Stick(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Stick(1, 0, 576), new Stick(1, 0, 576), new Stick(1, 0, 576)}, 
														   			        {new Stick(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Knife(0, 576), new Hammer(0, 576)},
															 			  new WoodAxeTemplate(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] clayMoldAxeRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {new WoodAxeTemplate(1, 0, 576), null},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new ClayMold(1, 0, 576), null, null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new ClayMold(1, 0, 576), null}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new ClayMold(1, 0, 576)}, 
														   			        {null, 				  null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new ClayMold(1, 0, 576),null, null},
														   			        {null, 				  null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new ClayMold(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new ClayMold(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {new ClayMold(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, new ClayMold(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, null},
														   			        {null, null, new ClayMold(1, 0, 576)},
																		  },
															 			  new Item[] {null, new WoodAxeTemplate(1, 0, 576)},
															 			  new ClayMoldAxe(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] chestRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Iron(1, 0, 576), new Wood(1, 0, 576)},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Hammer(0, 576), new Nail(1, 0, 576)},
															 			  new Chest(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)}, 
														   			        {new Wood(1, 0, 576), new Iron(1, 0, 576), new Wood(1, 0, 576)},
														   			        {new Wood(1, 0, 576), new Wood(1, 0, 576), new Wood(1, 0, 576)},
																		  },
															 			  new Item[] {new Nail(1, 0, 576), new Hammer(0, 576)},
															 			  new Chest(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] needleRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, new Stone(1, 0, 576), null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {new Stone(1, 0, 576), null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Sandpaper(0, 576), null},
															 			  new Needle(1, 0, 576)
																		  ),
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, null, new Wood(1, 0, 576)},
														   			        {null, null, new Stone(1, 0, 576)},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {null, new Wood(1, 0, 576), null},
														   			        {null, new Stone(1, 0, 576), null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Wood(1, 0, 576), null, null},
														   			        {new Stone(1, 0, 576), null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, new Wood(1, 0, 576)}, 
														   			        {null, null, new Stone(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, new Wood(1, 0, 576), null}, 
														   			        {null, new Stone(1, 0, 576), null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Wood(1, 0, 576), null, null}, 
														   			        {new Stone(1, 0, 576), null, null},
														   			        {null, null, null},
																		  },
															 			  new Item[] {null, new Sandpaper(0, 576)},
															 			  new Needle(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] leatherVestRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {new Leather(1, 0, 576), null, new Leather(1, 0, 576)}, 
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
																		  },
															 			  new Item[] {new Needle(1, 0, 576), new StringItem(1, 0, 576)},
															 			  new LeatherVest(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Leather(1, 0, 576), null, new Leather(1, 0, 576)}, 
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), new Needle(1, 0, 576)},
															 			  new LeatherVest(1, 0, 576)
																		  )
												};
	
	private CraftingItemsSlots[] leatherHatRecipesTable = { 
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Leather(1, 0, 576), new Leather(1, 0, 576), new Leather(1, 0, 576)},
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
																		  },
															 			  new Item[] {new Needle(1, 0, 576), new StringItem(1, 0, 576)},
															 			  new LeatherHat(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Leather(1, 0, 576), new Leather(1, 0, 576), new Leather(1, 0, 576)}, 
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new Needle(1, 0, 576), new StringItem(1, 0, 576)},
															 			  new LeatherHat(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {null, null, null}, 
														   			        {new Leather(1, 0, 576), new Leather(1, 0, 576), new Leather(1, 0, 576)},
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), new Needle(1, 0, 576)},
															 			  new LeatherHat(1, 0, 576)
																		  ),
													
													new CraftingItemsSlots(
															 new Item[][] { {new Leather(1, 0, 576), new Leather(1, 0, 576), new Leather(1, 0, 576)}, 
														   			        {new Leather(1, 0, 576), null, new Leather(1, 0, 576)},
														   			        {null, null, null},
																		  },
															 			  new Item[] {new StringItem(1, 0, 576), new Needle(1, 0, 576)},
															 			  new LeatherHat(1, 0, 576)
																		  ),
												};
	
	public CraftingItemsSlots[][] recipes9 = new CraftingItemsSlots[][] {stringRecipesTable, sandpaperRecipesTable, axeRecipesTable, pickaxeRecipesTable,
		knifeRecipesTable, hammerRecipesTable, woodTableRecipesTable, nailsRecipesTable, tableRecipesTable, woodPlankRecipesTable, polishedBasaltRecipesTable,
		ovenRecipesTable, anvilRecipesTable, stickRecipesTable, clayMoldRecipesTable, basaltHammerRecipesTable, basaltTrayRecipesTable, woodSwordTemplateRecipesTable,
		clayMoldSwordRecipesTable, rockFoodTrayRecipesTable, rockPotRecipesTable, woodPotRecipesTable, woodPotHerbRecipesTable, woodPotMushroomRedRecipesTable, woodPotMushroomBlueRecipesTable,
		woodPickaxeTemplateRecipesTable, clayMoldPickaxeRecipesTable, woodAxeTemplateRecipesTable, clayMoldAxeRecipesTable, chestRecipesTable, needleRecipesTable, 
		leatherVestRecipesTable, leatherHatRecipesTable};
	
	public Item checkCrafting(Item[][] craftingItems, Item[] tools)
	{	
		try 
		{
			for(int i = 0; i < recipes4.length; i++)
			{
				if(updateCrafting(craftingItems, tools, recipes4[i]))
				{
					return recipes4[i][0].getTarget().clone();
				}
			}
		}
		catch(Exception e) 
		{
			
		}
		
		return null;
	}
	
	public Item checkCraftingTable(Item[][] craftingItems, Item[] tools)
	{
		try 
		{
			for(int i = 0; i < recipes9.length; i++)
			{
				if(updateCrafting(craftingItems, tools, recipes9[i]))
				{
					return recipes9[i][0].getTarget().clone();
				}
			}
		}
		catch(Exception e) 
		{
			
		}
		
		return null;
	}
	
	public ArrayList<CraftingItemsSlots> itemOnCraftings4(Item item)
	{
		ArrayList<CraftingItemsSlots> items = new ArrayList<CraftingItemsSlots>();
		
		boolean isbreak = false;
		
		for(int i = 0; i < recipes4.length; i++)
		{
			for(int j = 0; j < recipes4[i].length; j++)
			{
				for(int y = 0; y < 2; y++)
				{
					for(int x = 0; x < 2; x++)
					{
						if(recipes4[i][j].getItem(y, x) != null)
						{	
							if(recipes4[i][j].getItem(y, x).getClass() == item.getClass())
							{
								items.add(recipes4[i][j]);
								
								isbreak = true;
								break;
							}
							else
							{
								for(int k = 0; k < recipes4[i][j].getTools().length; k++)
								{
									if(recipes4[i][j].getTool(k) != null)
									{
										if(recipes4[i][j].getTool(k).getClass() == item.getClass())
										{
											items.add(recipes4[i][j]);
											
											isbreak = true;
											break;
										}
									}
								}
								
								if(isbreak)
								{
									break;
								}
							}
						}
					}
					
					if(isbreak)
					{
						break;
					}
				}
				
				if(isbreak)
				{
					break;
				}
			}
			
			if(isbreak)
			{
				isbreak = false;
			}
		}
		
		return items;
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
