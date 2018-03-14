import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Math.*;
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
    ArrayList<UFO> enemies = new ArrayList<UFO>();
    private int score;
    public Screen(JFrame f) {
        super();    
        setFocusable(false);
        ground = 400;
        frame = f;
        (new Thread(new SpawnUFO(this))).start();
        score = 0;
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
            for (int s=0; s<enemies.size(); s++) {
                UFO o = enemies.get(s);
                Rectangle r1 = new Rectangle(r.getXX(), r.getYY(), 10, 40);
                Rectangle r2 = new Rectangle(o.getX(), o.getY(), 30, 30);
                if (r1.intersects(r2)) {
                    enemies.remove(s);
                    rockets.remove(i);
                    score++;
                }
            }
            if (r.getYY() < 0) {
                rockets.remove(i);
            }
        }
        for (int i=0; i<enemies.size(); i++) {
            UFO u = enemies.get(i);
            g.setColor(u.getColor());
            g.fillRect(u.getX(), u.getY(), 30, 30);  
            if (u.getTemp() == 1) {
                if (u.getDirection() == 1) {
                    u.setX(u.getX()-1);
                } else {
                    u.setX(u.getX()+1);
                }   
                u.setTemp(0);
            } else {   
                    u.setTemp(u.getTemp()+.25);
            }            
            if (u.getX() >= 770 && u.getDirection() == 0) {
                u.setDirection(1);
            }
            if (u.getX() <= 0 && u.getDirection() == 1) {
                u.setDirection(0);
            }
        }
        g.setFont(new Font("NORMAL", Font.BOLD, 40));
        g.setColor(Color.BLACK);
        g.drawString("" + score, 10, 38);
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
        rockets.add(new Rocket(xx+20, yy));        
    }
    public void leftPress() {
        leftpress = true;
    }
    public void rightPress() {
        rightpress = true;
    }
    public void upPress() {
        uppress = true;        
        if (uppress) {
            if (jumping == false && falling == false) {
                System.out.println("JUMPING");
                (new Thread(new Jump(this))).start();
            }
        } 
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
    public void addUFO() {
        int yY = 20+(int)(Math.random()*150);
        enemies.add(new UFO(0, yY));
    }
    public int getScore() {
        return score;
    }
}