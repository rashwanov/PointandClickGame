
package l10;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class IntroScreen extends JPanel
{
    JButton bCreds,bInst,bOptions,bMap;
    Image oldMain;
    
    public IntroScreen()
    {
        
        ImageIcon oldMainSource = new ImageIcon("images/pennmain.jpg");
        Image oldMain = oldMainSource.getImage();
        this.oldMain = oldMain;
        setBackground(Color.white);
        setLayout(null);
        bCreds = new JButton("About/Credits");
        bInst = new JButton("Instructions");
        bOptions = new JButton("Options");
        bMap = new JButton("Main Map");
        add(bCreds);
        bCreds.setForeground(Color.BLUE);
        bCreds.setFont(new Font("Arial", Font.PLAIN, 30));
        bCreds.setBounds(new Rectangle(2,580,300,100));
        bCreds.setFocusPainted(false);
        add(bInst);
        bInst.setFont(new Font("Arial", Font.PLAIN, 30));
        bInst.setForeground(Color.BLUE);
        bInst.setBounds(new Rectangle(335,580,300,100));
        add(bOptions);
        bOptions.setForeground(Color.GREEN);
        bOptions.setFont(new Font("Arial", Font.PLAIN, 30));
        bOptions.setBounds(new Rectangle(680,580,300,100));
        add(bMap);
        bMap.setForeground(Color.ORANGE);
        bMap.setFont(new Font("Arial", Font.PLAIN, 30));
        bMap.setBounds(new Rectangle(1035,580,300,100));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(oldMain, 200, 5, this);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString("                 The 3 Game Panel!", 45, 50);
    }
}