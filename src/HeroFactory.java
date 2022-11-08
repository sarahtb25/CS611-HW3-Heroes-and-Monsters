/* An interface that represents the expected behaviour of factories that will generate the various types of heroes
e.g. Warrior, Sorcerer and Paladin
 */
public interface HeroFactory <T extends Hero> {
    void generateHeroes();
    T getAHero(int index);
    int getNumberOfHeroes();
}
