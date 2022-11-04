public class Armor extends EquippableItem {
    private int damageReduction;

    public Armor() {}

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
