import java.util.List;

public class Heroes {
    private List<Hero> heroes; // min. 1 and max. 3 heroes, can use instanceof to get the type of hero

    public Heroes() {

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
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                                   HEROES                                                  |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%5s %10s %10s %8s %8s %10s %10s %10s %10s", "ID", "NAME", "HITPOINT", "MANA", "MONEY", "EXPERIENCE", "STRENGTH", "AGILITY", "DEXTERITY");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        for(Hero hero : heroes) {
            System.out.format("%7s %14s %7s %7s %7s %7s %7s %7s", hero.getId(), hero.getName(), hero.getHitPoints(), hero.getMana(), hero.getMoney(), hero.getExperience(), hero.getStrength(), hero.getAgility(), hero.getDexterity());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
