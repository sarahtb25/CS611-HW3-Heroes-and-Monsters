import java.util.Arrays;
import java.util.List;

// Represents all possible spells
public class SpellFactory {
    public static final List<String> spellNames = Arrays.asList("Flame_Tornado", "Breath_of_Fire", "Heat_Wave", "Lava_Comet", "Hell_Storm", "Snow_Cannon", "Ice_Blade", "Frost_Blizzard", "Arctic_Storm", "Lightning_Dagger", "Thunder_Blast", "Electric_Arrows", "Spark_Needles");
    public static final List<String> spellIds = Arrays.asList("F0", "F1", "F2", "F3", "F4", "C0", "C1", "C2", "C3", "L0", "L1", "L2", "L3");
    public static final List<Integer> spellCosts = Arrays.asList(700, 350, 450, 800, 600, 500, 250, 750, 700, 400, 750, 550, 500);
    public static final List<Integer> spellLevels = Arrays.asList(4, 1, 2, 7, 3, 2, 1, 5, 6, 1, 4, 5, 2);
    public static final List<Integer> spellDamage = Arrays.asList(850, 450, 600, 1000, 950, 650, 450, 850, 800, 500, 950, 650, 600);
    public static final List<Integer> spellNumberOfConsumptions = Arrays.asList(4, 10, 7, 1, 5, 4, 6, 2, 1, 1, 4, 5, 2, 10, 7, 4, 2);
    public static final List<Integer> spellManaCost = Arrays.asList(300, 100, 150, 550, 600, 250, 100, 350, 300, 150, 400, 200, 200);
    private List<Spell> spells;

    public SpellFactory() {
        for (int i = 0; i < spellNames.size(); i++) {
            if (spellIds.get(i).contains("F")) {
                FireSpell fireSpell = new FireSpell(spellNames.get(i), spellIds.get(i), spellCosts.get(i), spellLevels.get(i), spellNumberOfConsumptions.get(i), spellDamage.get(i), spellManaCost.get(i));
                spells.add(fireSpell);
            } else if (spellIds.get(i).contains("C")) {
                IceSpell iceSpell = new IceSpell(spellNames.get(i), spellIds.get(i), spellCosts.get(i), spellLevels.get(i), spellNumberOfConsumptions.get(i), spellDamage.get(i), spellManaCost.get(i));
                spells.add(iceSpell);
            } else if (spellIds.get(i).contains("L")) {
                LightningSpell lightningSpell = new LightningSpell(spellNames.get(i), spellIds.get(i), spellCosts.get(i), spellLevels.get(i), spellNumberOfConsumptions.get(i), spellDamage.get(i), spellManaCost.get(i));
                spells.add(lightningSpell);
            }
        }
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }
}
