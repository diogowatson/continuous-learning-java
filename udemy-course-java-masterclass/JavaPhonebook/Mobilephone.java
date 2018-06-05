// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

import java.util.ArrayList;
import java.util.Scanner;

public class Mobilephone {
      private ArrayList<Contacts> ContactList = new ArrayList<Contacts>();

    public Mobilephone() {}

   public void menu(){
        int option;

      Scanner input = new Scanner(System.in);
      do{
          System.out.println("***Welcome to your mobile phone book***");
          System.out.println("Select one of the further options:");
          System.out.println("1- Print list of contacts");
          System.out.println("2- Add new contact");
          System.out.println("3- update existing contact");
          System.out.println("4- remove contact");
          System.out.println("5- Serach contact by name");
          System.out.println("6- quit");

          option = input.nextInt();

          switch (option){
              case 1:printContacts();
                     break;
              case 2:addNewConatact();
                     break;
              case 3:updateContact();
                     break;
              case 4:removeContact();
                     break;
              case 5:searchContact();
              break;

          }

      }while(option !=6);

       System.out.println("Bye Bye!");
   }//end of menu

    public void printContacts() {
        ///loop trought Contact List and print it using contact.toString method
       if(ContactList.size()>=1) {
           for (int i = 0; i < ContactList.size(); i++) {
               System.out.println(ContactList.get(i).toString());
           }
       }else{
           System.out.println("Array empty!!");
       }
    }//end of printContacts

    public void addNewConatact(){

        Scanner input = new Scanner(System.in);
        System.out.println("Insert new name: ");
        String name = input.next();
        System.out.println(("Insert new number: "));
        long number = input.nextLong();
        Contacts temp = new Contacts(name,number);
        ContactList.add(temp);

        System.out.println("Contact Created!!");
        menu();

    }
    public void updateContact() {

        Scanner input = new Scanner(System.in);
        System.out.print("Insert the contact name: ");
        String N = input.next();

        int c = findContact(N);
        if(c>=0) {


            System.out.println("Insert new name: ");
            String name = input.next();
            System.out.println(("Insert new number: "));
            long number = input.nextLong();
            Contacts temp = new Contacts(name, number);
            ContactList.set(c,temp);

            System.out.println("Contact Updated!!");
            menu();
        }else{
            System.out.println("contact not found!!");
            menu();
        }

    }
    public void removeContact(){

        Scanner input = new Scanner(System.in);
        System.out.print("Insert the contact name: ");
        String N = input.next();


        int c = findContact(N);
        if(c>=0) {
            ContactList.remove(c);
            System.out.println("Item removed!");
            menu();
        }else{
            System.out.println("contact not found!!");
            menu();
        }
    }
    private void searchContact(){

        Scanner input = new Scanner(System.in);
        System.out.print("Insert the contact name: ");
        String N = input.next();


         int c = findContact(N);
         if(c>=0) {
             System.out.println(ContactList.get(c).toString());
             menu();
         }else{
             System.out.println("contact not found!!");
             menu();
         }
        } //searchContact end

    public int findContact(String s) {
        int back = 0;
          for (int i = 0; i <= ContactList.size(); i++) {
              Contacts contact=this.ContactList.get(i);
           if (contact.getName().equals(s)) {
               return i;
                }
            }

        return -1;
    }//end of findContact()



}//endo of mobilephone
