package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, front, back, enterPressed;
	public int code;
	public boolean checkDrawingTime;
	public GamePanel gamePanel;
	
	public KeyManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		enterPressed = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		code = e.getKeyCode();
		if(gamePanel.gameState == gamePanel.playState) {
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
			else if(code==KeyEvent.VK_B) { //type b for bug
				if(checkDrawingTime == false) {
					checkDrawingTime = true;
				}
			}	
			else if(code==KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
		} else if(gamePanel.gameState == gamePanel.pauseState) {
			
		} else if(gamePanel.gameState == gamePanel.dialogueState) {
			if(code == KeyEvent.VK_ENTER) {
				gamePanel.gameState = gamePanel.playState;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		code = e.getKeyCode();
		
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
		else if(code==KeyEvent.VK_B) {
			if(checkDrawingTime == true) {
				checkDrawingTime = false;
			}
		}
		else if(code==KeyEvent.VK_P) { //p for pause
			if(gamePanel.gameState == gamePanel.playState) {
				gamePanel.gameState = gamePanel.pauseState;
			} else if(gamePanel.gameState == gamePanel.pauseState) {
				gamePanel.gameState = gamePanel.playState;
			}
		}
		else if(code==KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
	}

}
