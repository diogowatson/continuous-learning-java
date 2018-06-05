//import java.util.Scanner;

/**
 * Created by diogowatson on 23/06/17.
**/

import javafx.scene.SnapshotParametersBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class POSApp {

    //Array who saves the items from serialized file on memory
    public List<Item> Store = new ArrayList<Item>();//create an array list of items

    /// methods
    //List items in the store
    public void listStore(){

        System.out.println("----Listing Items-----");
        for (int i = 0; i < Store.size(); i++) {
            String S=Store.get(i).printItem(true);
            System.out.println(S);

        }
    }
   //search for an item at Store Array and return the position if is true; if not returns -1
   public int searchItems(int skuSearch) {
       int r = -1;

       for (int i = 0; i < Store.size(); i++) {
          int s = Store.get(i).getSku();

           if (s == skuSearch) {

               r = i;
           }
       }
       return r;
   }

public boolean checkItem(int search){
        boolean r=false;
        for(int i=0;i<Store.size();i++){
               int s=Store.get(i).getSku();
               if(s==search){
                   r=true;
               }

}
    return r;
    }

   ///searh for an item and print it if found
   public void searchStore(){
       Scanner inputSku = new Scanner(System.in);
       System.out.print("Insert the sku you want to search: ");
       int skuSearch = inputSku.nextInt();
        int result=searchItems(skuSearch);
        if(result!=-1){
          System.out.println(Store.get(result).printItem(false));
        }else{
            System.out.println("Item not found!!");
        }
   }

  public void updateItemQty(Item I){
       Scanner answer=new Scanner(System.in);
       System.out.print("Insert how many itens you wanna addd:");
       int a=answer.nextInt();
       I.setQuantity(a);
  }

  public void updateMenu(){
      Scanner sku= new Scanner(System.in);
      System.out.print("Insert the sku: ");
      int s=sku.nextInt();

      if(checkItem(s)){
          updateItemQty(Store.get(searchItems(s)));
      }else{
          String b=null;
          do {
              System.out.println("Sku not found!!");
              Scanner a = new Scanner(System.in);
              System.out.print("try again?(y/n)");
              b = a.next();
          }while(b!="y"|| b!="Y" || b!="n" || b!="N");
          if(b=="y" && b=="Y"){
              updateMenu();
          }
      }
  }
    public void addItem(){

        Item temp=new Item();
        temp.inputItem();
        if(!checkItem(temp.getSku())) {

            Store.add(temp);
        }else{
            Scanner inputAnswer= new Scanner(System.in);
            System.out.println("There's already an Item with that sku Number");
            System.out.println("Press 'u' to update quantity");
            System.out.println("Press 'n' to try again");
            System.out.println("Press 'b' to return to menu");
            String a=inputAnswer.next();
            switch (a) {

                case "n": case"N":
                    addItem();
                    break;
                case "u": case"U":
                    updateItemQty(Store.get(searchItems(temp.getSku())));
                    break;
                case "b":case "B":
                    break;
            }


            //updateItem();
            //addItem();


        }
    }
    public void pointOfSale() {

        ArrayList<Item> point_of_sale = new ArrayList<>();
        double total=0;
        String Write;
        System.out.println("---Point Of Sale---");
        System.out.println("");

        int answer;
        Scanner ask = new Scanner(System.in);
        do {
            System.out.print("Insert SKU of the product");
            answer = ask.nextInt();

            if (checkItem(answer)) {

                int position = (searchItems(answer));
                String p = Store.get(position).printPOS();
                System.out.println(p);

                point_of_sale.add(Store.get(position));
               Store.get(position).reduceOneQty();
               //reduce one from quantity
            } else {
                System.out.println("Sku not found");
            }
            System.out.println("Enter new Sku or 0 to finish");
        } while (answer != 0);

        Write=String.format("-----------------------------------------------"+"%n"
                            +"Items in point of sale"+"%n"
                            +"-----------------------------------------------"+"%n");

        for (int i=0;i<point_of_sale.size();i++){
            Write+=point_of_sale.get(i).printItem(true);
            total+=point_of_sale.get(i).getPrice();

                  }

        Write+=("Total: "+total);
        System.out.println(Write);


    }
    public void addPerishable() {

        Perishable temp = new Perishable();
        temp.inputItem();
        if (!checkItem(temp.getSku())) {//check logic here

            Store.add(temp);
        } else {
            Scanner inputAnswer = new Scanner(System.in);
            System.out.println("There's already an Item with that sku Number");
            System.out.println("Press 'u' to update quantity");
            System.out.println("Press 'n' to try again");
            System.out.println("Press enter to return to menu");
            String a = inputAnswer.next();
            switch (a) {
                case "u":
                case "U":
                    updateItemQty(Store.get(searchItems(temp.getSku())));
                    break;
                case "n":
                case "N":
                    addPerishable();
                    break;
                default:
                    break;
            }
        }
    }
     public void saveItems() {
         try {

             ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.ser"));
             for (int i = 0; i < Store.size(); i++) {
                 os.writeObject(Store.get(i));
             }

         } catch (IOException ex) {
             ex.printStackTrace();
         }
     }//end of saveItems

     public void loadItems(){


try{
    BufferedReader check=new BufferedReader(new FileReader("data.ser"));
    if(check.readLine()==null){
        System.out.println("Store File is empty!");
        return;

    }

    }catch(Exception e){
    e.printStackTrace();
}

         try{

             FileInputStream fs= new FileInputStream("data.ser");

             ObjectInputStream is=new ObjectInputStream(fs);
             boolean count=true;
             while(count){
                 Item restore= (Item) is.readObject();
                 if(restore!=null) {
                     Store.add(restore);
                 }else{
                     count=false;
                 }
                 if(is.read()==-1){
                     break;
                 }
             }
             is.close();
            }catch(Exception e){
             e.printStackTrace();
             System.out.println("Store empty!!");

         }

     }
    ///menu
    public void PrintMenu(){

        System.out.println("1.List items");
        System.out.println("2.Add item");
        System.out.println("3.Add Perishable Item");
        System.out.println("4.Search Item");
        System.out.println("5.Update item Quantity");
        //System.out.println("6.Point Of Sale");
        System.out.println("7.Exit");
    }

    public void Menu(){

        int answer=1;

        loadItems();


       do {
            PrintMenu();

            Scanner reader = new Scanner(System.in);
            System.out.print("Select an option: ");
            answer = reader.nextInt();


            switch (answer) {

                case 1:
                    listStore();
                    break;

                case 2:
                    addItem();
                    break;

                case 3:
                    addPerishable();
                    break;

                case 4:
                    searchStore();
                    break;

                case 5:
                    updateMenu();
                     break;
                case 6:
                   pointOfSale();
                    break;
                case 7:
                    saveItems();
                    System.exit(1);

            }

        }while(answer!=0);

       //saveItems();
    }
}//end of POSApp
        /**
         *
         solution taht uses 2 array lists--updating to use only one
        for(int i=0; i<StoreNP.size(); i++){

            NonPerishable temp=new NonPerishable();
            temp=Store.get(i);
            temp.PrintItem(true);

        }//end of printing Non Perishable Items

       /** System.out.println("---Perishable Items---");
        for(int i=0; i<StoreP.size();i++ ){
            Perishable temp2=new Perishable();
            temp2=StoreP.get(i);
            temp2.PrintItem(true);
        }

    public void menu(){

        JFrame frame=new JFrame();
        JPanel panel= new JPanel();

        JButton button1=new JButton("List Items");
        JButton button2=new JButton("Add Non Perishable");
        JButton button3=new JButton("Perishable");
        JButton button4=new JButton("Search Item");
        JButton button5=new JButton("POS");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);


        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//put the buttons in a new line
        frame.getContentPane().add(BorderLayout.WEST, panel);
        frame.setSize(600, 600);
        frame.setVisible(true);

    }
}
**/