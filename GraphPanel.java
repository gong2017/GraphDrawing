/**
 * B. Postnikoff
 * Graph Panel
 * Allows user to select a graph to display
 * 2016-04-08
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class GraphPanel extends Panel
{
    private JLabel graphLabel = new JLabel("Choose graph: ");
    private String[] graphStringList = {"TestFile", "StarFile"}; 
    private JComboBox graphList;
    private Vertex[] vertexList;
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    // Button Panel constructor
    public GraphPanel(Window window)
    {
        super(window);
        this.graphList = new JComboBox(graphStringList);
        graphList.addActionListener(this);

        graphLabel.setForeground(Color.WHITE);

        this.add(graphLabel);
        this.add(graphList);

        graphList.setSelectedItem("TestFile");
        updateGraph();
    }

    // Updates the graph shown based on the combobox choice.
    @Override
    public void actionPerformed(ActionEvent e)
    {
        updateGraph();
    }

    // Updates the vertex list to represent the current graph. 
    public void updateGraph()
    {
        String fileName = graphList.getSelectedItem().toString();
        fileName += ".txt";
        vertexList = readFile(fileName);

        window.updateGraphVertices(vertexList);
        window.updateGraphEdges(edges);
        window.repaint();
    }

    // Reads in the file and returns a vertex list with adjacent vertices.
    public Vertex[] readFile(String fileName) {
        // Variables to read in the file.
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String vertexDetails;

        vertexList = null;
        edges = null;
        String[] vertexVertices;
        int vertexToAdd;
        Edge edge;
        int currentVertex;
        int lastUpdated = 1;
        boolean coordinateFlag = false;

        String graphName;
        int numVertices = 0; 
        int numEdges = 0;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            graphName = bufferedReader.readLine();
            numVertices = Integer.parseInt(bufferedReader.readLine());
            vertexList = new Vertex[numVertices+1];
            edges = new ArrayList<Edge>();

            // Initializes each vertex in the graph.
            for (int i = 1; i < numVertices+1; i++) {
                vertexList[i] = new Vertex(i);
            }

            // Start processing the file.
            vertexDetails = bufferedReader.readLine();

            // While the line is not empty
            while (vertexDetails != null && !coordinateFlag) {
                if (vertexDetails.equals("coordinates")) {
                    coordinateFlag = true;
                } else {
                    vertexVertices = vertexDetails.split(" ");
                    currentVertex = Integer.parseInt(vertexVertices[0]) * (-1);

                    for (int j = 1; j < vertexVertices.length; j++) {
                        vertexToAdd = Integer.parseInt(vertexVertices[j]);
                        (vertexList[currentVertex]).addVertex(vertexToAdd);

                        edge = new Edge();
                        edge.setFirstEdgeVertex(vertexList[currentVertex]);
                        edge.setSecondEdgeVertex(vertexList[vertexToAdd]);
                        vertexList[currentVertex].addEdge(edge);
                        vertexList[vertexToAdd].addEdge(edge);

                        edges.add(edge);
                        numEdges++;
                    }
                }

                vertexDetails = bufferedReader.readLine();
            }

            // Give coordinates to vertices
            while (vertexDetails != null) {
                vertexVertices = vertexDetails.split(" ");

                vertexList[lastUpdated].setX(Double.parseDouble(vertexVertices[0]));
                vertexList[lastUpdated].setY(Double.parseDouble(vertexVertices[1])*(-1));
                vertexList[lastUpdated].setHasCoordinates();
                lastUpdated++;

                vertexDetails = bufferedReader.readLine();
            }

            window.updateDetails(graphName, numVertices, numEdges);

        } catch (FileNotFoundException ex) {
            System.out.println("File " + fileName + " not found.\n");
        } catch (IOException ex) {
            System.out.println("IOException occurred.");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (IOException e) {
                System.out.println("IOException occurred.");
            }
        }

        return vertexList;
    }
}
