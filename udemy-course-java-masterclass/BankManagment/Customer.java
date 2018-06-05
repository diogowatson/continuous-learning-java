import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String custName;
    private int custAcount;
    ArrayList<Double> custTransactions = new ArrayList<Double>();

    public Customer(){
        Scanner in = new Scanner(System.in);
        System.out.print("Plese insert the customer name: ");
        String name = in.next();
        this.custName=name;
        System.out.print("Plese insert the customer account: ");
        int account = in.nextInt();
        this.custAcount = account;
    }//end of default constructor

    public Customer(String custName, int custAcount) {
        this.custAcount = custAcount;
        this.custName = custName;
    }//end of second costructor

    void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("1.Add transaction");
        System.out.println("2.List transactions");
        System.out.println("Press any other button to return to the previous menu");
        String option = in.nextLine();

        switch (option){
            case "1": addTransaction();
            case "2": listTransactions();
            default : break;
        }

    }
    void addTransaction( ){

        Scanner in = new Scanner(System.in);
        System.out.print("insert the value: ");
        double value = in.nextDouble();
        Double transaction = new Double(value);
        custTransactions.add(transaction);
        menu();
    }

    void listTransactions(){
        if(custTransactions.size()>0)
        transactionList();
        else System.out.println("Customer has no transactions");
        menu();
    }

    double getTransactionValue(int position){

        return custTransactions.get(position);

    }

    public String getCustName() {
        return custName;
    }

    public int getCustAcount() {
        return custAcount;
    }

    @Override
    public String toString() {
        return "Customer Name:" + custName+"\n"+
                "Customer Account:" + custAcount + "\n";

    }

    public void transactionList(){

       for(int i = 0; i<custTransactions.size();i++){
           System.out.println("transaction number "+ i +" "+custTransactions.get(i).toString());
       }


    }
}
