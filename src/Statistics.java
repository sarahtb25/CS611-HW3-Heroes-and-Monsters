// Prints statistics/scores of each round
public interface Statistics<T extends RoundHistory> {
    void addRoundHistory(T roundHistory);
    void printStatistics();
}
