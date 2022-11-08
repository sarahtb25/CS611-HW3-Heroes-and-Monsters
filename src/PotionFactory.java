import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible potions
public class PotionFactory implements ItemFactory<Potion> {
    public static final List<String> potionNames = Arrays.asList("Healing_Potion", "Strength_Potion", "Magic_Potion", "Luck_Elixir", "Mermaid_Tears", "Ambrosia");
    public static final List<String> potionIds = Arrays.asList("P0", "P1", "P2", "P3", "P4", "P5");
    public static final List<Integer> potionCosts = Arrays.asList(250, 200, 350, 500, 850, 1000);
    public static final List<Integer> potionLevels = Arrays.asList(1, 1, 2, 4, 5, 8);
    public static final List<Integer> attributeIncrease = Arrays.asList(100, 75, 100, 65, 100, 150);
    public static final List<Integer> numberOfConsumptions = Arrays.asList(20, 15, 10, 4, 3, 1);
    public static final List<List<String>> attributesAffected = Arrays.asList(Arrays.asList("health"), Arrays.asList("strength"), Arrays.asList("mana"), Arrays.asList("agility"), Arrays.asList("health", "mana", "strength", "agility"), Arrays.asList("health", "mana", "strength", "dexterity", "agility"));
    private List<Potion> potions = new ArrayList<>();

    public PotionFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < potionNames.size(); i++) {
            Potion potion = new Potion(potionNames.get(i), potionIds.get(i), potionCosts.get(i), potionLevels.get(i), numberOfConsumptions.get(i), attributeIncrease.get(i), attributesAffected.get(i));
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
