package src.Game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.Event.Check;
import src.character.Chick;
import src.character.Environment;
import src.character.Obstruc;

public class GAME extends JPanel implements KeyListener {
    private List<Obstruc> obstrucList = new ArrayList<>();
    private Chick P = new Chick(150, 375, 56, 90);
    private Obstruc O1 = new Obstruc(900, 430, 42, 42, this);
    private long lastPress = 0;
    public  long point = 0;
    protected int gameState;
    static JLabel h1; 
    static JLabel h2; 
    static JLabel h3;
    protected GAME() {
        setBounds(300, 200, 1000, 600);
        setFocusable(true);
        setLayout(null);
        addKeyListener(this);
        spawnObstrucs(8);
    }

    protected void setGameState(int state) {
        this.gameState = state;
        this.removeAll();
        this.repaint();
    }

    // -------------------------------------- draw each state ------------------------------------------------//
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (gameState) {
            case 0:
                drawStartState(g);
                break;
            case 1:
                if(h1 == null)
                    h1 = health_1();
                if(h2 == null)
                    h2 = health_2();
                if(h3 == null)
                    h3 = health_3();
                drawPlayState(g);
                break;
            case 2:
                drawEndState(g);
                break;
            default:
                throw new IllegalArgumentException("Invalid game state");
        }
    }

    // --------------------------------------- drawStartState -----------------------------------------------//
    protected void drawStartState(Graphics g) {
        g.drawImage(Environment.getImage(), 0, 0, 1000, 600, null);
        ImageIcon icon = new ImageIcon("img/pink2_group.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBounds(241, 120, icon.getIconWidth(), icon.getIconHeight());

        ImageIcon icon2 = new ImageIcon("img/startgame.png");
        JButton startButton = new JButton(icon2);

        startButton.setOpaque(false); 
        startButton.setContentAreaFilled(false); 
        startButton.setBorderPainted(false);
        startButton.setBounds(225, 270, icon.getIconWidth(), icon.getIconHeight());
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameState(1);
            }
        });
        add(startButton);
        add(iconLabel);
        setVisible(true);
    }

    // -------------------------------------- drawPlayState -----------------------------------------------------//
    protected void drawPlayState(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.drawImage(Environment.getImage(), 0, 0, 1000, 600, null);
        // gd.setFont(Element.getFont(30));
        gd.setColor(Color.black);
        gd.drawString("Point : " + point, 465, 40);
        // ------CHICK-----
        gd.drawImage(P.getImage(), P.x, P.y, P.width, P.height, null);
        gd.drawString("Health : " + P.health + " % ", 900, 40);

        // -----OBSTRC-----
        for (Obstruc item : obstrucList) {
            drawEvi(item, gd);
        }
        point += 1;
    }

    // ------------------------------ drawEndState ------------------------------------------------------//
    protected void drawEndState(Graphics g) {
        g.drawImage(Environment.getImage(), 0, 0, 1000, 600, null);
        ImageIcon icon = new ImageIcon("img/gameover2.png");
        JLabel endLabel = new JLabel(icon);
        endLabel.setHorizontalAlignment(SwingConstants.CENTER);
        endLabel.setBounds(241, 120, 519, 146);

        ImageIcon icon2 = new ImageIcon("img/restart1.png");
        JButton restartButton = new JButton(icon2);

        restartButton.setOpaque(false); 
        restartButton.setContentAreaFilled(false); 
        restartButton.setBorderPainted(false);
        restartButton.setBounds(280, 270, icon.getIconWidth(), icon.getIconHeight());
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameState(1);
            }
        });

        add(endLabel);
        add(restartButton);
        setVisible(true);
    }

    // -------------------------------- Set spawn ----------------------------------------------//
    protected void spawnObstrucs(int count) {
        obstrucList.clear();
        int far = 1000;
        for (int i = 0; i < count; i++) {
            int randomX = 800 + far + (int) (Math.random() * 500);
            obstrucList.add(new Obstruc(randomX, O1.y, O1.width, O1.height, this));
            far += 500;
        }
    }
    // -------------------------draw Obstruc and checkHit---------------------------------------//
    protected void drawEvi(Obstruc ob, Graphics2D g) {
        g.drawImage(ob.getImage(), ob.x, ob.y, ob.width, ob.height, null);
        if (Check.checkHit(P, ob)) {
            g.setStroke(new BasicStroke(10.0f));
            g.setColor(Color.RED);
            g.drawRect(0, 0, 984, 562);
            P.health -= 1;
    
            if (P.health <= 0) {
                removeHealthLabel(h3);
                P.health = new Chick().health;
                h1 = null;
                h2 = null;
                h3 = null;
                point = 0 ;
                spawnObstrucs(8);
                setGameState(2);
            }
            if (P.health <= 100 ) {
                removeHealthLabel(h1);
            }
            if(P.health <= 50 ){
                removeHealthLabel(h2);
            }
        }
    }
    // ------------------------------ 3 Hearts ----------------------------------------------//
    private JLabel health_1() {
            ImageIcon icon = new ImageIcon("img/heart_full.png");
            JLabel h1 = new JLabel(icon);
            h1.setBounds(850, 50, icon.getIconWidth(), icon.getIconHeight());
            add(h1);
            return h1;
    }
    private JLabel health_2(){
        ImageIcon icon = new ImageIcon("img/heart_full.png");
            JLabel h2 = new JLabel(icon);
            h2.setBounds(890, 50, icon.getIconWidth(), icon.getIconHeight());
            add(h2);
            return h2 ;
    }
    private JLabel health_3(){
        ImageIcon icon = new ImageIcon("img/heart_full.png");
            JLabel h3 = new JLabel(icon);
            h3.setBounds(930, 50, icon.getIconWidth(), icon.getIconHeight());
            add(h3);
            return h3 ;
    }
   private void removeHealthLabel(JLabel label) {
        remove(label);
        revalidate();
        repaint();
    }

    // ------------------------------ SetKeyPressed ----------------------------------------------//
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (System.currentTimeMillis() - lastPress > 600) {
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
