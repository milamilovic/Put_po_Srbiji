package object;

import javax.imageio.ImageIO;

public class Gift extends SuperObject{

	public Gift() {
		
		name = "gift";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/gift.png"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    collision = true;
		
	}

	
}