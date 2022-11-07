import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents the Monsters and Heroes game
public class MHBoardGame extends BoardGame {
    public static final int numberOfMonstersToDefeat = 100;
    public static final int minHero = 1;
    public static final int maxHero = 3;
    public static final MHHelp help = new MHHelp();

    private MHBoard board = new MHBoard();
    private MHStatistics statistics = new MHStatistics();
    private int numberOfHeroes = 0;
    private Heroes heroes;
    private MHPlayer player;
    private int numberOfBattles = 0;
    private final MHUtility utility = new MHUtility();

    public MHBoardGame() {
        super();
    }

    public void getPlayerName() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Please enter player name:");

        String playerName = scan.next();
        player = new MHPlayer(playerName);
    }

    public void getNumberOfHeroes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease input the number of heroes (minimum " + minHero + " and maximum " + maxHero + "):");
        String numberOfHeroes = scan.next();
        boolean isNumber = utility.checkIsNumber(numberOfHeroes);

        while(!isNumber || (Integer.parseInt(numberOfHeroes) < minHero && Integer.parseInt(numberOfHeroes) > maxHero)) {
            System.out.println("Please input the number of heroes (minimum " + minHero + " and maximum " + maxHero + "):");
            numberOfHeroes = scan.next();
            isNumber = utility.checkIsNumber(numberOfHeroes);
        }

        this.numberOfHeroes = Integer.parseInt(numberOfHeroes);
    }

    public void generateHeroes(int numberOfHeroes) {
        heroes = new Heroes();
        GenerateHeroes gh = new GenerateHeroes(numberOfHeroes);
        heroes = gh.getHeroes();
    }

    public void showHeroes() {
        heroes.printHeroes();
    }

    public void setPlayerHeroes() {
        player.setHeroes(heroes);
    }

    public void initializeGame() {
        getPlayerName();
        getNumberOfHeroes();
        generateHeroes(numberOfHeroes);
        setPlayerHeroes();
    }

    // Regenerate map
    public void regenerateMap() {
        board = new MHBoard();
        Cell cell = board.getRandomMarketCell();
        MarketPiece marketPiece = (MarketPiece) cell.getPiece();
        marketPiece.beforeEnteringMarket();

        printMap();
    }

    // View map
    public void printMap() {
        board.printBoard();
    }

    // Q/q
    public void quit() {
        statistics.printStatistics();
        System.out.println("\nQuitting game...");
        System.exit(1);
    }

    // I/i
    public void printHeroesInformation() {
        heroes.printHeroes();
    }

    // M/m
    public void goToMarket() {
        boolean quit = board.goToMarket(player);

        printMap();

        if (quit) {
            quit();
        }
    }

    public void checkQuitAndHaveBattleCondition(List<Boolean> hasQuitAndBattle) {
        if (hasQuitAndBattle.get(1)) {
            numberOfBattles++;
        }

        if (hasQuitAndBattle.get(0)) {
            quit();
        }
    }

    // W/w
    public void moveUp() {
        List<Boolean> hasQuitAndBattle = board.moveUp(player);
        printMap();

        checkQuitAndHaveBattleCondition(hasQuitAndBattle);
    }

    // A/a
    public void moveLeft() {
        List<Boolean> hasQuitAndBattle = board.moveLeft(player);
        printMap();

        checkQuitAndHaveBattleCondition(hasQuitAndBattle);
    }

    // S/s
    public void moveDown() {
        List<Boolean> hasQuitAndBattle = board.moveDown(player);
        printMap();

        checkQuitAndHaveBattleCondition(hasQuitAndBattle);
    }

    // D/d
    public void moveRight() {
        List<Boolean> hasQuitAndBattle = board.moveRight(player);
        printMap();

        checkQuitAndHaveBattleCondition(hasQuitAndBattle);
    }

    public void printOverallHelp() {
        help.printHelp();
    }

    public void printIntroduction() {
        help.printIntroduction();
    }

    // H/h
    public void printHelp() {
        help.printHelpMap();
    }

    // R/r
    public void printRules() {
        help.printRulesMap();
    }

    public void printOverallRules() {
        help.printRules();
    }

    // Hero <Hero ID>
    public void printHeroInformation(String heroId) {
        boolean heroExists = player.getHeroes().checkIfHeroExists(heroId);

        if (heroExists) {
            Hero hero = player.getHeroes().getHeroFromId(heroId);
            hero.printHero();
        } else {
            System.out.println("You do not have hero " + heroId + "!");
        }

    }

    // <Hero ID> Inventory
    public void viewHeroInventory(String heroId) {
        boolean heroExists = player.getHeroes().checkIfHeroExists(heroId);

        if (heroExists) {
            Hero hero = player.getHeroes().getHeroFromId(heroId);
            hero.getInventory().printInventory();
        } else {
            System.out.println("You do not have hero " + heroId + "!");
        }
    }

    // <Hero ID> drink <Potion ID>
    public void drinkPotion(String heroId, String potionId) {
        boolean heroExists = player.getHeroes().checkIfHeroExists(heroId);

        if (heroExists) {
            Hero hero = player.getHeroes().getHeroFromId(heroId);
            boolean potionExists = hero.getInventory().checkIfPotionExists(potionId);

            if (potionExists) {
                Potion potion = hero.getInventory().getPotionFromId(potionId);
                hero.drinkPotion(potion);
            } else {
                System.out.println("Hero " + hero.getName() + " does not have potion " + potionId + " in their inventory!");
            }
        } else {
            System.out.println("You do not have hero " + heroId + "!");
        }
    }

    // <Hero ID> change <Weapon or Armor ID>
    public void changeWeaponOrArmor(String heroId, String itemId) {
        boolean weaponExists;
        boolean armorExists;
        Hero hero = player.getHeroes().getHeroFromId(heroId);

        if (hero.getId().equals(heroId)) {
            if (itemId.contains(",")) {
                String[] itemIds = itemId.split(",");

                for (int i = 0; i < itemIds.length; i++) {
                    weaponExists = hero.getInventory().checkIfWeaponExists(itemIds[i]);

                    if (weaponExists) {
                        Weapon weapon = hero.getInventory().getWeaponFromId(itemIds[i]);
                        hero.replaceAWeaponOrArmor(weapon);
                    } else {
                        armorExists = hero.getInventory().checkIfArmorExists(itemIds[i]);

                        if (armorExists) {
                            Armor armor = hero.getInventory().getArmorFromId(itemIds[i]);
                            hero.replaceAWeaponOrArmor(armor);
                        } else {
                            System.out.println("Hero " + hero.getName() + " does not have weapon or armor " + itemIds[i] + " in their inventory!");
                        }
                    }
                }
            } else {
                weaponExists = hero.getInventory().checkIfWeaponExists(itemId);

                if (weaponExists) {
                    Weapon weapon = hero.getInventory().getWeaponFromId(itemId);
                    hero.replaceAWeaponOrArmor(weapon);
                } else {
                    armorExists = hero.getInventory().checkIfArmorExists(itemId);

                    if (armorExists) {
                        Armor armor = hero.getInventory().getArmorFromId(itemId);
                        hero.replaceAWeaponOrArmor(armor);
                    } else {
                        System.out.println("Hero " + hero.getName() + " does not have weapon or armor " + itemId + " in their inventory!");
                    }
                }
            }
        } else {
            System.out.println("You do not have hero " + heroId + "!");
        }
    }

    @Override
    public void playGame() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        String userInput = "y";
        boolean isValid;

        while (userInput.equals("y")) {
            printIntroduction();
            printOverallRules();
            printOverallHelp();
            initializeGame();
            Cell cell = board.getRandomMarketCell();
            MHRoundHistory roundHistory = new MHRoundHistory();
            numberOfBattles = 0;

            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            marketPiece.beforeEnteringMarket();

            printMap();

            while(!checkGameStatus()) {
                 do {
                    System.out.println("\nPlease provide a valid map command:");
                    userInput = scan.next().trim().toLowerCase();
                    isValid = utility.checkValidUserResponse(userInput);
                 } while(!isValid);

                 if (userInput.equals("w")) {
                     moveUp();
                 } else if (userInput.equals("a")) {
                     moveLeft();
                 } else if (userInput.equals("s")) {
                     moveDown();
                 } else if (userInput.equals("d")) {
                     moveRight();
                 } else if (userInput.equals("q")) {
                     quit();
                 } else if (userInput.equals("h")) {
                     printHelp();
                 } else if (userInput.equals("r")) {
                     printRules();
                 } else if (userInput.equals("i")) {
                     printHeroesInformation();
                 } else if (userInput.equals("m")) {
                     goToMarket();
                 } else if (userInput.equals("view map")) {
                     printMap();
                 } else if (userInput.equals("regenerate map")) {
                     regenerateMap();
                 } else if (userInput.contains(" inventory")) {
                     String heroId = userInput.split(" ")[0].toUpperCase();
                     viewHeroInventory(heroId);
                     System.out.println();
                 } else if (userInput.contains(" drink ")) {
                     String heroId = userInput.split(" ")[0].toUpperCase();
                     String potionId = userInput.split(" ")[2].toUpperCase();
                     drinkPotion(heroId, potionId);
                 } else if (userInput.contains("hero ")) {
                     String heroId = userInput.split(" ")[1].toUpperCase();
                     printHeroInformation(heroId);
                 } else if (userInput.contains(" change ")) {
                     String heroId = userInput.split(" ")[0].toUpperCase();
                     String itemId = userInput.split(" ")[2].toUpperCase();
                     changeWeaponOrArmor(heroId, itemId);
                 }
            }

            roundHistory.setNumberOfBattles(numberOfBattles);
            for (Hero hero : heroes.getHeroes()) {
                roundHistory.addHeroScoreToRoundHistory(hero.getName(), hero.getNumberOfTimesHeroDefeatedMonster());
            }
            statistics.addRoundHistory(roundHistory);

            showScore();

            if (heroes.getTotalNumberOfMonstersDefeated() >= numberOfMonstersToDefeat) {
                System.out.println("Congratulations! You have freed the villagers of Lockwood from the monsters' tyranny!");
                quit();
            } else {
                System.out.println("You have failed to free the villagers of Lockwood from the monsters' tyranny! Would you like to try again? Y/N");
                userInput = scan.next().trim().toLowerCase();

                if (userInput.equals("n")) {
                    quit();
                }
            }
        }
    }



    @Override
    public boolean checkGameStatus() {
        int numberOfHeroesAlive = heroes.getNumberOfHeroesAlive();
        int totalNumberOfHeroesDefeated = heroes.getTotalNumberOfMonstersDefeated();

        // Some heroes are still alive and the heroes have not defeated all the monsters yet, the game is not over yet
        if (numberOfHeroesAlive > 0 && totalNumberOfHeroesDefeated < numberOfMonstersToDefeat) {
            return false;
        }

        return true;
    }

    @Override
    public void showScore() {
        if (numberOfBattles == 1) {
            System.out.println("\nThere was " + numberOfBattles + " battle in this round.");
        } else {
            System.out.println("\nThere were " + numberOfBattles + " battles in this round.");
        }

        for (Hero hero : heroes.getHeroes()) {
            System.out.println("\tHero " + hero.getName() + " defeated " + hero.getNumberOfTimesHeroDefeatedMonster() + " monster(s).");
        }
        System.out.println("\n");
        showHeroes();
    }
}
