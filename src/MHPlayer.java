// Represents a Monster and Hero Player
public class MHPlayer extends Player {
    private Heroes heroes;
    int playerLocationRow = 0;
    int playerLocationColumn = 0;

    public MHPlayer(String name) {
        super(name);
    }

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

    public int getPlayerLocationRow() {
        return playerLocationRow;
    }

    public void setPlayerLocationRow(int playerLocationRow) {
        this.playerLocationRow = playerLocationRow;
    }

    public int getPlayerLocationColumn() {
        return playerLocationColumn;
    }

    public void setPlayerLocationColumn(int playerLocationColumn) {
        this.playerLocationColumn = playerLocationColumn;
    }
}
