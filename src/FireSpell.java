// Represents a fire spell
public class FireSpell extends Spell {
    public FireSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions, damage, manaCost);
    }

    @Override
    public void applySpell(Hero hero, Monster monster) {
        if (hero.getMana() < getManaCost()) {
            System.out.println(hero.getName() + " ha not enough mana! Unable to cast " + getItemName());
        } else {
            updateManaCost(hero);
            int noMoreOfAttribute = 0;

            if (monster.getHitPoint() - getDamage() < 0) {
                monster.setHitPoint(noMoreOfAttribute);
            } else {
                monster.setHitPoint(monster.getHitPoint() - getDamage());
            }

            if (monster.getDefense() * Monster.skillRemainingAfterSpellFactor < 0) {
                monster.setDefense(noMoreOfAttribute);
            } else {
                monster.setDefense((int) (monster.getDefense() * Monster.skillRemainingAfterSpellFactor));
            }
        }
    }
}
