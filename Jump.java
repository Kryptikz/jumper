public class Jump implements Runnable {
    private Screen s;
    public void run() {
        System.out.println("JUMP KEY PRESSED");
        s.jump();
        for (int i=0; i<100; i++) {
            s.setYY(s.getYY()-1);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        s.endJump();
    }
    public Jump(Screen screen) {
        s = screen;
    }
}