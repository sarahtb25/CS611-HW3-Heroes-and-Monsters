import java.util.Scanner;

// Represents a market
public class Market {
    public static final double sellItemFactor = 0.5;
    private final WeaponFactory wf = new WeaponFactory();
    private final ArmorFactory af = new ArmorFactory();
    private final PotionFactory pf = new PotionFactory();
    private final SpellFactory sf = new SpellFactory();

    public Market() {}

    public String getUserInput(MHPlayer player) {
        String userInput = "";
        Scanner scan = new Scanner(System.in);
        String itemId = "", heroId = "";
        Hero hero;

        while(!userInput.equals("x") || !userInput.equals("q")) {
            String instructions = "To Buy an item, enter Hero ID for a hero you have " +
                    "Buy followed by the item ID e.g. R0 Buy B0.\n" +
                    "To Sell an item, enter Hero ID for a hero you have " +
                    "Sell followed by the item ID e.g. R0 Sell B0.\n" +
                    "To view the items in the market, enter View Market.\n" +
                    "To view the heroes you have, enter View Heroes.";

            System.out.println(instructions);
            userInput = scan.next().trim().toLowerCase();

            if (userInput.contains(" buy ") || userInput.contains(" sell ")) {
                heroId = userInput.split(" ")[0];
                itemId = userInput.split(" ")[2];

                if (player.getHeroes().checkIfHeroExists(heroId)) {
                    hero = player.getHeroes().getHeroFromId(heroId);

                    if (userInput.contains(" buy ")) {
                        buyItem(hero, itemId.toUpperCase());
                    } else {
                        sellItem(hero, itemId.toUpperCase());
                    }
                } else {
                    System.out.println("You do not have Hero " + heroId + "!");
                }
            } else if (userInput.equals("view market")) {
                printMarketMenu();
            } else if (userInput.equals("view heroes")) {
                player.getHeroes().printHeroes();
            } else if (!userInput.equals("x") || !userInput.equals("q")){
                System.out.println("Invalid Input!");
            }
        }

        return userInput;
    }

    public void printMarketMenu() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                                   MARKET                                                  |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("\n\n");
        wf.printWeapons();
        System.out.println("\n\n");
        af.printArmors();
        System.out.println("\n\n");
        pf.printPotions();
        System.out.println("\n\n");
        sf.printSpells();
        System.out.println("\n\n");
    }

    public void buyItem(Hero hero, String itemId) {
        Weapon weapon;
        Armor armor;
        Potion potion;
        Spell spell;
        boolean canBuy = false;
        int cost = 0;

        if (itemId.contains("B")) {
            weapon = wf.getWeaponFromId(itemId);
            cost = weapon.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, weapon.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addWeapon(weapon);
            }
        } else if (itemId.contains("E")) {
            armor = af.getArmorFromId(itemId);
            cost = armor.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, armor.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addArmor(armor);
            }
        } else if (itemId.contains("F") || itemId.contains("C") || itemId.contains("L")) {
            spell = sf.getSpellFromId(itemId);
            cost = spell.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, spell.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addSpell(spell);
            }
        } else if (itemId.contains("P")) {
            potion = pf.getPotionFromId(itemId);
            cost = potion.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, potion.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addPotion(potion);
            }
        }

        hero.updateMoneyAfterBuyingItems(cost);
    }

    public void sellItem(Hero hero, String itemId) {
        Weapon weapon;
        Armor armor;
        int cost = 0;

        if (itemId.contains("B")) {
            weapon = wf.getWeaponFromId(itemId);
            cost = weapon.getCost();

            hero.getInventory().removeWeapon(weapon);
            hero.updateMoneyAfterSellingItems((int) (cost * sellItemFactor));
        } else if (itemId.contains("E")) {
            armor = af.getArmorFromId(itemId);
            cost = armor.getCost();

            hero.getInventory().removeArmor(armor);
            hero.updateMoneyAfterSellingItems((int) (cost * sellItemFactor));
        } else {
            System.out.println("Potions and Spells are consumable items, which cannot be sold once bought!");
        }
    }
}
