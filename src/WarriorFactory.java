import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible warriors
public class WarriorFactory implements HeroFactory<Warrior> {
    public static final List<String> WARRIOR_NAMES = Arrays.asList("Gaerdal_Ironhand", "Sehanine_Monnbow", "Muamman_Duathall", "Flandal_Steelskin", "Undefeated_Yoj", "Eunoia_Cyn");
    public static final List<String> WARRIOR_IDS = Arrays.asList("R0", "R1", "R2", "R3", "R4", "R5");
    public static final List<Integer> WARRIOR_MANA = Arrays.asList(700, 800, 600, 700, 700, 600);
    public static final List<Integer> WARRIOR_STRENGTH = Arrays.asList(700, 700, 900, 750, 800, 700);
    public static final List<Integer> WARRIOR_AGILITY = Arrays.asList(500, 800, 500, 650, 400, 800);
    public static final List<Integer> WARRIOR_DEXTERITY = Arrays.asList(600, 500, 750, 700, 700, 600);
    public static final List<Integer> WARRIOR_MONEY = Arrays.asList(7000, 8000, 6000, 7000, 7000, 6000);
    public static final List<Integer> WARRIOR_EXPERIENCE = Arrays.asList(7, 8, 6, 7, 7, 6);
    private List<Warrior> warriors = new ArrayList<>();
    private Inventory inventory = new Inventory();

    public WarriorFactory() {
        generateHeroes();
    }

    @Override
    public void generateHeroes() {
        for (int i = 0; i < WARRIOR_NAMES.size(); i++) {
            Warrior warrior = new Warrior(WARRIOR_NAMES.get(i), WARRIOR_IDS.get(i), WARRIOR_MANA.get(i), WARRIOR_STRENGTH.get(i), WARRIOR_AGILITY.get(i), WARRIOR_DEXTERITY.get(i), WARRIOR_MONEY.get(i), WARRIOR_EXPERIENCE.get(i), inventory);
            warriors.add(warrior);
        }
    }

    @Override
    public Warrior getAHero(int index) {
        return warriors.get(index);
    }

    @Override
    public int getNumberOfHeroes() {
        return warriors.size();
    }
}
