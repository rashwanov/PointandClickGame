package l10;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Instructions extends JPanel
{
    JButton bBack;
        
    public Instructions()
    {
        setBackground(Color.white);
        setLayout(null);
        bBack = new JButton("Back");
        add(bBack);
        bBack.setFont(new Font("Arial", Font.PLAIN, 30));
        bBack.setBounds(new Rectangle(515,460,150,50));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.blue);
        g.drawString("Instructions",450,60);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Options: Select your character and theme. Selecting "
                + "Courtney Brown will improve your performance in Game 1.",50,110);
        g.drawString("Selecting Bill Gates will improve your performance in Game"
                + " 2. Selecting Michael Phelps will increase your movement",50,140);
        g.drawString("speed on the main map.",50,170);
        
        g.drawString("Main Map: Use the arrow keys on your keyboard to travel"
                + " to a campus and start a game. You may also click a",50,215);
        g.drawString("campus to be taken there directly. World Campus can only "
                + "be accessed by clicking the icon.",50,245);
        
        g.drawString("Game 1: Press the Start button to begin the game. A button"
                + " will start jumping around the screen and will shrink",50,290);
        g.drawString("with each jump. Every time you click the button, your score"
                + "will increase. You will have 60 seconds.",50,320);
        
        g.drawString("Game 2: Answer trivia questions based on your selected "
                + "theme. Each correct answer will increase your score.",50,365);
        
        g.drawString("Game 3: Play tic-tac-toe against a computer opponent. You"
                + " go first by clicking in a square.",50,410);
    }
}