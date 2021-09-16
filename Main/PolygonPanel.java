package Main;

import javax.swing.*;
import java.awt.*;

public class PolygonPanel extends JPanel {
    private final Polygon polygon;

    public final int PANEL_WIDTH = 600;
    public final int PANEL_HEIGHT = 400;

    public PolygonPanel(Polygon polygon){
        this.polygon = polygon;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawPolygon(polygon);
        this.repaint();
        //g.drawRect(100, 100, 200, 200);
    }
}
