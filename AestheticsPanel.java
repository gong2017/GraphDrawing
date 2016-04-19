/**
 * B. Postnikoff
 * Aesthetics Panel
 * Holds the aestheic controls for the graph
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AestheticsPanel extends Panel
{
    Color blueColor = new Color(0,154,255);
    Color redColor = new Color(255, 102, 102);
    Color greenColor = new Color(0, 255, 153);
    private JLabel aesthetics = new JLabel("Choose aesthetics: ");
    private JButton eades = new JButton("(Step through) Eades");
    private JButton blueVertices = new JButton("Blue Vertices");
    private JButton redVertices = new JButton("Red Vertices");
    private JButton greenVertices = new JButton("Green Vertices");

    // AestheticsPanel object constructor
    public AestheticsPanel(Window window)
    {
        super(window);
        this.setBorder(BorderFactory.createEmptyBorder(0,10,350,0));

        aesthetics.setForeground(Color.WHITE);
        this.add(aesthetics);
        
        setButtonDetails(eades);
        setButtonDetails(blueVertices);
        setButtonDetails(redVertices);
        setButtonDetails(greenVertices);
        
        blueVertices.setBackground(blueColor);
        redVertices.setBackground(redColor);
        greenVertices.setBackground(greenColor);
    }

    // Sets button details, adds action listener, adds to panel
    public void setButtonDetails(JButton button)
    {
        button.addActionListener(this);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        this.add(button);
    }

    // Repaints the graph based on the aesthetic choices of the user
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == eades) {
            window.updateAesthetic(0);
        } else if (e.getSource() == blueVertices) {
            window.updateVertexColor(blueColor);
        } else if (e.getSource() == redVertices) {
            window.updateVertexColor(redColor);
        } else if (e.getSource() == greenVertices) {
            window.updateVertexColor(greenColor);
        }
        

        window.repaint();
    }
}
