public class Employee {
    /*This Employee object reason is to test the Gui. That's whys I'm not using setters and getters
    and why the members are not private. Everything is to be simpler since the iportnt class is GUI
     */

    int sku;
    String fName;
    String lName;

    Employee(){
        this.sku = 0;
        this.lName ="";
        this.fName = "";
    }
    @Override
    public String toString() {
        return "Employee{" +
                "sku=" + sku +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
