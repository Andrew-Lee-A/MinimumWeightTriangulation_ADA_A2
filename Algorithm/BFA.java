package Algorithm;

public class BFA {
    public double Triangulate(Point[] vertices, int i, int j){
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
}
