import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This class generates heroes according to the number of heroes wanted by player
public class GenerateHeroes {
    public static final WarriorFactory wf = new WarriorFactory();
    public static final SorcererFactory sf = new SorcererFactory();
    public static final PaladinFactory pf = new PaladinFactory();
    private int numberOfHeroes;

    public GenerateHeroes(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public Heroes getHeroes() {
        Heroes heroes = new Heroes();
        Hero hero = new Hero();
        ArrayList<String> typesOfHeroes = new ArrayList<>();
        String[] heroTypes = new String[]{"Warrior", "Sorcerer", "Paladin"};

        for (int i = 0; i < heroTypes.length; i++) {
            typesOfHeroes.add(heroTypes[i]);
        }

        for (int i = 0; i < numberOfHeroes; i++) {
            int heroType = (int) (Math.random() * typesOfHeroes.size());
            String typeOfHero = typesOfHeroes.get(heroType);

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
            typesOfHeroes.remove(typeOfHero);
        }

        return heroes;
    }
}
