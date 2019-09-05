/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l10;

/**
 *
 * @author Dolly
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
public class ScreenSize {
    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int width = dim.width;
    int height = dim.height;
    
}
