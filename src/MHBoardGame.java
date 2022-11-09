import java.util.List;
import java.util.Scanner;

// Represents the Monsters and Heroes game logic
public class MHBoardGame extends BoardGame {
    private static MHBoardGame game = new MHBoardGame();
    public static final int NUMBER_OF_MONSTERS_TO_DEFEAT = 100;
    public static final int MIN_HERO = 1;
    public static final int MAX_HERO = 3;
    private final MHHelp help = new MHHelp();
    private MHBoard board;
    private MHStatistics statistics = new MHStatistics();
    private int numberOfHeroes = 0;
    private Heroes heroes;
    private MHPlayer player;
    private int numberOfBattles = 0;
    private final MHUtility utility = new MHUtility();

    private MHBoardGame() {
        super();
    }

    public static MHBoardGame getGameInstance() {
        return game;
    }

    public void getPlayerName() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.println(ConsoleColours.GREEN + "[INPUT] Please enter player name:" + ConsoleColours.RESET);

        String playerName = scan.next();
        player = new MHPlayer(playerName);
    }

    public void getNumberOfHeroes() {
        Scanner scan = new Scanner(System.in);
        System.out.println(ConsoleColours.GREEN + "\n[INPUT] Please input the number of heroes (minimum " + MIN_HERO + " and maximum " + MAX_HERO + "):" + ConsoleColours.RESET);
        String numberOfHeroes = scan.next();
        boolean isNumber = utility.checkIsNumber(numberOfHeroes);

        while(!isNumber || (Integer.parseInt(numberOfHeroes) < MIN_HERO && Integer.parseInt(numberOfHeroes) > MAX_HERO)) {
            System.out.println(ConsoleColours.RED + "\n[ERROR] Invalid Input!" + ConsoleColours.RESET);
            System.out.println(ConsoleColours.GREEN + "\n[INPUT] Please input the number of heroes (minimum " + MIN_HERO + " and maximum " + MAX_HERO + "):" + ConsoleColours.RESET);
            numberOfHeroes = scan.next();
            isNumber = utility.checkIsNumber(numberOfHeroes);
        }

        this.numberOfHeroes = Integer.parseInt(numberOfHeroes);
    }

    public void generateHeroes(int numberOfHeroes) {
        System.out.println(ConsoleColours.YELLOW + "\n[GAME MESSAGE] Generating " + numberOfHeroes + " Heroes..." + ConsoleColours.RESET);
        heroes = new Heroes();
        GenerateHeroes gh = new GenerateHeroes(numberOfHeroes);
        heroes = gh.getHeroes();
        System.out.println(ConsoleColours.YELLOW + "\n[GAME MESSAGE] " + numberOfHeroes + " Heroes generated!" + ConsoleColours.RESET);
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
        printHeroesInformation();
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
        System.out.println(ConsoleColours.YELLOW + "\n[GAME MESSAGE] Quitting game..." + ConsoleColours.RESET);
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
            System.out.println(ConsoleColours.RED + "\n[ERROR] You do not have hero " + heroId + "!" + ConsoleColours.RESET);
        }

    }

    // <Hero ID> Inventory
    public void viewHeroInventory(String heroId) {
        boolean heroExists = player.getHeroes().checkIfHeroExists(heroId);

        if (heroExists) {
            Hero hero = player.getHeroes().getHeroFromId(heroId);
            hero.getInventory().printInventory();
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You do not have hero " + heroId + "!" + ConsoleColours.RESET);
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
                System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getName() + " does not have potion " + potionId + " in their inventory!" + ConsoleColours.RESET);
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You do not have hero " + heroId + "!" + ConsoleColours.RESET);
        }
    }

    // <Hero ID> change <Weapon or Armor ID>
    public void changeWeaponOrArmor(String heroId, String itemId) {
        boolean equippableItemExists;
        EquippableItem equippableItem;
        Hero hero = player.getHeroes().getHeroFromId(heroId);

        if (hero.getId().equals(heroId)) {
            if (itemId.contains(",")) {
                String[] itemIds = itemId.split(",");

                for (int i = 0; i < itemIds.length; i++) {
                    equippableItemExists = hero.getInventory().checkIfEquippableItemExists(itemIds[i]);

                    if (equippableItemExists) {
                        equippableItem = hero.getInventory().getEquippableItemFromId(itemIds[i]);
                        hero.replaceAWeaponOrArmor(equippableItem);
                    } else {
                        System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getName() + " does not have weapon or armor " + itemIds[i] + " in their inventory!" + ConsoleColours.RESET);
                    }
                }
            } else {
                equippableItemExists = hero.getInventory().checkIfEquippableItemExists(itemId);

                if (equippableItemExists) {
                    equippableItem = hero.getInventory().getEquippableItemFromId(itemId);
                    hero.replaceAWeaponOrArmor(equippableItem);
                } else {
                    System.out.println(ConsoleColours.RED + "\n[ERROR] Hero " + hero.getName() + " does not have weapon or armor " + itemId + " in their inventory!" + ConsoleColours.RESET);
                }
            }

            System.out.println(ConsoleColours.YELLOW + "\n[GAME MESSAGE] You are currently armed with:" + ConsoleColours.RESET);
            hero.printCurrentlyEquippedItems();
        } else {
            System.out.println("\nYou do not have hero " + heroId + "!");
        }
    }

    @Override
    public void playGame() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        String userInput = "y";
        boolean isValid;

        while (userInput.equals("y")) {
            printIntroduction();
            MHUtility.pause();
            printOverallRules();
            MHUtility.pause();
            printOverallHelp();
            initializeGame();
            regenerateMap();
            MHRoundHistory roundHistory = new MHRoundHistory();
            numberOfBattles = 0;

            while(!checkGameStatus()) {
                 do {
                    System.out.println(ConsoleColours.GREEN + "\n[INPUT] Please provide a valid map command:" + ConsoleColours.RESET);
                    userInput = scan.next().trim().toLowerCase();
                    isValid = utility.checkValidUserResponse(userInput);
                    if (!isValid) System.out.println(ConsoleColours.RED + "\n[ERROR] Invalid Input!" + ConsoleColours.RESET);
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
                     roundHistory.setNumberOfBattles(numberOfBattles);
                     for (Hero hero : heroes.getHeroes()) {
                         roundHistory.addHeroScoreToRoundHistory(hero.getName(), hero.getNumberOfTimesHeroDefeatedMonster());
                     }
                     statistics.addRoundHistory(roundHistory);

                     showScore();
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

            if (heroes.getTotalNumberOfMonstersDefeated() >= NUMBER_OF_MONSTERS_TO_DEFEAT) {
                System.out.println(ConsoleColours.CYAN_BOLD + "\nCongratulations! You have freed the villagers of Lockwood from the monsters' tyranny!" + ConsoleColours.RESET);
                quit();
            } else {
                do {
                    System.out.println(ConsoleColours.RED + "\nYou have failed to free the villagers of Lockwood from the monsters' tyranny! Would you like to try again? Y/N" + ConsoleColours.RESET);
                    userInput = scan.next().trim().toLowerCase();
                } while (!userInput.equals("y") && !userInput.equals("n"));

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
        if (numberOfHeroesAlive > 0 && totalNumberOfHeroesDefeated < NUMBER_OF_MONSTERS_TO_DEFEAT) {
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
