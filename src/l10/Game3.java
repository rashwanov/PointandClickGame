package l10;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Game3 extends JPanel implements ActionListener
{
    JButton bTopLeft,bTopMiddle,bTopRight,bMidLeft,bCenter,bMidRight,bBottomLeft,
        bBottomMiddle,bBottomRight, bQuit, bResults;
    int score = 0;
    Image tictactoe, goal, lost;
    ImageIcon playerIcon, opponentIcon, blank;
    boolean tl = false, tm = false, tr = false, ml = false, c = false, mr = false,
        bl =  false, bm = false, br = false, win = false, loss = false;
    String gameTheme;
    
    public Game3()
    {
        setBackground(Color.white);
        setLayout(null);
        ImageIcon ticTacToeSource = new ImageIcon("images/tictactoe.jpg");
        Image tictactoe = ticTacToeSource.getImage();
        this.tictactoe = tictactoe;
        blank = createIcon("images/white.jpg",130);
        bTopLeft = new JButton(createIcon("images/white.jpg",130));
        bTopMiddle = new JButton(createIcon("images/white.jpg",130));
        bTopRight = new JButton(createIcon("images/white.jpg",130));
        bMidLeft = new JButton(createIcon("images/white.jpg",130));
        bCenter = new JButton(createIcon("images/white.jpg",130));
        bMidRight = new JButton(createIcon("images/white.jpg",130));
        bBottomLeft = new JButton(createIcon("images/white.jpg",130));
        bBottomMiddle = new JButton(createIcon("images/white.jpg",130));
        bBottomRight = new JButton(createIcon("images/white.jpg",130));
        bQuit = new JButton("Quit");
        bResults = new JButton("See your results");
        add(bTopLeft);
        add(bTopMiddle);
        add(bTopRight);
        add(bMidLeft);
        add(bCenter);
        add(bMidRight);
        add(bBottomLeft);
        add(bBottomMiddle);
        add(bBottomRight);
        add(bQuit);
        bTopLeft.setBorderPainted(false);
        bTopMiddle.setBorderPainted(false);
        bTopRight.setBorderPainted(false);
        bMidLeft.setBorderPainted(false);
        bCenter.setBorderPainted(false);
        bMidRight.setBorderPainted(false);
        bBottomLeft.setBorderPainted(false);
        bBottomMiddle.setBorderPainted(false);
        bBottomRight.setBorderPainted(false);
        bTopLeft.setBounds(new Rectangle(350,30,130,130));
        bTopMiddle.setBounds(new Rectangle(517,30,130,130));
        bTopRight.setBounds(new Rectangle(685,30,130,130));
        bMidLeft.setBounds(new Rectangle(350,200,130,130));
        bCenter.setBounds(new Rectangle(517,200,130,130));
        bMidRight.setBounds(new Rectangle(685,200,130,130));
        bBottomLeft.setBounds(new Rectangle(350,370,130,130));
        bBottomMiddle.setBounds(new Rectangle(517,370,130,130));
        bBottomRight.setBounds(new Rectangle(685,370,130,130));
        bQuit.setBounds(new Rectangle(1060,10,65,50));
        bTopLeft.addActionListener(this);
        bTopMiddle.addActionListener(this);
        bTopRight.addActionListener(this);
        bMidLeft.addActionListener(this);
        bCenter.addActionListener(this);
        bMidRight.addActionListener(this);
        bBottomLeft.addActionListener(this);
        bBottomMiddle.addActionListener(this);
        bBottomRight.addActionListener(this);
        bQuit.addActionListener(this);
        setTheme("football");
    }
    
    private ImageIcon createIcon(String path, int dim)
    {
        ImageIcon imageSource = new ImageIcon(path);
        Image image = imageSource.getImage();
        Image imageTemp = image.getScaledInstance(dim, dim, dim);
        ImageIcon imageIcon = new ImageIcon(imageTemp);
        return imageIcon;
    }
    
    public void setTheme(String theme)
    {
        if (theme == "football")
        {
            playerIcon = createIcon("images/football.jpg",130);
            opponentIcon = createIcon("images/helmet.jpg",130);
            ImageIcon goalSource = new ImageIcon("images/goal.jpg");
            goal = goalSource.getImage();
            ImageIcon lostSource = new ImageIcon("images/lossFootball.jpg");
            lost = lostSource.getImage();
        }
        if (theme == "computer")
        {
            playerIcon = createIcon("images/cpu.jpg",130);
            opponentIcon = createIcon("images/ram.jpg",130);
            ImageIcon goalSource = new ImageIcon("images/supercomputer.jpg");
            goal = goalSource.getImage();
            ImageIcon lostSource = new ImageIcon("images/lossComputer.jpg");
            lost = lostSource.getImage();
        }
        if (theme == "math")
        {
            playerIcon = createIcon("images/sigma.png",130);
            opponentIcon = createIcon("images/pi.png",130);
            ImageIcon goalSource = new ImageIcon("images/aplus.jpg");
            goal = goalSource.getImage();
            ImageIcon lostSource = new ImageIcon("images/lossMath.jpg");
            lost = lostSource.getImage();
            gameTheme = "Math";
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object evt = event.getSource();
        if (evt == bTopLeft)
        {
            bTopLeft.setIcon(playerIcon);
            bTopLeft.removeActionListener(this);
            tl = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bTopMiddle)
        {
            bTopMiddle.setIcon(playerIcon);
            bTopMiddle.removeActionListener(this);
            tm = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bTopRight)
        {
            bTopRight.setIcon(playerIcon);
            bTopRight.removeActionListener(this);
            tr = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bMidLeft)
        {
            bMidLeft.setIcon(playerIcon);
            bMidLeft.removeActionListener(this);
            ml = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bCenter)
        {
            bCenter.setIcon(playerIcon);
            bCenter.removeActionListener(this);
            c = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bMidRight)
        {
            bMidRight.setIcon(playerIcon);
            bMidRight.removeActionListener(this);
            mr = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bBottomLeft)
        {
            bBottomLeft.setIcon(playerIcon);
            bBottomLeft.removeActionListener(this);
            bl = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bBottomMiddle)
        {
            bBottomMiddle.setIcon(playerIcon);
            bBottomMiddle.removeActionListener(this);
            bm = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bBottomRight)
        {
            bBottomRight.setIcon(playerIcon);
            bBottomRight.removeActionListener(this);
            br = true;
            checkWin();
            if (win == false)
            {
                opponentMove();
                checkWin();
            }
        }
        if (evt == bQuit)
        {
            bTopLeft.setIcon(blank);
            bTopMiddle.setIcon(blank);
            bTopRight.setIcon(blank);
            bMidLeft.setIcon(blank);
            bCenter.setIcon(blank);
            bMidRight.setIcon(blank);
            bBottomLeft.setIcon(blank);
            bBottomMiddle.setIcon(blank);
            bBottomRight.setIcon(blank);
            tl = false;
            tm = false;
            tr = false;
            ml = false;
            c = false;
            mr = false;
            bl = false;
            bm = false;
            br = false;
            bTopLeft.addActionListener(this);
            bTopMiddle.addActionListener(this);
            bTopRight.addActionListener(this);
            bMidLeft.addActionListener(this);
            bCenter.addActionListener(this);
            bMidRight.addActionListener(this);
            bBottomLeft.addActionListener(this);
            bBottomMiddle.addActionListener(this);
            bBottomRight.addActionListener(this);
        }
    }
    
    public void checkWin()
    {
        if (bTopLeft.getIcon() == bTopMiddle.getIcon() && bTopLeft.getIcon() == 
            bTopRight.getIcon())
        {
            if (bTopLeft.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bTopLeft.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bMidLeft.getIcon() == bCenter.getIcon() && bMidLeft.getIcon() == 
            bMidRight.getIcon())
        {
            if (bMidLeft.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bMidLeft.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bBottomLeft.getIcon() == bBottomMiddle.getIcon() && bBottomLeft.getIcon() == 
            bBottomRight.getIcon())
        {
            if (bBottomLeft.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bBottomLeft.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bTopLeft.getIcon() == bMidLeft.getIcon() && bTopLeft.getIcon() == 
            bBottomLeft.getIcon())
        {
            if (bTopLeft.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bTopLeft.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bTopMiddle.getIcon() == bCenter.getIcon() && bTopMiddle.getIcon() == 
            bBottomMiddle.getIcon())
        {
            if (bTopMiddle.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bTopMiddle.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bTopRight.getIcon() == bMidRight.getIcon() && bTopRight.getIcon() == 
            bBottomRight.getIcon())
        {
            if (bTopRight.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bTopRight.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bTopLeft.getIcon() == bCenter.getIcon() && bTopLeft.getIcon() == 
            bBottomRight.getIcon())
        {
            if (bTopLeft.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bTopLeft.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
        if (bBottomLeft.getIcon() == bCenter.getIcon() && bBottomLeft.getIcon() == 
            bTopRight.getIcon())
        {
            if (bBottomLeft.getIcon() == opponentIcon)
            {
                loss = true;
                this.repaint();
            }
            if (bBottomLeft.getIcon() == playerIcon)
            {
                win = true;
                this.repaint();
            }
        }
    }
    
    public void opponentMove()
    {
        if (tl == false)
        {
            bTopLeft.setIcon(opponentIcon);
            bTopLeft.removeActionListener(this);
            tl = true;
        }
        else if (tm == false)
        {
            bTopMiddle.setIcon(opponentIcon);
            bTopMiddle.removeActionListener(this);
            tm = true;
        }
        else if (tr == false)
        {
            bTopRight.setIcon(opponentIcon);
            bTopRight.removeActionListener(this);
            tr = true;
        }
        else if (ml == false)
        {
            bMidLeft.setIcon(opponentIcon);
            bMidLeft.removeActionListener(this);
            ml = true;
        }
        else if (c == false)
        {
            bCenter.setIcon(opponentIcon);
            bCenter.removeActionListener(this);
            c = true;
        }
        else if (mr == false)
        {
            bMidRight.setIcon(opponentIcon);
            bMidRight.removeActionListener(this);
            mr= true;
        }
        else if (bl == false)
        {
            bBottomLeft.setIcon(opponentIcon);
            bBottomLeft.removeActionListener(this);
            bl = true;
        }
        else if (bm == false)
        {
            bBottomMiddle.setIcon(opponentIcon);
            bBottomMiddle.removeActionListener(this);
            bm = true;
        }
        else if (br == false)
        {
            bBottomRight.setIcon(opponentIcon);
            bBottomRight.removeActionListener(this);
            br = true;
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(tictactoe, 0,0, this);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.white);
        requestFocusInWindow();
        if (win == true)
        {
            removeAll();
            score = 10;
            g.drawImage(goal, 0,0, this);
            if (gameTheme == "Math")
            {
                g.setColor(Color.black);
                g.drawString("You won!", 700, 300);
                g.drawString("Your score was 10", 700, 320);
            }
            else
            {
                g.drawString("You won!", 550, 150);
                g.drawString("Your score was 10", 550, 170);
            }
            add(bResults);
            bResults.setBounds(new Rectangle(535,430,150,50));
        }
        if (loss == true)
        {
            removeAll();
            g.drawImage(lost, 0,0, this);
            if (gameTheme == "Math")
            {
                g.setColor(Color.black);
                g.drawString("You lost", 550, 170);
                g.drawString("Your score was 0", 550, 190);
            }
            else
            {
                g.drawString("You lost", 550, 170);
                g.drawString("Your score was 0", 550, 190);
            }
            add(bResults);
            bResults.setBounds(new Rectangle(535,430,150,50));
        }
    }
}
