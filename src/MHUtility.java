import java.util.List;

// Contains methods that are used across different classes in the game
public class MHUtility implements Utility{

    public MHUtility() {}

    @Override
    public boolean checkValidUserResponse(String userResponse) {
        return (userResponse.equals("w") || userResponse.equals("a") || userResponse.equals("s") || userResponse.equals("d") || userResponse.equals("q") || userResponse.equals("h") || userResponse.equals("r") || userResponse.equals("i") || userResponse.equals("m") || userResponse.equals("view map") || userResponse.contains(" inventory") || userResponse.contains(" drink ") || userResponse.contains("hero ") || userResponse.equals("regenerate map") || userResponse.contains(" change "));
    }

    public boolean checkIsNumber(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void printWeapons(List<Weapon> weapons) {
        if (!weapons.isEmpty()) {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("|                                   WEAPONS                                                 |");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%12s %12s %12s %12s %12s %12s", "ID", "NAME", "COST", "LEVEL", "HANDS", "DAMAGE");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");

            for (Weapon weapon : weapons) {
                System.out.format("%12s %13s %11s %10s %12s %13s", weapon.getId(), weapon.getItemName(), weapon.getCost(), weapon.getRequiredLevel(), weapon.getNumberOfHandsRequired(), weapon.getDamage());
                System.out.println();
            }

            System.out.println("----------------------------------------------------------------------------------------------");
        }
    }

    public void printArmors(List<Armor> armors) {
        if (!armors.isEmpty()) {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("|                                   ARMORS                                                  |");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%12s %12s %20s %10s %20s", "ID", "NAME", "COST", "LEVEL", "DAMAGE REDUCTION");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");

            for (Armor armor : armors) {
                System.out.format("%12s %20s %11s %10s %15s", armor.getId(), armor.getItemName(), armor.getCost(), armor.getRequiredLevel(), armor.getDamageReduction());
                System.out.println();
            }

            System.out.println("----------------------------------------------------------------------------------------------");
        }
    }

    public void printPotions(List<Potion> potions) {
        if(!potions.isEmpty()) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|                                                           POTIONS                                                               |");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %15s %12s %9s %20s %20s %40s", "ID", "NAME", "COST", "LEVEL", "# OF CONSUMPTIONS", "INCREASE AMOUNT", "ATTRIBUTES");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

            for (Potion potion : potions) {
                System.out.format("%5s %20s %7s %7s %13s %24s %45s", potion.getId(), potion.getItemName(), potion.getCost(), potion.getRequiredLevel(), potion.getNumberOfConsumptions(), potion.getAttributeIncrease(), potion.getAttributesAffected().toString().replace("[", "").replace("]", ""));
                System.out.println();
            }

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void printSpells(List<Spell> spells) {
        if (!spells.isEmpty()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|                                                             SPELLS                                                               |");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%7s %17s %18s %13s %14s %9s %25s %14s", "ID", "TYPE", "NAME", "COST", "MANA COST", "LEVEL", "# OF CONSUMPTIONS", "DAMAGE");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

            for (Spell spell : spells) {
                String typeOfSpell = "";

                if (spell instanceof FireSpell) {
                    typeOfSpell = "Fire";
                } else if (spell instanceof IceSpell) {
                    typeOfSpell = "Ice";
                } else if (spell instanceof LightningSpell) {
                    typeOfSpell = "Lightning";
                }

                System.out.format("%7s %15s %23s %9s %10s %12s %19s %20s", spell.getId(), typeOfSpell, spell.getItemName(), spell.getCost(), spell.getManaCost(), spell.getRequiredLevel(), spell.getNumberOfConsumptions(), spell.getDamage());
                System.out.println();
            }

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
