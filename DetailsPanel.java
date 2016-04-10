/**
 * B. Postnikoff
 * Details Panel
 * 2016-04-09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailsPanel extends JPanel
{   
    private Window window;
    
    private String graphName;
    private String graphNameString = "GraphName:   ";
    private JLabel graphNameLabel;    
    
    private int numVertices;
    private String numVerticesString = "Number of vertices:   ";
    private JLabel numVerticesLabel;
    
    private int numEdges;
    private String numEdgesString = "Number of edges:   ";    
    private JLabel numEdgesLabel;
    
    public DetailsPanel(Window window)
    {      
        this.window = window;
        this.setLayout(new GridLayout(0,3));
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.setBackground(Color.BLACK);
               
        graphNameLabel = new JLabel(graphNameString);
        setLabelDetails(graphNameLabel);
        
        numVerticesLabel = new JLabel(numVerticesString);
        setLabelDetails(numVerticesLabel);
        
        numEdgesLabel = new JLabel(numEdgesString);
        setLabelDetails(numEdgesLabel);           
    }    
    
    public void setLabelDetails(JLabel label)
    {
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label);
    }
    
    // Updates the JLabels based on the graphs details
    public void updateDetails(String graphName, int numVertices, int numEdges)
    {
        this.graphName = graphName;
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        
        graphNameLabel.setText(graphNameString + graphName);
        numVerticesLabel.setText(numVerticesString + numVertices);
        numEdgesLabel.setText(numEdgesString + numEdges);
    }
}
