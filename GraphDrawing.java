/**
 * B. Postnikoff
 * Grsph Drawing
 * 2016-03-31
 */

import java.io.*;
import java.util.*;

public class GraphDrawing
{
    static String graphName = "COMP4060 Project: ";
    static int numVertices = 0;
    static ArrayList<Vertex> longestList = null;
    static int longListLength = 0;
    static int numInList = 0;

    public static void main(String[] args)
    {       
        // Read in the file and build a vertex list.
        Vertex[] vertexList = readFile();

        // Debugging line that prints out all vertices.
        printVertices(vertexList);

        System.out.println("\nDone.");
    }

    // Debugging function that prints what is in a list.
    public static void printVertices(Vertex[] vertexList)
    {
        for (int i = 1; i < vertexList.length; i++)
        {
            System.out.println(vertexList[i]);
        }

        System.out.println("\n");
    }    

    // Reads in the file and returns a vertex list with adjacent vertices.
    public static Vertex[] readFile()
    {
        // Vsriables to read in the file.
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String line = null;
        String fileName;

        // Graph files
        String mid7 = "Mid7.txt";
        String mid9 = "Mid9.txt";
        String nonHam24 = "NonHam24.txt";
        String thomassen = "Thomassen.txt";
        fileName = thomassen;

        Vertex[] vertexList = null;
        String vertexDetails;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            graphName += bufferedReader.readLine();
            numVertices = Integer.parseInt(bufferedReader.readLine());
            vertexList = new Vertex[numVertices+1];

            // Initializes each vertex in the graph.
            // 0 is not touched because it does not line up with the
            //     vertex numbers. 
            // It is easier to ignore zero.
            for (int i = 1; i < numVertices+1; i++)
            {
                vertexList[i] = new Vertex(i);
            }

            // Start processing the file.
            vertexDetails = bufferedReader.readLine().trim();

            while (vertexDetails != null)
            {
                String[] vertexVertices = vertexDetails.split(" ");
                int currentVertex = Integer.parseInt(vertexVertices[0]) * (-1);

                for (int j = 1; j < vertexVertices.length; j++)
                {
                    int vertexToAdd = Integer.parseInt(vertexVertices[j].trim());
                    (vertexList[currentVertex]).addVertex(vertexToAdd);
                    vertexList[vertexToAdd].addVertex(currentVertex);
                }

                vertexDetails = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File " + fileName + " not found.");
        }
        catch (IOException ex)
        {
            System.out.println("IOException occurred.");
        }
        finally
        {
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
