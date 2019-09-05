package l10;

import javax.swing.*;

public class MainFrame extends JFrame
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
    
    public MainFrame()
    {
        super("IST 240 Last Project");
        creds = new CreditsAbout();
        g1 = new Game1();
        g2 = new Game2();
        g3 = new Game3();
        over = new GameOver();
        inst = new Instructions();
        intro = new IntroScreen();
        map = new MainMap();
        opt = new Options();
        control = new ControlPanel(creds, g1, g2, g3, over, inst, intro, map, opt);
        ScreenSize screen = new ScreenSize();
        getContentPane().add(control);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(screen.width, screen.height);
        setVisible(true);
    }
}
