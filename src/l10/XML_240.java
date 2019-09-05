package l10;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * This class reads and writes XML files based on Java Beans DTD
 * It uses the standard Java classes
 * XMLEncoder
 * XMLDecoder
 * 
 * Use: create the class XML_240 x = new XML_240();
 * READER
 * Open a XML file to read: x.openReader(filename);
 * Close a XML reader file: x.closeReader();
 * 
 * Read an Object: x.readObject();
 * You need to know what TYPE of Object you are reading
 * String s = (String) x.readObject();
 * 
 * WRITER
 * Open a XML file to write: x.openWriter(filename);
 * Close a XML writer file: x.closeWriter();
 * 
 * Write an Object: x.writeObject(ANY JAVA OBJECT/INSTANCE HERE)
 * String s = "fred";
 * x.writeObject(s);
 */
/**
 *
 * @author fredfonseca
 */
public class XML_240
{

    XMLEncoder xmlWriter;
    XMLDecoder xmlReader;

    public XML_240()
    {

    }
//==========================================================================

    public void openReaderXML(String filename)
    {
        try
        {
            xmlReader = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
        } 
        catch (Exception RandExceptionVariable)
        {
            RandExceptionVariable.printStackTrace();
        }
    }
//==========================================================================

    public void openWriterXML(String filename)
    {
        try
        {
            xmlWriter = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        } 
        catch (Exception RandExceptionVariable)
        {
            RandExceptionVariable.printStackTrace();
        }
    }
//==========================================================================

    public void writeObject(Object objectInFile)
    {
        try
        {
            xmlWriter.writeObject(objectInFile);
        } 
        catch (Exception RandExceptionVariable)
        {
            RandExceptionVariable.printStackTrace();
        }
    }
//==========================================================================

    public Object ReadObject()
    {
        Object objectInFile = new Object();
        try
        {
            objectInFile = xmlReader.readObject();
        } 
        catch (Exception RandExceptionVariable)
        {
            RandExceptionVariable.printStackTrace();
        }
        return objectInFile;
    }
//==========================================================================

    public void closeReaderXML()
    {
        try
        {
            xmlReader.close();
        } 
        catch (Exception RandExceptionVariable)
        {
            RandExceptionVariable.printStackTrace();
        }
    }
//==========================================================================

    public void closeWriterXML()
    {
        try
        {
            xmlWriter.close();
        } 
        catch (Exception RandExceptionVariable)
        {
            RandExceptionVariable.printStackTrace();
        }
    }
}
