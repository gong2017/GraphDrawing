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
    private JCheckBox minVertexDistance = new JCheckBox("Minimize vertex distance");
    private JCheckBox minEdgeCrossing = new JCheckBox("Minimize edge crossings");
    private JCheckBox minGraphArea = new JCheckBox("Minimize graph area");
    private JCheckBox maxSymmetry = new JCheckBox("Maximize symmetry");    
    
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
