import java.util.ArrayList;

public class Monters implements INstorage {

    public int health;
    static int attackPower = 10;


    public Monters(int health) {
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int attack() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Monters{" +
                "health=" + health +
                '}';
    }
}
