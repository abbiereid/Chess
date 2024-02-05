import java.util.HashMap;

public class WhiteKnight extends Knight {
    String imPath = "whiteKnight.png";
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
