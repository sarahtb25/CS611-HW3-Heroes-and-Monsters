import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents all possible exoskeletons
public class ExoskeletonFactory implements MonsterFactory<Exoskeleton> {
    public static final List<String> EXOSKELETON_NAMES = Arrays.asList("Cyrrollalee", "Brandobaris", "BigBad-Wolf", "WickedWitch", "Aasterinian", "Chronepsish", "Kiaransalee", "St-Shargaas", "Merrshaullk", "St-Yeenoghu", "Venom", "Exodia");
    public static final List<String> EXOSKELETON_IDS = Arrays.asList("K0", "K1", "K2", "K3", "K4", "K5", "K6", "K7", "K8", "K9", "K10", "K11");
    public static final List<Integer> EXOSKELETON_LEVELS = Arrays.asList(7, 3, 1, 2, 4, 6, 8, 5, 10, 9, 6, 10);
    public static final List<Integer> EXOSKELETON_DAMAGE = Arrays.asList(700, 350, 150, 250, 400, 650, 850, 550, 1000, 950, 600, 1000);
    public static final List<Integer> EXOSKELETON_DEFENSE = Arrays.asList(800, 450, 250, 350, 500, 750, 950, 650, 900, 850, 600, 1000);
    public static final List<Integer> EXOSKELETON_DODGE_CHANCE = Arrays.asList(75, 30, 15, 25, 45, 60, 85, 55, 55, 90, 55, 50);
    private List<Exoskeleton> exoskeletons = new ArrayList<>();

    public ExoskeletonFactory() {
        generateMonsters();
    }

    @Override
    public void generateMonsters() {
        for (int i = 0; i < EXOSKELETON_NAMES.size(); i++) {
            Exoskeleton exoskeleton = new Exoskeleton(EXOSKELETON_NAMES.get(i), EXOSKELETON_IDS.get(i), EXOSKELETON_LEVELS.get(i), EXOSKELETON_DAMAGE.get(i), EXOSKELETON_DEFENSE.get(i), EXOSKELETON_DODGE_CHANCE.get(i));
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
