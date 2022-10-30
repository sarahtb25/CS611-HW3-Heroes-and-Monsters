// Represents an ice spell
public class IceSpell extends Spell {
    public IceSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions, damage, manaCost);
    }

    @Override
    public void applySpell(Hero hero, Monster monster) {
        updateManaCost(hero);
        int noMoreOfAttribute = 0;

        if (monster.getHitPoint() - getDamage() < 0) {
            monster.setHitPoint(noMoreOfAttribute);
        } else {
            monster.setHitPoint(monster.getHitPoint() - getDamage());
        }

        if (monster.getDamage() * Monster.skillRemainingAfterSpellFactor < 0) {
            monster.setDamage(noMoreOfAttribute);
        } else {
            monster.setDamage((int) (getDamage() * Monster.skillRemainingAfterSpellFactor));
        }
    }
}
