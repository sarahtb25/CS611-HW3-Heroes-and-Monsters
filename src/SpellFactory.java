import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible spells
public class SpellFactory implements ItemFactory<Spell> {
    public static final List<String> SPELL_NAMES = Arrays.asList("Flame_Tornado", "Breath_of_Fire", "Heat_Wave", "Lava_Comet", "Hell_Storm", "Snow_Cannon", "Ice_Blade", "Frost_Blizzard", "Arctic_Storm", "Lightning_Dagger", "Thunder_Blast", "Electric_Arrows", "Spark_Needles");
    public static final List<String> SPELL_IDS = Arrays.asList("F0", "F1", "F2", "F3", "F4", "C0", "C1", "C2", "C3", "L0", "L1", "L2", "L3");
    public static final List<Integer> SPELL_COSTS = Arrays.asList(700, 350, 450, 800, 600, 500, 250, 750, 700, 400, 750, 550, 500);
    public static final List<Integer> SPELL_LEVELS = Arrays.asList(4, 1, 2, 7, 3, 2, 1, 5, 6, 1, 4, 5, 2);
    public static final List<Integer> SPELL_DAMAGE = Arrays.asList(850, 450, 600, 1000, 950, 650, 450, 850, 800, 500, 950, 650, 600);
    public static final List<Integer> SPELL_NUMBER_OF_CONSUMPTIONS = Arrays.asList(4, 10, 7, 1, 5, 4, 6, 2, 1, 1, 4, 5, 2, 10, 7, 4, 2);
    public static final List<Integer> SPELL_MANA_COST = Arrays.asList(300, 100, 150, 550, 600, 250, 100, 350, 300, 150, 400, 200, 200);
    private List<Spell> spells = new ArrayList<>();

    public SpellFactory() {
        generateItems();
    }

    @Override
    public void generateItems() {
        for (int i = 0; i < SPELL_NAMES.size(); i++) {
            if (SPELL_IDS.get(i).contains("F")) {
                FireSpell fireSpell = new FireSpell(SPELL_NAMES.get(i), SPELL_IDS.get(i), SPELL_COSTS.get(i), SPELL_LEVELS.get(i), SPELL_NUMBER_OF_CONSUMPTIONS.get(i), SPELL_DAMAGE.get(i), SPELL_MANA_COST.get(i));
                spells.add(fireSpell);
            } else if (SPELL_IDS.get(i).contains("C")) {
                IceSpell iceSpell = new IceSpell(SPELL_NAMES.get(i), SPELL_IDS.get(i), SPELL_COSTS.get(i), SPELL_LEVELS.get(i), SPELL_NUMBER_OF_CONSUMPTIONS.get(i), SPELL_DAMAGE.get(i), SPELL_MANA_COST.get(i));
                spells.add(iceSpell);
            } else if (SPELL_IDS.get(i).contains("L")) {
                LightningSpell lightningSpell = new LightningSpell(SPELL_NAMES.get(i), SPELL_IDS.get(i), SPELL_COSTS.get(i), SPELL_LEVELS.get(i), SPELL_NUMBER_OF_CONSUMPTIONS.get(i), SPELL_DAMAGE.get(i), SPELL_MANA_COST.get(i));
                spells.add(lightningSpell);
            }
        }
    }

    @Override
    public List<Spell> getItems() {
        return spells;
    }

    @Override
    public void printItems() {
        MHUtility utility = new MHUtility();
        utility.printSpells(spells);
    }

    @Override
    public Spell getItemFromId(String id) {
        Spell spellWanted = new Spell();

        for (Spell spell : spells) {
            if (spell.getId().equals(id)) {
                spellWanted = spell;
            }
        }

        return spellWanted;
    }

    @Override
    public boolean checkItemExists(String id) {
        for (Spell spell : spells) {
            if (spell.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
