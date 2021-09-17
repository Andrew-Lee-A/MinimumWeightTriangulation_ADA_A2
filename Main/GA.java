package Main;

import Algorithm.Point;
import Algorithm.Solution;
import java.util.ArrayList;
import java.util.Collections;

// Brute force algorithm that solves the convex polygon triangulation problem for the minimum sum of interior edges
// Student: Andrew Lee 17983766
// Student:

public class GA {

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
                System.out.println(distance + ": (j,k)" + j + "," + k + " : " + i);

                // if the k value is the last vertex, an edge is drawn between i and k
            } else if (k == j - 1) {
                minList.add(vertices[k].dist(vertices[i]));
                distance = vertices[k].dist(vertices[i]);
                System.out.println(distance + ": (i,k)" + i + "," + k + " : " + j);

                // otherwise, a vertex is chosen that leads two to edges drawn. j to k and i to k.
            } else {
                minList.add(Double.min(vertices[j].dist(vertices[k]), vertices[k].dist(vertices[i])));
                distance = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
                System.out.println(distance + ": " + vertices[j].dist(vertices[k]) + ": " + j + "," + k + " + " + vertices[k].dist(vertices[i]) + ": " + i + "," + k + " Min: " + Double.min(vertices[j].dist(vertices[k]), vertices[k].dist(vertices[i])));
            }

        }

        // shortest is the index of the shortest edge in the minList + i + 1 ( i + 1: because shortest represents k and k starts at i + 1)
        shortest = minList.indexOf(Collections.min(minList)) + 1 + i;

        // if the k value is the intial vertex, the weight is the edge drawn between j and k
        if (shortest == i + 1) {
            weight = vertices[j].dist(vertices[shortest]);
            s.p1.add(vertices[j]);
            s.p2.add(vertices[shortest]);

            // if the k value is the last vertex, the weight is the edge drawn between i and k
        } else if (shortest == j - 1) {
            weight = vertices[shortest].dist(vertices[i]);
            s.p1.add(vertices[i]);
            s.p2.add(vertices[shortest]);

            // otherwise, the k is chosen that leads two to edges drawn. The weight is the sum of the edges j to k and i to k.
        } else {
            weight = vertices[j].dist(vertices[shortest]) + vertices[shortest].dist(vertices[i]);
            s.p1.add(vertices[i]);
            s.p2.add(vertices[shortest]);
            s.p1.add(vertices[j]);
            s.p2.add(vertices[shortest]);
        }

        System.out.println("\nShortest: " + shortest + " Weight:" + weight);
        s.cost = weight + Triangulate(vertices, i, shortest).cost + Triangulate(vertices, shortest, j).cost;
        System.out.println("Cost: " + s.cost);
        return s;
    }
}
