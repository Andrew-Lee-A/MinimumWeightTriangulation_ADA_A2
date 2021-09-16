package Algorithm;


import java.awt.*;

public class PolygonShapes {

    public static Polygon createTriangle() {
        return new Polygon(PolygonsSides.P_3_SIDES[0],
                PolygonsSides.P_3_SIDES[1],
                PolygonsSides.P_3_SIDES[0].length);
    }

    public static Polygon createSquare() {
        return new Polygon(PolygonsSides.P_4_SIDES[0],
                PolygonsSides.P_4_SIDES[1],
                PolygonsSides.P_4_SIDES[0].length);
    }

    public static Polygon createHexagon() {
        return new Polygon(PolygonsSides.P_6_SIDES[0],
                PolygonsSides.P_6_SIDES[1],
                PolygonsSides.P_6_SIDES[0].length);
    }

    public static Polygon createSeptagon() {
        return new Polygon(PolygonsSides.P_7_SIDES[0],
                PolygonsSides.P_7_SIDES[1],
                PolygonsSides.P_7_SIDES[0].length);
    }

    public static Polygon createOctagon() {
        return new Polygon(PolygonsSides.P_8_SIDES[0],
                PolygonsSides.P_8_SIDES[1],
                PolygonsSides.P_8_SIDES[0].length);
    }

    public static Polygon createHendacagon() {
        return new Polygon(PolygonsSides.P_11_SIDES[0],
                PolygonsSides.P_11_SIDES[1],
                PolygonsSides.P_11_SIDES[0].length);
    }
    
    public static Point[] getPointArray(Polygon polygon){
        Point[] vertices = new Point[polygon.npoints];
        
        for (int i = 0; i < polygon.npoints;i++){
            vertices[i] = new Point(polygon.xpoints[i], polygon.ypoints[i]);
        }
        
        return vertices;
    }
}
