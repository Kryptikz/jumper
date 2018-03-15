import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Create extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GAME");
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setFocusable(false);
        Screen screen = new Screen(frame);
        frame.add(screen);
        screen.drawing();
        Listener l = new Listener(screen);
        frame.addKeyListener(l);
        frame.setVisible(true);
        screen.setVisible(true);
    }
}