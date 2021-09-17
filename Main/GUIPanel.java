package Main;

import Algorithm.Solution;

import javax.swing.*;
import java.awt.*;

// Student: Andrew Lee 17983766
// Student: Jacob Tupe - 18018323

public class GUIPanel extends JPanel {
    // JPanel Components
    private final JComboBox<String> polygonComboBox;
    private final JButton bruteForceBtn, exactBtn, greedyBtn;
    private final JLabel sumOfLengths;
    // Command Panel
    private final JPanel controlPanel;

    // Solution
    private Solution solution;

    // Shapes
    private Polygon selectedPolygon;
    private Algorithm.Point[] vertices;

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

        // Initialise variables
        solution = new Solution();

        // Initialise Combo box
        String[] polygonOptions = {"Select a Polygon",
                "3 sides - Triangle",
                "4 sides - Square",
                "5 sides - Pentagon",
                "6 sides - Hexagon",
                "7 sides - Heptagon",
                "8 sides - Octagon",
                "9 sides - Nonagon",
                "10 sides - Decagon",
                "11 sides - Hendecagon",
                "12 sides - Dodecagon",
                "18 sides - Octadecagon",
                "20 sides - Icosagon",
                "23 sides - Icositrigon",
                "33 sides - Tritriacontagon"};
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

        // Layout Commands Panel with Flow Layout
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        // Combo Box
        controlPanel.add(polygonComboBox);
        // Label
        controlPanel.add(sumOfLengths);
        // Buttons
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
                // Pentagon
            case 3:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createPentagon()));
                break;
                // Hexagon
            case 4:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createHexagon()));
                break;
                // Septagon
            case 5:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createHeptagon()));
                break;
                // Octagon
            case 6:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createOctagon()));
                break;
                // Nonagon
            case 7:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createNonagon()));
                break;
                // Decagon
            case 8:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createDecagon()));
                break;
                // Hendecagon
            case 9:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createHendecagon()));
                break;
                // Dodecagon
            case 10:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createDodecagon()));
                break;
                // Octadecagon
            case 11:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createOctadecagon()));
                break;
                // Icosagon
            case 12:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createIcosagon()));
                break;
                // Icositrigon
            case 13:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createIcositrigon()));
                break;
                // Tritriacontagon
            case 14:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createTritriacontagon()));
                break;
            // Anything Else
            default:
                setPanel(new DrawingPanel(selectedPolygon = PolygonShapes.createTriangle()));
                break;
        }

        vertices = PolygonShapes.getPointArray(selectedPolygon);
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

    public void initialisePolygon(Solution s){
        DrawingPanel dp = new DrawingPanel(selectedPolygon);
        updateText(s.cost);
        dp.setSolution(s);
        setPanel(dp);
    }

    public void exactApproach(){
        solution = new Dynamic_GUI().Triangulate(vertices);
        initialisePolygon(solution);
    }

    public void bruteForceApproach(){
        solution = new BruteForce_GUI().Triangulate(vertices, 0, vertices.length-1);
        initialisePolygon(solution);
    }

    public void greedyApproach(){
        solution = new Greedy_GUI().Triangulate(vertices, 0, vertices.length-1);
        initialisePolygon(solution);
    }

    public void updateText(double cost){
        sumOfLengths.setText(String.format("Sum of lengths: %,.2f", cost));
    }
}
