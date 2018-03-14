import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Screen extends JComponent {
    private int xx = 0;
    private int yy = 0;
    public Screen() {
        super();
        setFocusable(false);
    }
    public void drawing() {
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(xx,yy,50,50);
        g.setColor(Color.GREEN);
        g.fillRect(0,450, 800, 350);
        System.out.println("X:" + xx + ", y:" + yy);
        drawing();
    }
    public void setX(int a) {
        xx= a;
    }
    public void setY(int a) {
        yy = a;
    }
    public int getX() {
        return xx;
    }
    public int getY() {
        return yy;
    }    
}