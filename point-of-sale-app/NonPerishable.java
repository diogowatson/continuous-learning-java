import java.util.Scanner;

/**
 * Created by diogowatson on 09/06/17.
 */
public class NonPerishable extends Item {
    NonPerishable(){}
    NonPerishable(int sku,String name, double price, Boolean tax) {//have to specify variables to called agai
        super(sku, name,price, tax);//by using super I call the constructor of the master class
    }
    public void  PrintItem(boolean linear){

           super.printItem(linear);//using super to call the method of the master class
           System.out.println("testing class");

        Scanner DayInput= new Scanner(System.in);
        System.out.print("");
        }//end of print item


    }//end of class

