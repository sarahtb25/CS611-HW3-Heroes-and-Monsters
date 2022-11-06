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
        System.out.println("Please input the number of heroes (minimum " + minHero + " and maximum " + maxHero + "):");
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

    public void enterCell(int row, int column) {
        Cell cell = board.getMHBoardCell(row, column);

        if (cell.getPiece() instanceof CommonPiece) {
            CommonPiece commonPiece = (CommonPiece) cell.getPiece();
            if (cell.getPiece().getId().equals("C")) {
                boolean hasQuit = commonPiece.enterCommon(player);

                if (commonPiece.isHaveBattle()) {
                    numberOfBattles++;
                }

                printMap();

                if (hasQuit) {
                    quit();
                }
            } else if (cell.getPiece().getId().equals("C*")) {
                commonPiece.leaveCommon();
            }
        } else if (cell.getPiece() instanceof MarketPiece) {
            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            if (cell.getPiece().getId().equals("M")) {
                marketPiece.beforeEnteringMarket();
                printMap();
            } else if (cell.getPiece().getId().equals("M*")) {
                marketPiece.leaveMarket();
            }
        } else if (cell.getPiece().getId().equals("I")) {
            System.out.println("You are not allowed to come to an invalid area!");
        }
    }

    // A/a
    public void moveLeft() {
        int[] rowAndColumnIndex = board.getRowAndColumnIndex();

        if (rowAndColumnIndex[1] - 1 >= 0) {
            rowAndColumnIndex[1] -= 1;
            enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
        } else {
            System.out.println("You cannot go outside the map!");
        }
    }

    // D/d
    public void moveRight() {
        int[] rowAndColumnIndex = board.getRowAndColumnIndex();

        if (rowAndColumnIndex[1] + 1 < MHBoard.numberOfRowsAndCols) {
            rowAndColumnIndex[1] += 1;
            enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
        } else {
            System.out.println("You cannot go outside the map!");
        }
    }

    // W/w
    public void moveUp() {
        int[] rowAndColumnIndex = board.getRowAndColumnIndex();

        if (rowAndColumnIndex[0] - 1 >= 0) {
            rowAndColumnIndex[0] -= 1;
            enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
        } else {
            System.out.println("You cannot go outside the map!");
        }
    }

    // S/s
    public void moveDown() {
        int[] rowAndColumnIndex = board.getRowAndColumnIndex();

        if (rowAndColumnIndex[0] + 1 < MHBoard.numberOfRowsAndCols) {
            rowAndColumnIndex[0] += 1;
            enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
        } else {
            System.out.println("You cannot go outside the map!");
        }
    }

    // M/m
    public void goToMarket() {
        boolean quit;
        int[] rowAndColumnIndex = board.getRowAndColumnIndex();
        Cell cell = board.getMHBoardCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);

        if (cell.getPiece() instanceof MarketPiece) {
            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            quit = marketPiece.market(player);
            printMap();

            if (quit) {
                quit();
            }
        }
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
        Hero hero = player.getHeroes().getHeroFromId(heroId);

        if (hero.getId().equals(heroId)) {
            boolean weaponExists = hero.getInventory().checkIfWeaponExists(itemId);

            if (weaponExists) {
                Weapon weapon = hero.getInventory().getWeaponFromId(itemId);
                hero.replaceAWeaponOrArmor(weapon);
            } else {
                boolean armorExists = hero.getInventory().checkIfArmorExists(itemId);

                if (armorExists) {
                    Armor armor = hero.getInventory().getArmorFromId(itemId);
                    hero.replaceAWeaponOrArmor(armor);
                } else {
                    System.out.println("Hero " + hero.getName() + " does not have weapon or armor " + itemId + " in their inventory!");
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
                     String heroId = userInput.split(" ")[0];
                     viewHeroInventory(heroId);
                 } else if (userInput.contains(" drink ")) {
                     String heroId = userInput.split(" ")[0];
                     String potionId = userInput.split(" ")[2];
                     drinkPotion(heroId, potionId);
                 } else if (userInput.contains("hero ")) {
                     String heroId = userInput.split(" ")[1];
                     printHeroInformation(heroId);
                 } else if (userInput.contains(" change ")) {
                     String heroId = userInput.split(" ")[0];
                     String itemId = userInput.split(" ")[2];
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

        // All heroes are still alive, the game is not over yet
        if (numberOfHeroesAlive == heroes.getHeroes().size() && totalNumberOfHeroesDefeated < numberOfMonstersToDefeat) {
            return false;
        }

        return true;
    }

    @Override
    public void showScore() {
        System.out.println("\nThere were " + numberOfBattles + " battles in this round.");
        for (Hero hero : heroes.getHeroes()) {
            System.out.println("\tHero " + hero.getName() + " defeated " + hero.getNumberOfTimesHeroDefeatedMonster() + " monster(s).");
        }
        System.out.println("\n");
        showHeroes();
    }
}
