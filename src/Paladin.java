// Represents a paladin
public class Paladin extends Hero {
    public Paladin(String name, String id, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, id, mana, strength, agility, dexterity, money, experience, inventory);
    }

    @Override
    public void levelUpSkills() {
        setStrength((int) (favouredSkillsLevelUpRate * getStrength()));
        setAgility((int) (levelUpRate * getAgility()));
        setDexterity((int) (favouredSkillsLevelUpRate * getDexterity()));
    }
}
