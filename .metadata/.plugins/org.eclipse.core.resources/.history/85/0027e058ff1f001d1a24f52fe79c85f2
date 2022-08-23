package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.Puzzle;

public class UserInterface {

	GamePanel gamePanel;
	Font arial_20;
	BufferedImage puzzleImage;
	public boolean  messageOn = false;
	public String message = ""; 
	

	public UserInterface(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		arial_20 = new Font("arial", Font.PLAIN, 20);
		Puzzle puzzle = new Puzzle();
		puzzleImage = puzzle.image;
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_20);
		g2.setColor(Color.white);
		g2.drawImage(puzzleImage, 10, 10, gamePanel.tileSize, gamePanel.tileSize, null);
		g2.drawString(" =  " + gamePanel.player.numOfPuzzles, 60, 45);
		if(messageOn) {
			g2.drawString(message, 10, gamePanel.tileSize * gamePanel.maxWorldRow / 2);
		}
		
	}
	
}
