import java.util.Scanner;

// Represents a battle between a hero and a monster
public class Battle {
    private Fighters fighters;
    public static final MHHelp help = new MHHelp();

    public Battle(Fighters fighters) {
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

                    if (userResponseOrBattleWinner.contains("change ")) {
                        EquippableItem item = new EquippableItem();
                        WeaponFactory wf = new WeaponFactory();
                        ArmorFactory af = new ArmorFactory();

                        String itemId = userResponseOrBattleWinner.split(" ")[1].toUpperCase();
                        if (itemId.contains(",")) {
                            String[] itemIds = itemId.split(",");
                            
                            for (int i = 0; i < itemIds.length; i++) {
                                if (itemIds[i].contains("B") || itemIds[i].contains("E")) {
                                    if (itemIds[i].contains("B")) {
                                        item = wf.getItemFromId(itemIds[i]);
                                    } else if (itemIds[i].contains("E")) {
                                        item = af.getItemFromId(itemIds[i]);
                                    }

                                    if (!item.getId().equals("none")) {
                                        hero.replaceAWeaponOrArmor(item);
                                        System.out.println("\nYou are currently armed with:");
                                        hero.printCurrentlyEquippedItems();
                                    } else {
                                        System.out.println("\nWeapon or armor with the ID " + itemIds[i] + " does not exist! You just lost a turn.");
                                    }
                                } else {
                                    System.out.println("\nWrong item ID used! B<number> for weapon and E<number> for armor. You just lost a turn.");
                                }
                            }
                        } else {
                            if (itemId.contains("B") || itemId.contains("E")) {
                                if (itemId.contains("B")) {
                                    item = wf.getItemFromId(itemId);
                                } else if (itemId.contains("E")) {
                                    item = af.getItemFromId(itemId);
                                }

                                if (!item.getId().equals("none")) {
                                    hero.replaceAWeaponOrArmor(item);
                                    System.out.println("\nYou are currently armed with:");
                                    hero.printCurrentlyEquippedItems();
                                } else {
                                    System.out.println("\nWeapon or armor with the ID" + itemId + " does not exist! You just lost a turn.");
                                }
                            } else {
                                System.out.println("\nWrong item ID used! B<number> for weapon and E<number> for armor. You just lost a turn.");
                            }
                        }
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
