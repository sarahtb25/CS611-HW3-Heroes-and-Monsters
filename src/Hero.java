import java.util.ArrayList;
import java.util.List;

// This class represents a hero
public class Hero extends NonPlayerCharacter {
    public static final double levelUpRate = 1.05;
    public static final double favouredSkillsLevelUpRate = 1.10;
    public static final int experienceLevelUpFactor = 10;
    public static final double manaLevelUpFactor = 1.1;
    public static final int experienceGainedFactor = 2;
    public static final int hitPointFactor = 100;
    public static final double dodgeChanceFactor = 0.2;
    public static final double attackDamageWithWeapon = 0.5;
    public static final double attackDamageWithSpell = 0.0001;
    public static final int levelUpMoneyFactor = 100;
    public static final int numMonsterPerBattle = 1;
    private int hitPoints;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private int experience;
    private int experienceGained;
    private int numberOfTimesHeroDefeatedMonster;
    private List<Item> currentlyEquippedItems = new ArrayList<>();
    private Inventory inventory;

    public Hero() {
        super();
    }

    public Hero(String name, String id, int mana, int strength, int agility, int dexterity, int money, int experience, Inventory inventory) {
        super(name, id);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = money;
        this.experience = experience;
        this.inventory = inventory;
        this.hitPoints = experience * hitPointFactor;
        this.experienceGained = 0;
        numberOfTimesHeroDefeatedMonster = 0;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getExperienceGained() {
        return experienceGained;
    }

    public void setExperienceGained(int experienceGained) {
        this.experienceGained = experienceGained;
    }

    public List<Item> getCurrentlyEquippedItems() {
        return currentlyEquippedItems;
    }

    public void setCurrentlyEquippedItems(List<Item> currentlyEquippedItems) {
        this.currentlyEquippedItems = currentlyEquippedItems;
    }

    public boolean checkIfHeroWearingAnItemType(Item item) {
        for (Item itemAlreadyOnHero : currentlyEquippedItems) {
            if ((itemAlreadyOnHero instanceof Weapon && item instanceof Weapon) || (itemAlreadyOnHero instanceof Armor && item instanceof Armor)) {
                return true;
            }
        }

        return false;
    }

    public Item getItemWornByHero(Item item) {
        Item itemWanted ;

        for (Item itemAlreadyOnHero : currentlyEquippedItems) {
            if ((itemAlreadyOnHero instanceof Weapon && item instanceof Weapon) || (itemAlreadyOnHero instanceof Armor && item instanceof Armor)) {
                item =  itemAlreadyOnHero;
            }
        }

        return item;
    }
    public void wearAWeaponOrArmor(Item item) {
        currentlyEquippedItems.add(item);
        removeItemFromInventory(item);
    }

    public void removeItemFromInventory(Item item) {
        if (item instanceof Weapon) {
            inventory.removeWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            inventory.removeArmor((Armor) item);
        }
    }

    public void addItemToInventory(Item item) {
        if (item instanceof Weapon) {
            inventory.addWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            inventory.addArmor((Armor) item);
        }
    }

    public void replaceAWeaponOrArmor(Item item) {
        boolean isWearing = checkIfHeroWearingAnItemType(item);

        if (isWearing) {
            Item itemAlreadyOnHero = getItemWornByHero(item);
            removeAWeaponOrArmorFromBody(itemAlreadyOnHero);
            wearAWeaponOrArmor(item);
        } else {
            wearAWeaponOrArmor(item);
        }
    }

    public void removeAWeaponOrArmorFromBody(Item item) {
        currentlyEquippedItems.remove(item);
        addItemToInventory(item);
    }

    public void drinkPotion(Potion potion) {
        potion.applyPotion(this);
    }

    public void useSpell(Spell spell, Monster monster) {
        spell.applySpell(this, monster);
    }

    public int getNumberOfTimesHeroDefeatedMonster() {
        return numberOfTimesHeroDefeatedMonster;
    }

    public void setNumberOfTimesHeroDefeatedMonster(int numberOfTimesHeroDefeatedMonster) {
        this.numberOfTimesHeroDefeatedMonster = numberOfTimesHeroDefeatedMonster;
    }

    // one-on-one battle, so if hero wins against a monster in a battle, increment this
    public void updateNumberOfTimesHeroDefeatedMonster() {
        numberOfTimesHeroDefeatedMonster++;
    }

    public void levelUpSkills() {
        strength = (int) (levelUpRate * strength);
        agility = (int) (levelUpRate * agility);
        dexterity = (int) (levelUpRate * dexterity);
    }

    public int experienceNeededToLevelUp() {
        int exp_points = experience * experienceLevelUpFactor;

        return exp_points;
    }

    public void updateExperienceGained(int monsterLevel) {
        experienceGained += numMonsterPerBattle * experienceGainedFactor;
        checkLevelUp(monsterLevel);
    }

    public void levelUp(int monsterLevel) {
        hitPoints = hitPoints * hitPointFactor;
        mana = (int) (mana * manaLevelUpFactor);
        int prevExperience = experience;
        while (experienceGained >= experienceNeededToLevelUp()) {
            experienceGained -= experienceNeededToLevelUp();
            experience++;
        }

        levelUpSkills();
        updateMoneyAfterBattle(monsterLevel);

        System.out.println("Congratulations! Hero " + getName() + " has leveled up from " + prevExperience + " to " + experience + "!");
        System.out.println(this);
    }

    public void checkLevelUp(int monsterLevel) {
        if (experienceGained >= experienceNeededToLevelUp()) {
            levelUp(monsterLevel);
        }
    }

    public double getDodgeChance() {
        return agility * dodgeChanceFactor;
    }

    public double getAttackDamageWithWeapon(int weapon_damage) {
        return ((strength + weapon_damage) * attackDamageWithWeapon);
    }

    public double getAttackDamageWithSpell(int spell_base_damage) {
        return (spell_base_damage + (dexterity * attackDamageWithSpell * spell_base_damage));
    }

    public void updateMoneyAfterBattle(int monsterLevel) {
        if (hitPoints > 0) {
            money += monsterLevel * levelUpMoneyFactor;
        }
    }

    public void updateMoneyAfterBuyingItems(int cost) {
        money -= cost;
    }

    // Consumable items (potions and spells) cannot be sold
    public void updateMoneyAfterSellingItems(int price) {
        money += price;
    }

    public boolean checkMoneyAndLevelToBuyItem(int cost, int requiredLevel) {
        if (cost > money && experience < requiredLevel) return false;

        return true;
    }

    // During battle, if spells are used against a monster
    public void updateManaCost(int manaCost) {
        mana -= manaCost;
    }

    public boolean isUnconscious() {
        if (hitPoints <= 0) {
            return true;
        }

        return false;
    }

    public boolean canUseSpell() {
        if (mana <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Hero " + getName() + " :" +
                "\n\tHit Points:"  + hitPoints +
                "\n\tMana: " + mana +
                "\n\tStrength: " + strength +
                "\n\tAgility: " + agility +
                "\n\tDexterity: " + dexterity +
                "\n\tMoney: " + money +
                "\n\tExperience: " + experience +
                "\n\tExperience Gained: " + experienceGained + "/" + experienceNeededToLevelUp() +
                "\n\tCurrently Equipped Items: " + currentlyEquippedItems +
                "\n\tinventory: " + inventory;
    }
}
