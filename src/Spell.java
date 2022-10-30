// Represents a spell
public class Spell extends ConsumableItem {
    private int damage;
    private int manaCost;

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
        updateManaCost(hero);
    }

    public void updateManaCost(Hero hero) {
        hero.setMana(hero.getMana() - manaCost);
    }
}
