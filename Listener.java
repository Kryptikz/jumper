import javax.swing.*;
import java.awt.event.*;

public class Listener extends KeyAdapter { 
    Screen current;
    boolean leftpress;
    boolean rightpress;
    boolean spacepress;
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("GOT KEY PRESS:" + key);
        if (key == KeyEvent.VK_LEFT) {
            current.leftPress();
        }
        if (key == KeyEvent.VK_RIGHT) {
            current.rightPress();
        }
        if (key == KeyEvent.VK_SPACE) {
            current.spacePress();
        }
        if (key == KeyEvent.VK_UP) {
            current.upPress();
        }
        current.drawing();
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("GOT KEY RELEASE:" + key);
        if (key == KeyEvent.VK_LEFT) {
            current.leftRelease();
        }
        if (key == KeyEvent.VK_RIGHT) {
            current.rightRelease();
        }
        if (key == KeyEvent.VK_SPACE) {
            current.spaceRelease();
        }        
        if (key == KeyEvent.VK_UP) {
            current.upRelease();
        } 
    }
    public void setScreen(Screen s) {
        current = s;
    }
    public Listener(Screen s) {
        current = s;
        leftpress = false;
        rightpress = false;
        spacepress = false;
    }
}    