// Represents a Monster and Hero Player
public class MHPlayer extends Player {
    private Heroes heroes;

    public MHPlayer(String name, Heroes heroes) {
        super(name);
        this.heroes = heroes;
    }

    public Heroes getHeroes() {
        return heroes;
    }

    public void setHeroes(Heroes heroes) {
        this.heroes = heroes;
    }
}
