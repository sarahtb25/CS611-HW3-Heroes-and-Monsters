import java.util.ArrayList;
import java.util.List;

// This class generates monsters as needed for a cell
public class GenerateMonsters {
    public static final DragonFactory df = new DragonFactory();
    public static final ExoskeletonFactory ef = new ExoskeletonFactory();
    public static final SpiritFactory sf = new SpiritFactory();
    public static int numberOfTypesOfMonsters = 3;
    private int numberOfHeroes;

    public GenerateMonsters(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public Monsters getMonsters() {
        Monsters monsters = new Monsters();
        Monster monster = new Monster();
        List<Integer> dragonIndexesAdded = new ArrayList<>();
        List<Integer> exoskeletonIndexesAdded = new ArrayList<>();
        List<Integer> spiritIndexesAdded = new ArrayList<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            int index = (int) (Math.random() * numberOfTypesOfMonsters);
            String typeOfMonster = new String [] {"Dragon", "Exoskeleton", "Spirit"}[index];

            if (typeOfMonster.equals("Dragon")) {
                int indexOfDragon = (int) (Math.random() * df.getNumberOfMonsters());

                while(dragonIndexesAdded.contains(indexOfDragon)) {
                    indexOfDragon = (int) (Math.random() * df.getNumberOfMonsters());
                }

                dragonIndexesAdded.add(indexOfDragon);
                monster = df.getAMonster(indexOfDragon);
            } else if (typeOfMonster.equals("Exoskeleton")) {
                int indexOfExoskeleton = (int) (Math.random() * ef.getNumberOfMonsters());

                while(exoskeletonIndexesAdded.contains(indexOfExoskeleton)) {
                    indexOfExoskeleton = (int) (Math.random() * ef.getNumberOfMonsters());
                }

                exoskeletonIndexesAdded.add(indexOfExoskeleton);
                monster = ef.getAMonster(indexOfExoskeleton);
            } else if (typeOfMonster.equals("Spirit")) {
                int indexOfSpirit = (int) (Math.random() * sf.getNumberOfMonsters());

                while(spiritIndexesAdded.contains(indexOfSpirit)) {
                    indexOfSpirit = (int) (Math.random() * sf.getNumberOfMonsters());
                }

                dragonIndexesAdded.add(indexOfSpirit);
                monster = sf.getAMonster(indexOfSpirit);
            }

            monsters.addMonster(monster);
        }

        return monsters;
    }
}
