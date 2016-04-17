/**
 * B. Postnikoff
 * Vertex
 * 2016-03-29
 */

import java.util.*;

public class Vertex
{
    private ArrayList<Integer> adjacentVertices;
    private int name;
    private int x;
    private int y;
    private boolean hasCoordinates;

    // Constructor for vertex objects
    public Vertex(int name)
    {
        this.name = name;
        adjacentVertices = new ArrayList<Integer>();
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
        return y+5;
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
    public ArrayList<Integer> getAdjacentVertices()
    {
        return adjacentVertices;
    }

    // Adds a new vertex to the adjacency list
    public void addVertex(int newVertex)
    {
        adjacentVertices.add(newVertex);
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
