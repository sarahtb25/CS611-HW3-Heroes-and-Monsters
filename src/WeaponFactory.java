import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible weapons
public class WeaponFactory implements ItemFactory<Weapon> {
    public static final List<String> WEAPON_NAMES = Arrays.asList("Sword", "Bow", "Scythe", "Axe", "TSwords", "Dagger", "Fists");
    public static final List<String> WEAPON_IDS = Arrays.asList("B0", "B1", "B2", "B3", "B4", "B5", "B6");
    public static final List<Integer> WEAPON_COSTS = Arrays.asList(500, 300, 1000, 550, 1400, 200, 0);
    public static final List<Integer> WEAPON_LEVELS = Arrays.asList(1, 2, 6, 5, 8, 1, 1);
    public static final List<Integer> WEAPON_DAMAGE = Arrays.asList(800, 500, 1100, 850, 1600, 250, 150);
    public static final List<Integer> REQUIRED_HANDS = Arrays.asList(1, 2, 2, 1, 2, 1, 2);

    private List<Weapon> weapons = new ArrayList<>();

    public WeaponFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < WEAPON_NAMES.size(); i++) {
            Weapon weapon = new Weapon(WEAPON_NAMES.get(i), WEAPON_IDS.get(i), WEAPON_COSTS.get(i), WEAPON_LEVELS.get(i), REQUIRED_HANDS.get(i), WEAPON_DAMAGE.get(i));
            weapons.add(weapon);
        }
    }

    @Override
    public List<Weapon> getItems() {
        return weapons;
    }

    @Override
    public void printItems() {
        MHUtility utility = new MHUtility();
        utility.printWeapons(weapons);
    }

    @Override
    public Weapon getItemFromId(String id) {
        Weapon weaponWanted = new Weapon();

        for (Weapon weapon : weapons) {
            if (weapon.getId().equals(id)) {
                weaponWanted = weapon;
            }
        }

        return weaponWanted;
    }

    @Override
    public boolean checkItemExists(String id) {
        for (Weapon weapon : weapons) {
            if (weapon.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
