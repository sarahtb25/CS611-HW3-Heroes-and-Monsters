// This class generates heroes according to the number of heroes wanted by player
public class GenerateHeroes {
    public static final WarriorFactory wf = new WarriorFactory();
    public static final SorcererFactory sf = new SorcererFactory();
    public static final PaladinFactory pf = new PaladinFactory();
    public static int numberOfTypesOfHeroes = 3;
    private int numberOfHeroes;

    public GenerateHeroes(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public Heroes getHeroes() {
        Heroes heroes = new Heroes();
        Hero hero = new Hero();

        for (int i = 0; i < numberOfHeroes; i++) {
            int index = (int) (Math.random() * numberOfTypesOfHeroes);
            String typeOfHero = new String [] {"Warrior", "Sorcerer", "Paladin"}[index];

            if (typeOfHero.equals("Warrior")) {
                int indexOfWarrior = (int) (Math.random() * wf.getNumberOfHeroes());
                hero = wf.getAHero(indexOfWarrior);
            } else if (typeOfHero.equals("Sorcerer")) {
                int indexOfSorcerer = (int) (Math.random() * sf.getNumberOfHeroes());
                hero = sf.getAHero(indexOfSorcerer);
            } else if (typeOfHero.equals("Paladin")) {
                int indexOfPaladin = (int) (Math.random() * pf.getNumberOfHeroes());
                hero = pf.getAHero(indexOfPaladin);
            }

            heroes.addHero(hero);
        }

        return heroes;
    }
}
