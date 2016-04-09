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
    ButtonPanel buttonPanel;
    
    // Constructor for the window
    public Window()
    {
        // Sets window defaults
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setResizable(false);
        this.setTitle("Graph Drawing Project");        
        
        // Adds the graph display panel
        this.graph = new DrawPolygon();
        graph.setPreferredSize(new Dimension(400, 500));
        graph.setOpaque(true);
        
        // Adds the button display panel
        this.buttonPanel = new ButtonPanel();
        buttonPanel.setPreferredSize(new Dimension(400, 500));
        buttonPanel.setOpaque(true);
        
        // Adds the panels to the content pane
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(graph, BorderLayout.WEST);
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);
        this.setVisible(true);        
    }
    
    // Updates the graph in the window
    public void updateGraphVertices(Vertex[] vertexList) {
        graph.updateVertices(vertexList);
    }
}
