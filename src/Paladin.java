// Represents a paladin
public class Paladin extends Hero {
    public Paladin(String name, String id, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, id, mana, strength, agility, dexterity, money, experience, inventory);
    }

    @Override
    public void levelUpSkills() {
        setStrength((int) (FAVOURED_SKILLS_LEVEL_UP_RATE * getStrength()));
        setAgility((int) (LEVEL_UP_RATE * getAgility()));
        setDexterity((int) (FAVOURED_SKILLS_LEVEL_UP_RATE * getDexterity()));
    }
}
