import java.util.List;

// An interface that contains the expected behaviour for all item factories e.g. WeaponFactory, etc.
public interface ItemFactory<T extends Item> {
    void generateItems();
    List<T> getItems();
    void printItems();
    T getItemFromId(String id);
    boolean checkItemExists(String id);
}
