import javax.swing.*;
import java.awt.event.*;

public class Listener extends KeyAdapter { 
    Screen current;
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("GOT KEY PRESS:" + key);
        if (key == KeyEvent.VK_LEFT) {
            current.setX(current.getX()-2);
            System.out.println("MOVING TO THE LEFT");
        }
        if (key == KeyEvent.VK_RIGHT) {
            current.setX(current.getX()+2);
            System.out.println("MOVING TO THE RIGHT");
        }
        if (key == KeyEvent.VK_UP) {
            current.setY(current.getY()-2);
            System.out.println("MOVING UP");
        }
        if (key == KeyEvent.VK_DOWN) {
            current.setY(current.getY()+2);
            System.out.println("MOVING DOWN");
        }
    }
    public void setScreen(Screen s) {
        current = s;
    }
    public Listener(Screen s) {
        current = s;
    }
}    