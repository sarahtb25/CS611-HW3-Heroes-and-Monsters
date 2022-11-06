import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible armors
public class ArmorFactory implements ItemFactory<Armor> {
    public static final List<String> armorNames = Arrays.asList("Platinum_Shield", "Breastplate", "Full_Body_Armor", "Wizard_Shield", "Guardian_Angel");
    public static final List<String> armorIds = Arrays.asList("E0", "E1", "E2", "E3", "E4");
    public static final List<Integer> armorCosts = Arrays.asList(150, 350, 1000, 1200, 1000);
    public static final List<Integer> armorLevels = Arrays.asList(1, 3, 8, 10, 10);
    public static final List<Integer> armorDamageReduction = Arrays.asList(200, 600, 1100, 1500, 1000);
    private List<Armor> armors = new ArrayList<>();

    public ArmorFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < armorNames.size(); i++) {
            Armor armor = new Armor(armorNames.get(i), armorIds.get(i), armorCosts.get(i), armorLevels.get(i), armorDamageReduction.get(i));
            armors.add(armor);
        }
    }

    @Override
    public List<Armor> getItems() {
        return armors;
    }

    @Override
    public void printItems() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                                   ARMORS                                                  |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%12s %12s %20s %10s %20s", "ID", "NAME", "COST", "LEVEL", "DAMAGE REDUCTION");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        for(Armor armor : armors) {
            System.out.format("%12s %20s %11s %10s %15s", armor.getId(), armor.getItemName(), armor.getCost(), armor.getRequiredLevel(), armor.getDamageReduction());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------");
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
}
