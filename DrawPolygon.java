/**
 * B. Postnikoff
 * Graph
 * 2016-03-31
 */
import java.awt.Color;
import java.awt.geom.Path2D;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon; 
import javax.swing.*;
import javax.swing.JFrame;
import java.math.*;
import java.util.*;

public class DrawPolygon extends JPanel {
    private Vertex[] vertexList;
    private int x;
    private int y;
    private ArrayList currentVertices;
    private Vertex currentVertex;

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
        //g.translate(getWidth()/2, getHeight()/2); 
        ((Graphics2D) g).setPaint(Color.BLACK);

        x = 50;
        y = 50;       

        if (vertexList != null)
        {
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

            for (int k = 1; k < vertexList.length; k++) {
                currentVertices = vertexList[k].getAdjacentVertices();

                for (int j = 0; j < currentVertices.size(); j++) {
                    currentVertex = vertexList[(int)currentVertices.get(j)];

                    g.drawLine(vertexList[k].getX(), vertexList[k].getY(), currentVertex.getX(), currentVertex.getY());
                }          
            }
        }
    }

    public void updateVertices(Vertex[] vertexList) {
        this.vertexList = vertexList;
    }
}