package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;

// Student: Jacob Tupe - 18018323

public class GUIFrame extends JFrame{
    // Panel
    GUIPanel panel = new GUIPanel();

    public GUIFrame(){
        setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.SOUTH);
        setTitle("Tessellation");

        // Resize frame to fit JPanel
        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create frame to hold JPanel subclass
        GUIFrame frame = new GUIFrame();

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
