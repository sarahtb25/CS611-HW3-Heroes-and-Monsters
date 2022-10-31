import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible warriors
public class WarriorFactory {
    public static final List<String> warriorNames = Arrays.asList("Gaerdal_Ironhand", "Sehanine_Monnbow", "Muamman_Duathall", "Flandal_Steelskin", "Undefeated_Yoj", "Eunoia_Cyn");
    public static final List<String> warriorIds = Arrays.asList("R0", "R1", "R2", "R3", "R4", "R5");
    public static final List<Integer> warriorMana = Arrays.asList(100, 600, 300, 200, 400, 400);
    public static final List<Integer> warriorStrength = Arrays.asList(700, 700, 900, 750, 800, 700);
    public static final List<Integer> warriorAgility = Arrays.asList(500, 800, 500, 650, 400, 800);
    public static final List<Integer> warriorDexterity = Arrays.asList(600, 500, 750, 700, 700, 600);
    public static final List<Integer> warriorMoney = Arrays.asList(1354, 2500, 2546, 2500, 2500, 2500);
    public static final List<Integer> warriorExperience = Arrays.asList(7, 8, 6, 7, 7, 6);
    private List<Warrior> warriors;
    private Inventory inventory = new Inventory(new ArrayList<Weapon>(), new ArrayList<Armor>(), new ArrayList<Potion>(), new ArrayList<Spell>());

    public WarriorFactory() {
        for (int i = 0; i < warriorNames.size(); i++) {
            Warrior warrior = new Warrior(warriorNames.get(i), warriorIds.get(i), warriorMana.get(i), warriorStrength.get(i), warriorAgility.get(i), warriorDexterity.get(i), warriorMoney.get(i), warriorExperience.get(i), inventory);
        }
    }

    public Warrior getAWarrior(int index) {
        return warriors.get(index);
    }

    public int getNumberOfWarriors() {
        return warriors.size();
    }
}
