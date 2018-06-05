public class DeluxeBurguer extends Burguer {

    private String side1;
    private String side2;
    public DeluxeBurguer(String breadType, String meat) {
        super(breadType, meat);
        this.side1 = "fries";
        this.side2 = "soda";
    }

    @Override
    public String toString() {
        return "This DeluxeBurguer is composed of \n" +
                "meat: "+ getMeat() +"\n"+
                "bread: "+getBreadType()+"\n"+
                "side1 '" + side1 + '\'' +"\n"+
                "side2 '" + side2 + '\'' +"\n";
    }
}
