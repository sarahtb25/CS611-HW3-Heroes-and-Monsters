import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

// To display the scores of a round of Monsters and Heroes
public class MHRoundHistory implements RoundHistory {
    private int numberOfBattles;
    // Stores hero's name and number of times they defeated a monster
    private HashMap<String, Integer> roundScores = new LinkedHashMap<>();

    public MHRoundHistory() {
    }

    public int getNumberOfBattles() {
        return numberOfBattles;
    }

    public void setNumberOfBattles(int numberOfBattles) {
        this.numberOfBattles = numberOfBattles;
    }

    public HashMap<String, Integer> getRoundScores() {
        return roundScores;
    }

    public void setRoundScores(HashMap<String, Integer> roundScores) {
        this.roundScores = roundScores;
    }

    public void addHeroScoreToRoundHistory(String name, int score) {
        roundScores.put(name, score);
    }

    @Override
    public void printRoundScores() {
        System.out.println("There were " + numberOfBattles + " battles.");
        Set<String> heroNames = roundScores.keySet();

        for (String heroName : heroNames) {
            System.out.println("\tHero " + heroName + " defeated " + roundScores.get(heroName) + " monster(s).");
        }
    }
}
