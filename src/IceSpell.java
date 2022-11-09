// Represents an ice spell
public class IceSpell extends Spell {
    public IceSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions, damage, manaCost);
    }

    public IceSpell(IceSpell iceSpell) {
        super(iceSpell.getItemName(), iceSpell.getId(), iceSpell.getCost(), iceSpell.getRequiredLevel(), iceSpell.getNumberOfConsumptions(), iceSpell.getDamage(), iceSpell.getManaCost());
    }

    @Override
    public void affectMonsterSkill(Monster monster) {
        int noMoreOfAttribute = 0;

        if (monster.getDamage() * Monster.SKILL_REMAINING_AFTER_SPELL_FACTOR < 0) {
            monster.setDamage(noMoreOfAttribute);
        } else {
            monster.setDamage((int) (getDamage() * Monster.SKILL_REMAINING_AFTER_SPELL_FACTOR));
        }
    }
}
