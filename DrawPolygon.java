/**
 * B. Postnikoff
 * Graph
 * 2016-03-31
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

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

            // Print out edges
            for (int j = 0; j < edges.size(); j++) {
                if (lineType == 0) {
                    edges.get(j).drawStraight(g);
                } else {
                    edges.get(j).drawOrthogonal(g);
                }
            }

            // Print out vertices
            for (int i = 1; i < vertexList.length; i++) {
                vertexList[i].Draw(g);
            }
        }
    }

    // Runs the Eades algorithm
    public void eades() {        
        for (int k = 1; k < vertexList.length; k++) {
            vertexList[k].resetAcceleration();
            vertexList[k].calculateForce(vertexList);
            vertexList[k].calculateEdgeForce();
            vertexList[k].calculateDisplacement();
        }
    }

    // Give initial coordinates to the vertices
    public void giveVerticesCoordinates(int width, int height)
    {
        Random random = new Random();
        int max = 200/2;
        int min = -200/2;
        int x;
        int y;        

        for ( int i = 1; i < vertexList.length; i++) {
            if(!vertexList[i].hasCoordinates()) {
                x = random.nextInt(max - min + 1) + min;
                y = random.nextInt(max - min + 1) + min;

                vertexList[i].setX(x);
                vertexList[i].setY(y);
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

    // Updates the colours of the vertices
    public void updateVertexColor(Color color) {
        for (int i = 1; i < vertexList.length; i++) {
            vertexList[i].updateColor(color);
        }
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

        if (aesthetic == 0) {
            for (int m = 0; m < 100; m++) {
                eades();
                repaint();
            }
        }
    }
}