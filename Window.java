/**
 * B. Postnikoff
 * Window
 * 2016-04-08
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Window extends JFrame
{
    DrawPolygon graph;
    GraphPanel graphPanel;
    LinePanel linePanel;
    AestheticsPanel aestheticsPanel;
    JPanel optionPanel;
    
    public static void main(String[] args)
    {
        Window window = new Window();
    }
    
    // Constructor for the window
    public Window()
    {
        // Sets window defaults
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setResizable(false);
        this.setTitle("Graph Drawing");        
        
        // Adds the graph display panel
        this.graph = new DrawPolygon();
        graph.setPreferredSize(new Dimension(625, 500));
        graph.setOpaque(true);
        
        // Creates the various option display panels
        this.graphPanel = new GraphPanel(this);
        graphPanel.setPreferredSize(new Dimension(175, 100));
        graphPanel.setOpaque(true);
        
        this.linePanel = new LinePanel();
        linePanel.setPreferredSize(new Dimension(175, 125));
        linePanel.setOpaque(true);
        
        this.aestheticsPanel = new AestheticsPanel();
        aestheticsPanel.setPreferredSize(new Dimension(175, 275));
        aestheticsPanel.setOpaque(true);        
        
        // Creates the option panel container panel
        optionPanel = new JPanel(new BorderLayout());
        optionPanel.add(graphPanel, BorderLayout.PAGE_START);
        optionPanel.add(linePanel, BorderLayout.CENTER);
        optionPanel.add(aestheticsPanel, BorderLayout.PAGE_END);
        
        // Adds the panels to the content pane     
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(graph, BorderLayout.WEST);
        this.getContentPane().add(optionPanel, BorderLayout.EAST);
        this.setVisible(true);        
    }
    
    // Updates the graph in the window
    public void updateGraphVertices(Vertex[] vertexList) {
        graph.updateVertices(vertexList);
    }
}
