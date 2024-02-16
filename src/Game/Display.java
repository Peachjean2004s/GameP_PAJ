package src.Game;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.character.Environment;

public class Display extends JFrame implements ActionListener  {
    public Display() {
        super("KAI_YANG_GAME");
        setting();
        
    }

    private void setting() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        GAME game = new GAME();
        add(game);
        setVisible(true);
	}
    
    public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("restart")) {
			removeContent();
			GAME game = new GAME();
			this.getContentPane().add(game);
			game.requestFocus();
		}
	}

    public void removeContent() {
		getContentPane().removeAll();
		revalidate(); 
		repaint();
	}
	public static void main(String[] arg) {
		Display dis = new Display();
   }
}
