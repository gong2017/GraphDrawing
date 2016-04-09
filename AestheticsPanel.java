/**
 * B. Postnikoff
 * Aesthetics Panel
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AestheticsPanel extends Panel
{
    private JLabel aesthetics = new JLabel("Choose aesthetics: ");
    private JRadioButton minVertexDistance = new JRadioButton("<html>Minimize vertex<br>distance</html>");
    private JRadioButton minEdgeCrossing = new JRadioButton("<html>Minimize edge<br>crossings</html>");
    private JRadioButton minGraphArea = new JRadioButton("Minimize graph area");
    private JRadioButton maxSymmetry = new JRadioButton("Maximize symmetry");    
    
    // AestheticsPanel object constructor
    public AestheticsPanel(Window window)
    {
        super(window);
        
        minVertexDistance.addActionListener(this);
        minEdgeCrossing.addActionListener(this);
        minGraphArea.addActionListener(this);
        maxSymmetry.addActionListener(this);
        
        this.add(aesthetics);
        this.add(minVertexDistance);
        this.add(minEdgeCrossing);
        this.add(minGraphArea);
        this.add(maxSymmetry);
    }
    
    // Repaints the graph based on the aesthetic choices of the user
    @Override
    public void actionPerformed(ActionEvent e)
    {
        window.repaint();
    }
}
