package Workshop2;
import java.io.Serializable;

public class Account implements Serializable {

    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    //constructors
    //default constructor-> initailize empty object
    public Account(){}

    /** Constructor @Param 1 Account Number(9 digits max)
     * @param1 client account
     * @Param2 client first name
     * @param3 client last name
     * @param4 balance of the account*/
    public Account(int account, String firstName, String lastName, double balance) throws AccountException{
        setAccount(account);
        setFirstName(firstName);
        setLastName(lastName);
        setBalance(balance);
    }
    //seters and getters

    /** @param account number
     * Throws exception if number is bigger than 9 digits*/
    public void setAccount(int account)throws AccountException {
        if(account>99999999 || account < 0){
            throw new AccountException("Account number out of range");
        }
        this.account = account;
    }

    public int getAccount() {
        return account;
    }

    /*@param client first name
    * throws exception if lenght is bigger than 30 caracters */
    public void setFirstName(String firstName)throws AccountException {
        if(firstName.length()>30){
            throw new AccountException("Name exceeds alowed range");
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    /*@param client Last name
    * Throws exception if lenght is bigger than 100 caracters */
    public void setLastName(String lastName)throws AccountException {
        if(lastName.length()>100){
            throw new AccountException("Last name exceeds alowed range");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account1 = (Account) o;

        if (account != account1.account) return false;
        if (Double.compare(account1.balance, balance) != 0) return false;
        if (!firstName.equals(account1.firstName)) return false;
        return lastName.equals(account1.lastName);
    }

    @Override
    public String toString() {
        return "Account number : " + getAccount() + "\n"+
                getFirstName() + " "+getLastName()+ "\n"+
                "Balance : " + getBalance() + "\n";
    }
}//end of class
