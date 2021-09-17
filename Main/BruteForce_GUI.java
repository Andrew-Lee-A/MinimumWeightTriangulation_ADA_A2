package Main;
// Brute force algorithm that solves the convex polygon triangulation problem for the minimum sum of interior edges
// Student: Andrew Lee 17983766
// Student: Jacob Tupe - 18018323


import Algorithm.Point;
import Algorithm.Solution;
import java.util.ArrayList;
import java.util.List;

// Student:
public class BruteForce_GUI {
    /**
     *
     * @param vertices
     * @param i
     * @param j
     * @return the minimum sum of if the interior edges given by the array of vertices
     */
    public Solution Triangulate(Point[] vertices, int i, int j) {
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
                System.out.println(weight + ": (j,k)" + j + "," + k + " : " + i);
                q1.add(vertices[j]);
                q2.add(vertices[k]);
                //drawArray.add(new ArrayList<>(Arrays.asList(vertices[j], vertices[k])));
                // if the k value is the last vertex, an edge is drawn between i and k
            } else if (k == j - 1) {
                weight = vertices[k].dist(vertices[i]);
                System.out.println(weight + ": (i,k)" + i + "," + k + " : " + j);
                //drawArray.add(new ArrayList<>(Arrays.asList(vertices[i], vertices[k])));
                q1.add(vertices[i]);
                q2.add(vertices[k]);
                // otherwise, a vertex is chosen that leads two to edges drawn. j to k and i to k.
            } else {
                weight = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
                System.out.println(weight + ": " + vertices[j].dist(vertices[k]) + ": " + j + "," + k + " + " + vertices[k].dist(vertices[i]) + ": " + i + "," + k);
                //drawArray.add(new ArrayList<>(Arrays.asList(vertices[j], vertices[k])));
                //drawArray.add(new ArrayList<>(Arrays.asList(vertices[i], vertices[k])));
                q1.add(vertices[i]);
                q2.add(vertices[k]);
                q1.add(vertices[j]);
                q2.add(vertices[k]);
            }

            Solution left = Triangulate(vertices, i, k);
            Solution right = Triangulate(vertices, k, j);

            double costOfBothSides = weight + left.cost + right.cost;
            if (s.cost > costOfBothSides){

                s.cost = costOfBothSides;
                left.p1.addAll(right.p1);
                q1.addAll(left.p1);
                s.p1 = q1;

                left.p2.addAll(right.p2);
                q2.addAll(left.p2);
                s.p2 = q2;
            }

//            s.cost = Double.min(s.cost, weight + Triangulate(vertices, i, k).cost
//                    + Triangulate(vertices, k, j).cost);

            System.out.println("Cost: " + s.cost);
        }
        return s;
    }
}
