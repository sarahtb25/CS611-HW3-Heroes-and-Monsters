import java.util.Scanner;

// Represents a market
public class Market {
    public static final double sellItemFactor = 0.5;
    public static final MHHelp help = new MHHelp();
    private final WeaponFactory wf = new WeaponFactory();
    private final ArmorFactory af = new ArmorFactory();
    private final PotionFactory pf = new PotionFactory();
    private final SpellFactory sf = new SpellFactory();

    public Market() {}

    public void printHelp() {
        help.printHelpMarket();
    }

    public void printRules() {
        help.printRulesMarket();
    }

    public String getUserInput(MHPlayer player) {
        String userInput = "";
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        String itemId = "", heroId = "";
        Hero hero;

        printMarketMenu();
        printHelp();

        while(!userInput.equals("x") && !userInput.equals("q")) {
            System.out.println();
            System.out.println("\nPlease provide a valid market command:");
            userInput = scan.next().trim().toLowerCase();

            if (userInput.contains(" buy ") || userInput.contains(" sell ")) {
                heroId = userInput.split(" ")[0].toUpperCase();
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
            } else if (userInput.equals("h")) {
                printHelp();
            } else if (userInput.equals("r")) {
                printRules();
            } else if (userInput.contains("hero ")) {
                heroId = userInput.split(" ")[1].toUpperCase();

                if (player.getHeroes().checkIfHeroExists(heroId)) {
                    hero = player.getHeroes().getHeroFromId(heroId);

                    hero.printHero();
                } else {
                    System.out.println("You do not have Hero " + heroId.toUpperCase() + "!");
                }
            } else if (!userInput.equals("x") && !userInput.equals("q")){
                System.out.println(userInput);
                System.out.println("\nInvalid Input!");
            }
        }

        return userInput;
    }

    public void printMarketMenu() {
        System.out.println("#############################################################################################");
        System.out.println("|                                   MARKET                                                  |");
        System.out.println("#############################################################################################");
        System.out.println("\n\n");
        wf.printItems();
        System.out.println("\n\n");
        af.printItems();
        System.out.println("\n\n");
        pf.printItems();
        System.out.println("\n\n");
        sf.printItems();
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
            weapon = wf.getItemFromId(itemId);
            cost = weapon.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, weapon.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addWeapon(weapon);
                hero.updateMoneyAfterBuyingItems(cost);
            } else {
                System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this weapon!");
            }
        } else if (itemId.contains("E")) {
            armor = af.getItemFromId(itemId);
            cost = armor.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, armor.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addArmor(armor);
                hero.updateMoneyAfterBuyingItems(cost);
            } else {
                System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this armor!");
            }
        } else if (itemId.contains("F") || itemId.contains("C") || itemId.contains("L")) {
            spell = sf.getItemFromId(itemId);
            cost = spell.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, spell.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addSpell(spell);
                hero.updateMoneyAfterBuyingItems(cost);
            } else {
                System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this spell!");
            }
        } else if (itemId.contains("P")) {
            potion = pf.getItemFromId(itemId);
            cost = potion.getCost();
            canBuy = hero.checkMoneyAndLevelToBuyItem(cost, potion.getRequiredLevel());

            if (canBuy) {
                hero.getInventory().addPotion(potion);
                hero.updateMoneyAfterBuyingItems(cost);
            } else {
                System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this potion!");
            }
        }
    }

    public void sellItem(Hero hero, String itemId) {
        int cost;

        if (itemId.contains("B")) {
            boolean weaponExists = hero.getInventory().checkIfWeaponExists(itemId);

            if (weaponExists) {
                Weapon weapon = hero.getInventory().getWeaponFromId(itemId);
                cost = weapon.getCost();

                hero.getInventory().removeWeapon(weapon);
                hero.updateMoneyAfterSellingItems((int) (cost * sellItemFactor));
            } else {
                System.out.println("Hero " + hero.getName() + " does not have weapon " + itemId + "!");
            }
        } else if (itemId.contains("E")) {
            boolean armorExists = hero.getInventory().checkIfArmorExists(itemId);

            if (armorExists) {
                Armor armor = hero.getInventory().getArmorFromId(itemId);
                cost = armor.getCost();

                hero.getInventory().removeArmor(armor);
                hero.updateMoneyAfterSellingItems((int) (cost * sellItemFactor));
            } else {
                System.out.println("Hero " + hero.getName() + " does not have armor " + itemId + "!");
            }
        } else {
            System.out.println("Potions and Spells are consumable items, which cannot be sold once bought!");
        }
    }
}
