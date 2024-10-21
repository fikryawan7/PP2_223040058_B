import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class HelloGridBagLayout extends JFrame {

    private Timer resetTimer; // Timer untuk mereset label otomatis

    public HelloGridBagLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Tekan Button Di Bawah Ini!", JLabel.CENTER);
        JLabel resultLabel = new JLabel("", JLabel.CENTER); // Label untuk menampilkan hasil saat tombol ditekan

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Membuat tombol Button 1
        JButton button1 = new JButton("Button 1");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(button1, gbc);

        // Membuat tombol Button 2
        JButton button2 = new JButton("Button 2");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(button2, gbc);

        // Membuat tombol Button 3
        JButton button3 = new JButton("Button 3");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(button3, gbc);

        // Membuat tombol Button 4
        JButton button4 = new JButton("Button 4");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button4, gbc);

        // Membuat tombol Button 5
        JButton button5 = new JButton("Button 5");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(button5, gbc);

        // Menambahkan listener untuk setiap tombol
        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();
                resultLabel.setText(sourceButton.getText() + " ditekan");
                
                // Reset label setelah 2 detik
                if (resetTimer != null && resetTimer.isRunning()) {
                    resetTimer.stop(); // Hentikan timer jika sudah berjalan
                }
                resetTimer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        resultLabel.setText(""); // Reset resultLabel setelah 2 detik
                    }
                });
                resetTimer.setRepeats(false); // Timer hanya berjalan sekali
                resetTimer.start();
            }
        };

        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);
        button4.addActionListener(buttonListener);
        button5.addActionListener(buttonListener);

        controlPanel.add(panel);

        this.setLayout(new GridLayout(3, 1)); // Mengatur layout untuk menambahkan label hasil
        this.add(headerLabel);
        this.add(controlPanel);
        this.add(resultLabel); // Menambahkan label hasil untuk menampilkan output
        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridBagLayout h = new HelloGridBagLayout();
                h.setVisible(true);
            }
        });
    }
}
