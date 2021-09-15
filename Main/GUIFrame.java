package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;

public class GUIFrame {
    public static void main(String[] args) {
        // Panel
        GUIPanel panel = new GUIPanel();

        // Create frame to hold JPanel subclass
        JFrame frame = new JFrame("Tessellation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add instance of panel to the frame
        frame.getContentPane().add(panel);
        // resize frame to fit JPanel
        frame.pack();

        // Position frame on center of screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth/2)-(frame.getWidth()/2),
                (screenHeight/2) - (frame.getHeight()/2)));

        // Show the frame
        frame.setVisible(true);
    }
}
