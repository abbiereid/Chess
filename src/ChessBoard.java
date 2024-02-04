import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {
    private static final int boardSize = 8;
    private static final int tileSize = 80;

    public ChessBoard() {
        setTitle("Chess Board");
        setSize(boardSize * tileSize, boardSize * tileSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pn = new JPanel(new GridLayout(boardSize, tileSize));
        initializeBoard(pn);

        add(pn);
        setVisible(true);
    }

    private void initializeBoard(JPanel chessboardPanel) {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                JPanel tile = new JPanel();
                tile.setPreferredSize(new Dimension(tileSize, tileSize));
                tile.setBackground((row + col) % 2 == 0 ? Color.gray : Color.darkGray);

                chessboardPanel.add(tile);
            }
        }
    }

    public static void main() {
        SwingUtilities.invokeLater(ChessBoard::new);
    }
}
