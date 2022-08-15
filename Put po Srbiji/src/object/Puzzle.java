package object;

import javax.imageio.ImageIO;

public class Puzzle extends SuperObject{

	public Puzzle() {
		
		name = "puzzle";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/puzzle_piece.png"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		solidArea.x = 12;
		solidArea.y = 12;
		solidArea.width = 36;
		solidArea.height = 36;
		
		
	}

	
	
}