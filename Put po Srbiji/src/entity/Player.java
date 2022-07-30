package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyManager;

public class Player extends Entity{
	
	GamePanel gamePanel;
	KeyManager keyManager;
	
	public Player(GamePanel gamePanel, KeyManager keyManager) {
		this.gamePanel = gamePanel;
		this.keyManager = keyManager;
		this.setDefaultValues();
		this.getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
		y = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;
		speed = 4;
		direction = "front";
	}
	
	public void getPlayerImage() {
		try {
			front = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_front.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_right2.png"));
			back = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_back.png"));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyManager.upPressed || keyManager.downPressed || keyManager.rightPressed || keyManager.leftPressed) {
			if(keyManager.upPressed) {
				direction = "up";
				y -= speed;
			}
			else if(keyManager.downPressed) {
				direction = "down";
				y += speed;
			}
			else if(keyManager.rightPressed) {
				direction = "right";
				x += speed;
			}
			else if(keyManager.leftPressed) {
				direction = "left";
				x -= speed;
			}
			
			spriteCounter++;
			if(spriteCounter>15) {
				if(spriteNum == 1) {
					spriteNum = 2;
				} else {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		} else if(keyManager.front) {
			direction = "front";
		} else if(keyManager.back) {
			direction = "back";
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			} else if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			} else if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			} else if(spriteNum == 2) {
				image = right2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			} else if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "front":
			image = front;
			break;
		case "back":
			image = back;
	}
	
		g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
	} 

}