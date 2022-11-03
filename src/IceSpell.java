// Represents an ice spell
public class IceSpell extends Spell {
    public IceSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions, damage, manaCost);
    }

    @Override
    public void affectMonsterSkill(Monster monster) {
        int noMoreOfAttribute = 0;

        if (monster.getDamage() * Monster.skillRemainingAfterSpellFactor < 0) {
            monster.setDamage(noMoreOfAttribute);
        } else {
            monster.setDamage((int) (getDamage() * Monster.skillRemainingAfterSpellFactor));
        }
    }
}
