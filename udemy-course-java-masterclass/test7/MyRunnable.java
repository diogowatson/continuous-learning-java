package test7;

import static test7.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "My runnable implemantation of run()");

    }
}
