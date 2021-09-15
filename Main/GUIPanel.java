package Main;

import Algorithm.PolygonsSides;

import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JPanel {
    // JPanel Components
    private final JComboBox<String> polygonComboBox;
    private final JButton bruteForceBtn, exactBtn, greedyBtn, stopBtn;
    private final FlowLayout layout;
    private final JLabel sumOfLengths;

    // Variables
    public final int PANEL_WIDTH = 700;
    public final int PANEL_HEIGHT = 500;

    public GUIPanel() {
        super();
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        layout = new FlowLayout();
        setLayout(layout);

        // Combo box
        String[] polygonOptions = {"Select a Polygon", "3 sides - Triangle", "4 sides - Square",
                "6 sides - Hexagon", "7 sides - Heptagon", "8 sides - Octagon", "11 sides - Hendecagon",
                "17 sides - Heptagon", "20 sides - Icosagon", "36 sides - Hextriacontagon"};
        polygonComboBox = new JComboBox<>(polygonOptions);

        // Label
        sumOfLengths = new JLabel("Sum of Lengths: ");

        // Buttons
        bruteForceBtn = new JButton("Brute Force Algorithm");
        bruteForceBtn.addActionListener(e -> bruteForceApproach());
        exactBtn = new JButton("Dynamic Exact Algorithm");
        exactBtn.addActionListener(e -> exactApproach());
        greedyBtn = new JButton("Greedy Algorithm");
        greedyBtn.addActionListener(e -> greedyApproach());
        stopBtn = new JButton("Stop");
        stopBtn.setEnabled(false);

        PolygonPanel pp = new PolygonPanel();
        add(pp);

        // Combo Box
        add(polygonComboBox);

        // Label
        add(sumOfLengths);

        // Buttons
        add(stopBtn);
        add(bruteForceBtn);
        add(exactBtn);
        add(greedyBtn);
    }

    public void exactApproach(){
        JOptionPane.showMessageDialog(this, "Exact Approach");
    }

    public void bruteForceApproach(){
        JOptionPane.showMessageDialog(this, "Brute Force Approach");
    }

    public void greedyApproach(){
        JOptionPane.showMessageDialog(this, "Greedy Approach");
    }
}
