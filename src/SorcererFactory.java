import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible sorcerers
public class SorcererFactory implements HeroFactory<Sorcerer> {
    public static final List<String> SORCERER_NAMES = Arrays.asList("Rillifane_Rallathil", "Segojan_Earthcaller", "Reign_Havoc", "Reverie_Ashels", "Kalabar", "Skye_Soar");
    public static final List<String> SORCERER_IDS = Arrays.asList("G0", "G1", "G2", "G3", "G4", "G5");
    public static final List<Integer> SORCERER_MANA = Arrays.asList(900, 500, 800, 700, 600, 500);
    public static final List<Integer> SORCERER_STRENGTH = Arrays.asList(750, 800, 800, 800, 850, 700);
    public static final List<Integer> SORCERER_AGILITY = Arrays.asList(450, 500, 800, 700, 400, 400);
    public static final List<Integer> SORCERER_DEXTERITY = Arrays.asList(500, 650, 800, 400, 600, 500);
    public static final List<Integer> SORCERER_MONEY = Arrays.asList(9000, 5000, 8000, 7000, 6000, 5000);
    public static final List<Integer> SORCERER_EXPERIENCE = Arrays.asList(9, 5, 8, 7, 6, 5);
    private List<Sorcerer> sorcerers = new ArrayList<>();
    private Inventory inventory = new Inventory();

    public SorcererFactory() {
        generateHeroes();
    }

    @Override
    public void generateHeroes() {
        for (int i = 0; i < SORCERER_NAMES.size(); i++) {
            Sorcerer sorcerer = new Sorcerer(SORCERER_NAMES.get(i), SORCERER_IDS.get(i), SORCERER_MANA.get(i), SORCERER_STRENGTH.get(i), SORCERER_AGILITY.get(i), SORCERER_DEXTERITY.get(i), SORCERER_MONEY.get(i), SORCERER_EXPERIENCE.get(i), inventory);
            sorcerers.add(sorcerer);
        }
    }

    @Override
    public Sorcerer getAHero(int index) {
        return sorcerers.get(index);
    }

    @Override
    public int getNumberOfHeroes() {
        return sorcerers.size();
    }
}
