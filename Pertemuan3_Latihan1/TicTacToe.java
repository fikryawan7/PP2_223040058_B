import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[] buttons;
    private boolean gameOver;
    private boolean xTurn;

    public TicTacToe() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameOver = false;
        xTurn = true; // Mulai dengan giliran 'X'

        buttons = new JButton[9];
        this.setLayout(new GridLayout(3, 3));

        // Membuat dan menambahkan tombol ke frame
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }

        this.setSize(300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText(xTurn ? "X" : "O");
                checkWinner();
                xTurn = !xTurn; // Ganti giliran
            }
        } else {
            int response = JOptionPane.showConfirmDialog(null, "Game Selesai. Mulai Ulang?", "Mulai ", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                resetGame();
            }
        }
    }

    private void checkWinner() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText();
        }

        String winner = "";
        // Cek baris dan kolom
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                winner = board[i][0];
                highlightWinningCombo(i * 3, i * 3 + 1, i * 3 + 2);
            }
            if (!board[0][i].isEmpty() && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                winner = board[0][i];
                highlightWinningCombo(i, i + 3, i + 6);
            }
        }
        // Cek diagonal
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            winner = board[0][0];
            highlightWinningCombo(0, 4, 8);
        }
        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            winner = board[0][2];
            highlightWinningCombo(2, 4, 6);
        }

        if (!winner.isEmpty()) {
            gameOver = true;
            JOptionPane.showMessageDialog(null, "Pemain " + winner + " Menang!");
        } else if (isBoardFull()) {
            gameOver = true;
            JOptionPane.showMessageDialog(null, "Hasil Seri!");
        }
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void highlightWinningCombo(int index1, int index2, int index3) {
        buttons[index1].setForeground(Color.RED);
        buttons[index2].setForeground(Color.RED);
        buttons[index3].setForeground(Color.RED);
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
            button.setForeground(Color.BLACK);
        }
        gameOver = false;
        xTurn = true; // Reset ke giliran 'X' lagi
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TicTacToe game = new TicTacToe();
                game.setVisible(true);
            }
        });
    }
}
