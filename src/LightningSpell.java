// Represents a Lightning Spell
public class LightningSpell extends Spell{
    public LightningSpell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions, damage, manaCost);
    }

    @Override
    public void affectMonsterSkill(Monster monster) {
        int noMoreOfAttribute = 0;

        if (monster.getDodgeChance() * Monster.SKILL_REMAINING_AFTER_SPELL_FACTOR < 0) {
            monster.setDodgeChance(noMoreOfAttribute);
        } else {
            monster.setDodgeChance((int) (monster.getDodgeChance() * Monster.SKILL_REMAINING_AFTER_SPELL_FACTOR));
        }
    }
}
