/**
 * B. Postnikoff
 * Graph
 * 2016-03-31
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.Font;

public class DrawPolygon extends JPanel {
    private Vertex[] vertexList;
    private ArrayList<Edge> edges;
    private ArrayList<Integer> currentVertices;
    private Vertex currentVertex;
    private int lineType = 0; // Straight line
    private int currentAesthetic = 4;
    private Font f = new Font("Monospaced", Font.BOLD, 14);

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
        g.translate(getWidth()/2, getHeight()/2);
        ((Graphics2D) g).setPaint(Color.BLACK); 

        // Only displays a graph if the list of vertices is not empty.
        if (vertexList != null)
        {
            // Gives coordinates to the vertices without coordinates
            giveVerticesCoordinates(getWidth(), getHeight());

            for (int j = 0; j < edges.size(); j++) {
                if (lineType == 0) {
                    edges.get(j).drawStraight(g);
                } else {
                     edges.get(j).drawOrthogonal(g);
                }
            }

            for (int i = 1; i < vertexList.length; i++) {
                vertexList[i].Draw(g);
            }
        }
    }

    // Give initial coordinates to the vertices
    public void giveVerticesCoordinates(int width, int height)
    {
        int x = (width/2) * (-1) + 50;
        int y = ((height/2) * (-1)) + 50;

        for ( int i = 1; i < vertexList.length; i++) {
            if(!vertexList[i].hasCoordinates()) {
                if (x >= getWidth()/2-50)
                {
                    x = (width/2) * (-1) + 50;
                    y += 50;
                }

                vertexList[i].setX(x);
                vertexList[i].setY(y);
                x += 50;
                vertexList[i].hasCoordinates();
            }
        }
    }

    // Update the edges of the graph
    public void updateEdges(ArrayList<Edge> edges) {
        this.edges = edges;
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

    // Updates the current aesthetical graph choice
    public void updateAesthetic(int aesthetic)
    {
        currentAesthetic = aesthetic;
    }
}