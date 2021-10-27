package Game.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener 
{
	
	private boolean[] keys;
	public boolean up, down, left, right, num1, num2, num3, num4, num5, e, shift, f, c, p;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		num1 = keys[KeyEvent.VK_1];
		num2 = keys[KeyEvent.VK_2];
		num3 = keys[KeyEvent.VK_3];
		num4 = keys[KeyEvent.VK_4];
		num5 = keys[KeyEvent.VK_5];
		e = keys[KeyEvent.VK_E];
		shift = keys[KeyEvent.VK_SHIFT];
		f = keys[KeyEvent.VK_F];
		c = keys[KeyEvent.VK_C];
		p = keys[KeyEvent.VK_ESCAPE];
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
}
