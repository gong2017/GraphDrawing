/**
 * B. Postnikoff
 * Line Panel
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LinePanel extends JPanel implements ActionListener
{
    private GridLayout gridLayout = new GridLayout(0,1);
    private JLabel lineLabel = new JLabel("Choose line shape: ");
    private JRadioButton straightLine = new JRadioButton("Straight");
    private JRadioButton orthogonalLine = new JRadioButton("Orthogonal");
    private JRadioButton polyLine = new JRadioButton("Polyline");    
    
    public LinePanel()
    {
        this.setBorder(BorderFactory.createEmptyBorder(0,10,20,0));
        this.setLayout(gridLayout);
        this.add(lineLabel);
        this.add(straightLine);
        this.add(orthogonalLine);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
