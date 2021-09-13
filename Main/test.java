/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


/**
 *
 * @author Andrew_PC
 */
// Class to store a point in the Euclidean plane
class Point
{
  int x, y;
  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
 
  // Utility function to return the distance between two
  // vertices in a 2-dimensional plane
  public double dist(Point p)
  {
 
    // The distance between vertices `(x1, y1)` & `(x2,
    // y2)` is `√((x2 − x1) ^ 2 + (y2 − y1) ^ 2)`
    return Math.sqrt((this.x - p.x) * (this.x - p.x)
                     + (this.y - p.y) * (this.y - p.y));
  }
  
  @Override
  public String toString(){
    String s  = "("+this.x+", "+this.y+")";  
    return s;
  }
}
 
class GFG
{
 
  // Function to calculate the weight of optimal
  // triangulation of a convex polygon represented by a
  // given set of vertices `vertices[i..j]`
  public static double MWT(Point[] vertices, int i, int j)
  {
      System.out.println(" "+ i + ", "+ j + vertices[i] + vertices[j]);
    // If the polygon has less than 3 vertices,
    // triangulation is not possible
    if (j <  i + 2)
    {
      return 0;
    }
 
    // keep track of the total weight of the minimum
    // weight triangulation of `MWT(i,j)`
    double cost = Double.MAX_VALUE;
 
    // consider all possible triangles `ikj` within the
    // polygon
    for (int k = i + 2; k <= j - 1; k++)
    {
        System.out.println("Enters," + i + ", "+ k + ", " + j);
      // The weight of a triangulation is the length
      // of perimeter of the triangle
      double weight = vertices[i].dist(vertices[k]);
        System.out.println(weight + " "+ i + ", "+ k + vertices[i] + vertices[k]);
 
      // choose the vertex `k` that leads to the
      // minimum total weight
      cost = Double.min(cost,
                        weight + MWT(vertices, i, k)
                        + MWT(vertices, k, j));
        System.out.println(cost);
    }
    return cost;
  }
  
  public static double greedy(Point[] vertices){
    if (vertices.length < 3)
    {
      return 0;
    }
    double cost = Double.MAX_VALUE;
    
    int j = 0;
    int k = 0;
    for (int i = 0; i < vertices.length; i++){
        j = i+1;
        k =j+1;
        for (int count = 1; count < vertices.length-2; count++){
            k = (k+1)%vertices.length;
        }
    }
    return cost;
  }
 
  public static double calculateAngle(double a, double b, double c){
       return Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
  }
  
  // Driver code
  public static void main(String[] args)
  {
 
    // vertices are given in clockwise order
    Point[] vertices
      = { new Point(0, 0), new Point(2, 0),
         new Point(2, 1), new Point(1, 2),
         new Point(0, 1) };
 
    System.out.println(MWT(vertices,
                           0, vertices.length - 1));
    
      System.out.println(GFG.calculateAngle(10, 10, 10));
      if (Math.round(GFG.calculateAngle(10, 10, 10)) == 60.0){
          System.out.println("true");
      }
      else{
          System.out.println("false");
      }
      
//      System.out.println(Math.sqrt((0-1) * (0-1)
//                     + (0-2) * (0-2)));
  }
}
 
// This code is contributed by Priiyadarshini Kumari