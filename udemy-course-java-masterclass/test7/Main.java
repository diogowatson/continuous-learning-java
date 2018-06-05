package test7;

import static test7.ThreadColor.ANSI_GREEN;
import static test7.ThreadColor.ANSI_RED;

public class Main {
    public  static void main (String argv[]){
      MyThread t1 = new MyThread();
      t1.setName(ANSI_GREEN+"t1 thread");
      t1.start();
//        MyThread t3 = new MyThread();
////        Multi m1 = new Multi();new
//
//        Thread t2 =new Thread(m1);
//       try {
//           t1.join();
//       }catch (Exception e){
//           System.out.println(e);
//       }
//        t2.start();
//        t3.start();

        ///syscronization
        System.out.println("syncronization");
        Table obj = new Table();
        MyThread1 t4 = new MyThread1(obj);
        MyThread2 t5 = new MyThread2(obj);
        t4.start();
        t5.start();

        Thread MyRunnableThread = new Thread(new MyRunnable());
        MyRunnableThread.setName(ANSI_GREEN +"== Another Thead ==");
        MyRunnableThread.start();

        Thread MyRunnable2 = new Thread(new MyRunnable() {
            @Override
            public void run(){
                try {
                    t4.join();
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "interrupted!!");
                }
                System.out.println(ANSI_RED + "Anonymous implementation of runnable");
            }
        });
        MyRunnable2.start();




    }
}
