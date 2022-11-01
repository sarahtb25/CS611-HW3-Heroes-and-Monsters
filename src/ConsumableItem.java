/* Represents an item that can be consumed, such as a potion or a spell
   Consumable items cannot be sold
 */
public class ConsumableItem extends Item {
    private int numberOfConsumptions;

    public ConsumableItem() {}

    public ConsumableItem(String itemName, String id, int cost, int requiredLevel, int numberOfConsumptions) {
        super(itemName, id, cost, requiredLevel);
        this.numberOfConsumptions = numberOfConsumptions;
    }

    public int getnumberOfConsumptions() {
        return numberOfConsumptions;
    }

    public void setnumberOfConsumptions(int numberOfConsumptions) {
        this.numberOfConsumptions = numberOfConsumptions;
    }

    // Reduce the number of times a consumable item can be consumed after using it each time
    public void consume() {
        numberOfConsumptions--;
    }
}
