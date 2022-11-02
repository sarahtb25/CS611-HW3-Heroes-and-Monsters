// Represents the Monsters and Heroes game
public class MHBoardGame extends BoardGame {
    public static final int minHero = 1;
    public static final int maxHero = 3;

    private MHBoard board;
    private Heroes heroes;
    private MHPlayer player;
    private int numberOfBattles = 0;

    public MHBoardGame() {
        super();
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

    @Override
    public void playGame() {

    }

    @Override
    public boolean checkGameStatus() {
        return false;
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
