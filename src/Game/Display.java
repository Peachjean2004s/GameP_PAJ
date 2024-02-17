package src.Game;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Display extends JFrame  {
    GAME game = new GAME();
    public Display() {
        super("KAI_YANG");
        setting();
    }

    private void setting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        add(game);
        setVisible(true);
	}

    // public void removeContent() {
	// 	getContentPane().removeAll();
	// 	revalidate(); 
	// 	repaint();
	// }

  


}
