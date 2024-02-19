package src.character;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Chick {
    public int x ;
	public int y;
	public int ChickSize;
	public int width;
	public int height;
    public static int jumpfloat = 120 ;
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
		final int numFrames = 20;
		final int animationDuration = 100;
		final int deltaY = jumpfloat / numFrames; 
	
		Timer timer = new Timer(animationDuration / numFrames, new ActionListener() {
			int frameCount = 0;
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (frameCount < numFrames) {
					y -= deltaY;
					page.repaint(); 
					frameCount++;
				} else {
					((Timer) e.getSource()).stop(); 
					Timer downTimer = new Timer(animationDuration / numFrames, new ActionListener() {
						int downFrameCount = 0;
	
						@Override
						public void actionPerformed(ActionEvent e) {
							if (downFrameCount < numFrames) {
								y += deltaY; 
								page.repaint(); 
								downFrameCount++;
							} else {
								((Timer) e.getSource()).stop();
							}
						}
					});
					downTimer.start(); 
				}
			}
		});
	
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