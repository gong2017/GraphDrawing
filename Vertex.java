/**
 * B. Postnikoff
 * Vertex
 * 2016-03-29
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.Font;

public class Vertex
{
    private ArrayList<Integer> adjacentVertices;
    private ArrayList<Edge> edges;
    private int name;
    private boolean hasCoordinates;
    private Vector position;
    private Vector displacement;
    private Vector acceleration;
    private Font f = new Font("Monospaced", Font.BOLD, 14);
    private Color color = new Color(255, 102, 102);

    // Constructor for vertex objects
    public Vertex(int name)
    {
        this.name = name;
        displacement = new Vector(0,0);
        acceleration = new Vector(0,0);
        position = new Vector(0,0);

        adjacentVertices = new ArrayList<Integer>();
        edges = new ArrayList<Edge>();
    }

    // Get the vertex's position vector
    public Vector getPosition() {
        return position;
    }

    // Resets acceleration
    public void resetAcceleration() {
        this.acceleration = new Vector();
    }
    
    // Calculates force
    // Limits the maximum displacement
    // Prevents the vertex from being placed outside the screen
    public Vector calculateForce(Vertex[] vertexList) {
        Vector result = new Vector();
        Vector temp;
        double temp2;
        
        for(int i = 1; i < vertexList.length; i++){
            if(vertexList[i]== this){
                continue;
            }

            temp = this.position.subtract(vertexList[i].getPosition());
            temp2 = 10 / Math.pow(temp.getLength(), 2);

            temp = temp.getUnitVector().multiply(temp2);
            result = result.add(temp);

        }
        
        acceleration = acceleration.add(result);
        
        return result;
    }
    
    // Calculates edge force, reacts to the edge
    public Vector calculateEdgeForce() {
        Vector totalEdgeForce = new Vector();
        Vector singleEdgeForce;
        
        
        for (int i = 0; i < edges.size(); i++) {
            singleEdgeForce = edges.get(i).getForce(this);
            totalEdgeForce = totalEdgeForce.add(singleEdgeForce);
        }
        
        acceleration = acceleration.add(totalEdgeForce);
        
        return totalEdgeForce;
    }
    
    // Calculates displacement
    public void calculateDisplacement() {
        displacement = displacement.add(acceleration);
        position = position.add(displacement);
        displacement = displacement.multiply(0.99);        
    }

    // Draw the vertex
    public void Draw(Graphics g) {
        ((Graphics2D)g).setPaint(color);
        g.fillOval((int)position.getX()-(30/2), (int)position.getY() -(30/2), 30, 30);
        ((Graphics2D)g).setPaint(Color.BLACK);
        g.setFont(f);
        g.drawString(name+"", (int)position.getX()-5, (int)position.getY()+5);
    }

    // Gets the x coordinate of the vertex
    public double getX() {
        return this.position.getX();
    }

    // Sets the x coordinate of the vertex
    public void setX(double x)
    {
        this.position.setX(x);
    }

    // Gets the y coordinate of the vertex
    public double getY()
    {
        return this.position.getY();
    }

    // Sets the y coordinate of the vertex
    public void setY(double y)
    {
        this.position.setY(y);
    }

    // Returns the name of the vertex.
    public int getName()
    {
        return name;
    }

    // Returns the adjacent vertices.
    public ArrayList<Integer> getAdjacentVertices()
    {
        return adjacentVertices;
    }

    // Adds a new vertex to the adjacency list
    public void addVertex(int newVertex)
    {
        adjacentVertices.add(newVertex);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    // Updates the flag saying a vertex has coordinates to true
    public void setHasCoordinates() {
        hasCoordinates = true;
    }

    // Returns true if the vertex already has coordinates
    public boolean hasCoordinates() {
        return hasCoordinates;
    }

    // Returns a string representation of the vertex.
    public String toString()
    {
        return name + " " + adjacentVertices;
    }
}
