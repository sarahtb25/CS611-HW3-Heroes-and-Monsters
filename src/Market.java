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

        printMarketMenu();
        printHelp();

        while(!userInput.equals("x") && !userInput.equals("q")) {
            System.out.println();
            System.out.println("\nPlease provide a valid market command:");
            userInput = scan.next().trim().toLowerCase();

            if (userInput.contains(" buy ") || userInput.contains(" sell ")) {
                heroId = userInput.split(" ")[0].toUpperCase();
                System.out.println("\nHero: " + heroId);
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
                    System.out.println("You do not have Hero " + heroId + "!");
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
                    System.out.println("You do not have Hero " + heroId.toUpperCase() + "!");
                }
            } else if (!userInput.equals("x") && !userInput.equals("q")){
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
        boolean canBuy;
        int cost;

        if (itemId.contains("B")) {
            if (wf.checkItemExists(itemId)) {
                weapon = wf.getItemFromId(itemId);
                cost = weapon.getCost();
                canBuy = hero.checkMoneyAndLevelToBuyItem(cost, weapon.getRequiredLevel());

                if (canBuy) {
                    hero.getInventory().addWeapon(weapon);
                    hero.updateMoneyAfterBuyingItems(cost);
                    System.out.println("\nAdded weapon " + itemId + " to hero " + hero.getId() + "'s inventory");
                } else {
                    System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy weapon " + itemId + "!");
                }
            } else {
                System.out.println("\nWeapon " + itemId + " does not exist!");
            }
        } else if (itemId.contains("E")) {
            if (af.checkItemExists(itemId)) {
                armor = af.getItemFromId(itemId);
                cost = armor.getCost();
                canBuy = hero.checkMoneyAndLevelToBuyItem(cost, armor.getRequiredLevel());

                if (canBuy) {
                    hero.getInventory().addArmor(armor);
                    hero.updateMoneyAfterBuyingItems(cost);
                    System.out.println("\nAdded armor " + itemId + " to hero " + hero.getId() + "'s inventory");
                } else {
                    System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this armor " + itemId + "!");
                }
            } else {
                System.out.println("\nArmor " + itemId + " does not exist!");
            }
        } else if (itemId.contains("F") || itemId.contains("C") || itemId.contains("L")) {
            if (sf.checkItemExists(itemId)) {
                spell = sf.getItemFromId(itemId);
                cost = spell.getCost();
                canBuy = hero.checkMoneyAndLevelToBuyItem(cost, spell.getRequiredLevel());

                if (canBuy) {
                    hero.getInventory().addSpell(spell);
                    hero.updateMoneyAfterBuyingItems(cost);
                    System.out.println("\nAdded spell " + itemId + " to hero " + hero.getId() + "'s inventory");
                } else {
                    System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this spell " + itemId + "!");
                }
            } else {
                System.out.println("\nSpell " + itemId + " does not exist!");
            }
        } else if (itemId.contains("P")) {
            if(pf.checkItemExists(itemId)) {
                potion = pf.getItemFromId(itemId);
                cost = potion.getCost();
                canBuy = hero.checkMoneyAndLevelToBuyItem(cost, potion.getRequiredLevel());

                if (canBuy) {
                    hero.getInventory().addPotion(potion);
                    hero.updateMoneyAfterBuyingItems(cost);
                    System.out.println("\nAdded potion " + itemId + " to hero " + hero.getId() + "'s inventory");
                } else {
                    System.out.println("Hero " + hero.getId() + " has either not enough money or not enough experience to buy this potion " + itemId + "!");
                }
            } else {
                System.out.println("\nPotion " + itemId + " does not exist!");
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
                System.out.println("\nRemoved weapon " + itemId + " from hero " + hero.getId() + "'s inventory");
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
                System.out.println("\nRemoved armor " + itemId + " from hero " + hero.getId() + "'s inventory");
            } else {
                System.out.println("Hero " + hero.getName() + " does not have armor " + itemId + "!");
            }
        } else {
            System.out.println("Potions and Spells are consumable items, which cannot be sold once bought!");
        }
    }
}
