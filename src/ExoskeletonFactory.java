import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible exoskeletons
public class ExoskeletonFactory implements MonsterFactory<Exoskeleton> {
    public static final List<String> exoskeletonNames = Arrays.asList("Cyrrollalee", "Brandobaris", "BigBad-Wolf", "WickedWitch", "Aasterinian", "Chronepsish", "Kiaransalee", "St-Shargaas", "Merrshaullk", "St-Yeenoghu", "Venom", "Exodia");
    public static final List<String> exoskeletonIds = Arrays.asList("K0", "K1", "K2", "K3", "K4", "K5", "K6", "K7", "K8", "K9", "K10", "K11");
    public static final List<Integer> exoskeletonLevels = Arrays.asList(7, 3, 1, 2, 4, 6, 8, 5, 10, 9, 6, 10);
    public static final List<Integer> exoskeletonDamage = Arrays.asList(700, 350, 150, 250, 400, 650, 850, 550, 1000, 950, 600, 1000);
    public static final List<Integer> exoskeletonDefense = Arrays.asList(800, 450, 250, 350, 500, 750, 950, 650, 900, 850, 600, 1000);
    public static final List<Integer> exoskeletonDodgeChance = Arrays.asList(75, 30, 15, 25, 45, 60, 85, 55, 55, 90, 55, 50);
    private List<Exoskeleton> exoskeletons = new ArrayList<>();

    public ExoskeletonFactory() {
        generateMonsters();
    }

    @Override
    public void generateMonsters() {
        for (int i = 0; i < exoskeletonNames.size(); i++) {
            Exoskeleton exoskeleton = new Exoskeleton(exoskeletonNames.get(i), exoskeletonIds.get(i), exoskeletonLevels.get(i), exoskeletonDamage.get(i), exoskeletonDefense.get(i), exoskeletonDodgeChance.get(i));
            exoskeletons.add(exoskeleton);
        }
    }

    @Override
    public Exoskeleton getAMonster(int index) {
        return exoskeletons.get(index);
    }

    @Override
    public int getNumberOfMonsters() {
        return exoskeletons.size();
    }
}
