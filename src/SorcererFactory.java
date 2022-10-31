import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible sorcerers
public class SorcererFactory {
    public static final List<String> sorcererNames = Arrays.asList("Rillifane_Rallathil", "Segojan_Earthcaller", "Reign_Havoc", "Reverie_Ashels", "Kalabar", "Skye_Soar");
    public static final List<String> sorcererIds = Arrays.asList("G0", "G1", "G2", "G3", "G4", "G5");
    public static final List<Integer> sorcererMana = Arrays.asList(1300, 900, 800, 900, 800, 1000);
    public static final List<Integer> sorcererStrength = Arrays.asList(750, 800, 800, 800, 850, 700);
    public static final List<Integer> sorcererAgility = Arrays.asList(450, 500, 800, 700, 400, 400);
    public static final List<Integer> sorcererDexterity = Arrays.asList(500, 650, 800, 400, 600, 500);
    public static final List<Integer> sorcererMoney = Arrays.asList(2500, 2500, 2500, 2500, 2500, 2500);
    public static final List<Integer> sorcererExperience = Arrays.asList(9, 5, 8, 7, 6, 5);
    private List<Sorcerer> sorcerers;
    private Inventory inventory = new Inventory(new ArrayList<Weapon>(), new ArrayList<Armor>(), new ArrayList<Potion>(), new ArrayList<Spell>());

    public SorcererFactory() {
        for (int i = 0; i < sorcererNames.size(); i++) {
            Sorcerer sorcerer = new Sorcerer(sorcererNames.get(i), sorcererIds.get(i), sorcererMana.get(i), sorcererStrength.get(i), sorcererAgility.get(i), sorcererDexterity.get(i), sorcererMoney.get(i), sorcererExperience.get(i), inventory);
        }
    }

    public Sorcerer getASorcerer(int index) {
        return sorcerers.get(index);
    }

    public int getNumberOfSorcerers() {
        return sorcerers.size();
    }
}
