import java.util.List;

// Represents a potion
public class Potion extends ConsumableItem {
    private int attributeIncrease;
    private List<String> attributesAffected;

    public Potion() {}

    public Potion(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions, int attributeIncrease, List<String> attributesAffected) {
        super(itemName, id, cost, requiredLevel, numberOfConsumptions);
        this.attributeIncrease = attributeIncrease;
        this.attributesAffected = attributesAffected;
    }

    public int getAttributeIncrease() {
        return attributeIncrease;
    }

    public void setAttributeIncrease(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public List<String> getAttributesAffected() {
        return attributesAffected;
    }

    public void setAttributesAffected(List<String> attributesAffected) {
        this.attributesAffected = attributesAffected;
    }
    
    public void impactOfPotion(Hero hero) {
        for (int i = 0; i < attributesAffected.size(); i++) {
            if (attributesAffected.get(i) == "health") hero.setHitPoints(hero.getHitPoints() + attributeIncrease);
            else if (attributesAffected.get(i) == "mana") hero.setMana(hero.getMana() + attributeIncrease);
            else if (attributesAffected.get(i) == "strength") hero.setStrength(hero.getStrength() + attributeIncrease);
            else if (attributesAffected.get(i) == "dexterity") hero.setDexterity(hero.getDexterity() + attributeIncrease);
            else if (attributesAffected.get(i) == "agility") hero.setAgility(hero.getAgility() + attributeIncrease);
        }
    }
}
