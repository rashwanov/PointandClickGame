package l10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlPanel extends JPanel implements ActionListener
{
    ControlPanel control;
    CreditsAbout creds;
    Game1 g1;
    Game2 g2;
    Game3 g3;
    GameOver over;
    Instructions inst;
    IntroScreen intro;
    MainMap map;
    Options opt;
    int gamesCompleted = 0, seconds = 0, minutes = 0;
    String lastCampus;
    Timer playtime;
    
    public ControlPanel(CreditsAbout creds, Game1 g1, Game2 g2, Game3 g3, 
            GameOver over, Instructions inst, IntroScreen intro, MainMap map, 
            Options opt)
    {
        GridLayout grid = new GridLayout(1,2,15,15);
        setLayout(grid);
        add(intro);
        intro.bCreds.addActionListener(this);
        intro.bInst.addActionListener(this);
        intro.bOptions.addActionListener(this);
        intro.bMap.addActionListener(this);
        creds.bBack.addActionListener(this);
        inst.bBack.addActionListener(this);
        opt.bGates.addActionListener(this);
        opt.bBrown.addActionListener(this);
        opt.bPhelps.addActionListener(this);
        opt.bFootball.addActionListener(this);
        opt.bComputer.addActionListener(this);
        opt.bMath.addActionListener(this);
        opt.bBack.addActionListener(this);
        map.bBehrend.addActionListener(this);
        map.bUPark.addActionListener(this);
        map.bScranton.addActionListener(this);
        map.bFayette.addActionListener(this);
        map.bWorld.addActionListener(this);
        map.bBack.addActionListener(this);
        map.bEnd.addActionListener(this);
        g1.bQuit.addActionListener(this);
        g1.bReturn.addActionListener(this);
        g2.bReturn.addActionListener(this);
        g3.bQuit.addActionListener(this);
        g3.bResults.addActionListener(this);
        this.intro = intro;
        this.creds = creds;
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.over = over;
        this.inst = inst;
        this.map = map;
        this.opt = opt;
        playtime = new Timer(1000,this);
        playtime.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object evt = event.getSource();
        //================================================ Intro buttons
        if (evt == intro.bCreds)
        {
            goToPanel(creds);
        }
        if (evt == intro.bInst)
        {
            goToPanel(inst);
        }
        if (evt == intro.bOptions)
        {
            goToPanel(opt);
        }
        if (evt == intro.bMap)
        {
            goToPanel(map);
            map.requestFocusInWindow();
        }
        //================================================ Misc buttons
        if (evt == creds.bBack)
        {
            goToPanel(intro);
        }
        if (evt == inst.bBack)
        {
            goToPanel(intro);
        }
        //================================================ Options buttons
        if (evt == opt.bGates)
        {
            map.setCharacter("Gates");
        }
        if (evt == opt.bBrown)
        {
            map.setCharacter("Brown");
            g1.setCharacter("Brown");
        }
        if (evt == opt.bPhelps)
        {
            map.setCharacter("Phelps");
        }
        if (evt == opt.bFootball)
        {
            g1.setTheme("football");
            g3.setTheme("football");
        }
        if (evt == opt.bComputer)
        {
            g1.setTheme("computer");
            g3.setTheme("computer");
        }
        if (evt == opt.bMath)
        {
            g1.setTheme("math");
            g3.setTheme("math");
        }
        if (evt == opt.bBack)
        {
            goToPanel(intro);
        }
        //============================================== Map buttons
        if (evt == map.bBehrend)
        {
            lastCampus = "Behrend";
            map.bBehrend.removeActionListener(this);
            progressGame();
            map.x = 305;
            map.y = 145;
            map.playerLocation();
        }
        if (evt == map.bUPark)
        {
            lastCampus = "UPark";
            map.bUPark.removeActionListener(this);
            progressGame();
            map.x = 525;
            map.y = 225;
            map.playerLocation();
        }
        if (evt == map.bScranton)
        {
            lastCampus = "Scranton";
            map.bScranton.removeActionListener(this);
            progressGame();
            map.x = 750;
            map.y = 150;
            map.playerLocation();
        }
        if (evt == map.bFayette)
        {
            lastCampus = "Fayette";
            map.bFayette.removeActionListener(this);
            progressGame();
            map.x = 290;
            map.y = 285;
            map.playerLocation();
        }
        if (evt == map.bWorld)
        {
            lastCampus = "World";
            map.bWorld.removeActionListener(this);
            progressGame();
        }
        if (evt == map.bBack)
        {
            goToPanel(intro);
        }
        if (evt == map.bEnd)
        {
            goToPanel(over);
            over.time = map.time;
            over.score = g1.score + g2.score + g3.score;
        }
        //=============================================== Game1 buttons
        if (evt == g1.bQuit)
        {
            restoreLastCampus();
            goToPanel(map);
            map.requestFocusInWindow();
        }
        if (evt == g1.bReturn)
        {
            goToPanel(map);
            gamesCompleted = 1;
            map.requestFocusInWindow();
            map.score = g1.score;
        }
        //=============================================== Game2 buttons
        if (evt == g2.bReturn)
        {
            goToPanel(map);
            gamesCompleted = 2;
            map.requestFocusInWindow();
            map.score = g1.score + g2.score;
        }
        //=============================================== Game3 buttons
        if (evt == g3.bQuit)
        {
            restoreLastCampus();
            goToPanel(map);
            map.requestFocusInWindow();
        }
        if (evt == g3.bResults)
        {
            goToPanel(over);
            gamesCompleted = 3;
            map.requestFocusInWindow();
            over.score = g1.score + g2.score + g3.score;
            over.time = map.time;
        }
        //============================================== Timer
        if (evt == playtime)
        {
            seconds = seconds + 1;
            if (seconds == 60)
            {
                seconds = 0;
                minutes = minutes + 1;
            }
            map.time = minutes + ":" + seconds;
            map.repaint();
        }
    }
    
    public ImageIcon createIcon(String path, int dim)
    {
        ImageIcon imageSource = new ImageIcon(path);
        Image image = imageSource.getImage();
        Image imageTemp = image.getScaledInstance(dim, dim, dim);
        ImageIcon imageIcon = new ImageIcon(imageTemp);
        return imageIcon;
    }
    
    private void progressGame()
    {
        removeAll();
        if (gamesCompleted == 0)
        {
            add(g1);
            g1.requestFocusInWindow();
        }
        if (gamesCompleted == 1)
        {
            add(g2);
            g2.requestFocusInWindow();
        }
        if (gamesCompleted == 2)
        {
            add(g3);
            g3.requestFocusInWindow();
        }
        if (gamesCompleted == 3)
        {
            add(over);
        }
        validate();
        repaint();
    }
    
    private void goToPanel(JPanel panel)
    {
        removeAll();
        add(panel);
        validate();
        repaint();
    }
    
    private void restoreLastCampus()
    {
        if (lastCampus == "Behrend")
        {
            map.bBehrend.addActionListener(this);
        }
        if (lastCampus == "UPark")
        {
            map.bUPark.addActionListener(this);
        }
        if (lastCampus == "Scranton")
        {
            map.bScranton.addActionListener(this);
        }
        if (lastCampus == "Fayette")
        {
            map.bFayette.addActionListener(this);
        }
        if (lastCampus == "World")
        {
            map.bWorld.addActionListener(this);
        }
    }
}
