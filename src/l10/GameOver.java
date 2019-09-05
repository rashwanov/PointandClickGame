package l10;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GameOver extends JPanel
{
    Image graduation;
    int score;
    String time;
    
    public GameOver()
    {
        setBackground(Color.white);
        setLayout(null);
        ImageIcon graduationSource = new ImageIcon("images/graduation.jpg");
        Image graduation = graduationSource.getImage();
        this.graduation = graduation;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(graduation, 0,0, this);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("Game Over",700,70);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString("Your final score was " + score,475,300);
        g.drawString("Your total time was " + time,475,340);
        requestFocusInWindow();
    }
}
