import java.util.Scanner;

// Represents the Monsters and Heroes game
public class MHBoardGame extends BoardGame {
    public static final int minHero = 1;
    public static final int maxHero = 3;
    public static final MHHelp help = new MHHelp();

    private MHBoard board = new MHBoard();
    private int numberOfHeroes = 0;
    private Heroes heroes;
    private MHPlayer player;
    private int numberOfBattles = 0;
    private MHUtility utility = new MHUtility();

    public MHBoardGame() {
        super();
    }

    public void getPlayerName() {
        Scanner scan = new Scanner(System.in);
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

    public void printMap() {
        board.printBoard();
    }

    @Override
    public void playGame() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        boolean isValid = false;

        while (!userInput.equals("n")) {
            initializeGame();
            MHCell cell = board.getRandomMHBoardCell();

            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            marketPiece.beforeEnteringMarket();

            printMap();

            // Print that there is a market, and to enter M/m to enter the market
            // If they press any other keys, redirect them accordingly
        }
    }

    @Override
    public boolean checkGameStatus() {
        int numberOfHeroesAlive = 0;

        for (Hero hero : heroes.getHeroes()) {
            if (hero.getHitPoints() <= 0) {
                numberOfHeroesAlive++;
            }
        }

        // All heroes are still alive, the game is not over yet
        if (numberOfHeroesAlive == heroes.getHeroes().size()) {
            return false;
        }

        return true;
    }

    @Override
    public void showScore() {
        System.out.println("There were " + numberOfBattles + " battles in this round.");
        for (Hero hero : heroes.getHeroes()) {
            System.out.println("\tHero " + hero.getName() + " defeated " + hero.getNumberOfTimesHeroDefeatedMonster() + " monster(s).");
        }
        System.out.println("\n");
        showHeroes();
    }
}
