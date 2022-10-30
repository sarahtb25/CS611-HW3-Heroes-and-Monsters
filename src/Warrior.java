public class Warrior extends Hero {
    public Warrior(String name, String id, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, id, mana, strength, agility, dexterity, money, experience, inventory);
    }

    @Override
    public void levelUpSkills() {
        setStrength((int) (favouredSkillsLevelUpRate * getStrength()));
        setAgility((int) (favouredSkillsLevelUpRate * getAgility()));
        setDexterity((int) (levelUpRate * getDexterity()));
    }
}
