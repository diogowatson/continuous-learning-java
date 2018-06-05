public class Burguer {

    private String breadType, meat, toppingOne, toppingtwo, toppingThree, toppingFour;
    private int price;
    enum toppings{cheese, lettuce, mustard, onions, pepper, specialSausage, mangoSauce, fries, soda };
    enum breadT{ normal, brown};
    enum meatType{beef, chicken, fish };

    public Burguer() {
    }

    public Burguer(String breadType, String meat, String toppingOne, String toppingtwo, String toppingThree, String toppingFour) {



        if(validateAll(meat, breadType, toppingOne, toppingtwo, toppingThree, toppingFour)) {
            this.breadType = breadType;
            this.meat = meat;
            this.toppingOne = toppingOne;
            this.toppingtwo = toppingtwo;
            this.toppingThree = toppingThree;
            this.toppingFour = toppingFour;

            price = 0;
            price += breadPrice();
            price += meatPrice();
            price += toppingPrice(4);
        }else{
            throw new IllegalArgumentException("error 1");
        }

    }

    public Burguer(String breadType, String meat, String toppingOne, String toppingtwo, String toppingThree) {
        if(validateAll(meat, breadType, toppingOne, toppingtwo, toppingThree)){
        this.meat = meat;
        this.toppingOne = toppingOne;
        this.toppingtwo = toppingtwo;
        this.toppingThree = toppingThree;
        this.toppingFour = null;

        price = 0;
        price += breadPrice();
        price += meatPrice();
        price += toppingPrice(3);
    }else{
            throw new IllegalArgumentException("error 2");
        }

}

    public Burguer(String breadType, String meat, String toppingOne, String toppingtwo) {
        if(validateAll(meat, breadType, toppingOne, toppingtwo)) {
            this.breadType = breadType;
            this.meat = meat;
            this.toppingOne = toppingOne;
            this.toppingtwo = toppingtwo;
            this.toppingThree = null;
            this.toppingFour = null;

            price = 0;
            price += breadPrice();
            price += meatPrice();
            price += toppingPrice(2);
        }else{
            throw new IllegalArgumentException("error 3");
        }

    }

    public Burguer(String breadType, String meat, String toppingOne) {
        if(validateAll(meat, breadType, toppingOne)) {
            this.breadType = breadType;
            this.meat = meat;
            this.toppingOne = toppingOne;
            this.toppingtwo = null;
            this.toppingThree = null;
            this.toppingFour = null;

            price = 0;
            price += breadPrice();
            price += meatPrice();
            price += toppingPrice(1);
        }else{
            throw new IllegalArgumentException("error 4");
        }

    }

    public Burguer(String breadType, String meat) {
        if(validateAll(meat, breadType)) {
            this.breadType = breadType;
            this.meat = meat;
            this.toppingOne = null;
            this.toppingtwo = null;
            this.toppingThree = null;
            this.toppingFour = null;

            price = 0;
            price += breadPrice();
            price += meatPrice();

        }else{
            throw new IllegalArgumentException("error 5");
        }

    }

    public boolean validateTopping(String topping) {

        for (toppings top : toppings.values()) {
            if (top.toString().equals(topping)) {
                return true;
            }
        }
        System.out.println(topping +" is not valid!");
        return false;
    }

    public boolean validateMeat(String type) {

        for (meatType me : meatType.values()) {
            if (me.toString().equals(type)) {
                return true;
            }
        }
        System.out.println(type +" is not valid!");
        return false;
    }

    public boolean validateBread(String type) {

        for (breadT top : breadT.values()) {
            if (top.toString().equals(type)) {
                return true;
            }
        }
        System.out.println(type +" is not valid!");
        return false;
    }

    public boolean validateAll(String meat, String bread){
        if (validateMeat(meat) && validateBread(bread)) {
            return true;
        }else{
            System.out.println("ValidationAll problem!!");
        }

        return false;
    }

    public boolean validateAll(String meat, String bread, String top1){
        if (validateMeat(meat) && validateBread(bread) && validateTopping(top1)) {
            return true;
        }else{
            System.out.println("ValidationAll problem!!");
        }

        return false;
    }

    public boolean validateAll(String meat, String bread, String top1, String top2){
        if (validateMeat(meat) && validateBread(bread) && validateTopping(top1)
                && validateTopping(top2)) {
            return true;
        }else{
            System.out.println("ValidationAll problem!!");
        }

        return false;
    }

    public boolean validateAll(String meat, String bread, String top1, String top2, String top3){
        if (validateMeat(meat) && validateBread(bread) && validateTopping(top1)
                && validateTopping(top2) && validateTopping(top3)) {
            return true;
        }else{
            System.out.println("ValidationAll problem!!");
        }

        return false;
    }

    public boolean validateAll(String meat, String bread, String top1, String top2, String top3, String top4){
        if (validateMeat(meat) && validateBread(bread) && validateTopping(top1)
                && validateTopping(top2) && validateTopping(top3) && validateTopping(top4)) {
            return true;
        }else{
            System.out.println("ValidationAll problem!!");
        }

        return false;
    }

    public double meatPrice(){
        switch (this.meat){
            case "beef":return 4.25;
            case "chicken":return 3.25;
            case "fish":return 5.40;

        }
        return 0.0;
    }

    public double breadPrice(){
        switch (this.breadType){
            case "normal":return 0.50;
            case "brown": return 0.70;
        }
        return 0.0;
    }//end of breadPrice

    public double toppingPrice(int numberToppings){
        switch (numberToppings){
            case 1:return 0.50;
            case 2:return 1.0;
            case 3:return 1.50;
            case 4:return 2.0;
            default:return 0;
        }

    }

    @Override
    public String toString() {
        return  "breadType " + breadType + " \n" +
                "meat " + meat + "\n" +
                "toppingOne " + toppingOne + "\n" +
                "toppingtwo '" + toppingtwo + "\n" +
                "toppingThree " + toppingThree + "\n" +
                "toppingFour " + toppingFour + "\n" +
                "price " + price;
    }

    public String getMeat(){
        return meat;
    }

    public String getBreadType() {
        return breadType;
    }
};//end of burguer class



