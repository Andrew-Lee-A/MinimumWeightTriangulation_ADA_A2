package Algorithm;

import Main.PolygonShapes;
import static Algorithm.BruteForceTest.Triangulate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Brute force algorithm that solves the convex polygon triangulation problem for the minimum sum of interior edges
// Student: Andrew Lee 17983766
// Student: Jacob Tupe - 18018323

class Greedytest {
    
    /**
     * 
     * @param vertices
     * @param i
     * @param j
     * @return the minimum sum of if the interior edges given by the array of vertices
     */
    public static Solution Triangulate(Point[] vertices, int i, int j) {
        
        Solution s = new Solution();
        
        //cannot triangulate a polygon with less than 3 edges
        if (j <= i + 2) {
            s.cost = 0;
            return s;
        }
        
        // list of the lengths of all edges drawn except for the case where two edges are drawn in which the minimum is stored. 
        ArrayList<Double> minList = new ArrayList<>();

        
        double cost; // cost represents the final length of the triangulation from the polygon
        int shortest; // shortest will the k that leads to the shortest edge drawn between vertices i,k and j,k
        double weight; // The weight of a triangulation is the sum of the length of its interior edges relative to the polygon
        
        //distance is a tmp variable used for debugging purposes. PLEASE REMOVE THIS BEFORE SUBMISION
        double distance = 0;
        
        for (int k = i + 1; k <= j - 1; k++) {
            
            // if the k value is the intial vertex, an edge is drawn between j and k
            if (k == i + 1) {
                minList.add(vertices[j].dist(vertices[k]));
                distance = vertices[j].dist(vertices[k]);
                
            // if the k value is the last vertex, an edge is drawn between i and k  
            } else if (k == j - 1) {
                minList.add(vertices[k].dist(vertices[i]));
                distance = vertices[k].dist(vertices[i]);
                
            // otherwise, a vertex is chosen that leads two to edges drawn. j to k and i to k.
            } else {
                minList.add(Double.min(vertices[j].dist(vertices[k]), vertices[k].dist(vertices[i])));
                distance = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
            }

        }
        
        // shortest is the index of the shortest edge in the minList + i + 1 ( i + 1: because shortest represents k and k starts at i + 1)
        shortest = minList.indexOf(Collections.min(minList)) + 1 + i;
        
        List<Point> q1 = new ArrayList<>();
        List<Point> q2 = new ArrayList<>();
            
        // if the k value is the intial vertex, the weight is the edge drawn between j and k
        if (shortest == i + 1) {
            weight = vertices[j].dist(vertices[shortest]);
            q1.add(vertices[j]);
            q2.add(vertices[shortest]);
            
        // if the k value is the last vertex, the weight is the edge drawn between i and k
        } else if (shortest == j - 1) {
            weight = vertices[shortest].dist(vertices[i]);
            q1.add(vertices[i]);
            q2.add(vertices[shortest]);
            
        // otherwise, the k is chosen that leads two to edges drawn. The weight is the sum of the edges j to k and i to k.
        } else {
            weight = vertices[j].dist(vertices[shortest]) + vertices[shortest].dist(vertices[i]);
            q1.add(vertices[i]);
            q2.add(vertices[shortest]);
            q1.add(vertices[j]);
            q2.add(vertices[shortest]);
        }
        
        
        
        Solution left = Triangulate(vertices, i, shortest);
        Solution right = Triangulate(vertices, shortest, j);
        
        s.cost = weight + left.cost + right.cost;
                
        left.p1.addAll(right.p1);
        q1.addAll(left.p1);
        s.p1 = q1;
        
        left.p2.addAll(right.p2);
        q2.addAll(left.p2);
        s.p2 = q2;
        return s;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println("Greedy Divide and Conq\n");
        Point[] vertices
                = {new Point(0, 0), new Point(2, 0),
                    new Point(2, 1), new Point(1, 2),
                    new Point(0, 1)};
        System.out.println("==Test vertices 1==");
        System.out.println(Triangulate(vertices,
                0, vertices.length - 1));

        //Triangle
        Point[] vertices3 = {
            new Point(0, 0), new Point(1, 1), new Point(0, 1)
        };
        System.out.println("\n==Triangle==");
        System.out.println(Triangulate(vertices3,
                0, vertices3.length - 1));

        //Square
        Point[] vertices4 = {
            new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0)
        };

        System.out.println("\n==Square==");
        System.out.println(Triangulate(vertices4,
                0, vertices4.length - 1));

        //pentagon (Greedy fails on this shape)
        Point[] vertices5 = {
            new Point(0, 0), new Point(0, 2), new Point(5, 4), new Point(6, 1),
            new Point(5, -2)
        };

        System.out.println("\n==Pentagon==");
        System.out.println(Triangulate(vertices5, 0, vertices5.length - 1));

        //Hexagon
        Point[] vertices6 = {
            new Point(0, 0), new Point(-2, 2), new Point(-1, 4),
            new Point(1, 5), new Point(3, 3), new Point(2, 1)
        };

        System.out.println("\n==Hexagon==");
        System.out.println(Triangulate(vertices6, 0, vertices6.length - 1));
    }
    

}
