import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Membuat panel dengan tata letak kisi-kisi 3x3
        JPanel panel = new JPanel(new GridLayout(3, 3));

        // Menambahkan tombol dengan nomor 1 hingga 9 ke kisi-kisi
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            // Tambahkan ActionListener ke setiap tombol
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Menampilkan pop-up dengan jumlah tombol yang diklik
                    JOptionPane.showMessageDialog(frame, "Angka: " + button.getText());
                }
            });
            panel.add(button);
        }

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
