public class RocketTimer {
    private int seconds;
    public RocketTimer(int time) {
        seconds = time;
    }
    public void time() {
        while(seconds != 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            seconds--;
        }
    }
}