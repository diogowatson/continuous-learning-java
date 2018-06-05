package Workshop2;

import java.io.*;
import java.util.ArrayList;

public class ReadAccount {
    private ArrayList<Account> readAccounts;
    private File file;
    /**constructor
     * takes filename as @param */
    ReadAccount(String fileName){
        readAccounts = new ArrayList<Account>();
        this.file    = new File(fileName);
    }
    //seters and getters
    public void setReadAccounts(Account readAccounts) {
        this.readAccounts.add(readAccounts);
    }
    public Account getReadAccounts(int get){
        return this.readAccounts.get(get);
    }
    public int getAccountsSize(){return this.readAccounts.size();}

//methods

    /** return a String with all the stored account listed */
    public String listAccounts(){
        String back = "";
        for (Account accounts : readAccounts){
            System.out.println(readAccounts);
           back += accounts.toString() + "\n";
        }
        return back;
}
    /* read the file and put its contents in the object Arraylist readAccounts
     * note: tryed to put declaration inside the constructor but was creating a
      * IO exception not declared*/
    public void readFile()throws IOException{

        FileInputStream fis   = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            ArrayList<?> temp = (ArrayList<?>) ois.readObject();
            for(int i =0 ;i < temp.size(); i++) {
                setReadAccounts((Account) temp.get(i));
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException | ClassNotFoundException ex){
            ex.getMessage();
        }finally {
            if(ois!= null)
                ois.close();
        }
    }//end of readFile
   /**print all the accounts (to be used in console mode  */
    public void print(){
        for(Account i : readAccounts){
            System.out.println(i);
        }
    }
}
