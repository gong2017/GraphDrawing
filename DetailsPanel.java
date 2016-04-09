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
    private String graphLabelString = "GraphName:   ";
    private JLabel graphNameLabel;
    
    private int numVertices;
    private String numVerticesLabelString = "Number of vertices:   ";
    private JLabel graphVerticesLabel;
    
    private int numEdges;
    private String numEdgesLabelString = "Number of edges:   ";    
    private JLabel graphEdgesLabel;
    
    public DetailsPanel(Window window)
    {      
        this.window = window;
        this.setLayout(new GridLayout(0,3));
        this.setBorder(BorderFactory.createEmptyBorder(20,10,0,0));
        
        graphNameLabel = new JLabel(graphLabelString);
        graphVerticesLabel = new JLabel(numVerticesLabelString);
        graphEdgesLabel = new JLabel(numEdgesLabelString);
        
        this.add(graphNameLabel);
        this.add(graphVerticesLabel);
        this.add(graphEdgesLabel);      
    }    
    
    // Updates the JLabels based on the graphs details
    public void updateDetails(String graphName, int numVertices, int numEdges)
    {
        this.graphName = graphName;
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        
        graphNameLabel.setText(graphLabelString + graphName);
        graphVerticesLabel.setText(numVerticesLabelString + numVertices);
        graphEdgesLabel.setText(numEdgesLabelString + numEdges);
    }
}
