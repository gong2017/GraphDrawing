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
    private ArrayList currentVertices;
    private Vertex currentVertex;
    private int lineType = 0;
    private int currentAesthetic = 4;
    private Font f = new Font("Monospaced", Font.BOLD, 14);
    private int x;
    private int y;

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

        // Only displays a graph if the list of vertices is not empty.
        if (vertexList != null)
        {
            giveVerticesCoordinates();

            // Draws the edges between the vertices on the screen
            for (int k = 1; k < vertexList.length; k++) {
                // Grab the vertex we would like to add edges from.
                currentVertices = vertexList[k].getAdjacentVertices();

                for (int j = 0; j < currentVertices.size(); j++) {
                    currentVertex = vertexList[(int)currentVertices.get(j)];
                    ((Graphics2D)g).setStroke(new BasicStroke(3));

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

            // Draws the vertices on the screen
            for ( int i = 1; i < vertexList.length; i++) {
                ((Graphics2D)g).setPaint(new Color(255, 102, 102));
                g.fillOval((vertexList[i].getX())-(30/2), (vertexList[i].getY())-(30/2), 30, 30);
                ((Graphics2D)g).setPaint(Color.BLACK);
                g.setFont(f);
                g.drawString(String.valueOf(i), vertexList[i].getX()-5, vertexList[i].getY()+5);
            } 
        }
    }

    // Give initial coordinates to the vertices
    public void giveVerticesCoordinates()
    {
        x = 50;
        y = 50;
        
        for ( int i = 1; i < vertexList.length; i++) {
            if (x >= getWidth()-50)
            {
                x = 50;
                y += 50;
            }

            vertexList[i].setX(x);
            vertexList[i].setY(y);
            x += 50;
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

    // Updates the current aesthetical graph choice
    public void updateAesthetic(int aesthetic)
    {
        currentAesthetic = aesthetic;
    }
}