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
                int indexOfWarrior = (int) (Math.random() * wf.getNumberOfWarriors());
                hero = wf.getAWarrior(indexOfWarrior);
            } else if (typeOfHero.equals("Sorcerer")) {
                int indexOfSorcerer = (int) (Math.random() * sf.getNumberOfSorcerers());
                hero = sf.getASorcerer(indexOfSorcerer);
            } else if (typeOfHero.equals("Paladin")) {
                int indexOfPaladin = (int) (Math.random() * pf.getNumberOfPaladins());
                hero = pf.getAPaladin(indexOfPaladin);
            }

            heroes.addHero(hero);
        }

        return heroes;
    }
}
