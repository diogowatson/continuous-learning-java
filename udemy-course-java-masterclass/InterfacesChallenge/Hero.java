public class Hero implements INstorage{
    public int health;
    static int attackPower = 20;

    public Hero(int health) {
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
        return "Hero{" +
                "health=" + health +
                '}';
    }
}
