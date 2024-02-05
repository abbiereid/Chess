import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class ChessBoard extends JFrame {
    private static final int boardSize = 8;
    private static final int tileSize = 80;
    private static int index = 0;

    static final ArrayList<Piece> pieces = new ArrayList<>();

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
        setPieces();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                JPanel tile = new JPanel();
                tile.setPreferredSize(new Dimension(tileSize, tileSize));
                tile.setBackground((row + col) % 2 == 0 ? Color.gray : Color.darkGray);
                chessboardPanel.add(tile);

                Piece p = pieces.get(index);
                if (p != null) {
                    ImageIcon icon = createImageIcon(p.getImPath());
                    if (icon != null) {
                        JLabel label = new JLabel(icon);
                        tile.add(label);
                    }
                    p.setX(tile.getLocation().x);
                    p.setY(tile.getLocation().y);
                }

                index++;

            }
        }
    }

    private ImageIcon createImageIcon(String path) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imgUrl);
            Image originalImage = originalIcon.getImage();

            int newWidth = originalImage.getWidth(null) / 2;
            int newHeight = originalImage.getHeight(null) / 2;

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    public static void setPieces() {
        pieces.add(new BlackRook());
        pieces.add(new BlackKnight());
        pieces.add(new BlackBishop());
        pieces.add(new BlackQueen());
        pieces.add(new BlackKing());
        pieces.add(new BlackBishop());
        pieces.add(new BlackKnight());
        pieces.add(new BlackRook());
        for(int i = 0; i < 8;i++) {
            pieces.add(new BlackPawn());
        }
        for (int x = 0; x < 32; x++) {
            pieces.add(null);
        }
        for(int i = 0; i < 8;i++) {
            pieces.add(new WhitePawn());
        }
        pieces.add(new WhiteRook());
        pieces.add(new WhiteKnight());
        pieces.add(new WhiteBishop());
        pieces.add(new WhiteQueen());
        pieces.add(new WhiteKing());
        pieces.add(new WhiteBishop());
        pieces.add(new WhiteKnight());
        pieces.add(new WhiteRook());
    }

    public static void main() {
        SwingUtilities.invokeLater(ChessBoard::new);
    }
}
