package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, front, back;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code==KeyEvent.VK_UP || code==KeyEvent.VK_W) {
			front = false;
			back = true;
			upPressed = true;
		} 
		else if(code==KeyEvent.VK_DOWN || code==KeyEvent.VK_S) {
			front = false;
			back = false;
			downPressed = true;
		}
		else if(code==KeyEvent.VK_LEFT || code==KeyEvent.VK_A) {
			front = false;
			back = false;
			leftPressed = true;
		} 
		else if(code==KeyEvent.VK_RIGHT || code==KeyEvent.VK_D) {
			front = false;
			back = false;
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code==KeyEvent.VK_UP || code==KeyEvent.VK_W) {
			upPressed = false;
		} 
		else if(code==KeyEvent.VK_DOWN || code==KeyEvent.VK_S) {
			front = true;
			downPressed = false;
		}
		else if(code==KeyEvent.VK_LEFT || code==KeyEvent.VK_A) {
			leftPressed = false;
		} 
		else if(code==KeyEvent.VK_RIGHT || code==KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

}
