import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private ArrayList<Branch> Branchs = new ArrayList<Branch>();

    Bank(){}

    void menu(){
        Scanner in = new Scanner(System.in);


        System.out.println("Select one of the following options:");
        System.out.println("1.Create new branch");
        System.out.println("2.Acess a branch");
        System.out.println("3.List Branches");
        System.out.println("4.Exit");
        int option =in.nextInt();
        switch (option){
            case 1:addBranch();

            case 2:acessBranch();

            case 3: listBranches();


        }
    }

    void addBranch(){

        Scanner in = new Scanner(System.in);
        System.out.print("Insert new branch Number:");
        int branchNum = in.nextInt();

        if(!checkBranch(branchNum)){
            Branch temp = new Branch(branchNum);
            Branchs.add(temp);
            System.out.println("Branch "+ branchNum + " created");
            menu();
        }else{
            System.out.println("Branch already exists!");
            menu();
        }
    }//end of addBranch

    void acessBranch(){

        Scanner in = new Scanner(System.in);
        System.out.print("Insert branch Number:");
        int branchNum = in.nextInt();

        if(checkBranch(branchNum)){
            int i=findBranch(branchNum);
            Branchs.get(i).menu();

        }else{
            System.out.println("Cant find Branch!");
            menu();
        }
    }

    boolean checkBranch(int branch) {
        if(!Branchs.isEmpty()) {
            for (int i = 0; i < Branchs.size(); i++) {
                if (Branchs.get(i).getBranchNumber() == branch) {
                    return true;
                }

            }
        }
        return false;

    }//end of checkBranch

    int findBranch(int branch) {

        int i;
        for (i = 0; i < Branchs.size(); i++) {
            if (Branchs.get(i).getBranchNumber() == branch) {
                       break;
            }

        }
        return i;
    }//end of find branch index

    void listBranches(){
        for(int i=0; i<Branchs.size(); i++){
            System.out.println(i+". "+Branchs.get(i).getBranchNumber());
        }
        menu();
    }

}
