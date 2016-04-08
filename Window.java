/**
 * B. Postnikoff
 * Window
 * 2016-04-08
 */

import javax.swing.*;

public class Window extends JFrame
{
    DrawPolygon graph;
    
    public Window()
    {
        this.graph = new DrawPolygon();
        this.add(graph);
        setUpWindow();
    }
    
    // Sets up the window for display
    public void setUpWindow()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(false);
        this.setTitle("Graph Drawing Project");
        this.setVisible(true);
    }
    
    public void updateGraphVertices(Vertex[] vertexList) {
        graph.updateVertices(vertexList);
    }
}
