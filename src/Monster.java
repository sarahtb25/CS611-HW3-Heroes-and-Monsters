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

    @Override
    public String toString() {
        return "Monster " + getName() + " :" +
                "\n\tlevel: " + level +
                "\n\tdamage: " + damage +
                "\n\tdefense: " + defense +
                "\n\tdodgeChance: " + dodgeChance;
    }
}
