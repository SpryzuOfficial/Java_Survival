package Game.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import Game.entities.ItemEntityManager;
import Game.ui.UiInventoryManager;

public class MouseManager implements MouseListener, MouseMotionListener, MouseWheelListener
{
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	public MouseManager()
	{
		
	}
	
	// Getters
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	// Implemented methods

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftPressed = true;
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			rightPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftPressed = false;
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			rightPressed = false;
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if(e.getWheelRotation() < 0)
		{
			UiInventoryManager.itemInitialY += 5;
			ItemEntityManager.scrollY += 4;
		}
		else
		{
			UiInventoryManager.itemInitialY -= 5;
			ItemEntityManager.scrollY -= 4;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
}
