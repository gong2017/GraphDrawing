/**
 * B. Postnikoff
 * Edge
 * 2016-04-18
 */

import java.awt.Color;
import java.awt.Graphics;

public class Edge
{
    private Vertex firstEdgeVertex;
    private Vertex secondEdgeVertex;
    private double length;

    // Edge object constructor
    public Edge() {
        length = 25;
    }

    // Sets the first vertex of the edge
    public void setFirstEdgeVertex(Vertex firstEdgeVertex) {
        this.firstEdgeVertex = firstEdgeVertex;
    }

    // Sets the second vertex of the edge
    public void setSecondEdgeVertex(Vertex secondEdgeVertex) {
        this.secondEdgeVertex = secondEdgeVertex;
    }

    // Draws the edge on the screen
    public void drawStraight(Graphics g) {
        g.setColor(Color.black);
        g.drawLine((int)(firstEdgeVertex.getPosition().getX()),
            (int)(firstEdgeVertex.getPosition().getY()),
            (int)(secondEdgeVertex.getPosition().getX()),
            (int)(secondEdgeVertex.getPosition().getY()));
    }

    // Draw the orthogonal lines
    public void drawOrthogonal(Graphics g) {
        g.drawLine((int)firstEdgeVertex.getX(),
            (int)firstEdgeVertex.getY(),
            (int)secondEdgeVertex.getX(),
            (int)firstEdgeVertex.getY());
        g.drawLine((int)secondEdgeVertex.getX(),
            (int)firstEdgeVertex.getY(),
            (int)secondEdgeVertex.getX(),
            (int)secondEdgeVertex.getY());
    }

    // Gets the "spring" of the edge
    public Vector getForce(Vertex springVertex)
    {
        Vector force;
        double temperature;
        double cooling;

        if(firstEdgeVertex == springVertex) {
            force = secondEdgeVertex.getPosition().subtract(firstEdgeVertex.getPosition());
        } else {
            force = firstEdgeVertex.getPosition().subtract(secondEdgeVertex.getPosition());
        }

        temperature = force.getLength() - 10 * length;
        cooling = Math.signum(temperature) * Math.log(Math.abs(temperature)) * 0.01;
        force = force.getUnitVector().multiply(cooling);

        return force;
    }
}
