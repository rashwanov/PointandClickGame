package l10;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Game1 extends JPanel implements ActionListener
{
    int score = 0;
    JButton bBall, bQuit, bReturn, bStart;
    int BUTTON_WIDTH = 90;
    int BUTTON_HEIGHT = 90;
    Timer ticker, bTicker; // initialized the timers
    int delay = 1000; // sets the delay value for the progressbar timer - milliseconds
    int wait = 2000; // sets the delay value for the bTicker timer  - milliseconds
    int totalTime = 10; // the total time in the progressbar - in this case 1 min or 60 sec
    JProgressBar timeLimitBar;
    Image field, ball, goal;
    Random rand = new Random();
    String player,gameTheme;

    public Game1()
    {
        setLayout(null);
        ImageIcon fieldSource = new ImageIcon("images/field.jpeg");
        Image field = fieldSource.getImage();
        this.field = field;
        ImageIcon ballSource = new ImageIcon("images/football.jpg");
        Image ball = ballSource.getImage();
        ImageIcon goalSource = new ImageIcon("images/goal.jpg");
        Image goal = goalSource.getImage();
        this.goal = goal;
        
        Image ballTemp = ball.getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT, 
            Image.SCALE_SMOOTH );  
        ImageIcon ballIcon = new ImageIcon(ballTemp);
        bBall = new JButton(ballIcon);
        bStart = new JButton("Start");
        bQuit = new JButton("Quit");
        bReturn = new JButton("Return to main map");
        add(bBall);
        bBall.addActionListener(this);
        bBall.setBounds(new Rectangle(400, 400, BUTTON_WIDTH, BUTTON_HEIGHT));
        bBall.setBorderPainted(false);
        
        add(bStart);
        bStart.addActionListener(this);
        bStart.setBounds(new Rectangle(950,10,65,50));
        
        add(bQuit);
        bQuit.addActionListener(this);
        bQuit.setBounds(new Rectangle(1060,10,65,50));

        ticker = new Timer(delay, this);

        // This is the button repainter timer
        bTicker = new Timer(wait, this);
        
        timeLimitBar = new JProgressBar(SwingConstants.VERTICAL, 0, 60);
        timeLimitBar.setValue(60);
        add(timeLimitBar);
        timeLimitBar.setBounds(new Rectangle(1130,0,50,550));
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object evt = event.getSource();
        
        if (evt == bStart)
        {
            ticker.start();
            bTicker.start();
            bStart.removeActionListener(this);
        }
        
        if (evt == bBall)
        {
            this.requestFocus();
            System.out.println("button");
            if (ticker.isRunning())
            {
                System.out.println("Score plus 1\n");

                bBall.setBounds(rand.nextInt(getWidth() - BUTTON_WIDTH),
                    rand.nextInt(getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                    BUTTON_HEIGHT);
                for (int tries = 0; tries < 50; tries++)
                {
                    if (intersectsComponent(bBall, getComponents()))
                    {
                        bBall.setBounds(rand.nextInt(getWidth() - BUTTON_WIDTH),
                            rand.nextInt(getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                            BUTTON_HEIGHT);
                    } 
                    else
                    {
                        add(bBall);
                        break; //cause the for loop to end
                    }
                }
                score++; 
            }
        }
        
        if (evt == bQuit)
        {
            ticker.stop();
            bTicker.stop();
            totalTime = 60;
            score = 0;
            timeLimitBar.setValue(60);
            bStart.addActionListener(this);
            BUTTON_HEIGHT = 90;
            BUTTON_WIDTH = 90;
            bBall.setBounds(new Rectangle(400, 400, BUTTON_WIDTH, BUTTON_HEIGHT));
        }
        
        if (evt == ticker)
        {
            totalTime = totalTime - 1;
            timeLimitBar.setValue(totalTime);
            timeLimitBar.setString(":" + totalTime + " Remaining");

            if (totalTime <= 0)
            {
                ticker.stop();
                bTicker.stop();
                System.out.println("Game Over\n");
                removeAll();
                validate();
                repaint();
            }
        }
        
        if (evt == bTicker)
        {
            validate(); 

            bBall.setBounds(rand.nextInt(getWidth() - BUTTON_WIDTH),
                rand.nextInt(getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                BUTTON_HEIGHT);
            for (int tries = 0; tries < 50; tries++)
            {
                if (intersectsComponent(bBall, getComponents()))
                {
                    bBall.setBounds(rand.nextInt(getWidth() - BUTTON_WIDTH),
                        rand.nextInt(getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                        BUTTON_HEIGHT);
                } 
                else
                {
                    add(bBall);
                    break;
                }
            }
            System.out.println(wait + "bTicker Timer Move Button\n");
            System.out.println(BUTTON_WIDTH + "bTicker Button width\n");
            System.out.println(BUTTON_HEIGHT + "bTicker Button height\n");
            wait = wait - 10;
            bTicker.setDelay(wait);
            BUTTON_WIDTH = BUTTON_WIDTH - 2; //Decreases the width of the box by 2
            BUTTON_HEIGHT = BUTTON_HEIGHT - 2; //Decreases the height of the box by 2
        }
    }

    public boolean intersectsComponent(Component component, Component[] components)
    {
        for (Component c : components)
        {
            if (c.getBounds().intersects(component.getBounds()))
            {
                return true;
            }
        }
        return false;
    }

    public void setTheme (String theme)
    {
        if (theme == "football")
        {
            bBall.setIcon(createIcon("images/football.jpg", 90));
            ImageIcon fieldSource = new ImageIcon("images/field.jpeg");
            field = fieldSource.getImage();
                        ImageIcon goalSource = new ImageIcon("images/goal.jpg");
            goal = goalSource.getImage();
            this.repaint();
        }
        if (theme == "computer")
        {
            bBall.setIcon(createIcon("images/cpu.jpg", 100));
            ImageIcon fieldSource = new ImageIcon("images/motherboard.jpg");
            field = fieldSource.getImage();
            ImageIcon goalSource = new ImageIcon("images/supercomputer.jpg");
            goal = goalSource.getImage();
            this.repaint();
        }
        if (theme == "math")
        {
            bBall.setIcon(createIcon("images/sigma.png", 75));
            ImageIcon fieldSource = new ImageIcon("images/chalkboard.jpg");
            field = fieldSource.getImage();
            ImageIcon goalSource = new ImageIcon("images/aplus.jpg");
            goal = goalSource.getImage();
            gameTheme = "Math";
            this.repaint();
        }
    }
    
    public void setCharacter (String character)
    {
        if (character == "Brown")
        {
            player = "Brown";
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
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        /*As long as the totaltime is greater than 0,
        * program will continue to use this graphics call
        * to paint the scene
        */
        
        if (totalTime > 0)
        {
            g.drawImage(field, 0,0, this);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.white);
            g.drawString("Score = " + score, 10, 20);
            g.drawString("Select Start when you're ready to play", 10, 40);
            g.drawString("You have 60 seconds to keep clicking on the ball to score", 10, 60);
            requestFocusInWindow();
        }
        else
        {
            //Once totalTime is less than or equal to zero, this is called to
            //display the game over message and data.
            removeAll();
            g.drawImage(goal, 0,0, this);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.white);
            if (gameTheme == "Math")
            {
                g.setColor(Color.black);
                g.drawString("Game complete!", 700, 300);
                if (player == "Brown")
                {
                    g.drawString("Courtney Brown's agility earned you 5 bonus "
                        + "points!", 700, 320);
                    score = score + 5;
                    g.drawString("Your score was " + score, 700, 340);
                }
                else
                {
                    g.drawString("Your score was " + score, 700, 320);
                }
            }
            else
            {
                g.drawString("Game complete!", 550, 150);
                if (player == "Brown")
                {
                    g.drawString("Courtney Brown's agility earned you 5 bonus "
                        + "points!", 430, 170);
                    score = score + 5;
                    g.drawString("Your score was " + score, 550, 190);
                }
                else
                {
                    g.drawString("Your score was " + score, 550, 170);
                }
            }
            add(bReturn);
            bReturn.setBounds(new Rectangle(535,430,150,50));
        }
    }
}