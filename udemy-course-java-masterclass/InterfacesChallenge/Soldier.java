public class Soldier implements INstorage{
    public int health;
    static int attackPower = 20;

    public Soldier(int health) {
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
        return "Soldier{" +
                "health=" + health +
                '}';
    }
}
