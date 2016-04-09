/**
 * B. Postnikoff
 * Vertex
 * 2016-03-29
 */

import java.util.*;

public class Vertex
{
    private ArrayList adjacentVertices;
    private int name;
    private int x;
    private int y;
    
    // Constructor for vertex objects
    public Vertex(int name)
    {
        this.name = name;
        adjacentVertices = new ArrayList();
    }
    
    // Gets the x coordinate of the vertex
    public int getX() {
        return x+5;
    }
    
    // Sets the x coordinate of the vertex
    public void setX(int x)
    {
        this.x = x;
    }
    
    // Gets the y coordinate of the vertex
    public int getY()
    {
        return y-5;
    }
    
    // Sets the y coordinate of the vertex
    public void setY(int y)
    {
        this.y = y;
    }
    
    // Returns the name of the vertex.
    public int getName()
    {
        return name;
    }
    
    // Returns the adjacent vertices.
    public ArrayList getAdjacentVertices()
    {
        return adjacentVertices;
    }
    
    // Adds a new vertex to the adjacency list
    public void addVertex(int newVertex)
    {
        adjacentVertices.add(newVertex);
    }

    // Returns a string representation of the vertex. 
    public String toString()
    {
        return name + " " + adjacentVertices;
    }
}
