import java.util.ArrayList;
import java.util.List;

// To display the scores of each round after a player chooses to quit the game
public class MHStatistics implements Statistics<MHRoundHistory> {
    private List<MHRoundHistory> MHRoundHistories;

    public MHStatistics() {
        MHRoundHistories = new ArrayList<>();
    }

    @Override
    public void addRoundHistory(MHRoundHistory roundHistory) {
        MHRoundHistories.add(roundHistory);
    }

    @Override
    public void printStatistics() {
        int roundNumber = 1;
        for (MHRoundHistory roundHistory : MHRoundHistories) {
            System.out.println("\n-----------------------");
            System.out.println("|       Round " + roundNumber + "       |");
            System.out.println("-----------------------");
            System.out.println();
            roundHistory.printRoundScores();
            roundNumber++;
        }
    }
}
