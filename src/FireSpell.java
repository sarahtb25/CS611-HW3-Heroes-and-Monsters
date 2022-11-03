// Represents a fire spell
public class FireSpell extends Spell {
    public FireSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions, damage, manaCost);
    }

    @Override
    public void affectMonsterSkill(Monster monster) {
        int noMoreOfAttribute = 0;

        if (monster.getDefense() * Monster.skillRemainingAfterSpellFactor < 0) {
            monster.setDefense(noMoreOfAttribute);
        } else {
            monster.setDefense((int) (monster.getDefense() * Monster.skillRemainingAfterSpellFactor));
        }
    }
}
