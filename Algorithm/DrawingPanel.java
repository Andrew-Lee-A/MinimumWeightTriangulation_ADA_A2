package Algorithm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final Polygon polygon;
    private Solution solution = new Solution();

    public final int PANEL_WIDTH = 600;
    public final int PANEL_HEIGHT = 400;

    public DrawingPanel(Polygon polygon){
        this.polygon = polygon;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawPolygon(polygon);

        g.setColor(Color.black);

        if (!solution.p1.isEmpty()){
            List<Point> p1 = solution.p1;
            List<Point> p2 = solution.p2;

            for (int i = 0; i < p1.size(); i++) {
                //g.drawLine(p1.get(i).getX(), p2.get(i).getX(), p1.get(i).getY(), p2.get(i).getY());
                g.drawLine(p1.get(i).getX(), p1.get(i).getY(), p2.get(i).getX(), p2.get(i).getY());
            }
        }

        this.repaint();
    }
}
