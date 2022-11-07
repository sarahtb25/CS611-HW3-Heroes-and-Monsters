import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible paladins
public class PaladinFactory implements HeroFactory<Paladin> {
    public static final List<String> paladinNames = Arrays.asList("Parzival", "Sehanine_Moonbow", "Skoraeus_Stonebones", "Garl_Glittergold", "Amaryllis_Astra", "Caliber_Heist");
    public static final List<String> paladinIds = Arrays.asList("H0", "H1", "H2", "H3", "H4", "H5");
    public static final List<Integer> paladinMana = Arrays.asList(700, 700, 400, 500, 500, 800);
    public static final List<Integer> paladinStrength = Arrays.asList(750, 750, 650, 600, 500, 400);
    public static final List<Integer> paladinAgility = Arrays.asList(650, 700, 600, 500, 500, 400);
    public static final List<Integer> paladinDexterity = Arrays.asList(700, 700, 350, 400, 500, 400);
    public static final List<Integer> paladinMoney = Arrays.asList(7000, 7000, 4000, 5000, 5000, 8000);
    public static final List<Integer> paladinExperience = Arrays.asList(7, 7, 4, 5, 5, 8);
    private List<Paladin> paladins = new ArrayList<>();
    private Inventory inventory = new Inventory();

    public PaladinFactory() {
        generateHeroes();
    }

    @Override
    public void generateHeroes() {
        for (int i = 0; i < paladinNames.size(); i++) {
            Paladin paladin = new Paladin(paladinNames.get(i), paladinIds.get(i), paladinMana.get(i), paladinStrength.get(i), paladinAgility.get(i), paladinDexterity.get(i), paladinMoney.get(i), paladinExperience.get(i), inventory);
            paladins.add(paladin);
        }
    }

    @Override
    public Paladin getAHero(int index) {
        return paladins.get(index);
    }

    @Override
    public int getNumberOfHeroes() {
        return paladins.size();
    }
}
