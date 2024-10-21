import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the frame

        // Set the layout to BorderLayout
        frame.setLayout(new BorderLayout());

        // Create labels for each region
        JLabel northLabel = new JLabel("NORTH", SwingConstants.CENTER);
        northLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel southLabel = new JLabel("SOUTH", SwingConstants.CENTER);
        southLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel eastLabel = new JLabel("EAST", SwingConstants.CENTER);
        eastLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel westLabel = new JLabel("WEST", SwingConstants.CENTER);
        westLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel centerLabel = new JLabel("CENTER", SwingConstants.CENTER);
        centerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add the labels to the frame in the respective positions
        frame.add(northLabel, BorderLayout.NORTH);
        frame.add(southLabel, BorderLayout.SOUTH);
        frame.add(eastLabel, BorderLayout.EAST);
        frame.add(westLabel, BorderLayout.WEST);
        frame.add(centerLabel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }
}
