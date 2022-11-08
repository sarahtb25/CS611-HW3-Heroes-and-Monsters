import java.util.ArrayList;
import java.util.List;

// Represents a list of heroes
public class Heroes {
    private List<Hero> heroes; // min. 1 and max. 3 heroes, can use instanceof to get the type of hero

    public Heroes() {
        heroes = new ArrayList<>();
    }
    public Heroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    // Used when a hero is defeated
    public void removeHero(Hero hero) {
        heroes.remove(hero);
    }

    public int getTotalNumberOfMonstersDefeated() {
        int totalNumberOfHeroesDefeated = 0;

        for (Hero hero : heroes) {
            totalNumberOfHeroesDefeated += hero.getNumberOfTimesHeroDefeatedMonster();
        }

        return totalNumberOfHeroesDefeated;
    }

    public int getNumberOfHeroesAlive() {
        int numberOfHeroesAlive = 0;

        for (Hero hero : heroes) {
            if (hero.getHitPoints() > 0) {
                numberOfHeroesAlive++;
            }
        }

        return numberOfHeroesAlive;
    }

    public boolean checkIfHeroExists(String id) {
        for (Hero hero : heroes) {
            if (hero.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public Hero getHeroFromId(String id) {
        Hero heroWanted = new Hero();

        for (Hero hero : heroes) {
            if (hero.getId().equals(id)) {
                heroWanted = hero;
                break;
            }
        }

        return heroWanted;
    }

    public void printHeroes() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                HEROES                                                              |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%7s %21s %15s %15s %7s %8s %13s %13s %10s %12s", "ID", "NAME", "TYPE", "HITPOINT", "MANA", "MONEY", "EXPERIENCE", "STRENGTH", "AGILITY", "DEXTERITY");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for(Hero hero : heroes) {
            System.out.format("%7s %25s %13s %10s %10s %8s %9s %14s %11s %10s", hero.getId(), hero.getName(), hero.getClass().toString().split(" ", 2)[1], hero.getHitPoints(), hero.getMana(), hero.getMoney(), hero.getExperience(), hero.getStrength(), hero.getAgility(), hero.getDexterity());
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
    }
}
