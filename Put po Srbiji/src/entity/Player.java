package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
		super(gamePanel);
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
		worldX = this.gamePanel.tileSize * 22;
		worldY = this.gamePanel.tileSize * 23;
		speed = 4;
		direction = "front";
	}
	
	public void getPlayerImage() {
		
			front = super.getImage("/player/girl_player_front.png");
			up1 = super.getImage("/player/girl_player_up1.png");			
			up2 = super.getImage("/player/girl_player_up2.png");
			down1 = super.getImage("/player/girl_player_down1.png");
			down2 = super.getImage("/player/girl_player_down2.png");
			left1 = super.getImage("/player/girl_player_left1.png");
			left2 = super.getImage("/player/girl_player_left2.png");
			right1 = super.getImage("/player/girl_player_right1.png");
			right2 = super.getImage("/player/girl_player_right2.png");
			back = super.getImage("/player/girl_player_back.png");
			
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
			intersectsNPC = false;
			gamePanel.colCheck.checkEntity(this, gamePanel.npc);
			//interactNPC(npcIndex);
			
			
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
		int npcIndex = gamePanel.colCheck.checkEntity(this, gamePanel.npc);
		interactNPC(npcIndex);
	}
	
	
	public void interactNPC(int i) {
		if(i!=999) {
			if(gamePanel.keyManager.enterPressed) {
				gamePanel.gameState = gamePanel.dialogueState;
				gamePanel.npc[i].speak();
			}
			gamePanel.keyManager.enterPressed = false;
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