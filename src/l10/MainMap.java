package l10;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;

public class MainMap extends JPanel implements KeyListener
{
    JButton bBehrend,bUPark,bScranton,bFayette,bBack,bEnd,bWorld,
            bPlayer;
    Graphics g;
    Image iMap, iPlayer;
    int x = 550, y = 150, speed = 7, score = 0;
    String time;
    
    public MainMap()
    {
        ImageIcon mapSource = new ImageIcon("images/map.png");
        Image iMap = mapSource.getImage();
        this.iMap = iMap;
        setLayout(null);
        bBehrend = new JButton(createIcon("images/behrend.jpg",130));
        bUPark = new JButton(createIcon("images/upark.jpg",130));
        bScranton = new JButton(createIcon("images/scranton.jpg",130));
        bFayette = new JButton(createIcon("images/fayette.png",130));
        bWorld = new JButton(createIcon("images/world.png",130));
        bBack = new JButton("Back");
        bEnd = new JButton("End game");
        bPlayer = new JButton(createIcon("images/gates.jpg", 75));
        
        add(bPlayer);
        add(bBehrend);
        add(bUPark);
        add(bScranton);
        add(bFayette);
        add(bWorld);
        add(bBack);
        add(bEnd);
        playerLocation();
        bPlayer.setBorderPainted(false);
        bBehrend.setBorderPainted(false);
        bUPark.setBorderPainted(false);
        bScranton.setBorderPainted(false);
        bFayette.setBorderPainted(false);
        bWorld.setBorderPainted(false);
        bBehrend.setBounds(new Rectangle(175,90,130,130));
        bUPark.setBounds(new Rectangle(525,300,130,130));
        bScranton.setBounds(new Rectangle(825,150,130,130));
        bFayette.setBounds(new Rectangle(290,360,130,130));
        bWorld.setBounds(new Rectangle(1025,20,130,130));
        bBack.setBounds(new Rectangle(25,225,100,50));
        bEnd.setBounds(new Rectangle(25,285,100,50));
        addKeyListener(this);
    }
    
    public void setCharacter (String character)
    {
        if (character == "Gates")
        {
            bPlayer.setIcon(createIcon("images/gates.jpg", 75));
        }
        if (character == "Brown")
        {
            bPlayer.setIcon(createIcon("images/brown.jpg", 75));
        }
        if (character == "Phelps")
        {
            bPlayer.setIcon(createIcon("images/phelps.jpg", 75));
            speed = 14;
        }
    }
    
    private ImageIcon createIcon(String path, int dim)
    {
        ImageIcon imageSource = new ImageIcon(path);
        Image image = imageSource.getImage();
        Image imageTemp = image.getScaledInstance(dim, dim, dim);
        ImageIcon imageIcon = new ImageIcon(imageTemp);
        return imageIcon;
    }
    
    private void click(AbstractButton button) 
    {
        button.doClick();
    }
    
    public void playerLocation()
    {
        bPlayer.setBounds(new Rectangle(x,y,75,75));
    }
    
    private void intersection()
    {
        if((bPlayer.getBounds()).intersects(bBehrend.getBounds()))
        {
            click(bBehrend);
            x = 305;
            y = 145;
            playerLocation();
        }
        if((bPlayer.getBounds()).intersects(bUPark.getBounds()))
        {
            click(bUPark);
            x = 525;
            y = 225;
            playerLocation();
        }
        if((bPlayer.getBounds()).intersects(bScranton.getBounds()))
        {
            click(bScranton);
            x = 750;
            y = 150;
            playerLocation();
        }
        if((bPlayer.getBounds()).intersects(bFayette.getBounds()))
        {
            click(bFayette);
            x = 290;
            y = 285;
            playerLocation();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent evt)
    {
        int kk = evt.getKeyCode();
        if (kk == evt.VK_LEFT)
        {
            x = x - speed;
            playerLocation();
            intersection();
        }
        if (kk == evt.VK_RIGHT)
        {
            x = x + speed;
            playerLocation();
            intersection();
        }
        if (kk == evt.VK_UP)
        {
            y = y - speed;
            playerLocation();
            intersection();
        }
        if (kk == evt.VK_DOWN)
        {
            y = y + speed;
            playerLocation();
            intersection();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt)
    {
    }

    @Override
    public void keyReleased(KeyEvent evt)
    {
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(iMap, 0,0, this);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.setColor(Color.white);
        g.drawString("Main Map",475,50);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Behrend",195,245);
        g.drawString("Fayette",315,515);
        g.drawString("University Park",505,455);
        g.drawString("Scranton",840,305);
        g.drawString("World Campus",1000,175);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score - " + score,5,505);
        g.drawString("Time - " + time,5,525);
        requestFocusInWindow();
    }
}
