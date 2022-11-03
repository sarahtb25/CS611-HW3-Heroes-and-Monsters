import java.util.Random;

public class CommonPiece extends MHPiece {
    public static final String name = "Common";
    public static final String id = "C";
    public static final String playerId = "C*";
    private int numberOfHeroes = 0;
    private Monsters monsters = new Monsters();

    public CommonPiece() {
        super(name, id);
    }

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public void setNumberOfHeroes(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public Monsters enterCommon() {
        // Represents that a player is in the common area
        setId(playerId);

        boolean haveMonster = haveMonsters();

       if (haveMonster) {
           monsters = getMonsters();
       }

       return monsters;
    }

    public void leaveCommon() {
        setId(id);
        System.out.println("Exiting Common area...");
    }

    public boolean haveMonsters() {
        Random random = new Random();

        return random.nextBoolean();
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }

    public Monsters getMonsters() {
        GenerateMonsters gm = new GenerateMonsters(numberOfHeroes);

        return gm.getMonsters();
    }
}
