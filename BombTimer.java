public class BombTimer implements Runnable {
    UFO u;
    public BombTimer(UFO o) {
        u = o;
    }
    public void run() {
        int time = 1;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (time == 0) {
                u.dropBomb();
                time = 1;
            } else {
                time--;
            }
        }
    }    
}