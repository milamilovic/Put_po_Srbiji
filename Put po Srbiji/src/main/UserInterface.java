package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

public class UserInterface {

	GamePanel gamePanel;
	Graphics2D g2;
	Font immortalFont;
	public boolean  messageOn = false;
	public String message = ""; 
	public int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	     

	public UserInterface(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		
		InputStream is = getClass().getResourceAsStream("/IMMORTAL.ttf");
		
		try {
			immortalFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		else if(gamePanel.gameState == gamePanel.dialogueState) {
			drawDialogueScreen();
		}
	}
	
	public void drawDialogueScreen() {
		
		int x = gamePanel.tileSize;
		int y = gamePanel.tileSize;
		int width = gamePanel.screenWidth - 2 * x;
		int height = gamePanel.tileSize * 5;
		drawDialogueWindow(x, y, width, height);
		
		x += gamePanel.tileSize;
		y += gamePanel.tileSize;
		g2.setColor(new Color(170, 170, 170));
		g2.setFont(immortalFont.deriveFont(Font.PLAIN, 25F));
		
		for(String line : currentDialogue.split(Pattern.quote("\n"))) {
			g2.drawString(line, x, y);
			y += 32;
		}
		
	}
	
	public void drawDialogueWindow(int x, int y, int width, int height) {
		Color c = new Color(0,0,0,242);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 25, 25);
		
		c = new Color(43, 40, 33);
		//c = new Color(87, 87, 87);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 15, 15);
	}

	public void drawPauseScreen() {
		
	}
	
}
