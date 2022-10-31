public class GenerateMonsters {
    public static final DragonFactory df = new DragonFactory();
    public static final ExoskeletonFactory ef = new ExoskeletonFactory();
    public static final SpiritFactory sf = new SpiritFactory();
    public static int numberOfTypesOfMonsters = 3;
    private int numberOfHeroes;

    public GenerateMonsters(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public Monsters getMonsters() {
        Monsters monsters = new Monsters();
        Monster monster = new Monster();

        for (int i = 0; i < numberOfHeroes; i++) {
            int index = (int) (Math.random() * numberOfTypesOfMonsters);
            String typeOfMonster = new String [] {"Dragon", "Exoskeleton", "Spirit"}[index];

            if (typeOfMonster.equals("Dragon")) {
                int indexOfDragon = (int) (Math.random() * df.getNumberOfDragons());
                monster = df.getADragon(indexOfDragon);
            } else if (typeOfMonster.equals("Exoskeleton")) {
                int indexOfExoskeleton = (int) (Math.random() * ef.getNumberOfExoskeletons());
                monster = ef.getAnExoskeleton(indexOfExoskeleton);
            } else if (typeOfMonster.equals("Spirit")) {
                int indexOfSpirit = (int) (Math.random() * sf.getNumberOfSpirits());
                monster = sf.getASpirit(indexOfSpirit);
            }

            monsters.addMonster(monster);
        }

        return monsters;
    }
}
