package src.character;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Obstruc  {
    public int x, y, width, height,reStart;
    int speed = 8 ; 

    public Obstruc(int x, int y, int width, int height,JPanel GAME) {
        reStart = x ;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        move(GAME);
    }

    public void move(JPanel page) {
        this.x -= speed;
        page.repaint();
        Timer timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x -= speed;
                page.repaint();
                if(x<= 0){
                    x = reStart ;
                }
            }

        });
        timer.start();
    }
    
   	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img/fire.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}	
    
}