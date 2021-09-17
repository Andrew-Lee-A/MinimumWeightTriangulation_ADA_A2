package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Student: Jacob Tupe - 18018323

class DynamicTest {

   
    public static Solution Triangulate(Point[] vertices) {
        
        int n = vertices.length;


        Solution[][] SolutionsTable = new Solution[n][n];


        for (int diagonal = 0; diagonal < n; diagonal++) {
            for (int i = 0, j = diagonal; j < n; i++, j++) {
                

                if (j <= i + 2) {
                    SolutionsTable[i][j]  = new Solution();
                    SolutionsTable[i][j].cost = 0;
                    continue;
                }

                SolutionsTable[i][j] = new Solution();

                
                for (int k = i + 1; k <= j - 1; k++) {
                    double weight;
                    List<Point> q1 = new ArrayList<>();
                    List<Point> q2 = new ArrayList<>();
                    
                    // The weight of triangulation is the length of its perimeter
                    if (k == i + 1) {
                        weight = vertices[j].dist(vertices[k]);
                        
                        q1.add(vertices[j]);
                        q2.add(vertices[k]);
                        
                        
                    } else if (k == j - 1) {
                        weight = vertices[k].dist(vertices[i]);
                        
                        q1.add(vertices[i]);
                        q2.add(vertices[k]);
                        
                    } else {
                        weight = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
                        
                        q1.add(vertices[i]);
                        q2.add(vertices[k]);
                        q1.add(vertices[j]);
                        q2.add(vertices[k]);
                    }

                    Solution left = SolutionsTable[i][k];
                    Solution right = SolutionsTable[k][j];
                    
                    double costOfBothSides = weight + left.cost + right.cost;
                    
                    //get the minimum
                    if (SolutionsTable[i][j].cost > costOfBothSides) {
                        SolutionsTable[i][j].cost = costOfBothSides;
                        
                        //recursively build the p1 array
                        left.p1.addAll(right.p1);
                        q1.addAll(left.p1);
                        SolutionsTable[i][j].p1 = q1;

                        //recursively build the p2 array
                        left.p2.addAll(right.p2);
                        q2.addAll(left.p2);
                        SolutionsTable[i][j].p2 = q2;

                    }
                }
            }
        }
        return SolutionsTable[0][n - 1];
    }

    public static void main(String[] args) {
        // vertices are given in clockwise order
        System.out.println("==DynamicExact==\n");
        Point[] vertices
                = {new Point(0, 0), new Point(2, 0),
                    new Point(2, 1), new Point(1, 2),
                    new Point(0, 1)};
        System.out.println("==Test vertices 1==");
        System.out.println(Triangulate(vertices));

        //Triangle
        Point[] vertices3 = {
            new Point(0, 0), new Point(1, 1), new Point(0, 1)
        };
        System.out.println("\n==Triangle==");
        System.out.println(Triangulate(vertices3));

        //Square
        Point[] vertices4 = {
            new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0)
        };

        System.out.println("\n==Square==");
        System.out.println(Triangulate(vertices4));

        //pentagon (Greedy fails on this shape)
        Point[] vertices5 = {
            new Point(0, 0), new Point(0, 2), new Point(5, 4), new Point(6, 1),
            new Point(5, -2)
        };

        System.out.println("\n==Pentagon==");
        System.out.println(Triangulate(vertices5));

        //Hexagon
        Point[] vertices6 = {
            new Point(0, 0), new Point(-2, 2), new Point(-1, 4),
            new Point(1, 5), new Point(3, 3), new Point(2, 1)
        };

        System.out.println("\n==Hexagon==");
        System.out.println(Triangulate(vertices));
    }
}
