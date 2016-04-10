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
        this.setBorder(BorderFactory.createEmptyBorder(0,10,180,0));
        
        aesthetics.setForeground(Color.WHITE);
        this.add(aesthetics);        
        
        setButtonDetails(minVertexDistance);
        setButtonDetails(minEdgeCrossing);
        setButtonDetails(minGraphArea);
        setButtonDetails(maxSymmetry);

        maxSymmetry.setSelected(true);        
    }
    
    // Sets button details, adds action listener, adds to panel
    public void setButtonDetails(JRadioButton button)
    {
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        this.add(button);
    }
    
    // Repaints the graph based on the aesthetic choices of the user
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == minVertexDistance)
        {
            minVertexDistance.setSelected(true);
            minEdgeCrossing.setSelected(false);
            minGraphArea.setSelected(false);
            maxSymmetry.setSelected(false);
            window.updateAesthetic(0);
        }
        else if (e.getSource() == minEdgeCrossing)
        {
            minVertexDistance.setSelected(false);
            minEdgeCrossing.setSelected(true);
            minGraphArea.setSelected(false);
            maxSymmetry.setSelected(false); 
            window.updateAesthetic(1);            
        }
        else if (e.getSource() == minGraphArea)
        {
            minVertexDistance.setSelected(false);
            minEdgeCrossing.setSelected(false);
            minGraphArea.setSelected(true);
            maxSymmetry.setSelected(false);            
            window.updateAesthetic(2);            
        }
        else
        {
            minVertexDistance.setSelected(false);
            minEdgeCrossing.setSelected(false);
            minGraphArea.setSelected(false);
            maxSymmetry.setSelected(true);            
            window.updateAesthetic(3);            
        }
        
        window.repaint();
    }
}
