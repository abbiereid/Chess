import java.util.HashMap;

public class BlackBishop extends Bishop {
    String imPath = "blackBishop.png";

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
