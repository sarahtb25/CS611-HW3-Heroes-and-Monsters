import java.util.Arrays;
import java.util.List;

// Represents all possible weapons
public class WeaponFactory {
    public static final List<String> weaponNames = Arrays.asList("Sword", "Bow", "Scythe", "Axe", "TSwords", "Dagger");
    public static final List<String> weaponIds = Arrays.asList("B0", "B1", "B2", "B3", "B4", "B5");
    public static final List<Integer> weaponCosts = Arrays.asList(500, 300, 1000, 550, 1400, 200);
    public static final List<Integer> weaponLevels = Arrays.asList(1, 2, 6, 5, 8, 1);
    public static final List<Integer> weaponDamage = Arrays.asList(800, 500, 1100, 850, 1600, 250);
    public static final List<Integer> requiredHands = Arrays.asList(1, 2, 2, 1, 2, 1);

    private List<Weapon> weapons;

    public WeaponFactory() {
        for (int i = 0; i < weaponNames.size(); i++) {
            Weapon weapon = new Weapon(weaponNames.get(i), weaponIds.get(i), weaponCosts.get(i), weaponLevels.get(i), requiredHands.get(i), weaponDamage.get(i));
            weapons.add(weapon);
        }
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
}
