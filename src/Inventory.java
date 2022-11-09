import java.util.ArrayList;
import java.util.List;

// Represents a hero's inventory, which keeps track of the weapons, armors, potions and spells a hero has
public class Inventory {
    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Potion> potions;
    private List<Spell> spells;

    public Inventory() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        potions = new ArrayList<>();
        spells = new ArrayList<>();
    }
    
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
        weapons.add(new Weapon(weapon));
    }

    public void addArmor(Armor armor) {
        armors.add(new Armor(armor));
    }

    // Potions and Spells are consumable items and cannot be sold
    public void addPotion(Potion potion) {
        potions.add(new Potion(potion));
    }

    public void addSpell(Spell spell) {
        if (spell instanceof FireSpell) {
            spells.add(new FireSpell((FireSpell)spell));
        } else if (spell instanceof LightningSpell) {
            spells.add(new LightningSpell((LightningSpell) spell));
        } else if (spell instanceof IceSpell) {
            spells.add(new IceSpell((IceSpell) spell));
        }
    }

    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }

    public void removeArmor(Armor armor) {
        armors.remove(armor);
    }

    public void removePotion() {
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i).getNumberOfConsumptions() == 0) {
                potions.remove(potions.get(i));
            }
        }
    }

    public void removeSpell() {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getNumberOfConsumptions() == 0) {
                spells.remove(spells.get(i));
            }
        }
    }

    public Spell getSpellFromId(String id) {
        Spell spellWanted = new Spell();

        for (Spell spell : spells) {
            if (spell.getId().equals(id)) {
                spellWanted = spell;
                break;
            }
        }

        return spellWanted;
    }

    public Potion getPotionFromId(String id) {
        Potion potionWanted = new Potion();

        for (Potion potion : potions) {
            if (potion.getId().equals(id)) {
                potionWanted = potion;
                break;
            }
        }

        return potionWanted;
    }

    public Weapon getWeaponFromId(String id) {
        Weapon weaponWanted = new Weapon();

        for (Weapon weapon : weapons) {
            if (weapon.getId().equals(id)) {
                weaponWanted = weapon;
                break;
            }
        }

        return weaponWanted;
    }

    public Armor getArmorFromId(String id) {
        Armor armorWanted = new Armor();

        for (Armor armor : armors) {
            if (armor.getId().equals(id)) {
                armorWanted = armor;
                break;
            }
        }

        return armorWanted;
    }

    public EquippableItem getEquippableItemFromId(String id) {
        if (checkIfWeaponExists(id)) {
            return (EquippableItem) getWeaponFromId(id);
        } else if (checkIfArmorExists(id)) {
            return (EquippableItem) getArmorFromId(id);
        }

        return new EquippableItem();
    }

    public boolean checkIfPotionExists(String potionId) {
        for (Potion potion : potions) {
            if (potion.getId().equals(potionId)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfSpellExists(String spellId) {
        for (Spell spell : spells) {
            if (spell.getId().equals(spellId)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfItemExists(String itemId) {
        if(checkIfWeaponExists(itemId) || checkIfArmorExists(itemId) || checkIfPotionExists(itemId) || checkIfSpellExists(itemId)) {
            return true;
        }

        return false;
    }

    public boolean checkIfWeaponExists(String weaponId) {
        for (Weapon weapon : weapons) {
            if (weapon.getId().equals(weaponId)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfArmorExists(String armorId) {
        for (Armor armor : armors) {
            if (armor.getId().equals(armorId)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfEquippableItemExists(String itemId) {
        if (checkIfWeaponExists(itemId) || checkIfArmorExists(itemId)) {
            return true;
        }

        return false;
    }

    public void printInventory() {
        MHUtility utility = new MHUtility();

        if (weapons.isEmpty() && armors.isEmpty() && spells.isEmpty() && potions.isEmpty()) {
            System.out.print("None");
        } else {
            System.out.println("\n#########################################################################################\n");
            System.out.println("|                                        Inventory                                      |\n");
            System.out.println("#########################################################################################\n");
            System.out.println();
            utility.printWeapons(weapons);
            System.out.println("\n\n");
            utility.printArmors(armors);
            System.out.println("\n\n");
            utility.printPotions(potions);
            System.out.println("\n\n");
            utility.printSpells(spells);
        }
    }


}
