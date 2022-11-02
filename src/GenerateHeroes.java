import java.util.ArrayList;
import java.util.List;

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
        List<Integer> warriorIndexesAdded = new ArrayList<>();
        List<Integer> sorcererIndexesAdded = new ArrayList<>();
        List<Integer> paladinIndexesAdded = new ArrayList<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            int index = (int) (Math.random() * numberOfTypesOfHeroes);
            String typeOfHero = new String [] {"Warrior", "Sorcerer", "Paladin"}[index];

            if (typeOfHero.equals("Warrior")) {
                int indexOfWarrior = (int) (Math.random() * wf.getNumberOfHeroes());

                while(warriorIndexesAdded.contains(indexOfWarrior)) {
                    indexOfWarrior = (int) (Math.random() * wf.getNumberOfHeroes());
                }

                warriorIndexesAdded.add(indexOfWarrior);
                hero = wf.getAHero(indexOfWarrior);
            } else if (typeOfHero.equals("Sorcerer")) {
                int indexOfSorcerer = (int) (Math.random() * sf.getNumberOfHeroes());

                while(sorcererIndexesAdded.contains(indexOfSorcerer)) {
                    indexOfSorcerer = (int) (Math.random() * sf.getNumberOfHeroes());
                }

                sorcererIndexesAdded.add(indexOfSorcerer);
                hero = sf.getAHero(indexOfSorcerer);
            } else if (typeOfHero.equals("Paladin")) {
                int indexOfPaladin = (int) (Math.random() * pf.getNumberOfHeroes());

                while(paladinIndexesAdded.contains(indexOfPaladin)) {
                    indexOfPaladin = (int) (Math.random() * pf.getNumberOfHeroes());
                }

                paladinIndexesAdded.add(indexOfPaladin);
                hero = pf.getAHero(indexOfPaladin);
            }

            heroes.addHero(hero);
        }

        return heroes;
    }
}
