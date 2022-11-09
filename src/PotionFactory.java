import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible potions
public class PotionFactory implements ItemFactory<Potion> {
    public static final List<String> POTION_NAMES = Arrays.asList("Healing_Potion", "Strength_Potion", "Magic_Potion", "Luck_Elixir", "Mermaid_Tears", "Ambrosia");
    public static final List<String> POTION_IDS = Arrays.asList("P0", "P1", "P2", "P3", "P4", "P5");
    public static final List<Integer> POTION_COSTS = Arrays.asList(250, 200, 350, 500, 850, 1000);
    public static final List<Integer> POTION_LEVELS = Arrays.asList(1, 1, 2, 4, 5, 8);
    public static final List<Integer> INCREASE_AMOUNT = Arrays.asList(100, 75, 100, 65, 100, 150);
    public static final List<Integer> NUMBER_OF_CONSUMPTIONS = Arrays.asList(20, 15, 10, 4, 3, 1);
    public static final List<List<String>> ATTRIBUTES_AFFECTED = Arrays.asList(Arrays.asList("health"), Arrays.asList("strength"), Arrays.asList("mana"), Arrays.asList("agility"), Arrays.asList("health", "mana", "strength", "agility"), Arrays.asList("health", "mana", "strength", "dexterity", "agility"));
    private List<Potion> potions = new ArrayList<>();

    public PotionFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < POTION_NAMES.size(); i++) {
            Potion potion = new Potion(POTION_NAMES.get(i), POTION_IDS.get(i), POTION_COSTS.get(i), POTION_LEVELS.get(i), NUMBER_OF_CONSUMPTIONS.get(i), INCREASE_AMOUNT.get(i), ATTRIBUTES_AFFECTED.get(i));
            potions.add(potion);
        }
    }

    @Override
    public List<Potion> getItems() {
        return potions;
    }

    @Override
    public void printItems() {
        MHUtility utility = new MHUtility();
        utility.printPotions(potions);
    }

    @Override
    public Potion getItemFromId(String id) {
        Potion potionWanted = new Potion();

        for (Potion potion : potions) {
            if (potion.getId().equals(id)) {
                potionWanted = potion;
            }
        }

        return potionWanted;
    }

    @Override
    public boolean checkItemExists(String id) {
        for (Potion potion : potions) {
            if (potion.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
