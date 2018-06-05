package test7;

import static test7.ThreadColor.ANSI_BLUE;

public class Table {
    synchronized  void printTable(int n){
        //method synchronizes
        for (int i = 1; i < 5; i++){
            System.out.println(ANSI_BLUE + n*i );
            try{
                Thread.sleep(400);
            }catch (Exception e) {
                System.out.println();
            }
        }
    }
}
