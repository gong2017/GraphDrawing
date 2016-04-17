/**
 * B. Postnikoff
 * Panel
 * Abstract panel class, used as base for other panels
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public abstract class Panel extends JPanel implements ActionListener
{
    protected Window window;
    protected GridLayout gridLayout = new GridLayout(0,1);
    
    // Window object constructor
    public Panel(Window window)
    {
        this.window = window;
        this.setBorder(BorderFactory.createEmptyBorder(0,10,20,0));
        this.setLayout(gridLayout);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }
}
