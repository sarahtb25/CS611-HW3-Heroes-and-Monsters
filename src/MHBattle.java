import java.util.Scanner;

// Represents a battle between a hero and a monster
public class MHBattle implements Battle {
    private Fighters fighters;
    private final MHHelp help = new MHHelp();

    public MHBattle(Fighters fighters) {
        this.fighters = fighters;
    }

    public Fighters getFighters() {
        return fighters;
    }

    // Print instructions
    public void printHelp() {
        help.printHelpBattle();
    }

    public void printRules() {
        help.printRulesBattle();
    }

    public boolean checkUserResponse(String userResponse) {
        return (userResponse.contains("change ") || userResponse.equals("hit") || userResponse.contains("cast ") || userResponse.equals("i") || userResponse.equals("r") || userResponse.equals("q") || userResponse.equals("h"));
    }

    @Override
    public String fight() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        String userResponseOrBattleWinner = "";
        String response = "";
        int turn = 0;
        boolean isValid;
        Hero hero = fighters.getHero();
        Monster monster = fighters.getMonster();

        printHelp();
        System.out.println("\n");
        fighters.printFightersInformation();

        while(!userResponseOrBattleWinner.equals("q")) {
            if (hero.getHitPoints() > 0 && monster.getHitPoint() > 0) {
                if (turn % 2 == 0) {
                    // Player's turn
                    do {
                        System.out.println("\nPlease enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):");
                        userResponseOrBattleWinner = scan.next().trim().toLowerCase();
                        isValid = checkUserResponse(userResponseOrBattleWinner);
                    } while (!isValid);

                    if (userResponseOrBattleWinner.contains(" change ")) {
                        EquippableItem equippableItem;
                        boolean equippableItemExists;

                        String itemId = userResponseOrBattleWinner.split(" ")[2].toUpperCase();
                        if (itemId.contains(",")) {
                            String[] itemIds = itemId.split(",");

                            for (int i = 0; i < itemIds.length; i++) {
                                equippableItemExists = hero.getInventory().checkIfEquippableItemExists(itemIds[i]);

                                if (equippableItemExists) {
                                    equippableItem = hero.getInventory().getEquippableItemFromId(itemIds[i]);
                                    hero.replaceAWeaponOrArmor(equippableItem);
                                } else {
                                    System.out.println("\nHero " + hero.getName() + " does not have weapon or armor " + itemIds[i] + " in their inventory! You just lost a turn.");
                                }
                            }
                        } else {
                            equippableItemExists = hero.getInventory().checkIfEquippableItemExists(itemId);

                            if (equippableItemExists) {
                                equippableItem = hero.getInventory().getEquippableItemFromId(itemId);
                                hero.replaceAWeaponOrArmor(equippableItem);
                            } else {
                                System.out.println("\nHero " + hero.getName() + " does not have weapon or armor " + itemId + " in their inventory! You just lost a turn.");
                            }
                        }

                        System.out.println("\nYou are currently armed with:");
                        hero.printCurrentlyEquippedItems();
                    } else if (userResponseOrBattleWinner.contains("cast ")) {
                        String spellId = userResponseOrBattleWinner.split(" ")[1].toUpperCase();
                        boolean spellExists = hero.getInventory().checkIfSpellExists(spellId);
                        if (spellExists) {
                            Spell spell = hero.getInventory().getSpellFromId(spellId);
                            response = hero.castSpell(spell, monster);
                            System.out.println(response);
                        } else {
                            System.out.println("\nSpell " + spellId + " does not exist in " + hero.getName() + "'s inventory! You just lost a turn.");
                        }
                    } else if (userResponseOrBattleWinner.equals("hit")) {
                        response = hero.hit(monster);
                        System.out.println(response);
                    } else if (userResponseOrBattleWinner.equals("i")) {
                        fighters.printFightersInformation();
                        turn--; // Ensure when increment happens, it is still hero's turn
                    } else if (userResponseOrBattleWinner.equals("h")) {
                        printHelp();
                        turn--; // Ensure when increment happens, it is still hero's turn
                    } else if (userResponseOrBattleWinner.equals("q")) { // Quit the game
                        break;
                    } else if (userResponseOrBattleWinner.equals("r")) {
                        printRules();
                        turn--; // Ensure when increment happens, it is still hero's turn
                    }
                } else {
                    // Monster's turn
                    response = monster.attack(hero);
                    System.out.println("\n" + response);
                }

                turn++;
            } else {
                break;
            }
        }

        if (!userResponseOrBattleWinner.equals("q")) {
            if (hero.getHitPoints() > 0) {
                userResponseOrBattleWinner = "hero";
                hero.updateNumberOfTimesHeroDefeatedMonster();
                updateHeroAfterBattle(hero, monster.getLevel());
            } else {
                userResponseOrBattleWinner = "monster";
            }
        }

        // contains q if user quits the game, or hero if hero wins the game, or monster if monster wins the game
        return userResponseOrBattleWinner;
    }

    public void updateHeroAfterBattle(Hero hero, int monsterLevel) {
        hero.updateExperienceGained();
        hero.updateMoneyAfterBattle(monsterLevel);
    }
}