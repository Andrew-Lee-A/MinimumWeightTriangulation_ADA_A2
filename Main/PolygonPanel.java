package Main;

import Algorithm.PolygonsSides;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

public class PolygonPanel extends JPanel {
    private final Rectangle rectangle = new Rectangle(2, 2);

    public final int PANEL_WIDTH = 600;
    public final int PANEL_HEIGHT = 400;

    public PolygonPanel(){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(100, 100, 200, 200);
    }
}
