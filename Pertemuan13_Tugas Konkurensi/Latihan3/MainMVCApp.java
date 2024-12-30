import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// Model: Menyimpan data
class DataModel {
    private final List<String> data = new ArrayList<>();

    public void generateData(int count) {
        data.clear();
        for (int i = 1; i <= count; i++) {
            data.add("Data ke-" + i);
        }
    }

    public List<String> getData() {
        return new ArrayList<>(data); // Return copy to prevent external modification
    }
}

// View: Menampilkan GUI
class DataView {
    private final JFrame frame;
    private final JButton loadButton;
    private final JProgressBar progressBar;
    private final JTextArea textArea;
    private final JLabel statusLabel;

    public DataView() {
        frame = new JFrame("Aplikasi MVC dengan Konkurensi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        loadButton = new JButton("Muat Data");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        textArea = new JTextArea();
        textArea.setEditable(false);
        statusLabel = new JLabel("Tekan tombol untuk memuat data.", JLabel.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(statusLabel, BorderLayout.NORTH);
        topPanel.add(progressBar, BorderLayout.SOUTH);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(loadButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }
}

// Controller: Mengelola logika dan interaksi
class DataController {
    private final DataModel model;
    private final DataView view;

    public DataController(DataModel model, DataView view) {
        this.model = model;
        this.view = view;

        view.getLoadButton().addActionListener(e -> loadData());
    }

    private void loadData() {
        // Nonaktifkan tombol saat proses berjalan
        view.getLoadButton().setEnabled(false);
        view.getStatusLabel().setText("Proses memuat data...");
        view.getProgressBar().setValue(0);
        view.getTextArea().setText("");

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                model.generateData(100); // Generate 100 data
                List<String> data = model.getData();

                for (int i = 0; i < data.size(); i++) {
                    Thread.sleep(50); // Simulasi delay
                    publish((i + 1) * 100 / data.size()); // Publikasikan progres
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int progress = chunks.get(chunks.size() - 1); // Ambil progres terbaru
                view.getProgressBar().setValue(progress);
            }

            @Override
            protected void done() {
                try {
                    model.getData().forEach(data -> view.getTextArea().append(data + "\n"));
                    view.getStatusLabel().setText("Proses selesai!");
                } catch (Exception e) {
                    view.getStatusLabel().setText("Terjadi kesalahan!");
                } finally {
                    view.getLoadButton().setEnabled(true);
                }
            }
        };

        worker.execute();
    }
}

// Main: Menggabungkan MVC
public class MainMVCApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataModel model = new DataModel();
            DataView view = new DataView();
            new DataController(model, view);
        });
    }
}
