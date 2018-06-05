package Workshop2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class SaveAccount {
    static private ArrayList<Account> accounts;
    File file;

    /**
     * constructor receive an Account Arralist( in this case the static accounts form Account class
     * Throws an IO exception if something wrong
     */
    SaveAccount(String fileName) throws IOException {
        accounts = new ArrayList<Account>();
        setFile(new File(fileName));
    }
    //setters e getters
    public void setFile(File file) {
        this.file = file;
    }
    public void addAccountsObject(Account obj) {
        accounts.add(obj);
    }
    public int getSize() {
        return accounts.size();
    }
    public static void setAccounts(ArrayList<Account> accounts) {
        SaveAccount.accounts = accounts;
    }
    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
    //methods
    /*Serialize and save the objects in the Array List in the file
     * note: thi slogic should be in the constructor, but for some strange reason
      * was not allowing it to close the file.*/
    void save() throws IOException {
        ReadAccount temp = new ReadAccount("/home/diogowatson/dev/workshop2/Save.ses");
        for (int i = 0; i < temp.getAccountsSize(); i++)
            //loop to check if there are duplicate objects
            //duplicate objects are not saved
            //an duplicate object must all param as the same
            for (int j = 0; j < accounts.size(); j++) {
                if (accounts.get(j).equals(temp.getReadAccounts(i))) {
                    accounts.remove(j);
                }
            }
        ObjectOutputStream os = null;
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(file);
            os = new ObjectOutputStream(fs);
            os.writeObject(accounts);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            if (os != null)
                os.close();
        }
    }
    /*Creates an menu in the console so the user can Input information
     * to create the objects and save it to the files */
    public void menu() {
        Account temp = null;
        int account;
        String firstname;
        String lastName;
        double balance;
        char answer;
        /*Loop to insert to create objects till answer 'N' */
        do {
            System.out.println("Insert the account values");
            System.out.print("Account number : ");
            Scanner in = new Scanner(System.in);
            account = in.nextInt();
            System.out.print("First Name : ");
            in = new Scanner(System.in);
            firstname = in.next();
            System.out.print("Last Name : ");
            in = new Scanner(System.in);
            lastName = in.next();
            System.out.print("Balance : ");
            balance = in.nextDouble();

            try {//set temporary Account object
                temp = new Account(account, firstname, lastName, balance);
            } catch (AccountException ex) {
                ex.printStackTrace();
            } finally {
                accounts.add(temp);//add object to ArrayList accounts
            }
            System.out.print("Create new Account?(Y/N): ");
            in = new Scanner(System.in);
            answer = in.next().charAt(0);

        } while (answer == 'Y' || answer == 'y');

    }//end of menu
}
