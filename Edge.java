// import java.awt.Color;
// import java.awt.Graphics;
// 
// public class Edge
// {
//     private Vertex firstEdgeVertex;
//     private Vertex secondEdgeVertex;
//     private double length;
// 
//     // Draws the edge on the screen
//     public void Draw(Graphics g)
//     {      
//         g.setColor(Color.black);
//         g.drawLine((int)(firstEdgeVertex.getPosition().getX()), 
//                    (int)(firstEdgeVertex.getPosition().getY()),
//                    (int)(secondEdgeVertex.getPosition().getX()),
//                    (int)(secondEdgeVertex.getPosition().getY()));
//     }
//     
//     // Sets the edge length
//     public void setLength() {
//         length = firstEdgeVertex.getPosition().subtract(secondEdgeVertex.getPosition()).getLength();
//     }
// 
//     // Gets the "spring" of the edge
//     public Vector getForce(Vertex springVertex)
//     {
//         Vector force;
//         double temperature;
//         double cooling;
// 
//         if(firstEdgeVertex == springVertex) {
//             force = secondEdgeVertex.getPosition().subtract(firstEdgeVertex.getPosition());
//         }
//         else
//         {
//             force = firstEdgeVertex.getPosition().subtract(secondEdgeVertex.getPosition());
//         }
// 
//         temperature = force.getLength() - 10 * length;
//         cooling = Math.signum(temperature) * Math.log( Math.abs(temperature)) * 0.01;
//         force = force.getUnitVector().multiply(cooling);
//         
//         return force;
//     }
// 
//     // Sets the first vertex of the edge
//     public void setFirstEdgeVertex(Vertex firstEdgeVertex) {
//         this.firstEdgeVertex = firstEdgeVertex;
//     }
//     
//     // Sets the second vertex of the edge
//     public void setSecondEdgeVertex(Vertex secondEdgeVertex) {
//         this.secondEdgeVertex = secondEdgeVertex;
//         setLength();
//     }
// }
