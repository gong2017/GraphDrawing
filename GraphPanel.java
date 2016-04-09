/**
 * B. Postnikoff
 * Graph Panel
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
    private String[] graphStringList = {"Mid7", "Mid9", "TestFile", "Thomassen"}; 
    private JComboBox graphList;
    private Vertex[] vertexList;

    // Button Panel constructor
    public GraphPanel(Window window)
    {
        super(window);
        this.graphList = new JComboBox(graphStringList);
        graphList.addActionListener(this);
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
    
    public void updateGraph()
    {
        String fileName = graphList.getSelectedItem().toString();
        fileName += ".txt";
        vertexList = readFile(fileName);
        
        window.updateGraphVertices(vertexList);
        window.repaint();        
    }
    
    // Reads in the file and returns a vertex list with adjacent vertices.
    public static Vertex[] readFile(String fileName) {
        // Variables to read in the file.
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String line = null;
        Vertex[] vertexList = null;
        String vertexDetails;
        int numVertices;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            // Throwaway graph name read line
            bufferedReader.readLine();
            numVertices = Integer.parseInt(bufferedReader.readLine());
            vertexList = new Vertex[numVertices+1];

            // Initializes each vertex in the graph.
            // 0 is not touched because it does not line up with the
            //     vertex numbers. 
            // It is easier to ignore zero.
            for (int i = 1; i < numVertices+1; i++) {
                vertexList[i] = new Vertex(i);
            }

            // Start processing the file.
            vertexDetails = bufferedReader.readLine().trim();

            // While the line is not empty
            while (vertexDetails != null) {
                String[] vertexVertices = vertexDetails.split(" ");
                int currentVertex = Integer.parseInt(vertexVertices[0]) * (-1);

                for (int j = 1; j < vertexVertices.length; j++) {
                    int vertexToAdd = Integer.parseInt(vertexVertices[j].trim());
                    (vertexList[currentVertex]).addVertex(vertexToAdd);
                }

                vertexDetails = bufferedReader.readLine();
            }
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
    
    // Debugging function that prints what is in the list of vertices.
    public static void printVertices(Vertex[] vertexList) {
        for (int i = 1; i < vertexList.length; i++) {
            System.out.println(vertexList[i]);
        }

        System.out.println("\n");
    }      
}
