// Represents items that can be worn or carried, such as a weapon or an armor
public class EquippableItem extends Item {
    public EquippableItem() {
    }

    public EquippableItem(String itemName, String id, int cost, int requiredLevel) {
        super(itemName, id, cost, requiredLevel);
    }
}
