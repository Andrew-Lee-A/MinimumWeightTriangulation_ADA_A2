package Main;

import Algorithm.BFA;
import Algorithm.DrawingPanel;
import Algorithm.PolygonShapes;

import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JPanel {
    // JPanel Components
    private final JComboBox<String> polygonComboBox;
    private final JButton bruteForceBtn, exactBtn, greedyBtn, stopBtn;
    private final JLabel sumOfLengths;
    // Command Panel
    private final JPanel controlPanel;

    private Polygon selectedPolygon;

    // Variables
    public final int PANEL_WIDTH = 900;
    public final int PANEL_HEIGHT = 700;

    JPanel drawPanel = new JPanel();
    {
        drawPanel.setPreferredSize(new Dimension(PANEL_WIDTH-100, PANEL_HEIGHT-100));
        drawPanel.setBackground(Color.white);
    }

    public GUIPanel() {
        super();
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(new BorderLayout());

        // Initialise Combo box
        String[] polygonOptions = {"Select a Polygon", "3 sides - Triangle", "4 sides - Square",
                "6 sides - Hexagon", "7 sides - Heptagon", "8 sides - Octagon", "11 sides - Hendecagon",
                "17 sides - Heptagon", "20 sides - Icosagon", "36 sides - Hextriacontagon"};
        polygonComboBox = new JComboBox<>(polygonOptions);
        polygonComboBox.addActionListener(e -> polygonSelection());

        // Initialise Label
        sumOfLengths = new JLabel();

        // Initialise Buttons
        bruteForceBtn = new JButton("Brute Force Algorithm");
        bruteForceBtn.addActionListener(e -> bruteForceApproach());
        exactBtn = new JButton("Dynamic Exact Algorithm");
        exactBtn.addActionListener(e -> exactApproach());
        greedyBtn = new JButton("Greedy Algorithm");
        greedyBtn.addActionListener(e -> greedyApproach());
        stopBtn = new JButton("Stop");
        stopBtn.setEnabled(false);

        // Layout Commands Panel with Flow Layout
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        // Combo Box
        controlPanel.add(polygonComboBox);
        // Label
        controlPanel.add(sumOfLengths);
        // Buttons
        controlPanel.add(stopBtn);
        controlPanel.add(bruteForceBtn);
        controlPanel.add(exactBtn);
        controlPanel.add(greedyBtn);

        // Add Control & DrawPanel to Main Panel
        add(controlPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
    }

    // Draws the selected polygon
    public void polygonSelection() {
        int index = polygonComboBox.getSelectedIndex();

        switch (index) {
            // Triangle
            case 1:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createTriangle()));
                break;
            // Square
            case 2:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createSquare()));
                break;
            case 3:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createHexagon()));
                break;
            case 4:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createSeptagon()));
                break;
            case 5:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createOctagon()));
                break;
            case 6:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createHendacagon()));
                break;
            // Anything Else
            default:
                JOptionPane.showMessageDialog(this, "Polygon Not Selected");
                break;
        }

        updateText(0);
    }

    // Redraws the draw panel
    public void setPanel(JPanel drawPanel){
        this.remove(this.drawPanel);
        this.drawPanel = drawPanel;
        this.add(drawPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void exactApproach(){
        JOptionPane.showMessageDialog(this, "Exact Approach\nNot implemented yet.");
    }

    public void bruteForceApproach(){
        Algorithm.Point[] vertices = PolygonShapes.getPointArray(selectedPolygon);

        double cost = new BFA().Triangulate(vertices, 0, vertices.length-1);
        updateText(cost);
    }

    public void greedyApproach(){
        JOptionPane.showMessageDialog(this, "Greedy Approach\nNot implemented yet.");
    }

    public void updateText(double cost){
        sumOfLengths.setText(String.format("Sum of lengths: %,.2f", cost));
    }
}
