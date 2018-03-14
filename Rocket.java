import javax.swing.*;
import java.awt.*;
public class Rocket {
    private int xx;
    private int yy;
    public Rocket(int xX, int yY) {
        xx = xX;
        yy = yY;
    }
    public int getXX() {
        return xx;
    }
    public int getYY() {
        return yy;
    }
    public void setYY(int yY) {
        yy = yY;
    }
}