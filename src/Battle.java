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
        help.printRules();
    }

    public boolean checkUserResponse(String userResponse) {
        return (userResponse.contains("change ") || userResponse.equals("hit") || userResponse.contains("cast ") || userResponse.equals("i") || userResponse.equals("r") || userResponse.equals("q") || userResponse.equals("h"));
    }

    public String fight() {
        Scanner scan = new Scanner(System.in);
        String userResponseOrBattleWinner = "";
        String response = "";
        int turn = 0;
        Hero hero = fighters.getHero();
        Monster monster = fighters.getMonster();

        while(hero.getHitPoints() > 0 || monster.getHitPoint() > 0 || !userResponseOrBattleWinner.equals("q")) {
            if (turn % 2 == 0) {
                // Player's turn
                printHelp();
                System.out.println("Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):");
                userResponseOrBattleWinner = scan.next().trim().toLowerCase();
                boolean isValid = checkUserResponse(userResponseOrBattleWinner);

                while(!isValid) {
                    System.out.println("Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):");
                    userResponseOrBattleWinner = scan.next().trim().toLowerCase();
                    isValid = checkUserResponse(userResponseOrBattleWinner);
                }

                if(userResponseOrBattleWinner.contains("change ")) {
                    Item item = new Item();
                    WeaponFactory wf = new WeaponFactory();
                    ArmorFactory af = new ArmorFactory();

                    String itemId = userResponseOrBattleWinner.split(" ")[1].toUpperCase();
                    if (itemId.contains("B") || itemId.contains("E")) {
                        if (itemId.contains("B")) {
                            item = wf.getItemFromId(itemId);
                        } else if (itemId.contains("E")) {
                            item = af.getItemFromId(itemId);
                        }

                        if (!item.getItemName().equals(null)) {
                            hero.replaceAWeaponOrArmor(item);
                            System.out.println("You are currently armed with:");
                            System.out.println(hero.getCurrentlyEquippedItems());
                        } else {
                            System.out.println("Weapon or armor with the ID does not exist! You just lost a turn :(");
                        }
                    } else {
                        System.out.println("Wrong item ID used! B<number> for weapon and E<number> for armor! You just lost a turn :(");
                    }
                } else if (userResponseOrBattleWinner.contains("cast ")) {
                    String spellId = userResponseOrBattleWinner.split(" ")[1];
                    Spell spell = hero.getInventory().getSpellFromId(spellId);

                    if (!spell.getItemName().equals(null)) {
                        hero.castSpell(spell, monster);
                    } else {
                        System.out.println("Spell does not exist in " + hero.getName() + "'s inventory! You just lost a turn :(");
                    }
                } else if (userResponseOrBattleWinner.equals("hit")) {
                    response = hero.hit(monster);
                    System.out.println(response);
                } else if (userResponseOrBattleWinner.equals("i")) {
                    System.out.println(hero);
                    System.out.println();
                    System.out.println(monster);
                } else if (userResponseOrBattleWinner.equals("h")) {
                    printHelp();
                } else if (userResponseOrBattleWinner.equals("q")) { // Quit the game
                    break;
                } else if (userResponseOrBattleWinner.equals("r")) {
                    printRules();
                }
            } else {
                // Monster's turn
                response = monster.attack(hero);
                System.out.println(response);
            }

            turn++;
        }

        if (!userResponseOrBattleWinner.equals("q")) {
            if (hero.getHitPoints() <= 0) {
                userResponseOrBattleWinner = "hero";
                hero.setNumberOfTimesHeroDefeatedMonster(hero.getNumberOfTimesHeroDefeatedMonster() + 1);
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
