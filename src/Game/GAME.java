package src.Game;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import src.Event.Check;
import src.character.Chick;
import src.character.Element;
import src.character.Environment;
import src.character.Obstruc;

public class GAME extends JPanel implements KeyListener {
    private List<Obstruc> obstrucList = new ArrayList<>();
    Chick P = new Chick(150, 265, 44, 70);
    Obstruc O1 = new Obstruc(900, 295, 30, 40, this);
    private long lastPress = 0;
    private long point = 0;
    static Display display;
    int gameState;
    // int startgame = 0;
    // int playgame = 1;
    // int endgame = 2;

    public GAME() {
        setOpaque(false); 
        setBounds(0, 0, 1000, 600);
        setFocusable(true);
        setLayout(null);
        addKeyListener(this);
        spawnObstrucs(8);
    }
    public void setGameState(int state) {
        this.gameState = state;
        this.removeAll();

        // Repaint the frame
        this.repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (gameState) {
            case 0:
                drawStartState(g);
                break;
            case 1:
                drawPlayState(g);
                break;
            case 2:
                drawEndState(g);
                break;
            default:
                throw new IllegalArgumentException("Invalid game state");
        }
    }
    //-------------------------------------------------------------------//
    private void drawStartState(Graphics g) {
        g.drawImage(Environment.getImage(), 0, 0, 1000, 600, null);
        ImageIcon icon = new ImageIcon("img/purple_group.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBounds(400, 150, icon.getIconWidth(), icon.getIconHeight()); // Example bounds, adjust as needed

        // Create a JButton
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(400, 250, 200, 50); // Example bounds, adjust as needed
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameState(1); 
            }
        });

        
        // Add button and icon to the GAME panel
        add(startButton);
        add(iconLabel);

        setVisible(true); // Ensure the panel is visible
    }
    

    public void drawPlayState(Graphics g) {            
        Graphics2D gd = (Graphics2D) g;
        gd.drawImage(Environment.getImage(), 0, 0, 1000, 600, null);

        gd.setFont(Element.getFont(30));
        gd.setColor(Color.black);
		gd.drawString("Point : "+point,750,40);
        // ------CHICK-----
        // drawHealth(gd);
        gd.setColor(Color.RED);
        gd.drawImage(P.getImage(), P.x, P.y, P.width, P.height, null);
        gd.drawString(P.health + "%", 40, 40);
        // -----OBSTRC-----
        for (Obstruc item : obstrucList) {
            drawEvi(item, gd);
        }
        this.point+=1;
    }
    private void spawnObstrucs(int count) {
        obstrucList.clear();
        int far = 500;
        for (int i = 0; i < count; i++) {
            int randomX = 400 + far + (int) (Math.random() * 500);
            obstrucList.add(new Obstruc(randomX, O1.y, O1.width,O1.height, this));
            far += 500;
        }
    }
    // private void drawHealth(Graphics2D g) {
    // try {
    // g.drawImage(ImageIO.read(new File("img\\heart.png")),10,20, 20,20,null);
    // g.setStroke(new BasicStroke(18.0f));
    // g.setColor(new Color(241, 98, 69));
    // g.drawLine(60, 30,60+P.health,30);
    // g.setColor(Color.white);
    // g.setStroke(new BasicStroke(6.0f));
    // g.drawRect(50,20, 200,20);
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    private void drawEvi(Obstruc ob, Graphics2D g) {
        g.drawImage(ob.getImage(), ob.x,ob.y, ob.width, ob.height, null);
        if (Check.checkHit(P, ob)) {
            g.setStroke(new BasicStroke(10.0f));
            g.setColor(Color.RED);
            g.drawRect(0, 0, 1000, 600);
            P.health -= 20;
            if(P.health<=0) {
                // display.endGame(this.point);
                setGameState(2); 
                // P.health = new Chick().health;
                // this.point = 0;
            }
        }
    }
    //-----------------------------------------------//
    private void drawEndState(Graphics g) {
        // Create a JLabel for displaying the end message
        g.drawImage(Environment.getImage(), 0, 0, 1000, 600, null);

        JLabel endLabel = new JLabel("Game Over!");
        endLabel.setFont(new Font("Arial", Font.BOLD, 24));
        endLabel.setForeground(Color.RED);
        endLabel.setHorizontalAlignment(SwingConstants.CENTER);
        endLabel.setBounds(350, 200, 300, 30);
    
        // Create buttons for restarting and closing the game
        JButton restartButton = new JButton("Restart");
        restartButton.setBounds(350, 250, 100, 30);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameState(1);
            }
        });
    
        // Add components to the GAME panel
        add(endLabel);
        add(restartButton);

        setVisible(true); // Ensure the panel is visible
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        
        if(System.currentTimeMillis()-lastPress> 600){
            if (e.getKeyCode() == 87 || e.getKeyCode() == 38 || e.getKeyCode() == 32) {
                P.jump(this);
                repaint();
            }
            lastPress = System.currentTimeMillis();
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
