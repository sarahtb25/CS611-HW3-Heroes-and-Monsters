import java.util.List;

public class Heroes {
    private List<Hero> heroes; // min. 1 and max. 3 heroes, can use instanceof to get the type of hero

    public Heroes() {

    }
    public Heroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    // Used when a hero is defeated
    public void removeHero(Hero hero) {
        heroes.remove(hero);
    }
}
