// This class represents a monster
public class Monster extends NonPlayerCharacter {
    public static final double dodgeChanceFactor = 0.1;
    public static final double skillRemainingAfterSpellFactor = 0.9;
    public static final int hitPointFactor = 100;
    private int hitPoint;
    private int level;
    private int damage;
    private int defense;
    private int dodgeChance;

    public Monster() {
        super();
        this.level = 1;
        this.damage = 1;
        this.defense = 1;
        this.dodgeChance = 1;
        this.hitPoint = 1;
    }

    public Monster(String name, String id, int level, int damage, int defense, int dodgeChance) {
        super(name, id);
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.hitPoint = level * hitPointFactor;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public double calculateDodge() {
        return (dodgeChance * dodgeChanceFactor);
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public String attack(Hero hero) {
        String response = "";
        int noMore = 0;

        // Hero can dodge
        if (hero.getDodgeChance() >= getDamage()) {
            response = "Hero " + hero.getName() + " managed to dodge Monster " + getName() + "'s attack!";
        } else {
            int damageReduceAmount = hero.defend();

            if (damageReduceAmount < damage) {
                int reduceHitPoints = damage - damageReduceAmount;

                if (hero.getHitPoints() - reduceHitPoints <= 0) {
                    hero.setHitPoints(noMore);
                    response = "Hero " + hero.getName() + " has been defeated!";
                } else {
                    hero.setHitPoints(hero.getHitPoints() - reduceHitPoints);
                    response = "Hero " + hero.getName() + " was hit by Monster " + getName() + " and lost " + reduceHitPoints + " hitpoints!";
                }
            } else {
                response = "Hero " + hero.getName() + " has successfully defended against Monster " + getName() + "'s attack!";
            }
        }

        return response;
    }

    @Override
    public String toString() {
        return "Monster " + getName() + " :" +
                "\n\tlevel: " + level +
                "\n\tdamage: " + damage +
                "\n\tdefense: " + defense +
                "\n\tdodgeChance: " + dodgeChance;
    }
}
