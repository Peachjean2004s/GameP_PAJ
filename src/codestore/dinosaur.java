package src.codestore;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;

// public class dinosaur extends JPanel implements KeyListener, ActionListener {
//     private int dinoX, dinoY;
//     private boolean jumping = false;
//     private Timer timer;

//     public dinosaur() {
//         setPreferredSize(new Dimension(600, 300));
//         setBackground(Color.WHITE);
//         dinoX = 50;
//         dinoY = 200;
//         timer = new Timer(10, this);
//         timer.start();
//         addKeyListener(this);
//         setFocusable(true);
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.setColor(Color.BLACK);
//         g.fillRect(dinoX, dinoY, 30, 30);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (jumping) {
//             dinoY -= 3;
//             if (dinoY <= 100)
//                 jumping = false;
//         } else if (dinoY < 200) {
//             dinoY += 3;
//         }
//         repaint();
//     }

//     @Override
//     public void keyTyped(KeyEvent e) {}

//     @Override
//     public void keyPressed(KeyEvent e) {
//         if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
//             jumping = true;
//         }
//     }

//     @Override
//     public void keyReleased(KeyEvent e) {}

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("Dinosaur Game");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.getContentPane().add(new dinosaur());
//             frame.pack();
//             frame.setLocationRelativeTo(null);
//             frame.setVisible(true);
//         });
//     }
// }
