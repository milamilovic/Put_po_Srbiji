package main;

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
	
}
