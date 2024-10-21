import javax.swing.*;

public class NasabahBank extends JFrame {

    public NasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label dan TextField untuk Nama
        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15, 10, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 30, 350, 30);

        // Label dan TextField untuk Nomor HP
        JLabel labelInput2 = new JLabel("Nomor HP: ");
        labelInput2.setBounds(15, 80, 350, 10);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 100, 350, 30);

        // Label dan RadioButton untuk Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 150, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 165, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 185, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Checkbox untuk Warga Negara Asing
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 220, 350, 30);

        // Label dan JList untuk Jenis Tabungan
        JLabel labelTabungan = new JLabel("Jenis Tabungan");
        labelTabungan.setBounds(15, 260, 350, 10);

        String[] tabungan = { "Junior", "Silver GPN", "Gold GPN", "Platinum GPN" };
        JList<String> tipeTabungan = new JList<>(tabungan);
        tipeTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tipeTabungan.setBounds(15, 280, 350, 70);

        // Slider untuk Frekuensi Transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi");
        labelFrekuensi.setBounds(15, 360, 350, 30);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        slider.setBounds(15, 390, 350, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel valueFrekuensi = new JLabel("Frekuensi: 1 transaksi");
        valueFrekuensi.setBounds(15, 440, 350, 30);
        slider.addChangeListener(e -> valueFrekuensi.setText("Frekuensi: " + slider.getValue() + " transaksi"));

        // Password dan Confirm Password
        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(15, 470, 350, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 500, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password");
        labelConfirmPassword.setBounds(15, 530, 350, 30);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 560, 350, 30);

        // Tanggal Lahir menggunakan JSpinner
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir");
        labelTanggalLahir.setBounds(15, 600, 350, 30);

        JLabel labelTanggal = new JLabel("Tanggal:");
        labelTanggal.setBounds(15, 620, 50, 30);

        JSpinner spinnerTanggal = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        spinnerTanggal.setBounds(150, 620, 200, 30);

        JLabel labelBulan = new JLabel("Bulan:");
        labelBulan.setBounds(15, 660, 50, 30);

        JSpinner spinnerBulan = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        spinnerBulan.setBounds(150, 660, 200, 30);

        JLabel labelTahun = new JLabel("Tahun:");
        labelTahun.setBounds(15, 700, 50, 30);

        JSpinner spinnerTahun = new JSpinner(new SpinnerNumberModel(1900, 1900, 2100, 1));
        spinnerTahun.setBounds(150, 700, 200, 30);

        // Button Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 740, 100, 30);

        // TextArea untuk output
        JTextArea textarea = new JTextArea();
        textarea.setBounds(15, 810, 350, 160);

        // ActionListener untuk tombol Simpan
        buttonSimpan.addActionListener(e -> {
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (password.equals(confirmPassword)) {
                String jenisKelamin = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
                String WNA = checkBox.isSelected() ? "Ya" : "Tidak";

                String nama = textField.getText();
                String nohp = textField2.getText();
                String jenisTabungan = tipeTabungan.getSelectedValue();
                int frekuensi = slider.getValue();
                int tanggal = (int) spinnerTanggal.getValue();
                int bulan = (int) spinnerBulan.getValue();
                int tahun = (int) spinnerTahun.getValue();

                textarea.setText("Nama: " + nama + "\n" +
                                 "Nomor HP: " + nohp + "\n" +
                                 "Jenis Kelamin: " + jenisKelamin + "\n" +
                                 "WNA: " + WNA + "\n" +
                                 "Jenis Tabungan: " + jenisTabungan + "\n" +
                                 "Frekuensi: " + frekuensi + " transaksi\n" +
                                 "Tanggal Lahir: " + tanggal + "/" + bulan + "/" + tahun);
            } else {
                JOptionPane.showMessageDialog(null, "Password tidak sesuai!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Tambahkan semua komponen ke JFrame
        this.add(labelInput);
        this.add(textField);
        this.add(labelInput2);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelTabungan);
        this.add(tipeTabungan);
        this.add(labelFrekuensi);
        this.add(slider);
        this.add(valueFrekuensi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(labelTanggal);
        this.add(spinnerTanggal);
        this.add(labelBulan);
        this.add(spinnerBulan);
        this.add(labelTahun);
        this.add(spinnerTahun);
        this.add(buttonSimpan);
        this.add(textarea);

        // Set layout dan tampilan form
        this.setSize(400, 1050);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new NasabahBank());
    }
}
