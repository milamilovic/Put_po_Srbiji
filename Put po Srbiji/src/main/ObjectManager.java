package main;

import object.Gift;
import object.Puzzle;

public class ObjectManager {

	GamePanel gp;

	public ObjectManager(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObjects() {
		
		gp.obj[0] = new Puzzle();
		gp.obj[0].worldX = 16 * gp.tileSize;
		gp.obj[0].worldY = 3 * gp.tileSize;
		
		gp.obj[1] = new Gift();
		gp.obj[1].worldX = 2 * gp.tileSize;
		gp.obj[1].worldY = 6 * gp.tileSize;
		
	}
	
}
