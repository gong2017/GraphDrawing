/**
 * B. Postnikoff
 * Line Panel
 * Line settings control pnael.
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LinePanel extends Panel
{
    private JLabel lineLabel = new JLabel("Choose line shape: ");
    private JRadioButton straightLine = new JRadioButton("Straight");
    private JRadioButton orthogonalLine = new JRadioButton("Orthogonal");

    // Line panel constructor
    public LinePanel(Window window)
    {
        super(window); 
        this.add(lineLabel);
        lineLabel.setForeground(Color.WHITE);
        
        straightLine.setSelected(true);
        setButtonDetails(straightLine);
        setButtonDetails(orthogonalLine);
    }
    
    // Sets the details of the buttons, and adds them to the Panel
    public void setButtonDetails(JRadioButton button)
    {
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        this.add(button);
    }

    // Adjusts the display of lines if options are adjusted
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Gets the source of the line change, sets its value to true
        //     and sets the other source to false
        if (e.getSource() == straightLine)
        {
            orthogonalLine.setSelected(false);
            straightLine.setSelected(true);
            window.updateLineType(0);
        }
        else
        {
            straightLine.setSelected(false);
            orthogonalLine.setSelected(true);
            window.updateLineType(1);
        }

        // Repaints the window based on line selection
        window.repaint();
    }
}