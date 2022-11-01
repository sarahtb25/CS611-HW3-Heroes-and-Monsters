import java.util.Arrays;
import java.util.List;

// Represents all possible potions
public class PotionFactory {
    public static final List<String> potionNames = Arrays.asList("Healing_Potion", "Strength_Potion", "Magic_Potion", "Luck_Elixir", "Mermaid_Tears", "Ambrosia");
    public static final List<String> potionIds = Arrays.asList("P0", "P1", "P2", "P3", "P4", "P5");
    public static final List<Integer> potionCosts = Arrays.asList(250, 200, 350, 500, 850, 1000);
    public static final List<Integer> potionLevels = Arrays.asList(1, 1, 2, 4, 5, 8);
    public static final List<Integer> attributeIncrease = Arrays.asList(100, 75, 100, 65, 100, 150);
    public static final List<Integer> numberOfConsumptions = Arrays.asList(20, 15, 10, 4, 3, 1);
    public static final List<List<String>> attributesAffected = Arrays.asList(Arrays.asList("health"), Arrays.asList("strength"), Arrays.asList("mana"), Arrays.asList("agility"), Arrays.asList("health", "mana", "strength", "agility"), Arrays.asList("health", "mana", "strength", "dexterity", "agility"));
    private List<Potion> potions;

    public PotionFactory() {
        for (int i = 0; i < potionNames.size(); i++) {
            Potion potion = new Potion(potionNames.get(i), potionIds.get(i), potionCosts.get(i), potionLevels.get(i), numberOfConsumptions.get(i), attributeIncrease.get(i), attributesAffected.get(i));
            potions.add(potion);
        }
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public void printPotions() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                                   POTIONS                                                 |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%5s %10s %10s %8s %10s %20s %17s", "ID", "NAME", "COST", "LEVEL", "NUMBER OF CONSUMPTIONS", "ATTRIBUTES INCREASE AMOUNT", "ATTRIBUTES AFFECTED");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        for(Potion potion : potions) {
            System.out.format("%7s %14s %7s %10s %25s %13s %30s", potion.getId(), potion.getItemName(), potion.getCost(), potion.getRequiredLevel(), potion.getnumberOfConsumptions(), potion.getAttributeIncrease(), potion.getAttributesAffected());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public Potion getPotionFromId(String id) {
        Potion potionWanted = new Potion();

        for (Potion potion : potions) {
            if (potion.getId().equals(id)) {
                potionWanted = potion;
            }
        }

        return potionWanted;
    }
}
