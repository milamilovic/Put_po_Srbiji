package object;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Gift extends SuperObject{

	public Gift(GamePanel gamePanel) {
		
		name = "gift";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/gift.png"));		
			BufferedImage scaledImage = new BufferedImage(gamePanel.tileSize, gamePanel.tileSize, BufferedImage.TYPE_INT_ARGB);
			final AffineTransform at = AffineTransform.getScaleInstance((double)gamePanel.tileSize / (double)image.getWidth(), (double)gamePanel.tileSize / (double)image.getHeight());
			final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
			scaledImage = ato.filter(image, scaledImage);
			image = scaledImage;	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    collision = true;
		
	}

	
}
