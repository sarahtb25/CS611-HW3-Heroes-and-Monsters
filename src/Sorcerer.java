// Represents a sorcerer
public class Sorcerer extends Hero {
    public Sorcerer(String name, String id, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, id, mana, strength, agility, dexterity, money, experience, inventory);
    }

    @Override
    public void levelUpSkills() {
        setStrength((int) (LEVEL_UP_RATE * getStrength()));
        setAgility((int) (FAVOURED_SKILLS_LEVEL_UP_RATE * getAgility()));
        setDexterity((int) (FAVOURED_SKILLS_LEVEL_UP_RATE * getDexterity()));
    }
}
