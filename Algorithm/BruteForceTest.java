package Algorithm;
// Brute force algorithm that solves the convex polygon triangulation problem for the minimum sum of interior edges
// Student: Andrew Lee 17983766
// Student: Jacob Tupe - 18018323

import java.util.ArrayList;
import java.util.List;


public class BruteForceTest {

    /**
     *
     * @param vertices
     * @param i
     * @param j
     * @return the minimum sum of if the interior edges given by the array of
     * vertices
     */
    public static Solution Triangulate(Point[] vertices, int i, int j) {
        Solution s = new Solution();

        //cannot triangulate a polygon with less than 3 edges
        if (j <= i + 2) {
            s.cost = 0;
            return s;
        }

        // cost represents the final length of the triangulation from the polygon 
        //double cost = Double.MAX_VALUE;
        // triangulate all possible vertices with the initial two edges being i and j
        for (int k = i + 1; k <= j - 1; k++) {

            // The weight of a triangulation is the length perimeter of the triangle
            double weight;
            List<Point> q1 = new ArrayList<>();
            List<Point> q2 = new ArrayList<>();

            // if the k value is the initial vertex, an edge is drawn between j and k
            if (k == i + 1) {
                weight = vertices[j].dist(vertices[k]);
                q1.add(vertices[j]);
                q2.add(vertices[k]);
                //drawArray.add(new ArrayList<>(Arrays.asList(vertices[j], vertices[k])));
                // if the k value is the last vertex, an edge is drawn between i and k
            } else if (k == j - 1) {
                weight = vertices[k].dist(vertices[i]);
                q1.add(vertices[i]);
                q2.add(vertices[k]);
                // otherwise, a vertex is chosen that leads two to edges drawn. j to k and i to k.
            } else {
                weight = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
                q1.add(vertices[i]);
                q2.add(vertices[k]);
                q1.add(vertices[j]);
                q2.add(vertices[k]);
            }

            Solution left = Triangulate(vertices, i, k);
            Solution right = Triangulate(vertices, k, j);

            double costOfBothSides = weight + left.cost + right.cost;
            if (s.cost > costOfBothSides) {

                s.cost = costOfBothSides;
                left.p1.addAll(right.p1);
                q1.addAll(left.p1);
                s.p1 = q1;

                left.p2.addAll(right.p2);
                q2.addAll(left.p2);
                s.p2 = q2;
            }

        }
        return s;
    }

    //Main method for testing
    // vertices are given in clockwise order
    public static void main(String[] args) {
        System.out.println("==BruteForce==\n");
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
