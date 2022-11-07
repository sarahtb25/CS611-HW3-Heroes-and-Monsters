import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

// To display the scores of a round of Monsters and Heroes
public class MHRoundHistory implements RoundHistory {
    private int numberOfBattles;
    // Stores hero's name and number of times they defeated a monster
    private HashMap<String, Integer> roundScores;

    public MHRoundHistory() {
        roundScores = new LinkedHashMap<>();
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
        if (numberOfBattles == 1) {
            System.out.println("\nThere was " + numberOfBattles + " battle in this round.");
        } else {
            System.out.println("\nThere were " + numberOfBattles + " battles in this round.");
        }

        Set<String> heroNames = roundScores.keySet();

        for (String heroName : heroNames) {
            System.out.println("\tHero " + heroName + " defeated " + roundScores.get(heroName) + " monster(s).");
        }
    }
}
