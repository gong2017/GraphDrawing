/**
 * B. Postnikoff
 * Aesthetics Panel
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AestheticsPanel extends JPanel implements ActionListener
{
    private GridLayout gridLayout = new GridLayout(0,1);
    private JLabel aesthetics = new JLabel("Choose aesthetics: ");
    private JCheckBox minVertexDistance = new JCheckBox("Minimize vertex distance");
    private JCheckBox minEdgeCrossing = new JCheckBox("Minimize edge crossings");
    private JCheckBox minGraphArea = new JCheckBox("Minimize graph area");
    private JCheckBox maxSymmetry = new JCheckBox("Maximize symmetry");    
    
    public AestheticsPanel()
    {
        this.setBorder(BorderFactory.createEmptyBorder(0,10,20,0));
        this.setLayout(gridLayout);
        this.add(aesthetics);
        this.add(minVertexDistance);
        this.add(minEdgeCrossing);
        this.add(minGraphArea);
        this.add(maxSymmetry);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
