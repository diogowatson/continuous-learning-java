public class HeathlyBurguer extends Burguer{

    public String topping5, topping6;

    public HeathlyBurguer(String breadType, String meat, String toppingOne, String toppingtwo, String toppingThree, String toppingFour, String topping5, String topping6) {
        super(breadType, meat, toppingOne, toppingtwo, toppingThree, toppingFour);

        this.topping5 = topping5;
        this.topping6 = topping6;
    }

    @Override
    public boolean validateBread(String type) {
        if (type=="brown"){
            return true;
        }else{
            System.out.println("system only accept brown bread for this kind of burguer");

        }
        return false;
    }

    @Override
    public String toString() {
        return "This HeathlyBurguer is compsed of\n" +
                super.toString()+ "\n"+
                "topping5 '" + topping5 + "\n"+
                ", topping6 " + topping6;
    }
}
