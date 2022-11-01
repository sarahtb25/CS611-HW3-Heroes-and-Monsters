// Represents an item that a hero can use in battle, e.g. weapon, armor, spell and potion
public class Item {
    private String itemName;
    private String id;
    private int cost;
    private int requiredLevel;

    public Item() {}
    public Item(String itemName, String id, int cost, int requiredLevel) {
        this.itemName = itemName;
        this.id = id;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
