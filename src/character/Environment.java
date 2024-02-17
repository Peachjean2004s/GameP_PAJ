package src.character;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Environment extends JPanel {
    public static BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img/sky_ground_star.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}	
}
