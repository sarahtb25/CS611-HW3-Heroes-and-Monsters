import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible weapons
public class WeaponFactory implements ItemFactory<Weapon> {
    public static final List<String> weaponNames = Arrays.asList("Sword", "Bow", "Scythe", "Axe", "TSwords", "Dagger");
    public static final List<String> weaponIds = Arrays.asList("B0", "B1", "B2", "B3", "B4", "B5");
    public static final List<Integer> weaponCosts = Arrays.asList(500, 300, 1000, 550, 1400, 200);
    public static final List<Integer> weaponLevels = Arrays.asList(1, 2, 6, 5, 8, 1);
    public static final List<Integer> weaponDamage = Arrays.asList(800, 500, 1100, 850, 1600, 250);
    public static final List<Integer> requiredHands = Arrays.asList(1, 2, 2, 1, 2, 1);

    private List<Weapon> weapons = new ArrayList<>();

    public WeaponFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < weaponNames.size(); i++) {
            Weapon weapon = new Weapon(weaponNames.get(i), weaponIds.get(i), weaponCosts.get(i), weaponLevels.get(i), requiredHands.get(i), weaponDamage.get(i));
            weapons.add(weapon);
        }
    }

    @Override
    public List<Weapon> getItems() {
        return weapons;
    }

    @Override
    public void printItems() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                                   WEAPONS                                                 |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%12s %12s %12s %12s %12s %12s", "ID", "NAME", "COST", "LEVEL", "HANDS", "DAMAGE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        for(Weapon weapon : weapons) {
            System.out.format("%12s %13s %11s %10s %12s %13s", weapon.getId(), weapon.getItemName(), weapon.getCost(), weapon.getRequiredLevel(), weapon.getNumberOfHandsRequired(), weapon.getDamage());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------");
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
