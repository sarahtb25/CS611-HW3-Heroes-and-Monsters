import java.util.List;

// Represents monsters in a common cell
public class Monsters {
    private List<Monster> monsters;

    public Monsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
