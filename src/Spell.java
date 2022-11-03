// Represents a spell
public class Spell extends ConsumableItem {
    private int damage;
    private int manaCost;

    public Spell() {}

    public Spell(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int damage, int manaCost) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions);
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void applySpell(Hero hero, Monster monster) {
        if (hero.getMana() < getManaCost()) {
            System.out.println(hero.getName() + " has not enough mana! Unable to cast " + getItemName());
        } else {
            updateManaCost(hero);
            int noMoreOfAttribute = 0;

            if (monster.getHitPoint() - hero.getAttackDamageWithSpell(getDamage()) < 0) {
                monster.setHitPoint(noMoreOfAttribute);
            } else {
                monster.setHitPoint(monster.getHitPoint() - hero.getAttackDamageWithSpell(getDamage()));
            }

            affectMonsterSkill(monster);
            consume();
        }
    }

    public void affectMonsterSkill(Monster monster) {}

    public void updateManaCost(Hero hero) {
        hero.setMana(hero.getMana() - manaCost);
    }
}
