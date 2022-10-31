// Represents the fighters in a battle i.e. Monster and Hero for Monsters and Heroes game
public class Fighters {
    private Hero hero;
    private Monster monster;

    public Fighters(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
