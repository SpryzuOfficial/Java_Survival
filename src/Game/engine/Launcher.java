package Game.engine;

public class Launcher 
{
	public static void main(String[] args)
	{	
		Game game = new Game("Survival", 704, 704);
		game.start();
	}
}
