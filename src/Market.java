import java.util.Scanner;

// Represents a market
public class Market {
    public static final double SELL_ITEM_FACTOR = 0.5;
    private final MHHelp help = new MHHelp();
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

        printMarketMenu();
        printHelp();

        while(!userInput.equals("x") && !userInput.equals("q")) {
            System.out.println();
            System.out.println(ConsoleColours.GREEN + "\n[INPUT] Please provide a valid market command:" + ConsoleColours.RESET);
            userInput = scan.next().trim().toLowerCase();

            if (userInput.contains(" buy ") || userInput.contains(" sell ")) {
                heroId = userInput.split(" ")[0].toUpperCase();
                itemId = userInput.split(" ")[2].toUpperCase();

                if (player.getHeroes().checkIfHeroExists(heroId)) {
                    Hero hero = player.getHeroes().getHeroFromId(heroId);

                    if (userInput.contains(" buy ")) {
                        if (itemId.contains(",")) {
                            String[] itemIds = itemId.split(",");

                            for (int i = 0; i < itemIds.length; i++) {
                                buyItem(hero, itemIds[i]);
                            }
                        } else {
                            buyItem(hero, itemId);
                        }
                    } else {
                        if (itemId.contains(",")) {
                            String[] itemIds = itemId.split(",");

                            for (int i = 0; i < itemIds.length; i++) {
                                sellItem(hero, itemIds[i]);
                            }
                        } else {
                            sellItem(hero, itemId);
                        }
                    }
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] You do not have Hero " + heroId + "!" + ConsoleColours.RESET);
                }
            } else if (userInput.equals("view market")) {
                printMarketMenu();
            } else if (userInput.equals("i")) {
                player.getHeroes().printHeroes();
            } else if (userInput.equals("h")) {
                printHelp();
            } else if (userInput.equals("r")) {
                printRules();
            } else if (userInput.contains("hero ")) {
                heroId = userInput.split(" ")[1].toUpperCase();

                if (player.getHeroes().checkIfHeroExists(heroId)) {
                    Hero hero = player.getHeroes().getHeroFromId(heroId);
                    hero.printHero();
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] You do not have Hero " + heroId.toUpperCase() + "!" + ConsoleColours.RESET);
                }
            } else if (!userInput.equals("x") && !userInput.equals("q")){
                System.out.println(ConsoleColours.RED + "\n[ERROR] Invalid Input!" + ConsoleColours.RESET);
            }
        }

        return userInput;
    }

    public void printMarketMenu() {
        System.out.println("\n#############################################################################################");
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
        boolean canBuy;
        boolean doNotHave = hero.checkItemNotPresent(itemId);
        int cost;

        if (doNotHave) {
            if (itemId.contains("B")) {
                if (wf.checkItemExists(itemId)) {
                    weapon = wf.getItemFromId(itemId);
                    cost = weapon.getCost();
                    canBuy = hero.checkMoneyAndLevelToBuyItem(cost, weapon.getRequiredLevel());

                    if (canBuy) {
                        hero.getInventory().addWeapon(weapon);
                        hero.updateMoneyAfterBuyingItems(cost);
                        System.out.println(ConsoleColours.CYAN + "\n[MARKET MESSAGE] Added weapon " + itemId + " to hero " + hero.getId() + "'s inventory" + ConsoleColours.RESET);
                    } else {
                        System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getId() + " has either not enough money or not enough experience to buy weapon " + itemId + "!" + ConsoleColours.RESET);
                    }
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] Weapon " + itemId + " does not exist!" + ConsoleColours.RESET);
                }
            } else if (itemId.contains("E")) {
                if (af.checkItemExists(itemId)) {
                    armor = af.getItemFromId(itemId);
                    cost = armor.getCost();
                    canBuy = hero.checkMoneyAndLevelToBuyItem(cost, armor.getRequiredLevel());

                    if (canBuy) {
                        hero.getInventory().addArmor(armor);
                        hero.updateMoneyAfterBuyingItems(cost);
                        System.out.println(ConsoleColours.GREEN + "\n[MARKET MESSAGE] Added armor " + itemId + " to hero " + hero.getId() + "'s inventory" + ConsoleColours.RESET);
                    } else {
                        System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getId() + " has either not enough money or not enough experience to buy this armor " + itemId + "!" + ConsoleColours.RESET);
                    }
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] Armor " + itemId + " does not exist!" + ConsoleColours.RESET);
                }
            } else if (itemId.contains("F") || itemId.contains("C") || itemId.contains("L")) {
                if (sf.checkItemExists(itemId)) {
                    spell = sf.getItemFromId(itemId);
                    cost = spell.getCost();
                    canBuy = hero.checkMoneyAndLevelToBuyItem(cost, spell.getRequiredLevel());

                    if (canBuy) {
                        hero.getInventory().addSpell(spell);
                        hero.updateMoneyAfterBuyingItems(cost);
                        System.out.println("\n[MARKET MESSAGE] Added spell " + itemId + " to hero " + hero.getId() + "'s inventory");
                    } else {
                        System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getId() + " has either not enough money or not enough experience to buy this spell " + itemId + "!" + ConsoleColours.RESET);
                    }
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] Spell " + itemId + " does not exist!" + ConsoleColours.RESET);
                }
            } else if (itemId.contains("P")) {
                if (pf.checkItemExists(itemId)) {
                    potion = pf.getItemFromId(itemId);
                    cost = potion.getCost();
                    canBuy = hero.checkMoneyAndLevelToBuyItem(cost, potion.getRequiredLevel());

                    if (canBuy) {
                        hero.getInventory().addPotion(potion);
                        hero.updateMoneyAfterBuyingItems(cost);
                        System.out.println(ConsoleColours.YELLOW + "\n[MARKET MESSAGE] Added potion " + itemId + " to hero " + hero.getId() + "'s inventory" + ConsoleColours.RESET);
                    } else {
                        System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getId() + " has either not enough money or not enough experience to buy this potion " + itemId + "!" + ConsoleColours.RESET);
                    }
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] Potion " + itemId + " does not exist!" + ConsoleColours.RESET);
                }
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getId() + " already has item " + itemId + "! Hoarding is not allowed." + ConsoleColours.RESET);
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
                hero.updateMoneyAfterSellingItems((int) (cost * SELL_ITEM_FACTOR));
                System.out.println(ConsoleColours.CYAN + "\n[MARKET MESSAGE] Removed weapon " + itemId + " from hero " + hero.getId() + "'s inventory" + ConsoleColours.RESET);
            } else {
                System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getName() + " does not have weapon " + itemId + "!" + ConsoleColours.RESET);
            }
        } else if (itemId.contains("E")) {
            boolean armorExists = hero.getInventory().checkIfArmorExists(itemId);

            if (armorExists) {
                Armor armor = hero.getInventory().getArmorFromId(itemId);
                cost = armor.getCost();

                hero.getInventory().removeArmor(armor);
                hero.updateMoneyAfterSellingItems((int) (cost * SELL_ITEM_FACTOR));
                System.out.println(ConsoleColours.GREEN + "\n[MARKET MESSAGE] Removed armor " + itemId + " from hero " + hero.getId() + "'s inventory" + ConsoleColours.RESET);
            } else {
                System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getName() + " does not have armor " + itemId + "!" + ConsoleColours.RESET);
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] Potions and Spells are consumable items, which cannot be sold once bought!" + ConsoleColours.RESET);
        }
    }
}
