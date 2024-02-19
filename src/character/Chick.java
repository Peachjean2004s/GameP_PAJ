package src.character;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.sound.sampled.*;

public class Chick {
    public int x ;
	public int y;
	public int ChickSize;
	public int width;
	public int height;
    public static int jumpfloat = 70 ;
	public int speed ;
	public int health = 100 ;
	public Chick(){

	}
	public Chick( int x ,  int y , int width , int height){
        this.x = x ;
        this.y = y ;
		this.width = width ;
		this.height = height ;

    }
	public void jump(JPanel page) {
		this.y -= jumpfloat;
		page.repaint();
		Timer timer =new Timer(550,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					y += jumpfloat;
					// Play the sound when jumping
					try {
						MusicKub.music("img/jump-15984.mp3");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					page.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img/Kaii2.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	public boolean chickstate(){
		if(this.health <= 0)
			return false;
		return true;
	}

    
    

}