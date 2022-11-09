import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible armors
public class ArmorFactory implements ItemFactory<Armor> {
    public static final List<String> ARMOR_NAMES = Arrays.asList("Platinum_Shield", "Breastplate", "Full_Body_Armor", "Wizard_Shield", "Guardian_Angel");
    public static final List<String> ARMOR_IDS = Arrays.asList("E0", "E1", "E2", "E3", "E4");
    public static final List<Integer> ARMOR_COSTS = Arrays.asList(150, 350, 1000, 1200, 1000);
    public static final List<Integer> ARMOR_LEVELS = Arrays.asList(1, 3, 8, 10, 10);
    public static final List<Integer> ARMOR_DAMAGE_REDUCTION = Arrays.asList(200, 600, 1100, 1500, 1000);
    private List<Armor> armors = new ArrayList<>();

    public ArmorFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < ARMOR_NAMES.size(); i++) {
            Armor armor = new Armor(ARMOR_NAMES.get(i), ARMOR_IDS.get(i), ARMOR_COSTS.get(i), ARMOR_LEVELS.get(i), ARMOR_DAMAGE_REDUCTION.get(i));
            armors.add(armor);
        }
    }

    @Override
    public List<Armor> getItems() {
        return armors;
    }

    @Override
    public void printItems() {
        MHUtility utility = new MHUtility();
        utility.printArmors(armors);
    }

    @Override
    public Armor getItemFromId(String id) {
        Armor armorWanted = new Armor();

        for (Armor armor : armors) {
            if (armor.getId().equals(id)) {
                armorWanted = armor;
            }
        }

        return armorWanted;
    }

    @Override
    public boolean checkItemExists(String id) {
        for (Armor armor : armors) {
            if (armor.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
