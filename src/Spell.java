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

    public String applySpell(Hero hero, Monster monster) {
        String response = "";

        updateManaCost(hero);
        int noMoreOfAttribute = 0;

        if (hero.getAttackDamageWithSpell(damage) <= monster.calculateDodge()) {
            response = "Monster " + monster.getName() + " managed to dodge Hero " + hero.getName() + "'s spell!";
        } else {
            int damageReduceAmount = monster.getDefense();

            if (damageReduceAmount < hero.getAttackDamageWithSpell(damage)) {
                int reduceHitPoints = (int) (hero.getAttackDamageWithSpell(damage) - damageReduceAmount);

                if (monster.getHitPoint() - reduceHitPoints <= 0) {
                    monster.setHitPoint(noMoreOfAttribute);
                    response = "Monster " + monster.getName() + " has been defeated!";
                } else {
                    monster.setHitPoint(monster.getHitPoint() - reduceHitPoints);
                    response = "Monster " + monster.getName() + " was hit by Hero " + hero.getName() + " and lost " + reduceHitPoints + " hitpoints!";
                }
            } else {
                response = "Monster " + monster.getName() + " has successfully defended against Hero " + hero.getName() + "'s spell!";
            }

            affectMonsterSkill(monster);
        }

            consume();

        return response;
    }

    public void affectMonsterSkill(Monster monster) {}

    public void updateManaCost(Hero hero) {
        hero.updateManaCost(manaCost);
    }
}
