import javax.swing.JFrame;
import java.lang.Math.*;
public class SpawnUFO implements Runnable{
    private int time;
    private int score;
    Screen frame;
    public SpawnUFO(Screen s) {
        frame = s;
    }
    public void run() {
        while(true) {
            try {
                score = frame.getScore();
                double time = (1000)*(3.365*Math.pow(.9384, score));
                System.out.println(time);
                Thread.sleep((long)time);
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame.addUFO();
        }
    }
}