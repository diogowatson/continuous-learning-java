package Workshop2;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        System.out.println("***JAVA workshop 2 Starting****");
        Scanner in = null;
        int answer = 0;
        System.out.print("Choose witch version you want to run\n"
                             +"\n"
                             +"1.Run task 1\n"
                             +"2.Run task 2\n"
                             +  ">");
        in = new Scanner(System.in);
        answer = in.nextInt();
        switch(answer) {
            case 1:
                try {
                    SaveAccount saveAccount = new SaveAccount("/home/diogowatson/dev/workshop2/Save.ses");
                    saveAccount.menu();
                    saveAccount.save();
                } catch (IOException ex) {
                    System.out.println("fail");
                    ex.printStackTrace();
                }
                ReadAccount read = new ReadAccount("/home/diogowatson/dev/workshop2/Save.ses");
                try {
                    read.readFile();
                    read.print();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            case 2:
                Gui test = new Gui();
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
