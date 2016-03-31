/**
 * B. Postnikoff
 * Vertex
 * 2016-03-29
 */

import java.util.*;

public class Vertex
{   
    private boolean visited;
    private ArrayList adjacentVertices;
    private int name;
    
    // Constructor for vertex objects
    public Vertex(int name)
    {
        this.name = name;
        adjacentVertices = new ArrayList();
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
