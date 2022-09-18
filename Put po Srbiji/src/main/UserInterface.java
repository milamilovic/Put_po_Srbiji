package main;

import java.awt.Font;
import java.awt.Graphics2D;

public class UserInterface {

	GamePanel gamePanel;
	Graphics2D g2;
	Font arial_20;
	public boolean  messageOn = false;
	public String message = ""; 
	public int messageCounter = 0;
	public boolean gameFinished = false;
	     

	public UserInterface(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		arial_20 = new Font("arial", Font.PLAIN, 20);
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		if(gamePanel.gameState == gamePanel.playState) {
			
		}
		else if(gamePanel.gameState == gamePanel.pauseState) {
			drawPauseScreen();
		}
	}
	
	public void drawPauseScreen() {
		
	}
	
}
