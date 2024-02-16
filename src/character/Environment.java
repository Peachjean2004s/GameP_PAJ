package src.character;

import javax.swing.*;

import src.Game.GAME;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Environment extends JPanel {

    // private Image backgroundImage;

    // public Environment(String imagePath) {
        
    //     // try {
    //     //     // Load the background image
    //     //     backgroundImage = ImageIO.read(new File(imagePath));
    //     // } catch (IOException e) {
    //     //     // Handle the exception more gracefully, for example:
    //     //     // JOptionPane.showMessageDialog(null, "Error loading background image: " + e.getMessage());
    //     //     e.printStackTrace(); // For debugging purposes
    //     // }
    //     backgroundImage = new ImageIcon(imagePath).getImage();
        
    // }

    // @Override
    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     // Draw the background image
    //     if (backgroundImage != null) {
    //         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    //     }
    // }
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
