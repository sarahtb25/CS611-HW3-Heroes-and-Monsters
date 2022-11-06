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
    public static final double revivalAlive = 1.1;
    public static final double revivalUnconscious = 0.5;
    private int hitPoints;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private int experience;
    private int experienceGained;
    private int numberOfTimesHeroDefeatedMonster;
    private List<EquippableItem> currentlyEquippedItems = new ArrayList<>();
    private Inventory inventory;

    public Hero() {
        super();
        this.mana = 1;
        this.strength = 1;
        this.agility = 1;
        this.dexterity = 1;
        this.money = 1;
        this.experience = 1;
        this.inventory = new Inventory();
        this.hitPoints = 100;
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

    public List<EquippableItem> getCurrentlyEquippedItems() {
        return currentlyEquippedItems;
    }

    public void setCurrentlyEquippedItems(List<EquippableItem> currentlyEquippedItems) {
        this.currentlyEquippedItems = currentlyEquippedItems;
    }

    public boolean checkIfHeroWearingAnItemType(EquippableItem item) {
        for (EquippableItem itemAlreadyOnHero : currentlyEquippedItems) {
            if ((itemAlreadyOnHero.getClass().equals(item.getClass()))) {
                return true;
            }
        }

        return false;
    }

    public EquippableItem getItemWornByHero(EquippableItem item) {
        for (EquippableItem itemAlreadyOnHero : currentlyEquippedItems) {
            if ((itemAlreadyOnHero.getClass().equals(item.getClass()))) {
                item =  itemAlreadyOnHero;
            }
        }

        return item;
    }
    public void wearAWeaponOrArmor(EquippableItem item) {
        currentlyEquippedItems.add(item);
        removeItemFromInventory(item);
    }

    public void removeItemFromInventory(EquippableItem item) {
        if (item instanceof Weapon) {
            inventory.removeWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            inventory.removeArmor((Armor) item);
        }
    }

    public void addItemToInventory(EquippableItem item) {
        if (item instanceof Weapon) {
            inventory.addWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            inventory.addArmor((Armor) item);
        }
    }

    public void replaceAWeaponOrArmor(EquippableItem item) {
        boolean isWearing = checkIfHeroWearingAnItemType(item);

        if (isWearing) {
            EquippableItem itemAlreadyOnHero = getItemWornByHero(item);
            removeAWeaponOrArmorFromBody(itemAlreadyOnHero);
            wearAWeaponOrArmor(item);
        } else {
            wearAWeaponOrArmor(item);
        }
    }

    public void removeAWeaponOrArmorFromBody(EquippableItem item) {
        currentlyEquippedItems.remove(item);
        addItemToInventory(item);
    }

    public String hit(Monster monster) {
        String response = "";
        int damage = 0;
        int noMore = 0;

        for (EquippableItem item : currentlyEquippedItems) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                damage = weapon.getDamage();
            }
        }

        if (damage > 0) {
            if (getAttackDamageWithWeapon(damage) <= monster.calculateDodge()) {
                response = "\nMonster " + monster.getName() + " managed to dodge Hero " + getName() + "'s attack!";
            } else {
                int damageReduceAmount = monster.getDefense();

                if (damageReduceAmount < getAttackDamageWithWeapon(damage)) {
                    int reduceHitPoints = (int) (getAttackDamageWithWeapon(damage) - damageReduceAmount);

                    if (monster.getHitPoint() - reduceHitPoints <= 0) {
                        monster.setHitPoint(noMore);
                        response = "\nMonster " + monster.getName() + " has been defeated!";
                    } else {
                        monster.setHitPoint(monster.getHitPoint() - reduceHitPoints);
                        response = "\nMonster " + monster.getName() + " was hit by Hero " + getName() + " and lost " + reduceHitPoints + " hitpoints!";
                    }
                } else {
                    response = "\nMonster " + monster.getName() + " has successfully defended against Hero " + getName() + "'s attack!";
                }
            }
        } else {
            response = "\n Hero is not equipped with a weapon!";
        }

        return response;
    }

    public int defend() {
        int damageReduceAmount = 0;

        for (EquippableItem item : currentlyEquippedItems) {
            if (item instanceof Armor) {
                Armor armor = (Armor) item;
                damageReduceAmount = armor.getDamageReduction();
            }
        }

        return damageReduceAmount;
    }

    public void drinkPotion(Potion potion) {
        potion.applyPotion(this);
    }

    public String castSpell(Spell spell, Monster monster) {
        String response = "";

        if (canUseSpell() && mana >= spell.getManaCost()) {
            response = spell.applySpell(this, monster);
        } else {
            response = "\n" + getName() + " has not enough mana! Unable to cast " + spell.getItemName();
        }

        return response;
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
        return experience * experienceLevelUpFactor;
    }

    // To be called after hero wins the battle
    public void updateExperienceGained() {
        experienceGained += numMonsterPerBattle * experienceGainedFactor;
        checkLevelUp();
    }

    public void levelUp() {
        hitPoints = hitPoints * hitPointFactor;
        mana = (int) (mana * manaLevelUpFactor);
        int prevExperience = experience;
        while (experienceGained >= experienceNeededToLevelUp()) {
            experienceGained -= experienceNeededToLevelUp();
            experience++;
        }

        levelUpSkills();

        System.out.println("Congratulations! Hero " + getName() + " has leveled up from " + prevExperience + " to " + experience + "!");
        System.out.println(this);
    }

    public void checkLevelUp() {
        if (experienceGained >= experienceNeededToLevelUp()) {
            levelUp();
        }
    }

    public double getDodgeChance() {
        return agility * dodgeChanceFactor;
    }

    public double getAttackDamageWithWeapon(int weapon_damage) {
        return ((strength + weapon_damage) * attackDamageWithWeapon);
    }

    public int getAttackDamageWithSpell(int spell_base_damage) {
        return (int) (spell_base_damage + (dexterity * attackDamageWithSpell * spell_base_damage));
    }

    // To be called after hero wins the battle
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
        if (cost > money || experience < requiredLevel) return false;

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

    // To be called if more heroes win the battle against the monsters i.e. monsters defeated >= (int) number of heroes/2
    public void revive(int startingHP, int startingMana) {
        if (isUnconscious()) {
            setHitPoints((int) (startingHP * revivalUnconscious));
            setMana((int) (startingMana * revivalUnconscious));
        } else {
            setHitPoints((int) (startingHP * revivalAlive));
            setMana((int) (startingMana * revivalAlive));
        }
    }

    public void printHero() {
        System.out.print("\nHero " + getName() + " :" +
                            "\n\tHit Points:"  + hitPoints +
                            "\n\tMana: " + mana +
                            "\n\tStrength: " + strength +
                            "\n\tAgility: " + agility +
                            "\n\tDexterity: " + dexterity +
                            "\n\tMoney: " + money +
                            "\n\tExperience: " + experience +
                            "\n\tExperience Gained: " + experienceGained + " / " + experienceNeededToLevelUp() +
                            "\n\tCurrently Equipped Items: ");

        printCurrentlyEquippedItems();
        System.out.println("\n\tInventory: ");
        inventory.printInventory();
    }

    public void printCurrentlyEquippedItems() {
        if (currentlyEquippedItems.isEmpty()) {
            System.out.print("None");
        } else {
            MHUtility utility = new MHUtility();

            System.out.println("\n#########################################################################################\n");
            System.out.println("|                                   Currently Equipped Items                              |\n");
            System.out.println("#########################################################################################\n");

            List<Weapon> weapons = new ArrayList<>();
            List<Armor> armors = new ArrayList<>();
            for (EquippableItem item : currentlyEquippedItems) {
                if (item instanceof Weapon) {
                    weapons.add((Weapon) item);
                } else if (item instanceof Armor) {
                    armors.add((Armor) item);
                }
            }
            utility.printWeapons(weapons);
            utility.printArmors(armors);
        }
    }
}
