
public class Testbuguer {
    public static void main(String[] argv) {

        Burguer one = new Burguer();
        boolean tester = one.validateAll("beef","normal","lettuce","mustard");
        if (tester) {
            System.out.println("yes");}else{System.out.println("Nope...");}


        Burguer two = new Burguer("normal", "beef","lettuce","mustard");
        System.out.println(two.toString());

        DeluxeBurguer d1 = new DeluxeBurguer("normal", "fish");
        System.out.println(d1.toString());

        HeathlyBurguer h1 = new HeathlyBurguer("brown", "fish","lettuce", "mustard",
                "fries","soda","onions","pepper");
        System.out.println(h1.toString());
    }
}
