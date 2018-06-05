package test7;

public class CountDownThread extends Thread {
    private Countdown threadCountDown;

    public CountDownThread(Countdown threadCountDown) {
        this.threadCountDown = threadCountDown;
    }

    public void run(){
        threadCountDown.doCountdown();
    }
}
