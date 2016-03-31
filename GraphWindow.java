/**
 * B. Postnikoff
 * GraphWindow
 * 2016-03-31
 */

import javax.swing.*;

public class GraphWindow extends JFrame
{
    // Constructor for a graph window object
    public GraphWindow()
    {
        this.setUpWindow();
    }
    
    // Sets the default for the window object;
    public void setUpWindow()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setResizable(false);
        this.setTitle("Graph Drawing Project");
        this.setVisible(true);
    }
}
