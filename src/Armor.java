public class Armor extends Item {
    private int damageReduction;

    public Armor(String itemName, String id, int cost, int requiredLevel, int damageReduction) {
        super(itemName, id, cost, requiredLevel);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }
}
