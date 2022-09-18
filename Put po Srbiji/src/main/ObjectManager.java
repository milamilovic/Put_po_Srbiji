package main;

import entity.NPC_boy;
import object.Gift;
import object.Puzzle;

public class ObjectManager {

	GamePanel gp;

	public ObjectManager(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObjects() {
		
		gp.obj[0] = new Puzzle(gp);
		gp.obj[0].worldX = 28 * gp.tileSize;
		gp.obj[0].worldY = 18 * gp.tileSize;
		
		gp.obj[1] = new Gift(gp);
		gp.obj[1].worldX = 15 * gp.tileSize;
		gp.obj[1].worldY = 21 * gp.tileSize;
		
	}
	

	public void setNPCs() {
		
		gp.npc[0] = new NPC_boy(gp);
		gp.npc[0].worldX = 18 * gp.tileSize;
		gp.npc[0].worldY = 20 * gp.tileSize;
		
	}
	
}
