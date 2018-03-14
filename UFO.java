import java.awt.Color;
import java.lang.Math.*;
public class UFO {
    private int x;
    private int y;
    private double temp;
    private Color c;
    private int direction; //0 is l-r, 1 is r-l
    public UFO(int xx, int yy) {
        int random = (int)(Math.random()*5);
        if (random == 0) {
            c = Color.GREEN;
        } 
        if (random == 1) {
            c = Color.MAGENTA;
        }
        if (random == 2) {
            c = Color.YELLOW;
        }
        if (random == 3) {
            c = Color.CYAN;
        }
        if (random == 4) {
            c = Color.ORANGE;
        }
        x = xx;
        y = yy;
        direction = (int)(Math.random()*2);
        System.out.println("DIRECTION: " + direction);
        if (direction == 1) {
            x = 800;
        }
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
    public Color getColor() {
        return c;
    }
    public void setTemp(double d) {
        temp = d;
    }
    public double getTemp() {
        return temp;
    }
    public int getDirection() {
        return direction;
    }
}