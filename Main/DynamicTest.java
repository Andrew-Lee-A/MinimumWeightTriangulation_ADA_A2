package Main;

import Algorithm.Point;
import Algorithm.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Dynamictest {

    // Function to calculate the weight of optimal triangulation of a convex polygon
    // represented by a given set of vertices
    public static Solution Triangulate(Point[] vertices) {
        // get the number of vertices in the polygon
        int n = vertices.length;

        // create a table for storing the solutions to subproblems
        // `SolutionsTable[i][j]` stores the weight of the minimum-weight triangulation
        // of the polygon below edge `ij`
        Solution[][] SolutionsTable = new Solution[n][n];

        // fill the table diagonally using the recurrence relation
        for (int diagonal = 0; diagonal < n; diagonal++) {
            for (int i = 0, j = diagonal; j < n; i++, j++) {
                // If the polygon has less than 3 vertices, triangulation is
                // not possible
                if (j <= i + 2) {
                    SolutionsTable[i][j]  = new Solution();
                    SolutionsTable[i][j].cost = 0;
                    continue;
                }

                SolutionsTable[i][j] = new Solution();

                // consider all possible triangles `ikj` within the polygon
                for (int k = i + 1; k <= j - 1; k++) {
                    double weight;
                    List<Point> q1 = new ArrayList<>();
                    List<Point> q2 = new ArrayList<>();
                    
                    // The weight of triangulation is the length of its perimeter
                    if (k == i + 1) {
                        weight = vertices[j].dist(vertices[k]);
                        //System.out.println(weight + ": (j,k)" + j + "," + k + " : " + i);
                        q1.add(vertices[j]);
                        q2.add(vertices[k]);
                        
                        // if the k value is the last vertex, an edge is drawn between i and k
                    } else if (k == j - 1) {
                        weight = vertices[k].dist(vertices[i]);
                        //System.out.println(weight + ": (i,k)" + i + "," + k + " : " + j);
                        q1.add(vertices[i]);
                        q2.add(vertices[k]);
                        // otherwise, a vertex is chosen that leads two to edges drawn. j to k and i to k.
                    } else {
                        weight = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
                        //System.out.println(weight + ": " + vertices[j].dist(vertices[k]) + ": " + j + "," + k + " + " + vertices[k].dist(vertices[i]) + ": " + i + "," + k);
                        q1.add(vertices[i]);
                        q2.add(vertices[k]);
                        q1.add(vertices[j]);
                        q2.add(vertices[k]);
                    }

                    Solution left = SolutionsTable[i][k];
                    Solution right = SolutionsTable[k][j];
                    
                    double costOfBothSides = weight + left.cost + right.cost;

                    if (SolutionsTable[i][j].cost > costOfBothSides) {
                        SolutionsTable[i][j].cost = costOfBothSides;

                        left.p1.addAll(right.p1);
                        q1.addAll(left.p1);
                        SolutionsTable[i][j].p1 = q1;

                        left.p2.addAll(right.p2);
                        q2.addAll(left.p2);
                        SolutionsTable[i][j].p2 = q2;

                    }

                    // choose vertex `k` that leads to the minimum total weight
                    //T[i][j].cost = Double.min(SolutionsTable[i][j].cost, weight + SolutionsTable[i][k].cost + SolutionsTable[k][j].cost);
                    
                }
            }
        }

        // the top-rightmost element in the table stores the result
        for (int i = 0; i < n - 1; i++) {
            System.out.println(Arrays.toString(SolutionsTable[i]));
        }
        return SolutionsTable[0][n - 1];
    }

    public static void main(String[] args) {
        // vertices are given in clockwise order
        Point[] vertices = {
            new Point(0, 0), new Point(2, 0), new Point(2, 1),
            new Point(1, 2), new Point(0, 1)
        };

        System.out.println("The weight of the optimal triangulation is "
                + Triangulate(vertices));
        
                Point[] vertices5 = {
            new Point(0, 0), new Point(0, 2), new Point(5, 4), new Point(6,1),
            new Point(5,-2)
        };
        
        System.out.println(Triangulate(vertices5));
    }
}
