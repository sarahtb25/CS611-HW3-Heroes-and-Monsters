// Represents a Lightning Spell
public class LightningSpell extends Spell{
    public LightningSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
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

        if (monster.getDodgeChance() * Monster.skillRemainingAfterSpellFactor < 0) {
            monster.setDodgeChance(noMoreOfAttribute);
        } else {
            monster.setDodgeChance((int) (monster.getDodgeChance() * Monster.skillRemainingAfterSpellFactor));
        }
    }
}
