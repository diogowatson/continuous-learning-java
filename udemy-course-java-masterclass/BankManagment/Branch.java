

import java.util.ArrayList;
import java.util.Scanner;


public class Branch {

    private int branchNumber;
    private ArrayList<Customer> customerList = new ArrayList<Customer>();


    public Branch( int branchNumber) {

        this.branchNumber = branchNumber;
    }

    void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Branch "+ branchNumber);
        System.out.println("Select one of the following options:");
        System.out.println("1.Add a customer");
        System.out.println("2.Find a customer");
        System.out.println("3.return to main menu");
        int option =in.nextInt();
        switch (option){
            case 1:addCustomer();

            case 2:findCustomer();
            case 3:break;
        }
    }

    public void findCustomer(){
        Scanner in;
        in = new Scanner(System.in);
        System.out.print("Search by name or account number?(press n for name or a for account");
        String choice = in.nextLine();
        if(choice.equals("n") || choice.equals("N")){
             findCustomerByName();

        }else if(choice.equals("A") || choice.equals("a")){
            findCustomerByAccountNumber();
        }else{
            Scanner in2 = new Scanner((System.in));
            System.out.println("Option not valid!");
            String option;
            do {
                System.out.println("Try again (Y) or return to main menu (N)?");
                option = in2.nextLine();
            }while(!option.equals("Y")||!option.equals("y")||!option.equals("N")||!option.equals("n"));
            if(option.equals("Y")||option.equals("y"))
                findCustomer();
            else menu();
        }
    }

    public void addCustomer(){
       Customer temp = new Customer();
       customerList.add(temp);
       menu();


    }

   public void findCustomerByName(){
       Scanner in = new Scanner(System.in);
       System.out.print("Please insert the customer name:");
       String name = in.next();
       int count =0;
           for(int i=0;i<customerList.size();i++){
               if(customerList.get(i).getCustName().equals(name)){
                   System.out.println(customerList.get(i).toString());
                   customerList.get(i).menu();
                   count++;
                   if(count>0)
                       System.out.println("Cannot find Customer!");
                   menu();
               }
           }


   }//end find customer by name

    public void findCustomerByAccountNumber()  {
        Scanner in = new Scanner(System.in);
        System.out.print("Please insert the customer account number:");
        int account = in.nextInt();
        int count=0;

            for(int i=0;i<customerList.size();i++){
                if(customerList.get(i).getCustAcount()==account){
                   System.out.println(customerList.get(i).toString());
                    customerList.get(i).menu();
                    if(count>0)
                        System.out.println("Cannot find Customer!");
                    menu();
                }
            }



    }//end of find bay account number

    public int getBranchNumber() {
        return branchNumber;
    }
}
