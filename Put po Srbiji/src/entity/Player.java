package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyManager;
import main.Reminder;

import java.util.concurrent.ThreadLocalRandom;

public class Player extends Entity{
	
	GamePanel gamePanel;
	KeyManager keyManager;
	
	public final int screenX;
	public final int screenY;
	
	public int numOfPuzzles = 0;
	
	public Player(GamePanel gamePanel, KeyManager keyManager) {
		this.gamePanel = gamePanel;
		this.keyManager = keyManager;
		
		screenX  = gamePanel.screenWidth / 2 - gamePanel.tileSize;
		screenY = gamePanel.screenHeight / 2 + gamePanel.tileSize * 2;
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		this.setDefaultValues();
		this.getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = gamePanel.tileSize * 22;
		worldY = gamePanel.tileSize * 23;
		speed = 4;
		direction = "front";
	}
	
	public void getPlayerImage() {
		try {
			
			front = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_front.png"));
			BufferedImage scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			final AffineTransform at = AffineTransform.getScaleInstance((double)gamePanel.tileSize / (double)front.getWidth(), (double)gamePanel.tileSize / (double)front.getHeight());
			final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
			scaledImage = ato.filter(front, scaledImage);
			front = scaledImage;
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_up1.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(up1, scaledImage);
			up1 = scaledImage;
			
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_up2.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(up2, scaledImage);
			up2 = scaledImage;
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_down1.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(down1, scaledImage);
			down1 = scaledImage;
			
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_down2.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(down2, scaledImage);
			down2 = scaledImage;
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_left1.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(left1, scaledImage);
			left1 = scaledImage;
			
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_left2.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(left2, scaledImage);
			left2 = scaledImage;
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_right1.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(right1, scaledImage);
			right1 = scaledImage;
			
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_right2.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(right2, scaledImage);
			right2 = scaledImage;
			
			back = ImageIO.read(getClass().getResourceAsStream("/player/girl_player_back.png"));
			scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			scaledImage = ato.filter(back, scaledImage);
			back = scaledImage;
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyManager.upPressed || keyManager.downPressed || keyManager.rightPressed || keyManager.leftPressed) {
			if(keyManager.upPressed) {
				direction = "up";
			}
			else if(keyManager.downPressed) {
				direction = "down";
			}
			else if(keyManager.rightPressed) {
				direction = "right";
			}
			else if(keyManager.leftPressed) {
				direction = "left";
			}
			
			collisionOn = false;
			gamePanel.colCheck.checkTile(this);
			int objIndex = gamePanel.colCheck.checkObject(this, true);
			this.pickUpObject(objIndex);
			
			
			if(collisionOn == false) {
				switch(direction){
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
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
	
	
	public void pickUpObject(int i) {
		if(i != 999) {
			if(gamePanel.obj[i].name.equals("puzzle")) {
				gamePanel.playSoundEffect(1);
				gamePanel.obj[i] = null;
				gamePanel.ui.showMessage("You found a puzzle piece!");
				numOfPuzzles++;
				if(gamePanel.ui.gameFinished) {
					//ako npr dodje do 10 onda tu promenljivu stavi na true
					//gamePanel.stopMusic();
				}
			} else if(gamePanel.obj[i].name.equals("gift")) {
				gamePanel.playSoundEffect(0);
				gamePanel.obj[i] = null;
				int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
				switch(randomNum) {
				case 0:
			        new Reminder(15, this, 3);
					break;
				case 1:
					new Reminder(15, this, -2);
					break;
				}
			}
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
	
		g2.drawImage(image, screenX, screenY, null);
	} 

}