package l10;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel implements ActionListener
{
    JButton bGates,bBrown,bPhelps,bFootball,bComputer,bMath,bBack;
    
    public Options()
    {
        setBackground(Color.white);
        setLayout(null);
        bGates = new JButton(createIcon("images/gates.jpg", 150));
        bBrown = new JButton();
        bPhelps = new JButton();
        bFootball = new JButton(createIcon("images/football.jpg", 150));
        bComputer = new JButton();
        bMath = new JButton();
        bBack = new JButton("Back");
        add(bGates);
        add(bBrown);
        add(bPhelps);
        add(bFootball);
        add(bComputer);
        add(bMath);
        add(bBack);
        bGates.addActionListener(this);
        bBrown.addActionListener(this);
        bPhelps.addActionListener(this);
        bFootball.addActionListener(this);
        bComputer.addActionListener(this);
        bMath.addActionListener(this);
        bGates.setBounds(new Rectangle(275,95,150,150));
        bBrown.setBounds(new Rectangle(550,95,150,150));
        bPhelps.setBounds(new Rectangle(825,95,150,150));
        bFootball.setBounds(new Rectangle(275,325,150,150));
        bComputer.setBounds(new Rectangle(550,325,150,150));
        bMath.setBounds(new Rectangle(825,325,150,150));
        bBack.setBounds(new Rectangle(65,245,150,80));
        bBack.setFont(new Font("Arial", Font.PLAIN, 30));
    }
    
    private ImageIcon createIcon(String path, int dim)
    {
        ImageIcon imageSource = new ImageIcon(path);
        Image image = imageSource.getImage();
        Image imageTemp = image.getScaledInstance(dim, dim, dim);
        ImageIcon imageIcon = new ImageIcon(imageTemp);
        return imageIcon;
    }
    
    private void updateCharacter(JButton buttonPressed)
    {
        if (buttonPressed == bGates)
        {
            bGates.setIcon(createIcon("images/gates.jpg", 150));
            bBrown.setIcon(null);
            bPhelps.setIcon(null);
        }
        if (buttonPressed == bBrown)
        {
            bBrown.setIcon(createIcon("images/brown.jpg", 150));
            bGates.setIcon(null);
            bPhelps.setIcon(null);
        }
        if (buttonPressed == bPhelps)
        {
            bPhelps.setIcon(createIcon("images/phelps.jpg", 150));
            bBrown.setIcon(null);
            bGates.setIcon(null);
        }
    }
    
    private void updateTheme(JButton buttonPressed)
    {
        if (buttonPressed == bFootball)
        {
            bFootball.setIcon(createIcon("images/football.jpg", 150));
            bComputer.setIcon(null);
            bMath.setIcon(null);
        }
        if (buttonPressed == bComputer)
        {
            bComputer.setIcon(createIcon("images/computer.jpg", 150));
            bFootball.setIcon(null);
            bMath.setIcon(null);
        }
        if (buttonPressed == bMath)
        {
            bMath.setIcon(createIcon("images/math.jpg", 150));
            bComputer.setIcon(null);
            bFootball.setIcon(null);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object evt = event.getSource();
        
        if (evt == bGates)
        {
            updateCharacter(bGates);
        }
        if (evt == bBrown)
        {
            updateCharacter(bBrown);
        }
        if (evt == bPhelps)
        {
            updateCharacter(bPhelps);
        }

        if (evt == bFootball)
        {
            updateTheme(bFootball);
        }
        if (evt == bComputer)
        {
            updateTheme(bComputer);
        }
        if (evt == bMath)
        {
            updateTheme(bMath);
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Options", 475, 50);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString("Character", 60, 180);
        g.drawString("Theme", 80, 415);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Bill Gates", 305, 275);
        g.drawString("Courtney Brown", 547, 275);
        g.drawString("Michael Phelps", 840, 275);
        g.drawString("Football", 315, 505);
        g.drawString("Computer Science", 540, 505);
        g.drawString("Math", 875, 505);
    }
}