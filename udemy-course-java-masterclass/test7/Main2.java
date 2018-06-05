package test7;

public class Main2 {
    public static void main(String[] argv){
        Countdown countdown = new Countdown();

        CountDownThread t1 = new CountDownThread(countdown);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
