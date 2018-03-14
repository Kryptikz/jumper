import java.awt.Color;
public class bomb {
    private int x;
    private int y;
    private Color c;
    public bomb(int xx, int yy, Color color) {
        x = xx;
        y = yy;
        c = color;
    }
    public void setX(int xx) {
        x = xx;
    }
    public void setY(int yy) {
        y = yy;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}