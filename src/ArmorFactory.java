import java.util.Arrays;
import java.util.List;

// Represents all possible armors
public class ArmorFactory {
    public static final List<String> armorNames = Arrays.asList("Platinum_Shield", "Breastplate", "Full_Body_Armor", "Wizard_Shield", "Guardian_Angel");
    public static final List<String> armorIds = Arrays.asList("E0", "E1", "E2", "E3", "E4");
    public static final List<Integer> armorCosts = Arrays.asList(150, 350, 1000, 1200, 1000);
    public static final List<Integer> armorLevels = Arrays.asList(1, 3, 8, 10, 10);
    public static final List<Integer> armorDamageReduction = Arrays.asList(200, 600, 1100, 1500, 1000);
    private List<Armor> armors;

    public ArmorFactory() {
        for (int i = 0; i < armorNames.size(); i++) {
            Armor armor = new Armor(armorNames.get(i), armorIds.get(i), armorCosts.get(i), armorLevels.get(i), armorDamageReduction.get(i));
            armors.add(armor);
        }
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }
}
