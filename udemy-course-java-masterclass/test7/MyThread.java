package test7;


import static test7.ThreadColor.ANSI_RED;

public class MyThread extends Thread{
    @Override
    public void run(){
        try{
            Thread.sleep(400);
        }catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(currentThread().getName());
        System.out.println(ANSI_RED +"Thread is running");
    }

}
