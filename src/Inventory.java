import java.util.List;

// Represents a player's inventory
public class Inventory {
    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Potion> potions;
    private List<Spell> spells;

    public Inventory(List<Weapon> weapons, List<Armor> armors, List<Potion> potions, List<Spell> spells) {
        this.weapons = weapons;
        this.armors = armors;
        this.potions = potions;
        this.spells = spells;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void addArmor(Armor armor) {
        armors.add(armor);
    }

    // Potions and Spells are consumable items and cannot be sold
    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }

    public void removeArmor(Armor armor) {
        armors.remove(armor);
    }

    @Override
    public String toString() {
        return  "------------\n" +
                "| Inventory |\n" +
                "------------" +
                "\n\tWeapons: \n" + weapons +
                "\n\tArmors: \n" + armors +
                "\n\tPotions: \n" + potions +
                "\n\tSpells: \n" + spells;
    }
}
