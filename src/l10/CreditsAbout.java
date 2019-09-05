package l10;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CreditsAbout extends JPanel
{
    JButton bBack;
        
    public CreditsAbout()
    {
        setBackground(Color.white);
        setLayout(null);
        bBack = new JButton("Back");
        bBack.setFont(new Font("Arial", Font.PLAIN, 30));
        add(bBack);
        bBack.setBounds(new Rectangle(515,460,150,50));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.blue);
        g.drawString("About",515,75);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("About: IST240 Group 1 Project. Is  a three appication Games ",50,110);
        g.drawString("Game 1: Will challenge the PSU Icon on chasing the Football and you will"
                + "score as many points",50,140);
        g.drawString("while the football continues to shrink in 60 seconds.",50,170);
              g.drawString("Game 2:  Will ask our PSU Icon questions "
                + "regarding Computers Science.",50,200);  
        g.drawString("Game 3:  Will ask our PSU Icon Math questions!",50,230);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.blue);
        g.drawString("Credits",500,280);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Made by: Dolly Haddad.",50,350);
    }
}