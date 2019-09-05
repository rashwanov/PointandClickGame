package l10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;      
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class Game2 extends JPanel implements KeyListener, ActionListener
{
    XMLDecoder de;
    String[] questions = new String[2];
    JRadioButton[] buttons = new JRadioButton[6];
    JLabel l1;
    ButtonGroup group;
    JButton nextQ, bReturn;
    XML_240 xml240ReadWrite=null;
    private Object doc;
    int score = 0;

    public Game2()
    {
       setLayout(new GridLayout(1,4));
        setBackground(Color.WHITE);
        xml240ReadWrite = new XML_240(); // creates the 240 class that reads and writes XML

        setFocusable(true);
        addKeyListener(this);

        //=================================
            xml240ReadWrite.openReaderXML("src/XML/L10_Data.xml");
            //QuestionGameTwo questionGameTwo = (QuestionGameTwo)xml240ReadWrite.ReadObject();
            //Iterator<Question> iterator = questionGameTwo.getQuestions().iterator();
            
            /*while(iterator.hasNext())
            {
                System.out.println((Question)iterator.next().getName());
            }*/
            //question1 = (String) xml240ReadWrite.ReadObject();
            questions[0] = (String) xml240ReadWrite.ReadObject();
            
            //ansOne1 = new JRadioButton((String) xml240ReadWrite.ReadObject());
            buttons[0] = new JRadioButton((String) xml240ReadWrite.ReadObject());
            //ansTwo1 = new JRadioButton((String) xml240ReadWrite.ReadObject());
            buttons[1] = new JRadioButton((String) xml240ReadWrite.ReadObject());
            //ansThree1 = new JRadioButton((String) xml240ReadWrite.ReadObject());
            buttons[2] = new JRadioButton((String) xml240ReadWrite.ReadObject());
            
            //question2 = (String) xml240ReadWrite.ReadObject();
            questions[1] = (String) xml240ReadWrite.ReadObject();
            //ansOne2 = new JRadioButton((String) xml240ReadWrite.ReadObject());
            buttons[3] = new JRadioButton((String) xml240ReadWrite.ReadObject());
            //ansTwo2 = new JRadioButton((String) xml240ReadWrite.ReadObject());
            buttons[4] = new JRadioButton((String) xml240ReadWrite.ReadObject());
            //ansThree2 = new JRadioButton((String) xml240ReadWrite.ReadObject());
            buttons[5] = new JRadioButton((String) xml240ReadWrite.ReadObject());
            
            for(int i=0;i<questions.length;i++)
            {
                System.out.println("Questions array: " +questions[i]);
            }
            for(int i=0;i<buttons.length;i++)
            {
                System.out.println("Questions array: " +buttons[i]);
            }
            
            xml240ReadWrite.closeReaderXML();
            
        //=================================
        //-------------------------------------------------------	    
        // add components to JPanel		
        //-------------------------------------------------------	    
        group = new ButtonGroup();
        nextQ = new JButton("Next Question");
        nextQ.addActionListener(this);
        l1 = new JLabel(questions[0]);
        add(l1);
        group.add(buttons[0]);
        group.add(buttons[1]);
        group.add(buttons[2]);
        add(buttons[0]);
        add(buttons[1]);
        add(buttons[2]);
        add(nextQ);
        bReturn = new JButton("Game complete");
        add(bReturn);
    }
/*
    public class Question
    {
        private String name = null;
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
    }
    
    public void addQuestion(Question question)
    {
        questions.add(question);
    }
    
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }
    */
    @Override
    public void keyTyped(KeyEvent evt)
    {
        int kk = evt.getKeyCode();
//-------------------------------------------------------------------
        if (kk == evt.VK_SPACE)
        {
            System.out.println("Escape Key typed; game two ended.");
        }
    }

    @Override
    public void keyPressed(KeyEvent evt)
    {
        int kk = evt.getKeyCode();
//-------------------------------------------------------------------
        if (kk == evt.VK_SPACE)
        {
            System.out.println("Escape Key pressed; game two ended.");
        }
    }

    @Override
    public void keyReleased(KeyEvent evt)
    {
//-------------------------------------------------------------------

        System.out.println("Escape Key released.");

    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == nextQ)
        {
            l1.setText("New Text");
            //group.setText("New Text");
            //JLabel l1 = new JLabel(questions[1]);
        //add(l1);
        
        group.add(buttons[3]);
        group.add(buttons[4]);
        group.add(buttons[5]);
        remove(buttons[0]);
        remove(buttons[1]);
        remove(buttons[2]);
        remove(nextQ);
        add(buttons[3]);
        add(buttons[4]);
        add(buttons[5]);
        add(nextQ);
            
            
    }
    }

    /*@Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}