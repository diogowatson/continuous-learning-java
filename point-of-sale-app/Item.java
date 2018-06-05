import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by diogowatson on 08/06/17.
 * Class tested and functional at June 9, 2017
 */
public class Item implements Serializable{
    //private variables
    private int m_sku;
    private String m_name;
    private double m_price;
    private Boolean m_taxed;
    private int m_quantity;

    //contructors
    Item() {
    }

    ;


    public Item(int sku, String name, double price, Boolean tax) {

        setSku(sku);
        setName(name);
        setPrice(price);
        setTax(tax);
        setQuantity(0);
    }//end of constructor

    //copy constructor

   public Item copyConstructor(Item I){
        return new Item(I.getSku(),I.getName(), I.getPrice(), I.isTaxed());
   }
    ///Geters

    public int getSku() {
        return m_sku;

    }

    public String getName() {
        return m_name;
    }

    public double getPrice() {
        return m_price;
    }

    public Boolean isTaxed() {
        return m_taxed;
    }

    public double getTax(){ return getPrice()*0.9;}

    public int getQuantity() {
        return m_quantity;
    }

    ///seters
    public void setSku(int sku) {
        m_sku = sku;
    }

    public void setName(String name) {
        m_name = name;
    }

    public void setPrice(double price) {
        m_price = price;
    }

    public void setTax(Boolean tax) {
        m_taxed = tax;
    }

    public void setQuantity(int qty) {
        m_quantity += qty;
    }

    public void reduceOneQty(){
        m_quantity=m_quantity-1;
    }

    ///method to print the information, in linae and no linear form
    public String printItem(Boolean linear) {
        String r=null;
        if (linear) {//if linear true, prints in linear mode
          r="| SKU: " + getSku()
                    + "|Name: " + getName()
                    + "| Price: ";
          if(isTaxed()){
             r+= getPrice()+"| Taxed:Yes";

            }else{
              r+=getPrice()+"| Taxed: No|";
          }
         r+="| Quantity: " + getQuantity() + "|";


        }
        if(!linear){
            r=String.format("Sku: " + getSku()+"%n"
                    + "Name: " + getName()+"%n"
                    + "Price: "+ getPrice()+"%n");
            if(isTaxed()) {
                r += "Taxed:Yes";
            }else{
                r+=String.format("Taxed: No"+"%n");
            }

            r+=String.format("Quantity: " + getQuantity() + "%n");
        }

        return r;
        }//end of toString override
public String printPOS(){

       String r;
       r=String.format("*********************"+"%n"
                      +"Product Name: "+getName()+"%n"
                      +"Product Price: "+getPrice()+"%n");
               if(this.isTaxed()){
           r+=String.format("Is taxed!"+"%n"
                   +"Price after Tax:"+getTax()+"%n"
                          );
               }else{
                   r+=String.format("Not taxed"+"%n"
                           +"price: "+getPrice()+"%n"
                           +"*********************"
                   );
               }
               return r;


}

    public void getTaxInput(){
        Scanner InputTax = new Scanner(System.in);
        System.out.print("Is the product taxed? (yes or no): ");
        String NewTax = InputTax.next();
        boolean tax=false;
        if (NewTax.equals("y")||NewTax.equals("n")||NewTax.equals("Y")||NewTax.equals("yes")||NewTax.equals("Yes")||NewTax.equals("N")||NewTax.equals("No")){
            if(NewTax.equals("y")||NewTax.equals("Y")||NewTax.equals("yes")||NewTax.equals("Yes")){
               //in java == dosent compare content only objects, so need to use equals (I cant overrride == like c++ I think
                tax=true;

            }

        }else{
            System.out.println("Error!! tax input invalid!! Try Again");
            getTaxInput();
        }
       this.setTax(tax);
    }///end of GEtTaxInput


        public void inputItem() {
        boolean tax = false;
        ///scan Sku
        Scanner InputSku = new Scanner(System.in); //reading from the system
        System.out.print("Please insert new SKU: ");//printing message
        int SkuNumber = InputSku.nextInt();
        setSku(SkuNumber);//set the sku value to the object

        ///scan Name
        Scanner inputName = new Scanner(System.in);
        System.out.print("Please enter name: ");
        String NewName = inputName.next();
        setName(NewName);///set name
        ///scan Price

        Scanner InputPrice = new Scanner(System.in);
        System.out.print("Please enter the price: ");
        Double NewPrice = InputPrice.nextDouble();
        setPrice(NewPrice);

        ///scan tax yes or no
        getTaxInput();

            Scanner answer=new Scanner(System.in);
            System.out.print("Please enter quantity: ");
            int a=answer.nextInt();
            setQuantity(a);
            }//end of input method

}//end of class
