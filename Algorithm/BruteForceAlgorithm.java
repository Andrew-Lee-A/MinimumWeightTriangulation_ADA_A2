package Algorithm;
// Brute force algorithm that solves the convex polygon triangulation problem for the minimum sum of interior edges
// Student: Andrew Lee 17983766
// Student: 
public class BruteForceAlgorithm {
    
    /**
     * 
     * @param vertices
     * @param i
     * @param j
     * @return the minimum sum of if the interior edges given by the array of vertices
     */
    public static double Triangulate(Point[] vertices, int i, int j) {

        //cannot triangulate a polygon with less than 3 edges
        if (j <= i + 2) {
            return 0;
        }
        
        // cost represents the final length of the triangulation from the polygon 
        double cost = Double.MAX_VALUE;

        // triangulate all possible vertices with the initial two edges being i and j
        for (int k = i + 1; k <= j - 1; k++) {

            // The weight of a triangulation is the length perimeter of the triangle
            double weight;

            // if the k value is the initial vertex, an edge is drawn between j and k
            if (k == i + 1) {
                weight = vertices[j].dist(vertices[k]);
                System.out.println(weight + ": (j,k)" + j + "," + k + " : " + i);

            // if the k value is the last vertex, an edge is drawn between i and k
            } else if (k == j - 1) {
                weight = vertices[k].dist(vertices[i]);
                System.out.println(weight + ": (i,k)" + i + "," + k + " : " + j);
            
            // otherwise, a vertex is chosen that leads two to edges drawn. j to k and i to k.
            } else {
                weight = vertices[j].dist(vertices[k]) + vertices[k].dist(vertices[i]);
                System.out.println(weight + ": " + vertices[j].dist(vertices[k]) + ": " + j + "," + k + " + " + vertices[k].dist(vertices[i]) + ": " + i + "," + k);
            }

            //take the minimum cost
            cost = Double.min(cost,
                    weight + Triangulate(vertices, i, k)
                    + Triangulate(vertices, k, j));
            System.out.println("Cost: " + cost);
        }
        return cost;
    }

    //Main method for testing
    // vertices are given in clockwise order
    public static void main(String[] args) {

        Point[] vertices
                = {new Point(0, 0), new Point(2, 0),
                    new Point(2, 1), new Point(1, 2),
                    new Point(0, 1)};

        System.out.println(Triangulate(vertices,
                0, vertices.length - 1));

        System.out.println("/n/n");

        //Triangle
        Point[] vertices3 = {
            new Point(0, 0), new Point(1, 1), new Point(0, 1)
        };

        //Square
        Point[] vertices4 = {
            new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0)
        };

        //pentagon (Greedy fails on this shape)
        Point[] vertices5 = {
            new Point(0, 0), new Point(0, 2), new Point(5, 4), new Point(6,1),
            new Point(5,-2)
        };
        
        System.out.println(Triangulate(vertices5, 0, vertices5.length - 1));
        
        //Hexagon
        Point[] vertices6 = {
            new Point(0, 0), new Point(-2, 2), new Point(-1, 4),
            new Point(1, 5), new Point(3, 3), new Point(2, 1)
        };

        //System.out.println(Triangulate(vertices3, 0, vertices3.length - 1));
    }

}
