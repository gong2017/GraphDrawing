/**
 * B. Postnikoff
 * Graph
 * 2016-03-31
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class DrawPolygon extends JPanel {
    private Vertex[] vertexList;
    private int x;
    private int y;
    private ArrayList currentVertices;
    private Vertex currentVertex;
    private int lineType = 0;

    // Constructor for a graph object
    public DrawPolygon() {
        super();
        this.vertexList = null;
    }

    // Paints the graph on the screen
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        ((Graphics2D) g).setPaint(Color.BLACK);

        // Starting coordinates for the graph to be displayed.
        x = 50;
        y = 50;        

        // Only displays a graph if the list of vertices is not empty. 
        if (vertexList != null)
        {
            // Draws the vertices on the screen
            for ( int i = 1; i < vertexList.length; i++) {
                if (x >= getWidth()-50)
                {
                    x = 50;
                    y += 50;
                }
                g.drawString(String.valueOf(i), x, y);

                vertexList[i].setX(x);
                vertexList[i].setY(y);
                x += 50;
            }

            // Draws the edges between the vertices on the screen
            for (int k = 1; k < vertexList.length; k++) {
                // Grab the vertex we would like to add edges from.
                currentVertices = vertexList[k].getAdjacentVertices();

                for (int j = 0; j < currentVertices.size(); j++) {
                    currentVertex = vertexList[(int)currentVertices.get(j)];

                    if (lineType == 0) {
                        g.drawLine(vertexList[k].getX(), vertexList[k].getY(), currentVertex.getX(), currentVertex.getY());
                    }
                    else
                    {
                        g.drawLine(vertexList[k].getX(), vertexList[k].getY(), currentVertex.getX(), vertexList[k].getY());
                        g.drawLine(currentVertex.getX(), vertexList[k].getY(), currentVertex.getX(), currentVertex.getY());
                    }
                }
            }
        }
    }

    // Updates the list of vertices we are currently processing
    public void updateVertices(Vertex[] vertexList) {
        this.vertexList = vertexList;
    }

    // Updates the line type to display in the graph
    public void updateLineType(int lineChoice)
    {
        lineType = lineChoice;
    }
}