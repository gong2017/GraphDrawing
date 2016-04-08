/**
 * B. Postnikoff
 * Graph Drawing
 * 2016-03-31
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class GraphWindow extends JFrame{
    static String graphName = "COMP4060 Project: ";
    static int numVertices = 0;

    public static void main(String[] args) {        
        userInterface();
        System.out.println("\nDone.");
    }

    // Draws a graph requested by a user. 
    public static void userInterface() {        
        Scanner scanner = new Scanner(System.in);
        int fileChoice;
        String fileName = null;
        Vertex[] vertexList;        
        
        // Create window, add graph to it
        GraphWindow graphWindow = new GraphWindow();
        setUpWindow(graphWindow);        
        DrawPolygon graph = new DrawPolygon();
        graphWindow.add(graph);
        
        // Read input from user. 
        do {
            System.out.println("File options: "
                + "\n1: Mid7"
                + "\n2: Mid9"
                + "\n3: TestFile"
                + "\n4: Thomassen"
                + "\n5: Quit Program.");
            System.out.print("Choose an option: ");
            fileChoice = scanner.nextInt();
            System.out.print("\n");

            switch (fileChoice) {
                case(1):
                fileName = "Mid7.txt";
                break;

                case(2):
                fileName = "Mid9.txt";
                break;

                case(3):
                fileName = "TestFile.txt";
                break;

                case(4):
                fileName = "Thomassen.txt";
                break;

                case(5):
                System.out.println("Ending program.");
                break;

                default:
                System.out.println("Not a valid choice");
            }   

            // Reads a graph file, if option was chosen
            if (fileChoice >= 1 && fileChoice <= 4) {
                vertexList = readFile(fileName);

                if (vertexList != null) {                    
                    graph.updateVertices(vertexList);
                    graphWindow.repaint();
                }
            }
        } while (fileChoice != 5);
    }

    // Debugging function that prints what is in a list.
    public static void printVertices(Vertex[] vertexList) {
        for (int i = 1; i < vertexList.length; i++) {
            System.out.println(vertexList[i]);
        }

        System.out.println("\n");
    }    

    // Reads in the file and returns a vertex list with adjacent vertices.
    public static Vertex[] readFile(String fileName) {
        // Vsriables to read in the file.
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String line = null;
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

    // Sets up the window for display
    public static void setUpWindow(GraphWindow window)
    {
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1000,1000);
        window.setResizable(false);
        window.setTitle("Graph Drawing Project");
        window.setVisible(true);
    }
}