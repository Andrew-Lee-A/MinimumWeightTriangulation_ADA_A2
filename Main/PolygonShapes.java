package Main;

// Student: Andrew Lee 17983766
// Student: Jacob Tupe - 18018323

import Algorithm.Point;
import Main.PolygonsSides;
import java.awt.*;

public class PolygonShapes {

    public static Point[] getPointArray(Polygon polygon){
        Point[] vertices = new Point[polygon.npoints];

        for (int i = 0; i < polygon.npoints;i++){
            vertices[i] = new Point(polygon.xpoints[i], polygon.ypoints[i]);
        }

        return vertices;
    }

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

    public static Polygon createPentagon(){
        return new Polygon(PolygonsSides.P_5_SIDES[0],
                PolygonsSides.P_5_SIDES[1],
                PolygonsSides.P_5_SIDES[0].length);
    }

    public static Polygon createHexagon() {
        return new Polygon(PolygonsSides.P_6_SIDES[0],
                PolygonsSides.P_6_SIDES[1],
                PolygonsSides.P_6_SIDES[0].length);
    }

    public static Polygon createHeptagon() {
        return new Polygon(PolygonsSides.P_7_SIDES[0],
                PolygonsSides.P_7_SIDES[1],
                PolygonsSides.P_7_SIDES[0].length);
    }

    public static Polygon createOctagon() {
        return new Polygon(PolygonsSides.P_8_SIDES[0],
                PolygonsSides.P_8_SIDES[1],
                PolygonsSides.P_8_SIDES[0].length);
    }

    public static Polygon createNonagon() {
        return new Polygon(PolygonsSides.P_9_SIDES[0],
                PolygonsSides.P_9_SIDES[1],
                PolygonsSides.P_9_SIDES[0].length);
    }

    public static Polygon createDecagon() {
        return new Polygon(PolygonsSides.P_10_SIDES[0],
                PolygonsSides.P_10_SIDES[1],
                PolygonsSides.P_10_SIDES[0].length);
    }

    public static Polygon createHendecagon() {
        return new Polygon(PolygonsSides.P_11_SIDES[0],
                PolygonsSides.P_11_SIDES[1],
                PolygonsSides.P_11_SIDES[0].length);
    }

    public static Polygon createDodecagon() {
        return new Polygon(PolygonsSides.P_12_SIDES[0],
                PolygonsSides.P_12_SIDES[1],
                PolygonsSides.P_12_SIDES[0].length);
    }

    public static Polygon createOctadecagon() {
        return new Polygon(PolygonsSides.P_18_SIDES[0],
                PolygonsSides.P_18_SIDES[1],
                PolygonsSides.P_18_SIDES[0].length);
    }

    public static Polygon createIcosagon() {
        return new Polygon(PolygonsSides.P_20_SIDES[0],
                PolygonsSides.P_20_SIDES[1],
                PolygonsSides.P_20_SIDES[0].length);
    }

    public static Polygon createIcositrigon() {
        return new Polygon(PolygonsSides.P_23_SIDES[0],
                PolygonsSides.P_23_SIDES[1],
                PolygonsSides.P_23_SIDES[0].length);
    }

    public static Polygon createTritriacontagon() {
        return new Polygon(PolygonsSides.P_33_SIDES[0],
                PolygonsSides.P_33_SIDES[1],
                PolygonsSides.P_33_SIDES[0].length);
    }
}
