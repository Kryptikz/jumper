import java.awt.Color;
public class bomb {
    private int x;
    private int y;
    private double temp;
    public bomb(int xx, int yy) {
        x = xx;
        y = yy;
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
    public void setTemp(double t) {
        temp = t;
    }
    public double getTemp() {
        return temp;
    }
}