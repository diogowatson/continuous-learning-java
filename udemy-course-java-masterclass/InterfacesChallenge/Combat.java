public class Combat {

    private Hero hero;
    private Monters monster;
    private Soldier soldier;
    private boolean isHero;


    public Combat(Hero hero, Monters monster) {
        this.hero = hero;
        this.monster = monster;
        this.isHero = true;
    }

    public Combat(Soldier soldier, Monters monster){
        this.soldier = soldier;
        this.monster = monster;
        this.isHero = false;
    }

    public void monsterAttack(){
        if(!isHero){
            if(this.soldier.health>0){
            int damage = this.soldier.health- this.monster.attack();
            this.soldier.health = damage;
            if(this.soldier.health==0){
                System.out.println("Soldier is dead");
            }else{
                System.out.println("Soldier receive a damage of " + damage);
                System.out.println(("Remaining heathl = "+ this.soldier.getHealth()));
            }

                }else {
                System.out.println("Soldier is already death....");
            }

        }else{
            int damage = this.hero.health- this.monster.attack();
            this.hero.health = damage;
            if(this.hero.health==0){
                System.out.println("hero is dead");
            }else{
                System.out.println("hero receive a damage of " + damage);
                System.out.println(("Remaining heathl = "+ this.hero.getHealth()));
            }

        }

            }



        
    public void soldierAttack(){
        if(this.monster.health>0) {
            int damage = this.monster.health - this.soldier.attack();
            this.monster.health = damage;
            if (this.monster.health == 0) {
                System.out.println("The monster is dead!!!");
            } else {
                System.out.println("Moster received a damege of " + damage);

            }
        }else{
            System.out.println("Monster is already death....");
        }
    }

    public void heroAttack(){
        if(this.monster.health>0){
        int damage = this.monster.health - this.hero.attack();
        this.monster.health = damage;
        if(this.monster.health==0){
            System.out.println("The monster is dead!!!");
        }else{
            System.out.println("Moster received a damage of "+damage);

        }
            }else{
            System.out.println("Monster is already death....");
        }
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Monters getMonster() {
        return monster;
    }

    public void setMonster(Monters monster) {
        this.monster = monster;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }
}
