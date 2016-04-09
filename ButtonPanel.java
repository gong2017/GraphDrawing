/**
 * B. Postnikoff
 * Button Panel
 * 2016-04-08
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel //implements ActionListener
{    
    private JComboBox graphList;
    private String[] graphStringList = {"Mid7", "Mid9", "TestFile", "Thomassen"}; 
    
    // Button Panel constructor
    public ButtonPanel()
    {        
        this.graphList = new JComboBox(graphStringList);
        this.add(graphList);
        
    }
}
