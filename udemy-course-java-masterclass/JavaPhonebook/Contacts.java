public class Contacts {
    private String name;
    private long number;


    //constructor - creates a new contact

    public Contacts(String name, long number) {
        this.name = name;
        this.number =  number;
    }

    //setName -> to update nam

    public void setName(String name) {
        this.name = name;
    }


    //set number -> to update number

    public void setNumber(long number) {
        this.number = number;
    }

    //getName -> to acess through name


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name " + name + "\n"+
                "Number " + number +"\n";
    }
}
