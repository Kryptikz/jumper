import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Screen extends JComponent {
    private int xx = 0;
    private int yy = 0;
    boolean jumping;
    boolean falling;
    private int ground;
    boolean spacepress;
    boolean rightpress;
    boolean leftpress;
    boolean uppress;
    JFrame frame;
    ArrayList<Rocket> rockets = new ArrayList<Rocket>();
    public Screen(JFrame f) {
        super();    
        setFocusable(false);
        ground = 400;
        frame = f;
    }
    public void drawing() {
        if (yy<ground && jumping == false) {
            yy++;
            falling = true;
        } else {
            falling = false;
        }
        if (rightpress == true && xx < 750) {
            xx++;
        }
        if (leftpress == true && xx > 0) {
            xx--;
        }
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,0,800,450);
        g.setColor(Color.RED);
        g.fillRect(xx,yy,50,50);
        g.setColor(Color.GREEN);
        g.fillRect(0,450, 800, 350);
        g.setColor(Color.GRAY);
        g.fillRect(0,500,800,300);
        g.setColor(Color.BLACK);
        for (int i=0; i<rockets.size(); i++) {
            Rocket r = rockets.get(i);
            g.fillRect(r.getXX(), r.getYY(), 10, 40);
            r.setYY(r.getYY()-1);
            if (r.getYY() < 0) {
                rockets.remove(i);
            }
        }
        drawing();
    }
    public void setXX(int a) {
        xx= a;
    }
    public void setYY(int a) {
        yy = a;
    }
    public int getXX() {
        return xx;
    }
    public int getYY() {
        return yy;
    }    
    public void jump() {
        jumping = true;
    }
    public void endJump() {
        jumping = false;
    }
    public boolean isJump() {
        return jumping;
    }
    public boolean isFalling() {
        return falling;
    }
    public void spacePress() {
        spacepress = true;
        if (spacepress) {
            if (jumping == false && falling == false) {
                System.out.println("JUMPING");
                (new Thread(new Jump(this))).start();
            }
        }            
    }
    public void leftPress() {
        leftpress = true;
    }
    public void rightPress() {
        rightpress = true;
    }
    public void upPress() {
        rockets.add(new Rocket(xx+20, yy));
        uppress = true;
    }
    public void spaceRelease() {
        spacepress = false;
    }
    public void leftRelease() {
        leftpress = false;
    }
    public void rightRelease() {
        rightpress = false;
    }
    public void upRelease() {
        uppress = false;
    }
}