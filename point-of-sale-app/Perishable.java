/**
 * Created by diogowatson on 23/06/17.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Perishable extends Item {
    Date Pdate;//create date objet Pdate(perishable date)

    //constructor
    Perishable(){}

    Perishable(int sku, String name, double price, Boolean tax) {
        setSku(sku);
        setName(name);
        setPrice(price);
        setTax(tax);
        setQuantity(0);

    }

    ///methods

    ///method to input Date
    public void InputDate(){///method to get the input date

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        System.out.print("Please insert the date (format yyyy.MM.dd) : ");
        Scanner InputDate= new Scanner(System.in);
        String dateInString = InputDate.next();

        try {

            Date date = formatter.parse(dateInString);
            this.Pdate=date;



        } catch (ParseException e) {

            System.out.println("!!Warning!! Date in the wrong format!! Try Again!!");
            InputDate();

        }

    }

    ///method to input item data
    public void InputItem(){
        super.toString();
        InputDate();
    }

    public String toString(boolean linear){
        String r=null;
        if(linear==true) {
           r= String.format("|P |" + super.printItem(linear)+(new SimpleDateFormat("MMM-dd-yyyy").format(this.Pdate)));//using super to call the method of the master class
        }else{
           r=String.format(super.printItem(linear)+"valid till: "+new SimpleDateFormat("MMM-dd-yyyy").format(this.Pdate));


        }
        return r;
    }
}
