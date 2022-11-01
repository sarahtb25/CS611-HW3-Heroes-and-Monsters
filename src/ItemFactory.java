import java.util.List;

// Expected behaviour for all item factories e.g. WeaponFactory, etc.
public interface ItemFactory<T extends Item> {
    void generateItems();
    List<T> getItems();
    void printItems();
    T getItemFromId(String id);
}
