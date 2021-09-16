package Algorithm;

import java.awt.*;

public class PolygonShapes {

    public static Polygon createTriangle() {
        return new Polygon(PolygonsSides.POLYGON_3_SIDES[0],
                PolygonsSides.POLYGON_3_SIDES[1],
                PolygonsSides.POLYGON_3_SIDES[0].length);
    }

    public static Polygon createSquare() {
        return new Polygon(PolygonsSides.POLYGON_4_SIDES[0],
                PolygonsSides.POLYGON_4_SIDES[1],
                PolygonsSides.POLYGON_4_SIDES[0].length);
    }
}
