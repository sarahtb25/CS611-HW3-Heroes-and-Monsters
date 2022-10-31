import java.util.Random;

public class CommonPiece extends MHPiece {
    public static final String name = "Common";
    public static final String id = "C";
    private int numberOfHeroes = 0;
    private Monsters monsters = new Monsters();

    public CommonPiece() {
        super(name, id);
    }

    // To be used when a player decides to move their hero(es) into the common area
    public CommonPiece(String playerId) {
        super(name, playerId);
    }

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public void setNumberOfHeroes(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public Monsters enterCommon() {
       boolean haveMonster = haveMonsters();

       if (haveMonster) {
           monsters = getMonsters();
       }

       return monsters;
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
