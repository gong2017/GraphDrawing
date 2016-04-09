/**
 * B. Postnikoff
 * Option panel
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionPanel extends JPanel implements ActionListener
{
    JButton exitButton;
    
    public OptionPanel()
    {
        exitButton = new JButton("Exit");
        this.add(exitButton);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
