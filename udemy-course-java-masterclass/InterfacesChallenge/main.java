public class main {

    public static void main(String[] argv){

        Monters m1 = new Monters(100);
        Monters m2 = new Monters(100);

        Hero Aragorn = new Hero(200);
        Soldier footSoldier = new Soldier (50);


        System.out.println("**********Combat Start*******");
        Combat one = new Combat(footSoldier, m1);
        one.soldierAttack();
        one.soldierAttack();
        one.monsterAttack();
        one.monsterAttack();
        one.monsterAttack();
        one.monsterAttack();
        one.monsterAttack();

        Combat two = new Combat(Aragorn, m2);

        two.monsterAttack();
        two.monsterAttack();
        two.monsterAttack();
        two.heroAttack();
        two.heroAttack();
        two.heroAttack();
        two.heroAttack();
        two.heroAttack();
        two.heroAttack();
        two.heroAttack();

    }
}
