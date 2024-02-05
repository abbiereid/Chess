import java.util.HashMap;

public class WhiteQueen extends Queen {
    String imPath = "whiteQueen.png";
    int x = 0;
    int y = 0;

    @Override
    public String getImPath() {
        return imPath;
    }

    @Override
    public void setX(int X) {
        x = X;
    }

    @Override
    public void setY(int Y) {
        y = Y;
    }
}
